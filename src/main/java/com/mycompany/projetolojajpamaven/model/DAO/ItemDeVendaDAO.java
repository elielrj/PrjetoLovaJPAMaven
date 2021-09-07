package com.mycompany.projetolojajpamaven.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.ItemDeVenda;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class ItemDeVendaDAO implements InterfaceDAO<ItemDeVenda> {

    private static ItemDeVendaDAO instance;
    protected EntityManager entityManager;
    
    public static ItemDeVendaDAO getInstance(){
        if(instance == null){
            instance = new ItemDeVendaDAO();
        }
        return instance;
    }

    public ItemDeVendaDAO() {
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
    public void Create(ItemDeVenda objeto) {
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
    public List<ItemDeVenda> Retrieve() {
         List<ItemDeVenda> listaBairros;
        listaBairros = entityManager.createQuery("Select c From itemdevenda c",ItemDeVenda.class).getResultList();
        return listaBairros;
    }

    @Override
    public ItemDeVenda Retrieve(int id) {
        return  entityManager.find(ItemDeVenda.class, id);
    }

    @Override
    public void Update(ItemDeVenda objeto) {
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
    public void Delete(ItemDeVenda objeto) {
       try{
            entityManager.getTransaction().begin();
            ItemDeVenda bairro = entityManager.find(ItemDeVenda.class, objeto.getId());
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }      
    }

    public void Delete(int idVenda) {
       try{
            entityManager.getTransaction().begin();
            ItemDeVenda bairro = entityManager.find(ItemDeVenda.class, idVenda);
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } 
    }
    
    public List<ItemDeVenda> RetrieveUmaListaDeItemDeVendaPeloIdDaVenda(int idDaVenda) {
        List<ItemDeVenda> lista = new ArrayList<>();
        for (ItemDeVenda i : Retrieve()){
            if(i.getVendaId().getId()== idDaVenda){
                lista.add(i);
            }
        }
        return lista;
    }
}
