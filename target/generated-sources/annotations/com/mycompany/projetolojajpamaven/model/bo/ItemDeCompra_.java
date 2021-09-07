package com.mycompany.projetolojajpamaven.model.bo;

import com.mycompany.projetolojajpamaven.model.bo.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-06T23:12:40")
@StaticMetamodel(ItemDeCompra.class)
public class ItemDeCompra_ { 

    public static volatile SingularAttribute<ItemDeCompra, Produto> produto;
    public static volatile SingularAttribute<ItemDeCompra, Integer> id;
    public static volatile SingularAttribute<ItemDeCompra, Float> subTotal;
    public static volatile SingularAttribute<ItemDeCompra, Integer> quantidade;
    public static volatile SingularAttribute<ItemDeCompra, Integer> compraId;

}