/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.vista.Administrador;
import ec.edu.intsuperior.vista.Loggin;
import ec.edu.intsuperior.vista.RegistrarProveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wssa8
 */
public class Controlador {
    Loggin loggin= new Loggin(this);
    Administrador administrador= new Administrador(this);
    RegistrarProveedor registrarProveedor= new RegistrarProveedor(this);
    Conexion conexion= new Conexion(this);
    
    public void mostrarProveedor(){
        registrarProveedor.setVisible(true);
    }
    public void cerrarProveedor(){
        registrarProveedor.setVisible(false);
    }
    
    public void mostrarLoggin(){
        loggin.setVisible(true);
    }
    public void cerrarLoggin(){
        loggin.setVisible(false);
    }
    public void mostrarAdministrador(){
        administrador.setVisible(true);
    }
    public void cerrarAdministrador(){
        administrador.setVisible(false);
    }
    
    public boolean logear(String user){
        boolean log=false;
        try {
            Statement stm= Conexion.conexion().createStatement();
            ResultSet rst= stm.executeQuery("Select username from user where username like '"+user+"'");
             while (rst.next()){
               log=true;
           }
       } catch (SQLException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
        return log;
    
    }
    
}
