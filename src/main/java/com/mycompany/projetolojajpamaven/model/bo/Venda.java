package com.mycompany.projetolojajpamaven.model.bo;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Array;

@Entity
@Table(name="venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name="id")
    private int id;//1
    
    @Column(name="datavenda")
    private String data;//2
    
    @Column(name="hora")
    private String hora;//3
    
    @Column(name="usercaixa")
    private String userCaixa;//4
    
    @Column(name="datavencimento")
    private String dataDeVencimento;//5
    
    @Column(name="observacao")
    private String observacao;//6
    
    @Column(name="valordesconto")
    private float valorDoDesconto;//7
    
    @Column(name="valortotal")
    private float valorTotal;//8
    
    @Column(name="status")
    private boolean status;//9
    
    @NotNull
    @JoinColumn(name="pessoafisicaid", referencedColumnName = "id",nullable = false)
    @ManyToOne
    private PessoaFisica pessoaFisica;//10
    
    @OneToMany(mappedBy = "vendaId", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<ItemDeVenda> itensDeVenda = new ArrayList<>();//11

    public Venda() {
        constroiCaixaItensDataHora();
        
    }    

    private Venda(VendaBuilder vendaBuilder) {
        this.id = vendaBuilder.id;
        this.data = vendaBuilder.data;
        this.hora = vendaBuilder.hora;
        this.dataDeVencimento = vendaBuilder.dataDeVencimento;
        this.observacao = vendaBuilder.observacao;
        this.valorDoDesconto = vendaBuilder.valorDoDesconto;
        this.valorTotal = vendaBuilder.valorTotal;
        this.status = vendaBuilder.status;
        this.pessoaFisica = vendaBuilder.pessoaFisica;
        //this.itensDeVenda = new ArrayList<>();
        constroiCaixaItensDataHora();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(String dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public float getValorDoDesconto() {
        return valorDoDesconto;
    }

    public void setValorDoDesconto(float valorDoDesconto) {
        this.valorDoDesconto = valorDoDesconto;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public List<ItemDeVenda> getItensDeVenda() {
        return itensDeVenda;
    }

    public void setItensDeVenda(List<ItemDeVenda> itensDeVenda) {
        this.itensDeVenda = itensDeVenda;
    }

    public String getUserCaixa() {
        return userCaixa;
    }

    public void setUserCaixa(String userCaixa) {
        this.userCaixa = userCaixa;
    }
    
    public int quantidadeDeItensNaLista(){
        return itensDeVenda.size();
    }

    private void constroiCaixaItensDataHora() {
        this.itensDeVenda = new ArrayList<>(); 
        dataHora();
        setUserCaixa("Eliel");
    }

    
    public static class VendaBuilder {

        private int id;
        private String data;
        private String hora;
        private String dataDeVencimento;
        private String observacao;
        private float valorDoDesconto;
        private float valorTotal;
        private boolean status;
        private PessoaFisica pessoaFisica;
        private String userCaixa;
        private List<ItemDeVenda> itensDeVenda;

        public VendaBuilder() {
            this.itensDeVenda = new ArrayList<>();
        }

        public VendaBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public VendaBuilder setData(String data) {
            this.data = data;
            return this;
        }

        public VendaBuilder setHora(String hora) {
            this.hora = hora;
            return this;
        }

        public VendaBuilder setDataDeVencimento(String dataDeVencimento) {
            this.dataDeVencimento = dataDeVencimento;
            return this;
        }

        public VendaBuilder setObservacao(String observacao) {
            this.observacao = observacao;
            return this;
        }

        public VendaBuilder setValorDoDesconto(float valorDoDesconto) {
            this.valorDoDesconto = valorDoDesconto;
            return this;
        }

        public VendaBuilder setValorTotal(float valorTotal) {
            this.valorTotal = valorTotal;
            return this;
        }

        public VendaBuilder setStatus(boolean status) {
            this.status = status;
            return this;
        }

        public VendaBuilder setUserCaixa(String userCaixa) {
            this.userCaixa = userCaixa;
            return this;
        }

        public VendaBuilder setPessoaFisica(PessoaFisica pessoaFisica) {
            this.pessoaFisica = pessoaFisica;
            return this;
        }

        public VendaBuilder setItensDeVenda(List<ItemDeVenda> itensDeVenda) {
            this.itensDeVenda = itensDeVenda;
            return this;
        }

        public Venda createVenda() {
            if(this == null){
                return new Venda();
            }else{
                return new Venda(this);
            }
        }
    }
    

    
    public  void adicionarItem(int quantidade, Produto produto){
        ItemDeVenda itemDeVenda = new ItemDeVenda.ItemDeVendaBuilder()
                .setQuantidade(quantidade)
                .setProduto(produto)
                .createItemDeVenda();
        for(ItemDeVenda i : itensDeVenda){
            if(itemDeVenda.getProduto().getId() == i.getProduto().getId()){
                i.setQuantidade(itemDeVenda.getQuantidade() + i.getQuantidade());
                i.atualizarSubTotal();
                return;
            }
        }
        itemDeVenda.atualizarSubTotal();
        itensDeVenda.add(itemDeVenda);
    }
    
    public  void adicionarItem(Produto produto){
        adicionarItem(1,produto);
    }
    
    public void removerItemDaLista(Produto produto){
        
        for(ItemDeVenda i : itensDeVenda){
            if (i.getProduto().getId() == produto.getId()){
                if (i.getQuantidade() > 1){
                    i.setQuantidade(i.getQuantidade() -1 );
                    break;
                } else if (i.getQuantidade() == 1){
                    itensDeVenda.remove(i);
                    break;
                }
            }
        }
    }
    
    public boolean existeItemNaLista(int idDaLinhaSelecionada) {
        if(idDaLinhaSelecionada > itensDeVenda.size())
            return false;        
        return true;
    }
    private void dataHora() {

        // data/hora atual
        LocalDateTime agora = LocalDateTime.now();

        // formatar a data
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        this.setData(formatterData.format(agora));

        //30 dias para pagamento
        this.setDataDeVencimento(formatterData.format(agora.plusMonths(1)));
        
        // formatar a hora
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.setHora(formatterHora.format(agora));

    }
    
    public void removerTodosOsItensDaLista(){
        itensDeVenda.clear();
    }
    
   
    
    public float calcularValorTotal(){
       float total = 0;
        
        for (ItemDeVenda itemDeVenda : itensDeVenda){
            total += itemDeVenda.calcularSubTotal();
        }
        return total;
    }
}
