package com.mycompany.projetolojajpamaven.model.DAO;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Cidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CidadeDAO implements InterfaceDAO<Cidade> {
    
    private static CidadeDAO instance;
    protected EntityManager entityManager;
    
    public static CidadeDAO getInstance(){
        if(instance == null){
            instance = new CidadeDAO();
        }
        return instance;
    }

    public CidadeDAO() {
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
    public void Create(Cidade objeto) {
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
    public List<Cidade> Retrieve() {

        List<Cidade> listaCidades;
        listaCidades = entityManager.createQuery("Select c From cidade c",Cidade.class).getResultList();
        return listaCidades;
        
    }

    @Override
    public Cidade Retrieve(int id) {        
        return  entityManager.find(Cidade.class, id);        
    }

    @Override
    public void Update(Cidade objeto) {
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
    public void Delete(Cidade objeto) {
        try{
            entityManager.getTransaction().begin();
            Cidade cidade = entityManager.find(Cidade.class, objeto.getId());
            entityManager.remove(cidade);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void Delete(int idCidade) {
        try{
            entityManager.getTransaction().begin();
            Cidade cidade = entityManager.find(Cidade.class, idCidade);
            entityManager.remove(cidade);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }    
}
