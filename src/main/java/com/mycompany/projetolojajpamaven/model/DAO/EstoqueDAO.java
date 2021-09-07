package com.mycompany.projetolojajpamaven.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Estoque;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EstoqueDAO implements InterfaceDAO<Estoque> {

    private static EstoqueDAO instance;
    protected EntityManager entityManager;
    
    public static EstoqueDAO getInstance(){
        if(instance == null){
            instance = new EstoqueDAO();
        }
        return instance;
    }

    public EstoqueDAO() {
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
    public void Create(Estoque objeto) {
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
    public List<Estoque> Retrieve() {
        List<Estoque> listaBairros;
        listaBairros = entityManager.createQuery("Select c From estoque c",Estoque.class).getResultList();
        return listaBairros;
    }

    @Override
    public Estoque Retrieve(int id) {
       return  entityManager.find(Estoque.class, id);

    }

    public int RetrieveDeIdEstoquePeloIdProduto(int id) {
        for(Estoque e: Retrieve()){
            if(e.getProdutoId() == id){
                return e.getId();
            }
        }
        return 0;
    }

    @Override
    public void Update(Estoque objeto) {
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
    public void Delete(Estoque objeto) {
        try{
            entityManager.getTransaction().begin();
            Estoque bairro = entityManager.find(Estoque.class, objeto.getId());
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } 
    }

    public Estoque RetrievePorIdDoProduto(int idProdutoDoEstoque) {
        for(Estoque e: Retrieve()){
            if(e.getProdutoId() == idProdutoDoEstoque){
                return e;
            }
        }
        return null;
    }
    
    public int BuscarAQuantidadeNoEstoqueComOIdDoProduto(int idDoProduto) {
        for(Estoque e: Retrieve()){
            if(e.getProdutoId() == idDoProduto){
                return e.getQuantidade();
            }
        }
        return 0;
    }
}
