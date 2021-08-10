package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.ItemDeCompra;
import com.mycompany.projetolojajpamaven.model.DAO.ItemDeCompraDAO;

public class ServiceItemDeCompra {

    public static void Incluir(ItemDeCompra objeto) {
        ItemDeCompraDAO itemDeCompraDAO = new ItemDeCompraDAO();
        itemDeCompraDAO.Create(objeto);
    }

    public static void Atualizar(ItemDeCompra objeto) {
        ItemDeCompraDAO itemDeCompraDAO = new ItemDeCompraDAO();
        itemDeCompraDAO.Update(objeto);
    }

    public static List<ItemDeCompra> Buscar() {
        ItemDeCompraDAO itemDeCompraDAO = new ItemDeCompraDAO();
        return (itemDeCompraDAO.Retrieve());
    }

    public static ItemDeCompra Buscar(int id) {
        ItemDeCompraDAO itemDeCompraDAO = new ItemDeCompraDAO();
        return itemDeCompraDAO.Retrieve(id);
    }

    public static void Deletar(ItemDeCompra objeto) {
        ItemDeCompraDAO itemDeCompraDAO = new ItemDeCompraDAO();
        itemDeCompraDAO.Delete(objeto);
    }
    
    public static List<ItemDeCompra> BuscarListaDeUmaCompra(int idDaCompra) {
        ItemDeCompraDAO itemDeCompraDAO = new ItemDeCompraDAO();
        return itemDeCompraDAO.RetrieveListaDeUmaCompra(idDaCompra);
    }
}
