package com.mycompany.projetolojajpamaven.model.DAO;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Bairro;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class BairroDAO implements InterfaceDAO<Bairro> {
    
    private static BairroDAO instance;
    protected EntityManager entityManager;

    public static BairroDAO getInstance(){
        if(instance == null){
            instance = new BairroDAO();
        }
        return instance;
    }
    
    public BairroDAO() {
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
    public void Create(Bairro objeto) {try{
        entityManager.getTransaction().begin();
        entityManager.persist(objeto);
        entityManager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Bairro> Retrieve() {
        List<Bairro> listaBairros;
        listaBairros = entityManager.createQuery("SELECT a FROM bairro a",Bairro.class).getResultList();
        return listaBairros; 
    }

    @Override
    public Bairro Retrieve(int id) {
        return  entityManager.find(Bairro.class, id);
    }

    @Override
    public void Update(Bairro objeto) {
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
    public void Delete(Bairro objeto) {
        try{
            entityManager.getTransaction().begin();
            Bairro bairro = entityManager.find(Bairro.class, objeto.getId());
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }        
    }

    public void Delete(int idBairro) {
        try{
            entityManager.getTransaction().begin();
            Bairro bairro = entityManager.find(Bairro.class, idBairro);
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }        
    }

    public List<Bairro> RetrieveForCity(int idCidade) {      
        return listaDeBairrosDeUmaCidade(Retrieve(), idCidade);     
    }

    public int RetrieveIdTheCity(int idBairro) {
        Bairro bairro = entityManager.find(Bairro.class, idBairro);
        return bairro.getCidade().getId();        
    }

    private List<Bairro> listaDeBairrosDeUmaCidade(List<Bairro> listaDeBairros, int idCidade) {
        
        List<Bairro> bairros = new ArrayList<>();
        
        for (Bairro bairro : listaDeBairros){
            if(bairro.getCidade().getId() == idCidade)
                bairros.add(bairro);
        }
        return bairros;
    }

    
}
