
package Job;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *27/02/2023
 * @author jobde
 */
public class Archivo {
    
    
    private File archivo;
     
     
    private final String nArchivo, formato;

    public Archivo(String nombreArchivo, String f) {
        
        nArchivo = nombreArchivo;
        
        formato = f;
        
        creacionArchivo();
        
    }

    private void creacionArchivo() {
        
        
        try {
                    archivo = new File(nArchivo + formato);
                    //Tratamos de guardar el archivo en la ruta donde se encuentra nuestro proyecto

            if (archivo.createNewFile()) {
                
                                           System.out.println("Se ha creado un archivo con extención :  " + formato);

            }
               
        }   catch (IOException formatoE) { 
            
             System.err.println("No fue posible crear el archivo con extención. " + formatoE);
                  
             JOptionPane.showMessageDialog(null,"Verifique la ubicación del archivo");
                    
        }
    }

    public void escribirArchivo(String entrada) {
        
        
        try {
            
            FileWriter escribir = new FileWriter(archivo);
            
            escribir.write(entrada);
            
            escribir.close();

        } catch (IOException NombreA) {
            
            
            System.err.println("No es posible escribir en el archivo : " + NombreA);
            
            
            JOptionPane.showMessageDialog(null,"No se pudo encontrar el archivo");
                    
        }

    }

    public String leerArchivo() {
        
        String cadena;
        
        String contenido = "";
        
        try {
            
            FileReader lector = new FileReader(archivo);
            
            BufferedReader lectura = new BufferedReader(lector);
            
            cadena = lectura.readLine();
            //Se lee la primera linea
            
            while (cadena != null) {
           
                contenido += cadena + "\n";
                
                cadena = lectura.readLine();
                
            }

        } catch (FileNotFoundException Formato) {
            
            System.err.println("No pudimos encontrar el archivo " + Formato);
            
            JOptionPane.showMessageDialog(null,"No encontramos el archivo");
                    
        } catch (IOException Formato) {
            
            System.err.println("No se puede leer el archivo " + Formato);
            
            JOptionPane.showMessageDialog(null,"El documento esta en blanco");
                    

        }
         
        //retornamos el contenido del archivo
        return contenido;
    }

    public String getPath() {
        
        return archivo.getAbsolutePath();
    }
    
}
