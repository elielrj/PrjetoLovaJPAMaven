package com.mycompany.projetolojajpamaven.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Endereco;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EnderecoDAO implements InterfaceDAO<Endereco> {

    private static EnderecoDAO instance;
    protected EntityManager entityManager;
    
    public static EnderecoDAO getInstance(){
        if(instance == null){
            instance = new EnderecoDAO();
        }
        return instance;
    }

    public EnderecoDAO() {
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
    public void Create(Endereco objeto) {
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
    public List<Endereco> Retrieve() {
        List<Endereco> listaBairros;
        listaBairros = entityManager.createQuery("Select c From endereco c",Endereco.class).getResultList();
        return listaBairros;
    }

    @Override
    public Endereco Retrieve(int id) {
                return  entityManager.find(Endereco.class, id);

    }

    @Override
    public void Update(Endereco objeto) {
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
    public void Delete(Endereco objeto) {
        try{
            entityManager.getTransaction().begin();
            Endereco bairro = entityManager.find(Endereco.class, objeto.getId());
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } 
    }

    public void Delete(int idEndereco) {
        Delete(Retrieve(idEndereco));
    }

    public int RetrievePorId(Endereco endereco) {
        
        for(Endereco e: Retrieve()){
            if(e.getBairro().getId() == endereco.getBairro().getId()){
                if(e.getLogradouro() == endereco.getLogradouro()){
                    if(e.getNumero() == endereco.getNumero()){
                        return e.getId();
                    }
                }
            }
        }
        return 0;
    }
}
