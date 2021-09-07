package com.mycompany.projetolojajpamaven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id")
    private int id;//1
    
    @Column(name="logradouro")
    private String logradouro;//2
    
    @Column(name="numero")
    private String numero;//3
    
    @JoinColumn(name="bairroid")
    @ManyToOne
    private Bairro bairro;//4
    
    @Column(name="cep")
    private String cep;//5
    
    @Column(name="status")
    private boolean status;//6

    public Endereco() {
    }

    private Endereco(EnderecoBuilder enderecoBuilder) {
        this.id = enderecoBuilder.id;
        this.logradouro = enderecoBuilder.logradouro;
        this.numero = enderecoBuilder.numero;
        this.bairro = enderecoBuilder.bairro;
        this.cep = enderecoBuilder.cep;
        this.status = enderecoBuilder.status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class EnderecoBuilder {

        private int id;
        private String logradouro;
        private String numero;
        private Bairro bairro;
        private String cep;
        private boolean status;

        public EnderecoBuilder() {
        }

        public EnderecoBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public EnderecoBuilder setLogradouro(String logradouro) {
            this.logradouro = logradouro;
            return this;
        }

        public EnderecoBuilder setNumero(String numero) {
            this.numero = numero;
            return this;
        }

        public EnderecoBuilder setBairro(Bairro bairro) {
            this.bairro = bairro;
            return this;
        }

        public EnderecoBuilder setCep(String cep) {
            this.cep = cep;
            return this;
        }

        public EnderecoBuilder setStatus(boolean status) {
            this.status = status;
            return this;
        }

        public Endereco createEndereco() {
            return new Endereco(this);
        }

    }

    @Override
    public String toString() {
        return "Rua " + logradouro + "Nr " + numero + "Bairro" + bairro;
    }
}
