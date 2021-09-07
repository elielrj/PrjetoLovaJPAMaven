package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.ContaAReceber;
import com.mycompany.projetolojajpamaven.model.DAO.ContaAReceberDAO;

public class ServiceContaAReceber {

    public static void Incluir(ContaAReceber objeto) {
        ContaAReceberDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(ContaAReceber objeto) {
        ContaAReceberDAO.getInstance().Update(objeto);
    }

    public static List<ContaAReceber> Buscar() {
       return  ContaAReceberDAO.getInstance().Retrieve();
    }

    public static ContaAReceber Buscar(int id) {
       return ContaAReceberDAO.getInstance().Retrieve(id);
    }

    public static void Deletar(ContaAReceber objeto) {
        ContaAReceberDAO.getInstance().Delete(objeto);
    }


    public static ContaAReceber BuscarIdDaContaAReceberPeloIdDaVenda(int idDaVenda) {
        return ContaAReceberDAO.getInstance().RetrieveIdDaContaAReceberPeloIdDaVenda(idDaVenda);
    }
}
