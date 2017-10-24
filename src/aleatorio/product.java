/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorio;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author oracle
 */
public class product {
        
    String codes;
    String descripcion;
    int price;
    
    
    public product() {
        codes = null;
        descripcion = null;
        price = 0;
    }

    public product(String codigo, String descripcion, int price) {
        this.codes = codigo;
        this.descripcion = descripcion;
        this.price = price;
    }

    public String getCodigo() {
        return codes;
    }

    public void setCodigo(String codigo) {
        this.codes = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrezo() {
        return price;
    }

    public void setPrezo(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY); 
        return "product{" + "codigo=" + codes + "\ndescripcion=" + descripcion + "\nprice=" + nf.format(price) + '}';
    }
    
}

    

