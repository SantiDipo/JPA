/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicio;

import libreria.entidad.Autor;
import libreria.entidad.Editorial;
import libreria.entidad.Libro;
import persistencia.LibroDAO;

/**
 *
 * @author Santiago D'Ippolito
 */
public class servicioLibro {

    private servicioAutor sa;
    private servicioEditorial se;
    private LibroDAO libroDAO;

    public servicioLibro(LibroDAO libroDAO) {
        this.libroDAO = new LibroDAO();
    }

    public void setServicios(servicioAutor sa, servicioEditorial se) {
        this.sa = sa;
        this.se = se;
    }

    public servicioLibro() {
    }

    public Libro crearLibro(Integer id,Boolean alta, Long isbn, String titulo, String anio, Integer ejemplares, Integer ejemplaresPrestados,
        Integer ejemplaresRestantes, Autor autor, Editorial editorial) throws Exception {
        Libro nuevolibro = new Libro();

        try {

            if (isbn == null || isbn == 0) {
                throw new Exception("Debe ingresar el ISBN del libro o ingresar un ISBN valido");

            }
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe ingresar el titulo del libro");

            }

            if (alta == false) {
                throw new Exception("El libro esta dado de baja");
            }
            System.out.println("Ingrese el nombre del libro");
            nuevolibro.setId(id);
            nuevolibro.setIsbn(isbn);
            System.out.println(isbn);
            nuevolibro.setTitulo(titulo);
            System.out.println(titulo);
            nuevolibro.setAnio(anio);
            System.out.println(anio);
            nuevolibro.setEjemplares(ejemplares);
            System.out.println(ejemplares);
            nuevolibro.setEjemplaresPrestados(ejemplaresPrestados);
            System.out.println(ejemplaresPrestados);
            nuevolibro.setEjemplaresRestantes(ejemplaresRestantes);
            System.out.println(ejemplaresRestantes);
            nuevolibro.setAutor(autor);
            System.out.println(autor);
            nuevolibro.setEditorial(editorial);
            System.out.println(editorial);
            System.out.println(nuevolibro);
            libroDAO.guardar(nuevolibro);
            return nuevolibro;

        } catch (Exception e) {
            throw e;
        }

    }

    public Libro buscarLibroPorIsbn(Long isbn) {
        try {
            return libroDAO.buscarLibroPorIsbn(isbn, Integer.SIZE);
        } catch (Exception e) {
            return null;
        }

    }

    public Libro buscarLibroPorTitulo(String titulo) {
        try {
            return libroDAO.buscarLibroPorTitulo(titulo, Integer.SIZE);
        } catch (Exception e) {
            return null;
        }
    }
}
