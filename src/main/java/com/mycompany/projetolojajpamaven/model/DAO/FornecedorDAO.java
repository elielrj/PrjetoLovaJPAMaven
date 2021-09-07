package com.mycompany.projetolojajpamaven.model.DAO;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FornecedorDAO implements InterfaceDAO<Fornecedor> {
    
    private static FornecedorDAO instance;
    protected EntityManager entityManager;
    
    public static FornecedorDAO getInstance(){
        if(instance == null){
            instance = new FornecedorDAO();
        }
        return instance;
    }

    public FornecedorDAO() {
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
    public void Create(Fornecedor objeto) {
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
    public List<Fornecedor> Retrieve() {
List<Fornecedor> listaBairros;
        listaBairros = entityManager.createQuery("Select c From fornecedor c",Fornecedor.class).getResultList();
        return listaBairros;
    }
    
    @Override
    public Fornecedor Retrieve(int id) {
                        return  entityManager.find(Fornecedor.class, id);

    }
    
    @Override
    public void Update(Fornecedor objeto) {
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
    public void Delete(Fornecedor objeto) {
        try{
            entityManager.getTransaction().begin();
            Fornecedor bairro = entityManager.find(Fornecedor.class, objeto.getId());
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void Delete(int idFornecedor) {
       try{
            entityManager.getTransaction().begin();
            Fornecedor bairro = entityManager.find(Fornecedor.class, idFornecedor);
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
