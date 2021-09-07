package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.ItemDeVenda;
import com.mycompany.projetolojajpamaven.model.DAO.ItemDeVendaDAO;

public class ServiceItemDeVenda {

    public static void Incluir(ItemDeVenda objeto) {
        ItemDeVendaDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(ItemDeVenda objeto) {
        ItemDeVendaDAO.getInstance().Update(objeto);
    }

    public static List<ItemDeVenda> Buscar() {
      return ItemDeVendaDAO.getInstance().Retrieve();
    }

    public static ItemDeVenda Buscar(int id) {
      return ItemDeVendaDAO.getInstance().Retrieve(id);
    }

    public static void Deletar(ItemDeVenda objeto) {
        ItemDeVendaDAO.getInstance().Delete(objeto);
    }
    public static void Deletar(int idVenda) {
        ItemDeVendaDAO.getInstance().Delete(idVenda);
    }
    
    public static List<ItemDeVenda> BuscarUmaListaDeItemDeVendaPeloIdDaVenda(int idDaVenda) {
      return ItemDeVendaDAO.getInstance().RetrieveUmaListaDeItemDeVendaPeloIdDaVenda(idDaVenda);
    }
}
