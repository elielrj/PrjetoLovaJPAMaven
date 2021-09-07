package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Produto;
import com.mycompany.projetolojajpamaven.model.DAO.ProdutoDAO;

public class ServiceProduto {

    public static void Incluir(Produto objeto) {
        ProdutoDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(Produto objeto) {
        ProdutoDAO.getInstance().Update(objeto);
    }

    public static List<Produto> Buscar() {
       return ProdutoDAO.getInstance().Retrieve();
    }

    public static Produto Buscar(int id) {
      return ProdutoDAO.getInstance().Retrieve(id);
    }

    public static Produto Buscar(String codigoDeBarrasDoProduto) {
       return ProdutoDAO.getInstance().Retrieve(codigoDeBarrasDoProduto);
    }
    
    public static void Deletar(Produto objeto) {
        ProdutoDAO.getInstance().Delete(objeto);
    }
    
    public static void Deletar(int idProduto) {
        ProdutoDAO.getInstance().Delete(idProduto);
    }
    
    public static boolean codigoDeBarrasValido(String codBarras){
       return ProdutoDAO.getInstance().codigoDeBarrasValido(codBarras);
        
    }
}
