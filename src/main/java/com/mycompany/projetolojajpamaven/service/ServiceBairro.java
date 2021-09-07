package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Bairro;
import com.mycompany.projetolojajpamaven.model.DAO.BairroDAO;

public class ServiceBairro {

    public static void Incluir(Bairro objeto) {
        BairroDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(Bairro objeto) {
        BairroDAO.getInstance().Update(objeto);
    }

    public static List<Bairro> Buscar() {
        return BairroDAO.getInstance().Retrieve();
    }

    public static Bairro Buscar(int id) {
        return BairroDAO.getInstance().Retrieve(id);
    }

    public static void Deletar(Bairro objeto) {
        BairroDAO.getInstance().Delete(objeto);
    }

    public static void Deletar(int idBairro) {
        BairroDAO.getInstance().Delete(idBairro);
    }

    public static List<Bairro> BuscarPorCidade(int idCidade) {
        return BairroDAO.getInstance().RetrieveForCity(idCidade);
    }

    public static int BuscarIdDaCidade(int idBairro) {
        return BairroDAO.getInstance().RetrieveIdTheCity(idBairro);
    }
}
