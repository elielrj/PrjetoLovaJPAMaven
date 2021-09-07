package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.PessoaFisica;
import com.mycompany.projetolojajpamaven.model.DAO.PessoaFisicaDAO;


public class ServicePessoaFisica {

    public static void Incluir(PessoaFisica objeto) {
        PessoaFisicaDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(PessoaFisica objeto) {
        PessoaFisicaDAO.getInstance().Update(objeto);
    }

    public static List<PessoaFisica> Buscar() {
      return PessoaFisicaDAO.getInstance().Retrieve();
    }

    public static PessoaFisica Buscar(int id) {
       return PessoaFisicaDAO.getInstance().Retrieve(id);
    }

    public static void Deletar(PessoaFisica objeto) {
        PessoaFisicaDAO.getInstance().Delete(objeto);
    }
    
    public static void Deletar(int idPessoaFisica) {
        PessoaFisicaDAO.getInstance().Delete(idPessoaFisica);
    }

    public static List<PessoaFisica> BuscarAluno() {
       return PessoaFisicaDAO.getInstance().RetrieveAluno();
    }

    public static List<PessoaFisica> BuscarPersonal() {
      return PessoaFisicaDAO.getInstance().RetrievePersonal();
    }
}
