package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Pagar;
import com.mycompany.projetolojajpamaven.model.DAO.PagarDAO;

public class ServicePagar {

    public static void Incluir(Pagar objeto) {
        PagarDAO pagarDAO = new PagarDAO();
        pagarDAO.Create(objeto);
    }

    public static void Atualizar(Pagar objeto) {
        PagarDAO pagarDAO = new PagarDAO();
        pagarDAO.Update(objeto);
    }

    public static List<Pagar> Buscar() {
        PagarDAO pagarDAO = new PagarDAO();
        return (pagarDAO.Retrieve());
    }

    public static Pagar Buscar(int id) {
        PagarDAO pagarDAO = new PagarDAO();
        return pagarDAO.Retrieve(id);
    }

    public static void Deletar(Pagar objeto) {
        PagarDAO pagarDAO = new PagarDAO();
        pagarDAO.Delete(objeto);
    }
    public static void Deletar(int idPagar) {
        PagarDAO pagarDAO = new PagarDAO();
        pagarDAO.Delete(idPagar);
    }
}
