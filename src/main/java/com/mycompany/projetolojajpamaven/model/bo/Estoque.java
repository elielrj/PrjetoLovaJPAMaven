package com.mycompany.projetolojajpamaven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "estoque")
public class Estoque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name="id")
    private int id;
    
    //@JoinColumn(name="produtoid")
    //@ManyToOne
    @Column(name="produtoid")
    private int produtoId;
    
    @Column(name="quantidade")
    private int quantidade;

    public Estoque() {
    }

    private Estoque(EstoqueBuilder estoqueBuilder) {
        this.id = estoqueBuilder.id;
        this.produtoId = estoqueBuilder.produtoId;
        this.quantidade = estoqueBuilder.quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public static class EstoqueBuilder {

        private int id;
        private int produtoId;
        private int quantidade;

        public EstoqueBuilder() {
        }

        public EstoqueBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public EstoqueBuilder setProdutoId(int produtoId) {
            this.produtoId = produtoId;
            return this;
        }

        public EstoqueBuilder setQuantidade(int quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public Estoque createEstoque() {
            return new Estoque(this);
        }

    }
}
