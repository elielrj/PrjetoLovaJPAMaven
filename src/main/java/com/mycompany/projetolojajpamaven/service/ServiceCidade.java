package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Cidade;
import com.mycompany.projetolojajpamaven.model.DAO.CidadeDAO;

public class ServiceCidade {

    public static void Incluir(Cidade objeto) {
        CidadeDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(Cidade objeto) {
        CidadeDAO.getInstance().Update(objeto);
        
    }

    public static List<Cidade> Buscar() {
        return CidadeDAO.getInstance().Retrieve();
    }

    public static Cidade Buscar(int id) {            
            return CidadeDAO.getInstance().Retrieve(id);        
    }

    public static void Deletar(Cidade objeto) {
        CidadeDAO.getInstance().Delete(objeto);
        
    }

    public static void Deletar(int idCidade) {
        CidadeDAO.getInstance().Delete(idCidade);        
    }
}
