package com.mycompany.projetolojajpamaven.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.ItemDeCompra;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ItemDeCompraDAO implements InterfaceDAO<ItemDeCompra> {

    private static ItemDeCompraDAO instance;
    protected EntityManager entityManager;
    
    public static ItemDeCompraDAO getInstance(){
        if(instance == null){
            instance = new ItemDeCompraDAO();
        }
        return instance;
    }

    public ItemDeCompraDAO() {
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
    public void Create(ItemDeCompra objeto) {
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
    public List<ItemDeCompra> Retrieve() {
        List<ItemDeCompra> listaBairros;
        listaBairros = entityManager.createQuery("Select c From itemdecompra c",ItemDeCompra.class).getResultList();
        return listaBairros;
    }

    @Override
    public ItemDeCompra Retrieve(int id) {
       return  entityManager.find(ItemDeCompra.class, id);
    }

    @Override
    public void Update(ItemDeCompra objeto) {
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
    public void Delete(ItemDeCompra objeto) {
       try{
            entityManager.getTransaction().begin();
            ItemDeCompra bairro = entityManager.find(ItemDeCompra.class, objeto.getId());
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } 
    }
    
    public List<ItemDeCompra> RetrieveListaDeUmaCompra(int idDaCompra) {
        List<ItemDeCompra> lista = new ArrayList<>();
        for (ItemDeCompra i : Retrieve()){
            if(i.getCompraId() == idDaCompra){
                lista.add(i);
            }
        }
        return lista;
    }

}
