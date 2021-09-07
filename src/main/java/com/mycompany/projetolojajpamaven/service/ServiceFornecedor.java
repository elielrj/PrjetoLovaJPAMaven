package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Fornecedor;
import com.mycompany.projetolojajpamaven.model.DAO.FornecedorDAO;

public class ServiceFornecedor {

    public static void Incluir(Fornecedor objeto) {
        FornecedorDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(Fornecedor objeto) {
        FornecedorDAO.getInstance().Update(objeto);
    }

    public static List<Fornecedor> Buscar() {
       return FornecedorDAO.getInstance().Retrieve();
    }

    public static Fornecedor Buscar(int id) {
       return FornecedorDAO.getInstance().Retrieve(id);
    }

    public static void Deletar(Fornecedor objeto) {
        FornecedorDAO.getInstance().Delete(objeto);
    }
    
    public static void Deletar(int idFornecedor) {
        FornecedorDAO.getInstance().Delete(idFornecedor);
    }
}
