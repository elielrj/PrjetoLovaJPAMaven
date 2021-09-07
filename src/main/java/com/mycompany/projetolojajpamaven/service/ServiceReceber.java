package com.mycompany.projetolojajpamaven.service;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Receber;
import com.mycompany.projetolojajpamaven.model.DAO.ReceberDAO;

public class ServiceReceber {

    public static void Incluir(Receber objeto) {
        ReceberDAO.getInstance().Create(objeto);
    }

    public static void Atualizar(Receber objeto) {
        ReceberDAO.getInstance().Update(objeto);
    }

    public static List<Receber> Buscar() {
      return ReceberDAO.getInstance().Retrieve();
    }
  /*  
    public static List<Receber> BuscarPorVendasNaoRecebidas() {
      return ReceberDAO.getInstance().RetrieveBuscarPorVendasNaoRecebidas();
    } 
*/
    public static List<Receber> BuscarPorVendasRecebidas(int idContaAReceber) {
      return ReceberDAO.getInstance().RetrieveBuscarPorVendasRecebidas(idContaAReceber);
    }

    public static Receber Buscar(int id) {
      return ReceberDAO.getInstance().Retrieve(id);
    }
    
    public static Receber BuscarPorUmaIdVendaRecebido(int idVenda) {
     return ReceberDAO.getInstance().RetrievePorUmaIdVendaRecebido(idVenda);  
    }

    public static void Deletar(Receber objeto) {
        ReceberDAO.getInstance().Delete(objeto);
    }
    public static void Deletar(int idReceber) {
        ReceberDAO.getInstance().Delete(idReceber);
    }
}
