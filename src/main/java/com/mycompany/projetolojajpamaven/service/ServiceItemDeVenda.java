package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.ItemDeVenda;
import com.mycompany.projetolojajpamaven.model.DAO.ItemDeVendaDAO;

public class ServiceItemDeVenda {

    public static void Incluir(ItemDeVenda objeto) {
        ItemDeVendaDAO itemDeVendaDAO = new ItemDeVendaDAO();
        itemDeVendaDAO.Create(objeto);
    }

    public static void Atualizar(ItemDeVenda objeto) {
        ItemDeVendaDAO itemDeVendaDAO = new ItemDeVendaDAO();
        itemDeVendaDAO.Update(objeto);
    }

    public static List<ItemDeVenda> Buscar() {
        ItemDeVendaDAO itemDeVendaDAO = new ItemDeVendaDAO();
        return (itemDeVendaDAO.Retrieve());
    }

    public static ItemDeVenda Buscar(int id) {
        ItemDeVendaDAO itemDeVendaDAO = new ItemDeVendaDAO();
        return itemDeVendaDAO.Retrieve(id);
    }

    public static void Deletar(ItemDeVenda objeto) {
        ItemDeVendaDAO itemDeVendaDAO = new ItemDeVendaDAO();
        itemDeVendaDAO.Delete(objeto);
    }
    public static void Deletar(int idVenda) {
        ItemDeVendaDAO itemDeVendaDAO = new ItemDeVendaDAO();
        itemDeVendaDAO.Delete(idVenda);
    }
    
    public static List<ItemDeVenda> BuscarUmaListaDeItemDeVendaPeloIdDaVenda(int idDaVenda) {
        ItemDeVendaDAO itemDeVendaDAO = new ItemDeVendaDAO();
        return itemDeVendaDAO.RetrieveUmaListaDeItemDeVendaPeloIdDaVenda(idDaVenda);
    }
}
