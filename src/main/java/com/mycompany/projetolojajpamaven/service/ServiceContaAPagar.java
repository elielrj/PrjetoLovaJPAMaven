package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.ContaAPagar;
import com.mycompany.projetolojajpamaven.model.DAO.ContaAPagarDAO;

public class ServiceContaAPagar {

    public static void Incluir(ContaAPagar objeto) {
        ContaAPagarDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(ContaAPagar objeto) {
        ContaAPagarDAO.getInstance().Update(objeto);
    }

    public static List<ContaAPagar> Buscar() {
        return ContaAPagarDAO.getInstance().Retrieve();
    }

    public static ContaAPagar Buscar(int id) {
        return ContaAPagarDAO.getInstance().Retrieve(id);
    }

    public static void Deletar(ContaAPagar objeto) {
        ContaAPagarDAO.getInstance().Delete(objeto);
    }

    public static ContaAPagar BuscarIdDaContaAPagarPeloIdDaCompra(int idDaCompra) {
        return ContaAPagarDAO.getInstance().RetrieveIdDaContaAPagarrPeloIdDaCompra(idDaCompra);
    }
}
