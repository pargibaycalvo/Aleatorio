/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import static java.lang.String.format;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author oracle
 */
public class Aleatorio {

    /**
     * @param args the command line arguments
     */    
        static File directorio = new File("/home/oracle/NetBeansProjects/aleatorio/archivos");
        static File archivo = new File("/home/oracle/NetBeansProjects/aleatorio/archivos/productos.txt");
        
        static public String[]codes={"p1","p2","p3"};
        static public String[]descricion={"parafusos","cravos","tachas"};
        static public int[]price={3,4,5};
        
        static RandomAccessFile rnd=null;
        
        
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        carpeta(directorio);
        archivo(archivo);
        escribir(archivo);
        lectura(archivo);
    }
    
    static void carpeta(File directorio){

        if(directorio.exists())
            System.out.println("Directorio existente "+directorio.getPath());
        else
            directorio.mkdir();
    }
    
    static void archivo(File archivo) throws IOException{

        if(archivo.exists())
            System.out.println("Archivo de texto existente "+archivo.getPath());
        else
            archivo.createNewFile();
    }

    
    static void escribir(File archivo){
            try {
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(archivo)));
                rnd=new RandomAccessFile(archivo,"rw");
                for(int i=0;i<codes.length;i++){
                    rnd.writeChars(lolo(codes[i],3));
                    rnd.writeChars(lolo(descricion[i],10));
                    rnd.writeInt(price[i]);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Aleatorio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Aleatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    static String lolo (String cadea, int maximo){
        cadea= format("%" + maximo + "s", cadea);
        return cadea;      
    }
    
    static void lectura(File archivo) throws IOException{
        try{
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            rnd=new RandomAccessFile(archivo,"rw");
            rnd.seek(30);
            
        String codigo = "",desc="";
        for(int i = 0; i<3;i++){
            codigo += rnd.readChar();
        }
        for(int i = 0; i<10;i++){
            desc += rnd.readChar();
        }
        
        product aux = new product(codigo.trim(),desc.trim(),(int)(double)rnd.readInt());
        System.out.println(aux.toString());
        
        } catch (IOException ex) {
                Logger.getLogger(Aleatorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }    
}
