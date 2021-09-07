package com.mycompany.projetolojajpamaven.model.DAO;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Pagar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PagarDAO implements InterfaceDAO<Pagar> {

    private static PagarDAO instance;
    protected EntityManager entityManager;
    
    public static PagarDAO getInstance(){
        if(instance == null){
            instance = new PagarDAO();
        }
        return instance;
    }

    public PagarDAO() {
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
    public void Create(Pagar objeto) {
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
    public List<Pagar> Retrieve() {
       List<Pagar> listaBairros;
        listaBairros = entityManager.createQuery("Select c From pagar c",Pagar.class).getResultList();
        return listaBairros;
    }

    @Override
    public Pagar Retrieve(int id) {
        return  entityManager.find(Pagar.class, id);
    }

    @Override
    public void Update(Pagar objeto) {
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
    public void Delete(Pagar objeto) {
try{
            entityManager.getTransaction().begin();
            Pagar bairro = entityManager.find(Pagar.class, objeto.getId());
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } 
       
    }
    public void Delete(int idPagar){
        try{
            entityManager.getTransaction().begin();
            Pagar bairro = entityManager.find(Pagar.class, idPagar);
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
