package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Estoque;
import com.mycompany.projetolojajpamaven.model.DAO.EstoqueDAO;

public class ServiceEstoque {

    public static void Incluir(Estoque objeto) {
        EstoqueDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(Estoque objeto) {
        EstoqueDAO.getInstance().Update(objeto);
    }

    public static List<Estoque> Buscar() {
       return EstoqueDAO.getInstance().Retrieve();
    }

    public static Estoque Buscar(int id) {
       return EstoqueDAO.getInstance().Retrieve(id);
    }
    
    public static void Deletar(Estoque objeto) {
        EstoqueDAO.getInstance().Delete(objeto);
    }
    
    public static Estoque BuscarEstoquePorIdDoProduto(int idDoProduto) {
      return EstoqueDAO.getInstance().RetrievePorIdDoProduto(idDoProduto);
    }
    
    public static Estoque BuscarEstoquePorIdPeloProduto(int idDoProduto) {
        return EstoqueDAO.getInstance().RetrievePorIdDoProduto(idDoProduto);
    }
    
    
    public static int BuscarAQuantidadeNoEstoqueComOIdDoProduto(int idDoProduto) {
       return EstoqueDAO.getInstance().BuscarAQuantidadeNoEstoqueComOIdDoProduto(idDoProduto);
    }
}
