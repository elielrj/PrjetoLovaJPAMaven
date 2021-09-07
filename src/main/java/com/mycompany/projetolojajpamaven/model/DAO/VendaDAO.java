package com.mycompany.projetolojajpamaven.model.DAO;

import java.util.List;
import com.mycompany.projetolojajpamaven.model.bo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mycompany.projetolojajpamaven.model.bo.ContaAReceber;
import com.mycompany.projetolojajpamaven.model.bo.Estoque;
import com.mycompany.projetolojajpamaven.model.bo.ItemDeVenda;
import com.mycompany.projetolojajpamaven.model.bo.PessoaFisica;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VendaDAO implements InterfaceDAO<Venda> {
    
    private static VendaDAO instance;
    protected EntityManager entityManager;
    
    public static VendaDAO getInstance(){
        if(instance== null){
            instance = new VendaDAO();
        }
        return instance;
    }

    public VendaDAO() {
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
    public void Create(Venda objeto) {
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
    public Venda Retrieve(int id) {
        return  entityManager.find(Venda.class, id);
    }

    @Override
    public List<Venda> Retrieve() {
        List<Venda> listaBairros;
        listaBairros = entityManager.createQuery("Select c From venda c",Venda.class).getResultList();
        return listaBairros;
    }

    public List<Venda> RetrieveBuscaVendaDeUmCliente(PessoaFisica pessoaFisica) {
       List<Venda> lista = new ArrayList<>();
       
       for(Venda v : Retrieve()){
           if(v.getPessoaFisica().getNome().equalsIgnoreCase(pessoaFisica.getNome())){
               lista.add(v);
           }
       }
       return lista;
    }

    public List<Venda> RetrieveBuscaVendaDeUmClientePorIDPFeData(PessoaFisica pessoaFisica, String data) {
        List<Venda> lista = new ArrayList<>();
       
       for(Venda v : Retrieve()){
           if(v.getPessoaFisica().getId() == pessoaFisica.getId()){
               if(v.getData() == data){
                   lista.add(v);
               }
           }
       }
       return lista;
    }
    
    @Override
    public void Update(Venda objeto) {
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
    public void Delete(Venda objeto) {
        try{
            entityManager.getTransaction().begin();
            Venda bairro = entityManager.find(Venda.class, objeto.getId());
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
            Venda bairro = entityManager.find(Venda.class, idVenda);
            entityManager.remove(bairro);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } 
    }

    public int RetrieveObjetoVendaPeloClienteValorTotalEData(Venda venda) {
/*
        for(Venda v: Retrieve()){
            if(v.getPessoaFisica().getNome().equalsIgnoreCase(venda.getPessoaFisica().getNome())){
                if(v.getData().equals(venda.getData())){
                    if(v.getValorTotal() == venda.getValorTotal()){
                        return v.getId();
                    }
                }
            }
        }
        return 0;        
  
        List<Venda> listaBairros; */
        List<Venda> v = new ArrayList<>();
        
        Query query = entityManager.createQuery("Select c From venda c where c.pessoaFisica = :pessoa and c.data = :data and c.valorTotal = :valor", Venda.class);
        query.setParameter("pessoa", venda.getPessoaFisica());
        query.setParameter("data", venda.getData());
        query.setParameter("valor", venda.getValorTotal());
        
        v = query.getResultList();
        
        
        for (Venda ve : v){
            return ve.getId();
        }
        
     return 0;
    }

    public int BuscarProximoId(){
        List<Venda> listaBairros;
        listaBairros = entityManager.createQuery("Select c From venda c",Venda.class).getResultList();
        return listaBairros.size()+1;
    }

}
