package com.mycompany.projetolojajpamaven.model.bo;

import com.mycompany.projetolojajpamaven.model.bo.Fornecedor;
import com.mycompany.projetolojajpamaven.model.bo.ItemDeCompra;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-06T23:12:40")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, String> userCaixa;
    public static volatile SingularAttribute<Compra, String> observacao;
    public static volatile ListAttribute<Compra, ItemDeCompra> itensDeCompra;
    public static volatile SingularAttribute<Compra, String> data;
    public static volatile SingularAttribute<Compra, String> hora;
    public static volatile SingularAttribute<Compra, Float> valorTotal;
    public static volatile SingularAttribute<Compra, String> dataDeVencimento;
    public static volatile SingularAttribute<Compra, Integer> id;
    public static volatile SingularAttribute<Compra, Fornecedor> fornecedor;
    public static volatile SingularAttribute<Compra, Float> valorDeDesconto;
    public static volatile SingularAttribute<Compra, Boolean> status;

}