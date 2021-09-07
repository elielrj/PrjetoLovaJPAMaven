package com.mycompany.projetolojajpamaven.model.DAO;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mycompany.projetolojajpamaven.model.bo.Estoque;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutoDAO implements InterfaceDAO<Produto> {

    private static ProdutoDAO instance;
    protected EntityManager entityManager;
    
    public static ProdutoDAO getInstance(){
        if(instance == null){
            instance = new ProdutoDAO();
        }
        return instance;
    }

    public ProdutoDAO() {
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
    public void Create(Produto objeto) {
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
    public List<Produto> Retrieve() {
        List<Produto> listaBairros;
        listaBairros = entityManager.createQuery("Select c From produto c",Produto.class).getResultList();
        return listaBairros;
    }

    @Override
    public Produto Retrieve(int id) {
        return  entityManager.find(Produto.class, id);
    }

    public Produto Retrieve(String codigodeBarrasDoProduto) {
        
        for (Produto p : Retrieve()){
            if(p.getCodigoDeBarras().equals(codigodeBarrasDoProduto)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void Update(Produto objeto) {
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
    public void Delete(Produto objeto) {        
       try{
            entityManager.getTransaction().begin();
            Produto bairro = entityManager.find(Produto.class, objeto.getId());
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } 
    }
    
     public void Delete(int idProduto) {
        
    }

    public boolean codigoDeBarrasValido(String codBarras) {
        for (Produto p : Retrieve()){
            if(p.getCodigoDeBarras().equals(codBarras)){
                return true;
            }
        }
        return false;
    }
}
