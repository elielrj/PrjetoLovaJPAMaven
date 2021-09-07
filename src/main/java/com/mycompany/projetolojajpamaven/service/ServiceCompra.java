package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Compra;
import com.mycompany.projetolojajpamaven.model.DAO.CompraDAO;

public class ServiceCompra {

    public static void Incluir(Compra objeto) {
        CompraDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(Compra objeto) {
        CompraDAO.getInstance().Update(objeto);
    }

    public static List<Compra> Buscar() {
        return CompraDAO.getInstance().Retrieve();
    }

    public static Compra Buscar(int id) {
        return CompraDAO.getInstance().Retrieve(id);
    }

    public static void Deletar(Compra objeto) {
        CompraDAO.getInstance().Delete(objeto);
    }
    
    public static void Deletar(int idDaCompra) {
        CompraDAO.getInstance().Delete(idDaCompra);
    }
    
    public static int Buscar(Compra compra) {
        return CompraDAO.getInstance().Retrieve(compra).getId();
    }
}
