package com.mycompany.projetolojajpamaven.model.bo;

import com.mycompany.projetolojajpamaven.model.bo.Produto;
import com.mycompany.projetolojajpamaven.model.bo.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-06T21:17:26")
@StaticMetamodel(ItemDeVenda.class)
public class ItemDeVenda_ { 

    public static volatile SingularAttribute<ItemDeVenda, Venda> vendaId;
    public static volatile SingularAttribute<ItemDeVenda, Produto> produto;
    public static volatile SingularAttribute<ItemDeVenda, Integer> id;
    public static volatile SingularAttribute<ItemDeVenda, Float> subTotal;
    public static volatile SingularAttribute<ItemDeVenda, Integer> quantidade;

}