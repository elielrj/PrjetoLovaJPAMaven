package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.ItemDeCompra;
import com.mycompany.projetolojajpamaven.model.DAO.ItemDeCompraDAO;

public class ServiceItemDeCompra {

    public static void Incluir(ItemDeCompra objeto) {
        ItemDeCompraDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(ItemDeCompra objeto) {
        ItemDeCompraDAO.getInstance().Update(objeto);
    }

    public static List<ItemDeCompra> Buscar() {
       return ItemDeCompraDAO.getInstance().Retrieve();
    }

    public static ItemDeCompra Buscar(int id) {
       return ItemDeCompraDAO.getInstance().Retrieve(id);
    }

    public static void Deletar(ItemDeCompra objeto) {
        ItemDeCompraDAO.getInstance().Delete(objeto);
    }
    
    public static List<ItemDeCompra> BuscarListaDeUmaCompra(int idDaCompra) {
       return ItemDeCompraDAO.getInstance().RetrieveListaDeUmaCompra(idDaCompra);
    }
}
