/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidad.Autor;

/**
 *
 * @author Santiago D'Ippolito
 */
public class AutorDAO {

    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
    protected EntityManager em = emf.createEntityManager();

    public void conectar() {
        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

     public void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

     public void guardar(Autor autor) {
        conectar();
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        desconectar();
    }

     public void editar(Autor autor) {
        conectar();
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
        desconectar();
    }

     public void eliminar(Autor autor) {
        conectar();
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
        desconectar();
    }

    public Autor buscarAutor(String nombre, Integer id) {
        conectar();
        em.getTransaction().begin();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre like :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        System.out.println(autor);
        desconectar();
        return autor;
    }

}