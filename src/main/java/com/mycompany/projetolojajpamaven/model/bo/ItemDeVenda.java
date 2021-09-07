package com.mycompany.projetolojajpamaven.model.bo;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "itemdevenda")
public class ItemDeVenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name="id")
    private int id;//1
    
    @Column(name="quantidade")
    private int quantidade;//3
    
    @JoinColumn(name="produtoid")
    @ManyToOne
    private Produto produto;//4
    
    @Column(name="subtotal")
    private float subTotal;//5
    
    @NotNull
    @ManyToOne//(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendaid", referencedColumnName = "id", nullable = false)
    private Venda vendaId;//6

    public ItemDeVenda() {
    }

    private ItemDeVenda(ItemDeVendaBuilder itemDeVendaBuilder) {
        this.id = itemDeVendaBuilder.id;
        this.quantidade = itemDeVendaBuilder.quantidade;
        this.produto = itemDeVendaBuilder.produto;
        this.subTotal = itemDeVendaBuilder.subTotal;
        this.vendaId = itemDeVendaBuilder.vendaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public Venda getVendaId() {
        return vendaId;
    }

    public void setVendaId(Venda vendaId) {
        this.vendaId = vendaId;
    }

    public static class ItemDeVendaBuilder {

        private int id;
        private boolean status;
        private int quantidade;
        private Produto produto;
        private float subTotal;
        private Venda vendaId;

        public ItemDeVendaBuilder() {
        }

        public ItemDeVendaBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ItemDeVendaBuilder setQuantidade(int quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public ItemDeVendaBuilder setProduto(Produto produto) {
            this.produto = produto;
            return this;
        }

        public ItemDeVendaBuilder setVendaId(Venda vendaId) {
            this.vendaId = vendaId;
            return this;
        }
        
        public ItemDeVendaBuilder setSubTotal(float subTotal) {
            this.subTotal = subTotal;
            return this;
        }

        public ItemDeVenda createItemDeVenda() {
            this.subTotal = quantidade * produto.getValor();
            return new ItemDeVenda(this);
        }

    }
    
    public Float calcularSubTotal(){
        subTotal = quantidade * produto.getValor();
        return subTotal;
    }
    
    public void atualizarSubTotal(){
        subTotal = quantidade * produto.getValor();
    }

}
