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
import persistencia.LibroDAO;

/**
 *
 * @author Santiago D'Ippolito
 */
public class libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Menu m = new Menu();
        m.ejecucion();
    }
}
