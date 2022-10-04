/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidad.Autor;
import libreria.entidad.Editorial;
import libreria.entidad.Libro;
import libreria.servicio.servicioAutor;
import libreria.servicio.servicioEditorial;
import libreria.servicio.servicioLibro;

/**
 *
 * @author Santiago D'Ippolito
 */
public class libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        EntityManager em = emf.createEntityManager();
        Autor autor = new Autor();
        servicioAutor sa = new servicioAutor();
        Libro libro = new Libro();
        servicioLibro sl = new servicioLibro();
        Editorial editorial = new Editorial();
        servicioEditorial se = new servicioEditorial();

        autor = sa.crearAutor(Integer.SIZE, Boolean.TRUE, "rober");
        editorial = se.crearEditorial(Integer.SIZE, Boolean.TRUE, "facu");
        libro= sl.crearLibro(Integer.SIZE, Boolean.TRUE, 9788437622156L, "Don Quijote de la Mancha", "1605", 100, 50, 50, autor, editorial);
        sa.buscarAutor("CORTAZAR");

    }
}
