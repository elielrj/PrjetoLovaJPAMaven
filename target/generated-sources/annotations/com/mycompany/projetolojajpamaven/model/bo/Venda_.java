package com.mycompany.projetolojajpamaven.model.bo;

import com.mycompany.projetolojajpamaven.model.bo.ItemDeVenda;
import com.mycompany.projetolojajpamaven.model.bo.PessoaFisica;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-09-06T23:12:40")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, String> userCaixa;
    public static volatile SingularAttribute<Venda, PessoaFisica> pessoaFisica;
    public static volatile SingularAttribute<Venda, String> observacao;
    public static volatile SingularAttribute<Venda, Float> valorDoDesconto;
    public static volatile SingularAttribute<Venda, String> data;
    public static volatile SingularAttribute<Venda, String> hora;
    public static volatile SingularAttribute<Venda, Float> valorTotal;
    public static volatile SingularAttribute<Venda, String> dataDeVencimento;
    public static volatile SingularAttribute<Venda, Integer> id;
    public static volatile ListAttribute<Venda, ItemDeVenda> itensDeVenda;
    public static volatile SingularAttribute<Venda, Boolean> status;

}