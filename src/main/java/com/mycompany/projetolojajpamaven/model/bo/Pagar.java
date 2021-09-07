package com.mycompany.projetolojajpamaven.model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "pagar")
public class Pagar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name="id")
    private int id;//1
    
    @Column(name="datapagamento")
    private String dataPagamento;//2
    
    @Column(name="hora")
    private String hora;//3
   // private float valorDesconto;//4
    
    @Column(name="valoracrescimo")
    private float valorAcrescimo;//5
    
    @Column(name="valorpago")
    private float valorPago;//6
    
    @Column(name="observacao")
    private String observacao;//7
    //private Compra compra;//8
    //private boolean status;//9
    
    @JoinColumn(name="contaapagarid")
    @ManyToOne
    private ContaAPagar contaAPagar;

    public Pagar() {
    }

    private Pagar(PagarBuilder pagarBuilder) {
        this.id = pagarBuilder.id;
        this.dataPagamento = pagarBuilder.dataPagamento;
        this.hora = pagarBuilder.hora;
        //this.valorDesconto = pagarBuilder.valorDesconto;
        this.valorAcrescimo = pagarBuilder.valorAcrescimo;
        this.valorPago = pagarBuilder.valorPago;
        this.observacao = pagarBuilder.observacao;
        this.contaAPagar = pagarBuilder.contaAPagar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
    public float getValorAcrescimo() {
        return valorAcrescimo;
    }

    public void setValorAcrescimo(float valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public ContaAPagar getContaAPagar() {
        return contaAPagar;
    }

    public void setContaAPagar(ContaAPagar contaAPagar) {
        this.contaAPagar = contaAPagar;
    }

    public static class PagarBuilder {

        private int id;
        private String dataPagamento;
        private String hora;
       // private float valorDesconto;
        private float valorAcrescimo;
        private float valorPago;
        private String observacao;
  //      private Compra compra;
//        private boolean status;
        private ContaAPagar contaAPagar;


        public PagarBuilder() {
        }

        public PagarBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public PagarBuilder setDataPagamento(String dataPagamento) {
            this.dataPagamento = dataPagamento;
            return this;
        }

        public PagarBuilder setHora(String hora) {
            this.hora = hora;
            return this;
        }

        
        public PagarBuilder setValorAcrescimo(float valorDeAcrescimo) {
            this.valorAcrescimo = valorDeAcrescimo;
            return this;
        }

        public PagarBuilder setValorPago(float valorPago) {
            this.valorPago = valorPago;
            return this;
        }

        public PagarBuilder setContaAPagar(ContaAPagar contaAPagar) {
            this.contaAPagar = contaAPagar;
            return this;
        }

        public PagarBuilder setObservacao(String observacao) {
            this.observacao = observacao;
            return this;
        }

        public Pagar createPagar() {
            return new Pagar(this);
        }

    }

}
