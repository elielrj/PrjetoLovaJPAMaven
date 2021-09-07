package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Endereco;
import com.mycompany.projetolojajpamaven.model.DAO.EnderecoDAO;

public class ServiceEndereco {

    public static void Incluir(Endereco objeto) {
        EnderecoDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(Endereco objeto) {
        EnderecoDAO.getInstance().Update(objeto);
    }

    public static List<Endereco> Buscar() {
        return EnderecoDAO.getInstance().Retrieve();
    }

    public static Endereco Buscar(int id) {
       return EnderecoDAO.getInstance().Retrieve(id);
    }

    public static void Deletar(Endereco objeto) {
        EnderecoDAO.getInstance().Delete(objeto);
    }

    public static void Deletar(int idEndereco) {
        EnderecoDAO.getInstance().Delete(idEndereco);
    }

    public static int BuscarPorId(Endereco endereco) {
        return EnderecoDAO.getInstance().RetrievePorId(endereco);
    }
}
