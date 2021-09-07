package com.mycompany.projetolojajpamaven.model.bo;

import com.mycompany.projetolojajpamaven.model.bo.ContaAPagar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-06T21:17:26")
@StaticMetamodel(Pagar.class)
public class Pagar_ { 

    public static volatile SingularAttribute<Pagar, ContaAPagar> contaAPagar;
    public static volatile SingularAttribute<Pagar, String> observacao;
    public static volatile SingularAttribute<Pagar, String> dataPagamento;
    public static volatile SingularAttribute<Pagar, Float> valorAcrescimo;
    public static volatile SingularAttribute<Pagar, String> hora;
    public static volatile SingularAttribute<Pagar, Float> valorPago;
    public static volatile SingularAttribute<Pagar, Integer> id;

}