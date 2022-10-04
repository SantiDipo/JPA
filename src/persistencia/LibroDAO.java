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
import libreria.entidad.Editorial;
import libreria.entidad.Libro;

/**
 *
 * @author Santiago D'Ippolito
 */
public class LibroDAO extends DAO<Libro> {

    @Override
    public void eliminar(Libro libro) {
        super.eliminar(libro); 
    }

    @Override
    public void editar(Libro libro) {
        super.editar(libro); 
    }

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro); 
    }

    @Override
    public void desconectar() {
        super.desconectar(); 
    }

    @Override
    public void conectar() {
        super.conectar(); 
    }

    public Libro buscarLibroPorIsbn(Long isbn, Integer id) {
        conectar();
        em.getTransaction().begin();
        Libro libro = (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.isbn like :isbn")
                .setParameter("isbn", isbn).getSingleResult();
        desconectar();
        return libro;
    }

    public Libro buscarLibroPorTitulo(String titulo, Integer id) {
        conectar();
        em.getTransaction().begin();
        Libro libro = (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.titulo like :titulo")
                .setParameter("titulo", titulo).getSingleResult();
        desconectar();
        return libro;
    }

    public Libro buscarLibroPorAutor(Autor autor, Integer id) {
        conectar();
        em.getTransaction().begin();
        Libro libro = (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.autor like :autor")
                .setParameter("autor", autor).getSingleResult();
        desconectar();
        return libro;
    }

    public Libro buscarLibroPorEditorial(Editorial editorial, Integer id) {
        conectar();
        em.getTransaction().begin();
        Libro libro = (Libro) em.createQuery("SELECT a FROM Libro a WHERE a.editorial like :editorial")
                .setParameter("editorial", editorial).getSingleResult();
        desconectar();
        return libro;
    }

}
