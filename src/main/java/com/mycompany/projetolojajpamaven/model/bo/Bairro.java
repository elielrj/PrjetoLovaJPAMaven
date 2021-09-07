package com.mycompany.projetolojajpamaven.model.bo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="bairro")
public class Bairro implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="nome")
    private String nome;    //OBRIGATÓRIO
    
    @Column(name="status")
    private boolean status; //OBRIGATÓRIO
    
    @JoinColumn(name="cidadeid")
    @ManyToOne
    private Cidade cidade;  //OBRIGATÓRIO

    public Bairro() {
    }

  

    private Bairro(BairroBuilder bairroBuilder) {
        this.id = bairroBuilder.id;
        this.nome = bairroBuilder.nome;
        this.status = bairroBuilder.status;
        this.cidade = bairroBuilder.cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static class BairroBuilder {

        private int id;
        private String nome;
        private boolean status;
        private Cidade cidade;

        public BairroBuilder() {
        }

        public BairroBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public BairroBuilder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public BairroBuilder setStatus(boolean status) {
            this.status = status;
            return this;
        }

        public BairroBuilder setCidade(Cidade cidade) {
            this.cidade = cidade;
            return this;
        }

        public Bairro createBairro() {
            return new Bairro(this);
        }
    
    }

    

}
