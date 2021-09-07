package com.mycompany.projetolojajpamaven.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import com.mycompany.projetolojajpamaven.model.bo.ContaAReceber;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContaAReceberDAO implements InterfaceDAO<ContaAReceber> {

    private static ContaAReceberDAO instance;
    protected EntityManager entityManager;
    
    public static ContaAReceberDAO getInstance(){
        if(instance == null){
            instance = new ContaAReceberDAO();
        }
        return instance;
    }

    public ContaAReceberDAO() {
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
    public void Create(ContaAReceber objeto) {
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
    public List<ContaAReceber> Retrieve() {
        List<ContaAReceber> listaContaAReceber;
        listaContaAReceber = entityManager.createQuery("Select c From contaareceber c",ContaAReceber.class).getResultList();
        return listaContaAReceber; 
    }
   

    @Override
    public ContaAReceber Retrieve(int id) {
        return  entityManager.find(ContaAReceber.class, id);
    }

    @Override
    public void Update(ContaAReceber objeto) {
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
    public void Delete(ContaAReceber objeto) {
        try{
            entityManager.getTransaction().begin();
            ContaAReceber bairro = entityManager.find(ContaAReceber.class, objeto.getId());
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }        
    }
    
    public ContaAReceber RetrieveIdDaContaAReceberPeloIdDaVenda(int idDaVenda) {
       List<ContaAReceber> contasAReceber = Retrieve();
        
       for(ContaAReceber c: contasAReceber){
           if(c.getVendaId() == idDaVenda){
               return c;
           }
       }
       return null;
    }
}
