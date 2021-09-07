package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Receber;
import com.mycompany.projetolojajpamaven.model.DAO.ReceberDAO;

public class ServiceItemDeReceber {

    public static void Incluir(Receber objeto) {
        ReceberDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(Receber objeto) {
        ReceberDAO.getInstance().Update(objeto);
    }

    public static List<Receber> Buscar() {
       return ReceberDAO.getInstance().Retrieve();
    }

    public static Receber Buscar(int id) {
      return ReceberDAO.getInstance().Retrieve(id);
    }

    public static void Deletar(Receber objeto) {
        ReceberDAO.getInstance().Delete(objeto);
    }
}
