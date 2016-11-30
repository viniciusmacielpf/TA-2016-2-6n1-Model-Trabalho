/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Vini
 */
public class TestePersistirImovel {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirImovel() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-2016-2-6n1-Mode-TrabalholPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean exept = false;
        try {
            Pessoa obj  = new Pessoa();
            obj.setNome("Pessoa");
            obj.setSobrenome("De teste");
            obj.setEndereco("Rua dos alfeneiros");
            obj.setEmail("eamail@mail.com");
            
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            exept = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exept);
    }

}
