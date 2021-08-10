package com.mycompany.projetolojajpamaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mycompany.projetolojajpamaven.model.bo.Pagar;
import com.mycompany.projetolojajpamaven.model.bo.Receber;
import com.mycompany.projetolojajpamaven.view.busca.TelaBuscaReceber;

public class ControllerReceberBusca implements ActionListener {

    TelaBuscaReceber telaBuscaReceber;

    public ControllerReceberBusca(TelaBuscaReceber telaBuscaReceber) {
        this.telaBuscaReceber = telaBuscaReceber;

        this.telaBuscaReceber.getjButtonCarregar().addActionListener(this);
        this.telaBuscaReceber.getjButtonSair().addActionListener(this);
        this.telaBuscaReceber.getjButton_Deletar().setEnabled(false);

        carregarDadosNaTabela();
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBuscaReceber.getjButtonSair()) 
            this.telaBuscaReceber.dispose();
        
        else if (e.getSource() == this.telaBuscaReceber.getjButtonCarregar()) {
            ControllerReceber.codigo = (int) this.telaBuscaReceber.getjTable_ReceberBusca().getValueAt(
                    this.telaBuscaReceber.getjTable_ReceberBusca().getSelectedRow(),0);
            this.telaBuscaReceber.dispose();
        }else if (e.getSource() == this.telaBuscaReceber.getjButton_Deletar()){
            try{
                com.mycompany.projetolojajpamaven.service.ServicePagar.Deletar((int) this.telaBuscaReceber.getjTable_ReceberBusca().getValueAt(
                        this.telaBuscaReceber.getjTable_ReceberBusca().getSelectedRow(),0)); 
                JOptionPane.showMessageDialog(null, "Pagar deletado com sucesso!");
                carregarDadosNaTabela();
            } catch (Exception ex) {
                throw new RuntimeException(" \nCLASSE: ControllerBuscaBairro->actionPerformed(ActionEvent e)->deletar\nMENSAGEM:" 
                        + ex.getMessage() + "\nLOCALIZADO:" 
                        + ex.getLocalizedMessage()
                );
            }
        }
        
    }

    private void carregarDadosNaTabela() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaReceber.getjTable_ReceberBusca().getModel();
        tabela.getDataVector().removeAllElements();

        for (Receber recebimentosDaLista : com.mycompany.projetolojajpamaven.service.ServiceReceber.Buscar()) {
            tabela.addRow(new Object[]{
                recebimentosDaLista.getId(),
                recebimentosDaLista.getDataRecebimento(),
                recebimentosDaLista.getHora(),
                recebimentosDaLista.getValorAcrescimo(),
                recebimentosDaLista.getValorRecebido(),
                recebimentosDaLista.getObservacao(),
                recebimentosDaLista.getContaAReceber().getId()
            });
        }
    }

}
