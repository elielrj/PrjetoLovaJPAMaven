package com.mycompany.projetolojajpamaven.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.mycompany.projetolojajpamaven.model.bo.ContaAReceber;
import com.mycompany.projetolojajpamaven.view.busca.TelaBuscaContaAReceber;
import com.mycompany.projetolojajpamaven.view.cadastro.TelaCadastroContaAReceber;

public class ControllerContasAReceberBusca implements ActionListener {

    TelaBuscaContaAReceber telaBuscaContaAReceber;

    public ControllerContasAReceberBusca(TelaBuscaContaAReceber telaBuscaContaAReceber) {
        
        this.telaBuscaContaAReceber = telaBuscaContaAReceber;
        
        this.telaBuscaContaAReceber.getjButtonSair().addActionListener(this);
        
        carregarDadosNaTabela();
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        if (e.getSource() == this.telaBuscaContaAReceber.getjButtonSair())
            this.telaBuscaContaAReceber.dispose();
      
    }

    private void carregarDadosNaTabela() {
        
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaContaAReceber.getjTable_ContaAReceber().getModel();
        tabela.getDataVector().removeAllElements();
        
        for (ContaAReceber contaAReceberDaLista : com.mycompany.projetolojajpamaven.service.ServiceContaAReceber.Buscar()) {
            tabela.addRow(new Object[]{
                contaAReceberDaLista.getId(),
                contaAReceberDaLista.getVendaId(),
                contaAReceberDaLista.getValor(),
                contaAReceberDaLista.getStatus()
            });
        }
    }

   
    
    
}
