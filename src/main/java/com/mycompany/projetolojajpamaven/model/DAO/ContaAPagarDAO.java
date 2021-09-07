package com.mycompany.projetolojajpamaven.model.DAO;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.ContaAPagar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContaAPagarDAO implements InterfaceDAO<ContaAPagar> {

    private static ContaAPagarDAO instance;
    protected EntityManager entityManager;
    
    public static ContaAPagarDAO getInstance(){
        if(instance == null){
            instance = new ContaAPagarDAO();
        }
        return instance;
    }

    public ContaAPagarDAO() {
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
    public void Create(ContaAPagar objeto) {
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
    public List<ContaAPagar> Retrieve() {
        List<ContaAPagar> listaContaAPagar;
        listaContaAPagar = entityManager.createQuery("Select c From contaapagar c",ContaAPagar.class).getResultList();
        return listaContaAPagar;
        
    }

    @Override
    public ContaAPagar Retrieve(int id) {
        return  entityManager.find(ContaAPagar.class, id);
    }

    @Override
    public void Update(ContaAPagar objeto) {
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
    public void Delete(ContaAPagar objeto) {
        try{
            entityManager.getTransaction().begin();
            ContaAPagar contaAPagar = entityManager.find(ContaAPagar.class, objeto.getId());
            entityManager.remove(contaAPagar);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public ContaAPagar RetrieveIdDaContaAPagarrPeloIdDaCompra(int idDaCompra) {
       
        List<ContaAPagar> contasAPagar = Retrieve();
        
        for (ContaAPagar contas : contasAPagar){
            if(contas.getCompraId() == idDaCompra){
                return contas;
            }
        }
        return null;        
    }
}
