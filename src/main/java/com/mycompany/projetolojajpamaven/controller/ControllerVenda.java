package com.mycompany.projetolojajpamaven.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.mycompany.projetolojajpamaven.model.bo.ContaAReceber;
import com.mycompany.projetolojajpamaven.model.bo.Estoque;
import com.mycompany.projetolojajpamaven.model.bo.ItemDeVenda;
import com.mycompany.projetolojajpamaven.model.bo.PessoaFisica;
import com.mycompany.projetolojajpamaven.model.bo.Produto;
import com.mycompany.projetolojajpamaven.view.busca.TelaBuscaPessoaFisica;
import com.mycompany.projetolojajpamaven.view.busca.TelaBuscaProduto;
import com.mycompany.projetolojajpamaven.view.cadastro.TelaCadastroVenda;
import com.mycompany.projetolojajpamaven.model.bo.Venda;
import com.mycompany.projetolojajpamaven.view.busca.TelaBuscaVenda;

public class ControllerVenda implements ActionListener {

    TelaCadastroVenda telaCadastroVenda;
    public static int codigo;
    private Venda venda;

    public ControllerVenda(TelaCadastroVenda telaCadastroVenda) {

        this.telaCadastroVenda = telaCadastroVenda;
        this.venda = new Venda.VendaBuilder().createVenda();

        //BOTÕES
        this.telaCadastroVenda.getjButton_Novo().addActionListener(this);
        this.telaCadastroVenda.getjButton_Buscar().addActionListener(this);
        this.telaCadastroVenda.getjButton_Cancelar().addActionListener(this);
        this.telaCadastroVenda.getjButton_Gravar().addActionListener(this);
        this.telaCadastroVenda.getjButton_Sair().addActionListener(this);
        this.telaCadastroVenda.getjButton_ProdutoPesquisa().addActionListener(this);
        this.telaCadastroVenda.getjButton_ProdutoAdicionar().addActionListener(this);
        this.telaCadastroVenda.getjButton_ClienteBuscaId().addActionListener(this);
        this.telaCadastroVenda.getjButton_ProdutoRemover().addActionListener(this);
        this.telaCadastroVenda.getjPanelDados().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (existeFaturamentoEmAndamento()) {
                        if (validarCodigoBarras()) {
                            inserirItem();
                        } else {
                            JOptionPane.showMessageDialog(null, "C�digo de Barras inv�lilido");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "N�o existe um faturamento em andamento");
                    }
                } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
                    buscaCodigoDeBarrasDoProduto();
                } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
                    novoFaturamento();
                } else if (evt.getKeyCode() == KeyEvent.VK_F3) {
                    cancelarFaturamento();
                } else if (evt.getKeyCode() == KeyEvent.VK_F4) {
                    //persistir no banco
                    gravarVenda();
                } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
                    //remover item selecionado
                    if (existeFaturamentoEmAndamento()) {
                        removerItemFaturado();
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione 1 item!");
                    }
                }
            }

        });
        this.telaCadastroVenda.getjFormattedTextField_ProdutoCodBarras().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (existeFaturamentoEmAndamento()) {
                        if (validarCodigoBarras()) {
                            inserirItem();
                        } else {
                            JOptionPane.showMessageDialog(null, "C�digo de Barras inv�lido");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "N�o existe um faturamento em andamento");
                    }
                } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
                    buscaCodigoDeBarrasDoProduto();
                } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
                    novoFaturamento();
                } else if (evt.getKeyCode() == KeyEvent.VK_F3) {
                    cancelarFaturamento();
                } else if (evt.getKeyCode() == KeyEvent.VK_F4) {
                    //persistir no banco
                    gravarVenda();
                } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
                    //remover item selecionado
                    if (existeFaturamentoEmAndamento()) {
                        removerItemFaturado();
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione 1 item!");
                    }
                }
            }

        });
        //KEY   
        this.telaCadastroVenda.getjPanelDados().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (existeFaturamentoEmAndamento()) {
                        if (validarCodigoBarras()) {
                            inserirItem();
                        } else {
                            JOptionPane.showMessageDialog(null, "C�d de Barras inv�lido");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "N�o existe um faturamento em andamento");
                    }
                } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
                    buscaCodigoDeBarrasDoProduto();
                } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
                    novoFaturamento();
                } else if (evt.getKeyCode() == KeyEvent.VK_F3) {
                    cancelarFaturamento();
                } else if (evt.getKeyCode() == KeyEvent.VK_F4) {
                    //persistir no banco
                    gravarVenda();
                } else if (evt.getKeyCode() == KeyEvent.VK_F5) {
                    //remover item selecionado
                    if (existeFaturamentoEmAndamento()) {
                        removerItemFaturado();
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione 1 item!");
                    }
                }
            }

        });

        Ativa(true);
        desativarPorPadrao();
        LimpaEstadoComponentes(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 1 - NOVO
        if (e.getSource() == this.telaCadastroVenda.getjButton_Novo()) {
            novoFaturamento();
            // 2 - CANCELAR
        } else if (e.getSource() == this.telaCadastroVenda.getjButton_Cancelar()) {
            cancelarFaturamento();
            // 3- GRAVAR
        } else if (e.getSource() == this.telaCadastroVenda.getjButton_Gravar()) {
            if (validarCliente()) {
                gravarVenda();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um cliente!");
                this.telaCadastroVenda.getjTextField_ClienteId().requestFocus();
            }
            // 4- BUSCAR
        } else if (e.getSource() == this.telaCadastroVenda.getjButton_Buscar()) {

            //codigo = 0;
            TelaBuscaVenda TelaBuscaVenda = new TelaBuscaVenda(null, true);
            ControllerVendaBusca controllerVendaBusca = new ControllerVendaBusca(TelaBuscaVenda);
            TelaBuscaVenda.setVisible(true);

            if (codigo != 0) {
                Ativa(false);
                LimpaEstadoComponentes(true);

                venda = com.mycompany.projetolojajpamaven.service.ServiceVenda.Buscar(codigo);

                this.telaCadastroVenda.getjTextField_Faturamento_Id().setText(venda.getId() + "");//1
                this.telaCadastroVenda.getjFormattedTextField_FaturamentoData().setText(venda.getData());//2
                this.telaCadastroVenda.getjFormattedTextField_FaturamentoHora().setText(venda.getHora());//3
                this.telaCadastroVenda.getjTextField_FaturamentoUsuario().setText(venda.getUserCaixa());//4
                this.telaCadastroVenda.getjFormattedTextField_DataDeVencimento().setText(venda.getDataDeVencimento());//5
                this.telaCadastroVenda.getjTextArea_Obs().setText(venda.getObservacao());//6
                this.telaCadastroVenda.getjFormattedTextField_ValorDeDesconto().setText(venda.getValorDoDesconto() + "");//7
                this.telaCadastroVenda.getjLabel_FaturamentoValorTotal().setText(venda.getValorTotal() + "");//8
                this.telaCadastroVenda.getjComboBoxStatus().setSelectedItem(venda.getStatus());//9
                //CLIENTE - PESSOA F�?SICA
                this.telaCadastroVenda.getjTextField_ClienteId().setText(venda.getPessoaFisica().getId() + "");//10 - 1
                this.telaCadastroVenda.getjTextField_Cliente_Nome().setText(venda.getPessoaFisica().getNome());//10 - 2
                // N�o necessário: 3,4,5
                this.telaCadastroVenda.getjTextField_Cliente_Cidade().setText(venda.getPessoaFisica().getEndereco().getBairro().getCidade().getNome());//10 - 6?
                this.telaCadastroVenda.getjTextField_Cliente_Bairro().setText(venda.getPessoaFisica().getEndereco().getBairro().getNome());//10 - 6?
                // N�o necessário 7
                this.telaCadastroVenda.getjTextField_Cliente_Tel1().setText(venda.getPessoaFisica().getTelefone1());//10 -8 
                this.telaCadastroVenda.getjTextField_Cliente_Tel2().setText(venda.getPessoaFisica().getTelefone2());//10 - 9
                this.telaCadastroVenda.getjComboBox_alunoOuPersonal().setSelectedItem(venda.getPessoaFisica().getTipo());
                this.telaCadastroVenda.getjTextField_Cliente_Email().setText(venda.getPessoaFisica().getEmail());//10 - 10                
JOptionPane.showConfirmDialog(null, "antes de itens");
                //venda.setItensDeVenda(com.mycompany.projetolojajpamaven.service.ServiceItemDeVenda.BuscarUmaListaDeItemDeVendaPeloIdDaVenda(venda.getId())); //11
                atualizarTabelaDeItens();
            }
            // 5- PESQUISAR PRODUTO
        } else if (e.getSource() == this.telaCadastroVenda.getjButton_ProdutoPesquisa()) {
            buscaCodigoDeBarrasDoProduto();
            // 6 - ADICIONAR PRODUTO
        } else if (e.getSource() == this.telaCadastroVenda.getjButton_ProdutoAdicionar()) {
            if (existeFaturamentoEmAndamento()) {
                if (validarCodigoBarras()) {
                    inserirItem();
                } else {
                    JOptionPane.showMessageDialog(null, "C�d de Barras inv�lido");
                    this.telaCadastroVenda.getjFormattedTextField_ProdutoCodBarras().requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "N�o existe um faturamento em andamento");
                this.telaCadastroVenda.getjComboBoxStatus().requestFocus();
            }
            // 8 - SAIR
        } else if (e.getSource() == this.telaCadastroVenda.getjButton_Sair()) {
            this.telaCadastroVenda.dispose();
            // 7 - PESQUISAR CLIENTE
        } else if (e.getSource() == this.telaCadastroVenda.getjButton_ClienteBuscaId()) {
            if (validarCliente()) {

                if (this.telaCadastroVenda.getjComboBox_alunoOuPersonal().getSelectedItem().equals("Aluno")) {
                    buscaClienteAluno();
                } else if (this.telaCadastroVenda.getjComboBox_alunoOuPersonal().getSelectedItem().equals("Personal")) {
                    buscaClientePersonal();
                } else {
                    JOptionPane.showMessageDialog(null, "Escolha Aluno ou Personal");
                    this.telaCadastroVenda.getjComboBox_alunoOuPersonal().requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Busque um cliente válido!");
            }
            // 6 - REMOVER PRODUTO
        } else if (e.getSource() == this.telaCadastroVenda.getjButton_ProdutoRemover()) {

            if (existeFaturamentoEmAndamento()) {
                removerItemFaturado();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione 1 item!");
                this.telaCadastroVenda.getjTable_FaturamentoItens().requestFocus();
            }
        }
    }

    public void Ativa(boolean estadoBotoes) {
        this.telaCadastroVenda.getjButton_Novo().setEnabled(estadoBotoes);
        this.telaCadastroVenda.getjButton_Cancelar().setEnabled(!estadoBotoes);
        this.telaCadastroVenda.getjButton_Gravar().setEnabled(!estadoBotoes);
        this.telaCadastroVenda.getjButton_Buscar().setEnabled(estadoBotoes);
        this.telaCadastroVenda.getjButton_Sair().setEnabled(estadoBotoes);

        this.telaCadastroVenda.getjFormattedTextField_ProdutoCodBarras().setEnabled(!estadoBotoes);
        this.telaCadastroVenda.getjButton_ProdutoPesquisa().setEnabled(!estadoBotoes);

        this.telaCadastroVenda.getjButton_ProdutoAdicionar().setEnabled(!estadoBotoes);
        this.telaCadastroVenda.getjButton_ProdutoRemover().setEnabled(!estadoBotoes);
        this.telaCadastroVenda.getjButton_ClienteBuscaId().setEnabled(!estadoBotoes);
        this.telaCadastroVenda.getjTable_FaturamentoItens().setEnabled(!estadoBotoes);
        this.telaCadastroVenda.getjComboBoxStatus().setEnabled(!estadoBotoes);
        this.telaCadastroVenda.getjTextArea_Obs().setEnabled(!estadoBotoes);
        this.telaCadastroVenda.getjFormattedTextField_ValorDeDesconto().setEnabled(!estadoBotoes);
        this.telaCadastroVenda.getjFormattedTextField_DataDeVencimento().setEnabled(!estadoBotoes);
        this.telaCadastroVenda.getjComboBox_alunoOuPersonal().setEnabled(!estadoBotoes);
    }

    public void desativarPorPadrao() {
        this.telaCadastroVenda.getjTextField_Cliente_Nome().setEnabled(false);
        this.telaCadastroVenda.getjTextField_Cliente_Cidade().setEnabled(false);
        this.telaCadastroVenda.getjTextField_Cliente_Bairro().setEnabled(false);
        this.telaCadastroVenda.getjTextField_Cliente_Email().setEnabled(false);
        this.telaCadastroVenda.getjTextField_Cliente_Tel1().setEnabled(false);
        this.telaCadastroVenda.getjTextField_Cliente_Tel2().setEnabled(false);
        this.telaCadastroVenda.getjTextField_ClienteId().setEnabled(false);

        this.telaCadastroVenda.getjFormattedTextField_FaturamentoData().setEnabled(false);
        this.telaCadastroVenda.getjFormattedTextField_FaturamentoHora().setEnabled(false);
        this.telaCadastroVenda.getjTextField_FaturamentoUsuario().setEnabled(false);
        this.telaCadastroVenda.getjTextField_Faturamento_Id().setEnabled(false);

    }

    public void LimpaEstadoComponentes(boolean estadoCompo) {

        Component[] componentes = this.telaCadastroVenda.getjTable_FaturamentoItens().getComponents(); //verificar
        for (Component componente : componentes) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
                componente.setEnabled(estadoCompo);
            }

            if (componente instanceof JFormattedTextField) {
                ((JFormattedTextField) componente).setText("");
                componente.setEnabled(estadoCompo);
            }

            if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedItem(0);
                componente.setEnabled(estadoCompo);
            }

            if ((componente instanceof JTextArea)) {
                ((JTextArea) componente).setToolTipText("");
                ((JTextArea) componente).setEditable(estadoCompo);
            }

            if ((componente instanceof JTextArea)) {
                ((JTextArea) componente).setText("");
                componente.setEnabled(estadoCompo);
            }
            if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedItem(0);
                componente.setEnabled(estadoCompo);
            }

        }
    }

    private void buscaCodigoDeBarrasDoProduto() {

        TelaBuscaProduto telaBuscaProduto = new TelaBuscaProduto(null, true);
        ControllerProdutoBusca controllerBuscaProduto = new ControllerProdutoBusca(telaBuscaProduto);
        telaBuscaProduto.setVisible(true);

        this.telaCadastroVenda.getjFormattedTextField_ProdutoCodBarras().setText(
                com.mycompany.projetolojajpamaven.service.ServiceProduto.Buscar(
                        telaBuscaProduto.getCodProduto()
                ).getCodigoDeBarras()
        );
    }

    public void inserirItem() {
        //1º Cria e busca produto pelo Cod Barras
        Produto produto = com.mycompany.projetolojajpamaven.service.ServiceProduto.Buscar(this.telaCadastroVenda.getjFormattedTextField_ProdutoCodBarras().getText());
        //2º Adicionar produto e qtd; atribuindo a responsabilidade a venda de criar ItemDeVenda
        venda.adicionarItem(produto);
        //3º atualizar tabela da tela
        atualizarTabelaDeItens();
    }

    public void novoFaturamento() {
        Ativa(false);
        LimpaEstadoComponentes(true);
        codigo = 0;
        this.telaCadastroVenda.getjComboBoxStatus().setSelectedItem("Faturando");
        this.telaCadastroVenda.getjTextField_FaturamentoUsuario().setText(venda.getUserCaixa());
        this.telaCadastroVenda.getjFormattedTextField_FaturamentoData().setText(venda.getData());
        this.telaCadastroVenda.getjFormattedTextField_FaturamentoHora().setText(venda.getHora());
        this.telaCadastroVenda.getjFormattedTextField_DataDeVencimento().setText(venda.getDataDeVencimento());
        this.telaCadastroVenda.getjFormattedTextField_ValorDeDesconto().setText(venda.getValorDoDesconto() + "");
    }

    public void buscaClienteAluno() {
        TelaBuscaPessoaFisica telaBuscaPessoaFisica = new TelaBuscaPessoaFisica(null, true);
        ControllerPessoaFisicaAlunoBusca controllerBuscaPessoaFisicaAlunoBusca = new ControllerPessoaFisicaAlunoBusca(telaBuscaPessoaFisica);
        telaBuscaPessoaFisica.setVisible(true);

        venda.setPessoaFisica(
                com.mycompany.projetolojajpamaven.service.ServicePessoaFisica.Buscar(
                        telaBuscaPessoaFisica.getIdDaPessoaFisica())
        );
        this.telaCadastroVenda.getjTextField_ClienteId().setText(telaBuscaPessoaFisica.getIdDaPessoaFisica() + "");

        //CLIENTE - PESSOA F�?SICA
        this.telaCadastroVenda.getjTextField_ClienteId().setText(venda.getPessoaFisica().getId() + "");//10 - 1
        this.telaCadastroVenda.getjTextField_Cliente_Nome().setText(venda.getPessoaFisica().getNome());//10 - 2
        // N�o necessário: 3,4,5
        this.telaCadastroVenda.getjTextField_Cliente_Cidade().setText(venda.getPessoaFisica().getEndereco().getBairro().getCidade().getNome());//10 - 6?
        this.telaCadastroVenda.getjTextField_Cliente_Bairro().setText(venda.getPessoaFisica().getEndereco().getBairro().getNome());//10 - 6?
        // N�o necessário 7
        this.telaCadastroVenda.getjTextField_Cliente_Tel1().setText(venda.getPessoaFisica().getTelefone1());//10 -8 
        this.telaCadastroVenda.getjTextField_Cliente_Tel2().setText(venda.getPessoaFisica().getTelefone2());//10 - 9
        this.telaCadastroVenda.getjComboBox_alunoOuPersonal().setSelectedItem(venda.getPessoaFisica().getTipo());
        this.telaCadastroVenda.getjTextField_Cliente_Email().setText(venda.getPessoaFisica().getEmail());//10 - 10 

    }

    private boolean validarCodigoBarras() {
        /*
        String codigoDeBarras = semMascara(this.telaCadastroVenda.getjFormattedTextField_ProdutoCodBarras().getText());

        if (codigoDeBarras.equals("")) { //"             "
            return false;
        } else if (codigoDeBarras.equals("")) {
            return false;
        } else if (codigoDeBarras.length() >= 13) {
            return false;
        } else {
            Produto produto = service.ServiceProduto.BuscarObjetoVendaPeloClienteValorTotalEData(Integer.parseInt(codigoDeBarras));
            if (produto.getId() == Integer.parseInt(codigoDeBarras)) {
                return true;
            }
            return false;
        }*/

        return com.mycompany.projetolojajpamaven.service.ServiceProduto.codigoDeBarrasValido(
                (this.telaCadastroVenda.getjFormattedTextField_ProdutoCodBarras().getText())
        );

    }

    private void atualizarTabelaDeItens() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroVenda.getjTable_FaturamentoItens().getModel();
        tabela.getDataVector().removeAllElements();
        int contador = 0;
        if (venda.quantidadeDeItensNaLista() > 0) {
            for (ItemDeVenda itemDeVenda : venda.getItensDeVenda()) {
                tabela.addRow(new Object[]{
                    ++contador,
                    itemDeVenda.getProduto().getId(),
                    itemDeVenda.getProduto().getDescricao(),
                    itemDeVenda.getQuantidade(),
                    itemDeVenda.getProduto().getValor(),
                    itemDeVenda.getSubTotal()
                });
            }
        } else {
            tabela.addRow(new Object[]{});
        }
        this.telaCadastroVenda.getjTable_FaturamentoItens().setModel(tabela);
        this.telaCadastroVenda.getjLabel_FaturamentoValorTotal().setText(venda.calcularValorTotal() + "");
    }

    private void gravarVenda() {

        venda.setData(this.telaCadastroVenda.getjFormattedTextField_FaturamentoData().getText());//2
        venda.setHora(this.telaCadastroVenda.getjFormattedTextField_FaturamentoHora().getText());//3

        venda.setUserCaixa(this.telaCadastroVenda.getjTextField_FaturamentoUsuario().getText());//4
        venda.setDataDeVencimento(this.telaCadastroVenda.getjFormattedTextField_DataDeVencimento().getText());//5
        venda.setObservacao(this.telaCadastroVenda.getjTextArea_Obs().getText());//6
        venda.setValorDoDesconto(
                Float.parseFloat(
                        substituirVirgolaPorPonto(this.telaCadastroVenda.getjFormattedTextField_ValorDeDesconto().getText())
                )
        );//7
        venda.setValorTotal(Float.parseFloat(this.telaCadastroVenda.getjLabel_FaturamentoValorTotal().getText()));//8
        venda.setStatus(this.telaCadastroVenda.getjComboBoxStatus().getSelectedItem().equals("Faturando"));//9
        //ATRIBUIÇÃO DA PESSOA F�?SICA É FEITA NA BUSCA - 10
        
        venda.setPessoaFisica(
                buscaPessoaFisica(
                        Integer.parseInt(this.telaCadastroVenda.getjTextField_ClienteId().getText())
                )
        );
        
        //VENDA OK
        if (codigo == 0) {
            
            
            //1º incluir a venda
            com.mycompany.projetolojajpamaven.service.ServiceVenda.Incluir(venda);
            //Resgatar o Id da Venda
           /* int idDaVenda = com.mycompany.projetolojajpamaven.service.ServiceVenda.BuscarObjetoVendaPeloClienteValorTotalEData(venda);
            //Venda vendaAtualizada = com.mycompany.projetolojajpamaven.service.ServiceVenda.Buscar(idDaVenda);
            
            for(ItemDeVenda i : com.mycompany.projetolojajpamaven.service.ServiceItemDeVenda.Buscar()){
                if(i.getVendaId() == null){
                    
                    com.mycompany.projetolojajpamaven.service.ServiceVenda.Atualizar(vendaAtualizada);
                }
            
            }
            */
            
            //2º incluir os itens c/ idVenda na tabela de itens de venda no banco           

            for (ItemDeVenda itemDeVenda : venda.getItensDeVenda()) {
                itemDeVenda.setVendaId(venda);//venda.getId());
                //!!com.mycompany.projetolojajpamaven.service.ServiceItemDeVenda.Incluir(itemDeVenda);

                //ESTOQUE: 1º busca estoque pelo produtoId
                Estoque estoque = com.mycompany.projetolojajpamaven.service.ServiceEstoque.BuscarEstoquePorIdDoProduto(itemDeVenda.getProduto().getId());
                //ESTOQUE: 2º setar a nova qtd no estoque
                estoque.setQuantidade(estoque.getQuantidade() - itemDeVenda.getQuantidade());
                com.mycompany.projetolojajpamaven.service.ServiceEstoque.Atualizar(estoque);
                //VENDA: finalmente incluir-la
                //!!com.mycompany.projetolojajpamaven.service.ServiceItemDeVenda.Incluir(itemDeVenda);

            }

            //3º criar conta a receber
            ContaAReceber contaAReceber = new ContaAReceber.ContaAReceberBuilder()
                    .setVendaId(venda.getId())
                    .setValor(venda.getValorTotal())
                    .setStatus(false)
                    .createContaAReceber();
            com.mycompany.projetolojajpamaven.service.ServiceContaAReceber.Incluir(contaAReceber);
            
        } else {
            //1º atualizar a venda
            com.mycompany.projetolojajpamaven.service.ServiceVenda.Atualizar(venda);
            JOptionPane.showMessageDialog(null, "tewte itens");
            //2º deletar itens anterior no banco
            //buscar antes de deletar!
            List<ItemDeVenda> itensDeVenda = com.mycompany.projetolojajpamaven.service.ServiceItemDeVenda.BuscarUmaListaDeItemDeVendaPeloIdDaVenda(venda.getId());

            for (ItemDeVenda itemDeVenda : itensDeVenda) {
                Estoque estoque = com.mycompany.projetolojajpamaven.service.ServiceEstoque.BuscarEstoquePorIdDoProduto(itemDeVenda.getProduto().getId());
                estoque.setQuantidade(
                        estoque.getQuantidade() + itemDeVenda.getQuantidade()
                );
                com.mycompany.projetolojajpamaven.service.ServiceEstoque.Atualizar(estoque);
                com.mycompany.projetolojajpamaven.service.ServiceItemDeVenda.Deletar(itemDeVenda);
            }

            //3ºatualizar os itens c/ idVenda e incluir na tabela de itens de venda no banco          
            for (ItemDeVenda item : venda.getItensDeVenda()) {
                //Setar o IDVenda no item
                item.setVendaId(venda);//venda.getId());
                try {
                    //buscar estoque, depois debitar e atualizar
                    Estoque estoque = com.mycompany.projetolojajpamaven.service.ServiceEstoque.Buscar(item.getProduto().getId());
                    estoque.setQuantidade(estoque.getQuantidade() - item.getQuantidade());
                    com.mycompany.projetolojajpamaven.service.ServiceEstoque.Atualizar(estoque);
                    //Incluir item
                    com.mycompany.projetolojajpamaven.service.ServiceItemDeVenda.Incluir(item);                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Estoque insuficiente!");
                    throw new RuntimeException(" \nCLASSE: BairroDAO->Retrive->bairroDAO\nMENSAGEM:"
                            + ex.getMessage() + "\nLOCALIZADO:"
                            + ex.getLocalizedMessage()
                    ); 
                } 
            }
            
            //4º atualizar conta a receber (BUSCA, ATUALIZA VALOR, E ATUALIZA)
            ContaAReceber contaAReceber = com.mycompany.projetolojajpamaven.service.ServiceContaAReceber.BuscarIdDaContaAReceberPeloIdDaVenda(venda.getId());
            contaAReceber.setValor(venda.getValorTotal());
            com.mycompany.projetolojajpamaven.service.ServiceContaAReceber.Atualizar(contaAReceber);
                    
        }

        Ativa(true);
        LimpaEstadoComponentes(false);

    }

    private boolean itemDaTabelaEstaSelecionada() {
        return this.telaCadastroVenda.getjTable_FaturamentoItens().getSelectionModel().isSelectionEmpty();
    }

    private void removerItemFaturado() {

       // int numeroDaLinhasSelecionada = this.telaCadastroVenda.getjTable_FaturamentoItens().getSelectionModel().getSelectionMode();

        int idDoProdutoSelecionado = (int) this.telaCadastroVenda.getjTable_FaturamentoItens().getValueAt(
                this.telaCadastroVenda.getjTable_FaturamentoItens().getSelectedRow(), 1);
        Produto produto = com.mycompany.projetolojajpamaven.service.ServiceProduto.Buscar(idDoProdutoSelecionado);
        venda.removerItemDaLista(produto);
        atualizarTabelaDeItens();

    }

    private boolean validarCliente() {
        if (this.telaCadastroVenda.getjTextField_ClienteId().getText() != "") {
            return true;
        }
        return false;
    }

    private void buscaClientePersonal() {

        TelaBuscaPessoaFisica telaBuscaPessoaFisica = new TelaBuscaPessoaFisica(null, true);
        ControllerPessoaFisicaPersonalBusca controllerBuscaPessoaFisicaPersonalBusca = new ControllerPessoaFisicaPersonalBusca(telaBuscaPessoaFisica);
        telaBuscaPessoaFisica.setVisible(true);

        venda.setPessoaFisica(
                com.mycompany.projetolojajpamaven.service.ServicePessoaFisica.Buscar(
                        telaBuscaPessoaFisica.getIdDaPessoaFisica())
        );
        this.telaCadastroVenda.getjTextField_ClienteId().setText(telaBuscaPessoaFisica.getIdDaPessoaFisica() + "");

        //CLIENTE - PESSOA F�?SICA
        this.telaCadastroVenda.getjTextField_ClienteId().setText(venda.getPessoaFisica().getId() + "");//10 - 1
        this.telaCadastroVenda.getjTextField_Cliente_Nome().setText(venda.getPessoaFisica().getNome());//10 - 2
        // N�o necessário: 3,4,5
        this.telaCadastroVenda.getjTextField_Cliente_Cidade().setText(venda.getPessoaFisica().getEndereco().getBairro().getCidade().getNome());//10 - 6?
        this.telaCadastroVenda.getjTextField_Cliente_Bairro().setText(venda.getPessoaFisica().getEndereco().getBairro().getNome());//10 - 6?
        // N�o necessário 7
        this.telaCadastroVenda.getjTextField_Cliente_Tel1().setText(venda.getPessoaFisica().getTelefone1());//10 -8 
        this.telaCadastroVenda.getjTextField_Cliente_Tel2().setText(venda.getPessoaFisica().getTelefone2());//10 - 9
        this.telaCadastroVenda.getjComboBox_alunoOuPersonal().setSelectedItem(venda.getPessoaFisica().getTipo());
        this.telaCadastroVenda.getjTextField_Cliente_Email().setText(venda.getPessoaFisica().getEmail());//10 - 10 

    }

    private static String semMascara(String dado) {
        //dado = dado.replaceAll("\\.", "");
        dado = dado.replaceAll("\\,", ".");
        return dado;
    }

    private void cancelarFaturamento() {
        venda.removerTodosOsItensDaLista();
        this.telaCadastroVenda.getjTextField_ClienteId().setText("");
        this.telaCadastroVenda.getjTextField_Cliente_Nome().setText("");
        this.telaCadastroVenda.getjTextField_Cliente_Cidade().setText("");
        this.telaCadastroVenda.getjTextField_Cliente_Bairro().setText("");
        this.telaCadastroVenda.getjTextField_Cliente_Email().setText("");
        this.telaCadastroVenda.getjTextField_Cliente_Tel1().setText("");
        this.telaCadastroVenda.getjTextField_Cliente_Tel2().setText("");
        this.telaCadastroVenda.getjTextArea_Obs().setText("");
        this.telaCadastroVenda.getjTextField_Faturamento_Id().setText("");
        this.telaCadastroVenda.getjComboBox_alunoOuPersonal().setSelectedItem("");
        atualizarTabelaDeItens();
        Ativa(true);
        LimpaEstadoComponentes(false);
    }

    private boolean existeFaturamentoEmAndamento() {
        if (this.telaCadastroVenda.getjComboBoxStatus().getSelectedItem().equals("Faturando")) {
            return true;
        }
        return false;
    }

    private void dataHora() {

        // data/hora atual
        LocalDateTime agora = LocalDateTime.now();

        // formatar a data
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        venda.setData(formatterData.format(agora));

        // formatar a hora
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        venda.setHora(formatterHora.format(agora));

    }
    
    private static String substituirVirgolaPorPonto(String dado) {
        //dado = dado.replaceAll("\\.", "");
        dado = dado.replaceAll("\\,", ".");
        return dado;
    }

    private PessoaFisica buscaPessoaFisica(int idPessoaFisica) {
        return com.mycompany.projetolojajpamaven.service.ServicePessoaFisica.Buscar(idPessoaFisica);
    }
}



