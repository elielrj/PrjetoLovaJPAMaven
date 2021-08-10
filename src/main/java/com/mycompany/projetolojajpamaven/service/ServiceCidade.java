package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Cidade;
import com.mycompany.projetolojajpamaven.model.DAO.CidadeDAO;

public class ServiceCidade {

    public static void Incluir(Cidade objeto) {
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidadeDAO.Create(objeto);
    }

    public static void Atualizar(Cidade objeto) {
        
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidadeDAO.Update(objeto);
        
    }

    public static List<Cidade> Buscar() {
        
            CidadeDAO cidadeDAO = new CidadeDAO();
            return (cidadeDAO.Retrieve());
        
    }

    public static Cidade Buscar(int id) {
            CidadeDAO cidadeDAO = new CidadeDAO();
            return cidadeDAO.Retrieve(id);
        
    }

    public static void Deletar(Cidade objeto) {
        
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidadeDAO.Delete(objeto);
        
    }

    public static void Deletar(int idCidade) {
        
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidadeDAO.Delete(idCidade);
        
    }
}
