package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Pagar;
import com.mycompany.projetolojajpamaven.model.DAO.PagarDAO;

public class ServicePagar {

    public static void Incluir(Pagar objeto) {
        PagarDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(Pagar objeto) {
        PagarDAO.getInstance().Update(objeto);
    }

    public static List<Pagar> Buscar() {
       return PagarDAO.getInstance().Retrieve();
    }

    public static Pagar Buscar(int id) {
       return PagarDAO.getInstance().Retrieve(id);
    }

    public static void Deletar(Pagar objeto) {
        PagarDAO.getInstance().Delete(objeto);
    }
    public static void Deletar(int idPagar) {
        PagarDAO.getInstance().Delete(idPagar);
    }
}
