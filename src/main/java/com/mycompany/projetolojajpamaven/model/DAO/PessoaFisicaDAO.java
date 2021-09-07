package com.mycompany.projetolojajpamaven.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.PessoaFisica;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaFisicaDAO implements InterfaceDAO<PessoaFisica> {

    private static PessoaFisicaDAO instance;
    protected EntityManager entityManager;
    
    public static PessoaFisicaDAO getInstance(){
        if(instance == null){
            instance = new PessoaFisicaDAO();
        }
        return instance;
    }

    public PessoaFisicaDAO() {
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
    public void Create(PessoaFisica objeto) {
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
    public List<PessoaFisica> Retrieve() {
        List<PessoaFisica> listaBairros;
        listaBairros = entityManager.createQuery("Select c From pessoafisica c",PessoaFisica.class).getResultList();
        return listaBairros;
    }

    @Override
    public PessoaFisica Retrieve(int id) {
return  entityManager.find(PessoaFisica.class, id);
      

    }

    @Override
    public void Update(PessoaFisica objeto) {
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
    public void Delete(PessoaFisica objeto) {
try{
            entityManager.getTransaction().begin();
            PessoaFisica bairro = entityManager.find(PessoaFisica.class, objeto.getId());
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }   
        
    }
    
    public void Delete(int idPessoaFisica) {
try{
            entityManager.getTransaction().begin();
            PessoaFisica bairro = entityManager.find(PessoaFisica.class, idPessoaFisica);
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } 
       
    }

    public List<PessoaFisica> RetrieveAluno() {

        List<PessoaFisica> aluno = new ArrayList<>();
        
        for (PessoaFisica p : Retrieve()){
            if(p.getTipo().equalsIgnoreCase("Aluno")){
                aluno.add(p);
            }
        }
        return aluno;
    }

    public List<PessoaFisica> RetrievePersonal() {

        List<PessoaFisica> personal = new ArrayList<>();
        
        for (PessoaFisica p : Retrieve()){
            if(p.getTipo().equalsIgnoreCase("Personal")){
                personal.add(p);
            }
        }
        return personal;
        
    }

}
