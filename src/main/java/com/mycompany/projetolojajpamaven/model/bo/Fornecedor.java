package com.mycompany.projetolojajpamaven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "fornecedor")
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name="id")
    private int id;//1
    
    @Column(name="razaosocial")
    private String razaoSocial;//2
    
    @Column(name="inscricaoestadual")
    private String inscricaoEstadual;//3
    
    @Column(name="cnpj")
    private String cnpj;//4
    
    @JoinColumn(name="enderecoid")
    @ManyToOne
    private Endereco endereco;//5
    
    @Column(name="telefone1")
    private String telefone1;//6
    
    @Column(name="telefone2")
    private String telefone2;//7
    
    @Column(name="email")
    private String email;//8
    
    @Column(name="observacao")
    private String observacao;//9
    
    @Column(name="status")
    private boolean status;//10
    
    @Column(name="complemento")
    private String complemento;//11

    public Fornecedor() {
    }

    private Fornecedor(FornecedorBuilder fornecedorBuilder) {
        this.id = fornecedorBuilder.id;
        this.razaoSocial = fornecedorBuilder.razaoSocial;
        this.inscricaoEstadual = fornecedorBuilder.inscricaoEstadual;
        this.cnpj = fornecedorBuilder.cnpj;
        this.endereco = fornecedorBuilder.endereco;
        this.telefone1 = fornecedorBuilder.telefone1;
        this.telefone2 = fornecedorBuilder.telefone2;
        this.email = fornecedorBuilder.email;
        this.observacao = fornecedorBuilder.observacao;
        this.status = fornecedorBuilder.status;
        this.complemento = fornecedorBuilder.complemento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public static class FornecedorBuilder {

        private int id;
        private String razaoSocial;
        private String inscricaoEstadual;
        private String cnpj;
        private Endereco endereco;
        private String telefone1;
        private String telefone2;
        private String email;
        private String observacao;
        private boolean status;
        private String complemento;

        public FornecedorBuilder() {
        }

        public FornecedorBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public FornecedorBuilder setRazaoSocial(String razaoSocial) {
            this.razaoSocial = razaoSocial;
            return this;
        }

        public FornecedorBuilder setInscricaoEstadual(String inscricaoEstadual) {
            this.inscricaoEstadual = inscricaoEstadual;
            return this;
        }

        public FornecedorBuilder setCnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public FornecedorBuilder setEndereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public FornecedorBuilder setTelefone1(String telefone1) {
            this.telefone1 = telefone1;
            return this;
        }

        public FornecedorBuilder setTelefone2(String telefone2) {
            this.telefone2 = telefone2;
            return this;
        }

        public FornecedorBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public FornecedorBuilder setObservacao(String observacao) {
            this.observacao = observacao;
            return this;
        }

        public FornecedorBuilder setStatus(boolean status) {
            this.status = status;
            return this;
        }

        public FornecedorBuilder setComplemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public Fornecedor createFornecedor() {
            return new Fornecedor(this);
        }

    }

    

}
