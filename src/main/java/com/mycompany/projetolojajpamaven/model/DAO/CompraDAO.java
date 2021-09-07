package com.mycompany.projetolojajpamaven.model.DAO;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Compra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CompraDAO implements InterfaceDAO<Compra> {

    private static CompraDAO instance;
    protected EntityManager entityManager;
    
    public static CompraDAO getInstance(){
        if(instance == null){
            instance = new CompraDAO();
        }
        return instance;
    }

    public CompraDAO() {
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
    public void Create(Compra objeto) {        
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
    public List<Compra> Retrieve() {
        List<Compra> listaCompras;
        listaCompras = entityManager.createQuery("Select c From compra c",Compra.class).getResultList();
        return listaCompras;
    }

    @Override
    public Compra Retrieve(int id) {
        return  entityManager.find(Compra.class, id);         
    }

    @Override
    public void Update(Compra objeto) {
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
    public void Delete(Compra objeto) {
        try{
            entityManager.getTransaction().begin();
            Compra compra = entityManager.find(Compra.class, objeto.getId());
            entityManager.remove(compra);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public Compra Retrieve(Compra compra) {
        
    
        
        for(Compra c : Retrieve()){
            if(c.getValorTotal() == compra.getValorTotal()){
                if(c.getFornecedor() == compra.getFornecedor()){
                    if(c.getData() == compra.getData()){
                        compra = c;
                        break;
                    }
                }
                        
            }
        }
        return compra;        
    }

    public void Delete(int idDaCompra) {
        try{
            entityManager.getTransaction().begin();
            Compra compra = entityManager.find(Compra.class, idDaCompra);
            entityManager.remove(compra);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
