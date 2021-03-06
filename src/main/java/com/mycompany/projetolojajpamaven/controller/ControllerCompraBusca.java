package com.mycompany.projetolojajpamaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mycompany.projetolojajpamaven.view.busca.TelaBuscaCompra;
import com.mycompany.projetolojajpamaven.model.bo.Compra;

public class ControllerCompraBusca implements ActionListener {

    TelaBuscaCompra telaBuscaCompra;
    int idCompra = 0;

    public ControllerCompraBusca(TelaBuscaCompra telaBuscaCompra) {
        
        this.telaBuscaCompra = telaBuscaCompra;
        
        this.telaBuscaCompra.getjButtonCarregar().addActionListener(this);
        this.telaBuscaCompra.getjButtonSair().addActionListener(this);
        this.telaBuscaCompra.getjButton_deletar().addActionListener(this);

        
       carregarDadosNaTabela();

    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() == this.telaBuscaCompra.getjButtonSair()) 
            this.telaBuscaCompra.dispose();
        else if (e.getSource() == this.telaBuscaCompra.getjButtonCarregar()) {

            idCompra = (int) this.telaBuscaCompra.getjTable_BuscaCompras().getValueAt(this.telaBuscaCompra.getjTable_BuscaCompras().getSelectedRow(), 0);
            ControllerCompra.codigo = idCompra;
            this.telaBuscaCompra.setIdCompra(idCompra);
            this.telaBuscaCompra.dispose();
        }else if (e.getSource() == this.telaBuscaCompra.getjButton_deletar()){
            try{
                com.mycompany.projetolojajpamaven.service.ServiceCompra.Deletar((int) 
                        
                        this.telaBuscaCompra.getjTable_BuscaCompras().getValueAt(
                        this.telaBuscaCompra.getjTable_BuscaCompras().getSelectedRow(),0)
                );
                JOptionPane.showMessageDialog(null, "Compra deletado com sucesso!");
                carregarDadosNaTabela();
            } catch (Exception ex) {
                throw new RuntimeException(" \nCLASSE: ControllerCompraBusca->actionPerformed(ActionEvent e)->deletar\nMENSAGEM:" 
                        + ex.getMessage() + "\nLOCALIZADO:" 
                        + ex.getLocalizedMessage()
                );
            }
        }
       
    }
    
    private void carregarDadosNaTabela() {
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaCompra.getjTable_BuscaCompras().getModel();
        tabela.getDataVector().removeAllElements();
        
        for (Compra compraDaLista : com.mycompany.projetolojajpamaven.service.ServiceCompra.Buscar()) {
            tabela.addRow(new Object[]{
                compraDaLista.getId(),//1
                compraDaLista.getData(),//2
                compraDaLista.getHora(),//3
                //compraDaLista.getUserCaixa(),//4
                compraDaLista.getDataDeVencimento(),//5
                compraDaLista.getObservacao(),//6
                compraDaLista.getValorDeDesconto(),//7
                compraDaLista.getValorTotal(),//8
                compraDaLista.getStatus()//9
                //compraDaLista.getPessoaFisica().getNome(),//10
                //compraDaLista.quantidadeDeItensNaLista()//10
            });
        }
    }

}
