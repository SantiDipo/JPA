/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicio;

import java.util.Date;
import libreria.entidad.Prestamo;
import persistencia.PrestamoDAO;

/**
 *
 * @author Santiago D'Ippolito
 */
public class servicioPrestamo {

    private PrestamoDAO prestamoDAO;

    public servicioPrestamo() {
        this.prestamoDAO = new PrestamoDAO();
    }

    public Prestamo registrarPrestamos(Boolean alta, Date fp, Date fd) throws Exception {
        Prestamo nuevoPrestamo = new Prestamo();
        try {

            if (fp == null) {
                throw new Exception("Debe ingresar la fecha del prestamo");
            }
            if (fd == null) {
                throw new Exception("Debe ingresar la fecha de devolución");
            }
            if (alta == false) {
                throw new Exception("El cliente está dado de baja");
            }
                nuevoPrestamo.setAlta(true);
                nuevoPrestamo.setFechaPrestamo(fp);
                nuevoPrestamo.setFechaDevolucion(fd);
                prestamoDAO.guardar(nuevoPrestamo);
                return nuevoPrestamo;
            }catch (Exception e) {
            e.getMessage();
            return null;
        }
        
    }
}

