package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Venda;
import com.mycompany.projetolojajpamaven.model.DAO.VendaDAO;
import com.mycompany.projetolojajpamaven.model.bo.PessoaFisica;

public class ServiceVenda {

    public static void Incluir(Venda objeto) {
        VendaDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(Venda objeto) {
        VendaDAO.getInstance().Update(objeto);
    }

    public static List<Venda> Buscar() {
      return VendaDAO.getInstance().Retrieve();
    }

    public static Venda Buscar(int id) {
      return VendaDAO.getInstance().Retrieve(id);
    }
    
    public static int BuscarObjetoVendaPeloClienteValorTotalEData(Venda venda) {
       return VendaDAO.getInstance().RetrieveObjetoVendaPeloClienteValorTotalEData(venda);
    }

    public static void Deletar(Venda objeto) {
        VendaDAO.getInstance().Delete(objeto);
    }
    /*
    public static void Deletar(int idVenda) {
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.Delete(idVenda);
    }*/
    
    public static  List<Venda> RetriveBuscaVendaDeUmCliente(PessoaFisica pessoaFisica){
      return VendaDAO.getInstance().RetrieveBuscaVendaDeUmCliente(pessoaFisica);
    }
    public static  List<Venda> RetriveBuscaVendaDeUmClientePelaIDPFeData(PessoaFisica pessoaFisica, String data){
      return VendaDAO.getInstance().RetrieveBuscaVendaDeUmClientePorIDPFeData(pessoaFisica, data);
    }
    
    public static int BuscarProximoId(){
        return VendaDAO.getInstance().BuscarProximoId();
    }
}
