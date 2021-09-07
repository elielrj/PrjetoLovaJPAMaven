package com.mycompany.projetolojajpamaven.model.DAO;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Receber;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static com.mycompany.projetolojajpamaven.service.ServiceReceber.Deletar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReceberDAO implements InterfaceDAO<Receber> {

    private static ReceberDAO instance;
    protected EntityManager entityManager;
    
    public static ReceberDAO getInstance(){
        if(instance == null){
            instance = new ReceberDAO();
        }
        return instance;
    }

    public ReceberDAO() {
        this.entityManager = getEntityManager();
    }
    
    private EntityManager getEntityManager() {
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoLojaJPAMaven");
        
        if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;   
    }
    
    
    @Override
    public void Create(Receber objeto) {
        try{
        entityManager.getTransaction().begin();
        entityManager.persist(objeto);
        entityManager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Receber> Retrieve() {
        List<Receber> listaBairros;
        listaBairros = entityManager.createQuery("Select c From receber c",Receber.class).getResultList();
        return listaBairros;
    }
    /*
     public List<Receber> RetrieveBuscarPorVendasNaoRecebidas() {
         
    }
*/
     public List<Receber> RetrieveBuscarPorVendasRecebidas(int idContaAReceber) {
         List<Receber> lista = new ArrayList<>();
         
         for(Receber r : Retrieve()){
             if(r.getContaAReceber().getId() == idContaAReceber){
                 lista.add(r);
             }
         }
         return lista;
     }

         
     
    @Override
    public Receber Retrieve(int id) {
         return  entityManager.find(Receber.class, id);
         
    }

    @Override
    public void Update(Receber objeto) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
         
    }

    @Override
    public void Delete(Receber objeto) {

         try{
            entityManager.getTransaction().begin();
            Receber bairro = entityManager.find(Receber.class, objeto.getId());
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } 
    }

    public void Delete(int idReceber) {
        try{
            entityManager.getTransaction().begin();
            Receber bairro = entityManager.find(Receber.class, idReceber);
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } 
        
    }

    public Receber RetrievePorUmaIdVendaRecebido(int idVenda) {
       for (Receber r : Retrieve()){
           if(r.getContaAReceber().getVendaId() == idVenda){
               return r;
           }
       }
       return null;
    }
}
