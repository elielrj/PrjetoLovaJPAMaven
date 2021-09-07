package com.mycompany.projetolojajpamaven.model.bo;

import com.mycompany.projetolojajpamaven.model.bo.ContaAReceber;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-06T23:12:40")
@StaticMetamodel(Receber.class)
public class Receber_ { 

    public static volatile SingularAttribute<Receber, String> observacao;
    public static volatile SingularAttribute<Receber, Float> valorAcrescimo;
    public static volatile SingularAttribute<Receber, String> hora;
    public static volatile SingularAttribute<Receber, Integer> id;
    public static volatile SingularAttribute<Receber, ContaAReceber> contaAReceber;
    public static volatile SingularAttribute<Receber, String> dataRecebimento;
    public static volatile SingularAttribute<Receber, Float> valorRecebido;

}