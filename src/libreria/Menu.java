/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidad.Autor;
import libreria.entidad.Cliente;
import libreria.entidad.Editorial;
import libreria.entidad.Libro;
import libreria.servicio.servicioAutor;
import libreria.servicio.servicioCliente;
import libreria.servicio.servicioEditorial;
import libreria.servicio.servicioLibro;
import libreria.servicio.servicioPrestamo;

/**
 *
 * @author Santiago D'Ippolito
 */
public class Menu {

    private final servicioAutor sa;
    private final servicioLibro sl;
    private final servicioEditorial se;

    public Menu() {
        this.sa = new servicioAutor();
        this.sl = new servicioLibro();
        this.se = new servicioEditorial();
    }

    public void ejecucion() throws Exception {

        String nombreA1 = "Cortazar";
        String nombreA2 = "Borges";

        String nombreE1 = "Minotauro";
        String nombreE2 = "Siruela";

        String nombreC1 = "PEPE";
        String nombreC2 = "CARLOS";

        Long isbn1 = 9788437622156L;
        Long isbn2 = 8788437622156L;
        String titulo1 = "Don Quijote de la Mancha";
        String titulo2 = "El Señor De Los Anillos";
        String anio1 = "1605";
        String anio2 = "1993";
        Integer ejemplares1 = (int) Math.floor(Math.random() * (10 - 1000 + 1) + 1000);
        Integer ejemplares2 = (int) Math.floor(Math.random() * (10 - 1000 + 1) + 1000);
        Integer ejemplaresP1 = ejemplares1 - (int) Math.floor(Math.random() * (10 - 500 + 1) + 500);
        Integer ejemplaresP2 = ejemplares2 - (int) Math.floor(Math.random() * (10 - 500 + 1) + 500);
        Integer ejemplaresR1 = ejemplares1;
        Integer ejemplaresR2 = ejemplares2;
        
        Date d1 = new Date(2022 - 1900, 10 + 1, 5);
        Date d2 = new Date(2022 - 1900, 10 + 1, 10);
        Date d3 = new Date(2022 - 1900, 10 + 1, 5);
        Date d4 = new Date(2022 - 1900, 10 + 1, 25);

        Autor autor1 = sa.crearAutor(Integer.SIZE, Boolean.TRUE, nombreA1);
        Autor autor2 = sa.crearAutor(Integer.SIZE, Boolean.TRUE, nombreA2);

        Editorial editorial1 = se.crearEditorial(Integer.SIZE, Boolean.TRUE, nombreE1);
        Editorial editorial2 = se.crearEditorial(Integer.SIZE, Boolean.TRUE, nombreE2);

        Libro libro1 = sl.crearLibro(Integer.SIZE, Boolean.TRUE, isbn1, titulo1, anio1, ejemplares1, ejemplaresP1, ejemplaresR1, autor1, editorial1);
        Libro libro2 = sl.crearLibro(Integer.SIZE, Boolean.TRUE, isbn2, titulo2, anio2, ejemplares2, ejemplaresP2, ejemplaresR2, autor2, editorial2);

        System.out.println("Elija el autor que desea buscar");
        sa.buscarAutor(nombreA1);

        System.err.println("Elija libro por ISBN");
        sl.buscarLibroPorIsbn(8788437622156L);

        System.out.println("Elija el titulo del libro que desea buscar");
        sl.buscarLibroPorTitulo(titulo1);

        System.out.println("Elija el autor del libro que desee");
        sl.buscarLibroPorAutor(nombreA1);

        System.out.println("Elija la editorial del libro que desea");
        sl.buscarLibroPorEditorial(nombreE2);

        System.out.println("Elija la editorial del libro que desea");
        sl.buscarLibroPorEditorial(nombreE2);
        servicioCliente sc = new servicioCliente();

        Cliente c1 = sc.crearCliente(Boolean.TRUE, 36417598L, nombreC1, "SANCHEZ", "4323540");
        Cliente c2 = sc.crearCliente(Boolean.TRUE, 35488674L, nombreC2, "ELESCAMOSO", "4313189");
        
        servicioPrestamo sp = new servicioPrestamo();
        sp.registrarPrestamos(Boolean.TRUE, d1, d2, libro1, c1);
        sp.registrarPrestamos(Boolean.TRUE, d3, d4, libro2, c2);
        sp.buscarPrestamoPorCliente("SANCHEZ");
    }
}

