package Job;

/**
 *25/02/23
 * @author jobde
 */
public class Encriptar {
    private final String[] contraseña;
    private String[] TextoEncriptado;
    private String fin;
    private final int Desplazo = 3;

    public Encriptar(String entrada) {
        
        fin = "";
        contraseña = entrada.split("\n");

    }

    public String getSalidaCifrada() {
        for (String linea : encriptar()) {
            fin += linea + "\n";
        }

        return fin;
    }

    public String getSalidaDescifrada() {
        for (String linea : desEncriptar()) {
            fin += linea + "\n";
        }

        return fin;
    }

    private String[] encriptar() {
        TextoEncriptado = new String[contraseña.length];
        for (int i = 0; i < contraseña.length; i++) {
            
            
            //MOVEMOS
            
            char lineaChar[] = new char[contraseña[i].length()];
            //AUXILIAR
            
            String lineaNueva = ""; 
            

            for (int j = 0; j < contraseña[i].length(); j++) {
                
                if (contraseña[i].charAt(j) >= 48 && contraseña[i].charAt(j) <= 57) { 
                    
                    lineaChar[j] = (char) (contraseña[i].charAt(j)); 

                } else {
                    
                    lineaChar[j] = (char) (contraseña[i].charAt(j) + Desplazo); 
                    
                }
                
                
                lineaNueva += lineaChar[j]; 
            }
            
            
            TextoEncriptado[i] = lineaNueva; 

           
            lineaNueva = ""; 
            
            for (int j = TextoEncriptado[i].length() - 1; j > -1; j--) {
                
                
                lineaChar[j] = TextoEncriptado[i].charAt(j); 
                
                lineaNueva += lineaChar[j]; 
                
            }
            TextoEncriptado[i] = lineaNueva;

            
            lineaNueva = ""; 
            
            for (int j = 0; j < TextoEncriptado[i].length(); j++) {
                
                boolean numeros = TextoEncriptado[i].charAt(j) >= 48 && TextoEncriptado[i].charAt(j) <= 57;
                
                if (j >= (TextoEncriptado[i].length() / 2) && !numeros) {
                    
                    lineaChar[j] = (char) (TextoEncriptado[i].charAt(j) - 1); 
                    
                } else {
                    
                    lineaChar[j] = TextoEncriptado[i].charAt(j);
                }
                
                lineaNueva += lineaChar[j]; 
                
            }
            
            TextoEncriptado[i] = lineaNueva;
            
        }
        return TextoEncriptado;
        
    }

    private String[] desEncriptar() {
        
        TextoEncriptado = new String[contraseña.length];
        
        for (int i = 0; i < contraseña.length; i++) { 
           
            char lineaChar[] = new char[contraseña[i].length()];
            
            String lineaNueva = "";

            for (int j = 0; j < contraseña[i].length(); j++) {
                
                boolean numeros = contraseña[i].charAt(j) >= 48 && contraseña[i].charAt(j) <= 57;
                
                if (j >= (contraseña[i].length() / 2) && !numeros) {
                    
                    lineaChar[j] = (char) (contraseña[i].charAt(j) + 1); 
                    
                } else {
                    
                    lineaChar[j] = contraseña[i].charAt(j);
                }
                
                lineaNueva += lineaChar[j]; 
                
            }
            
            TextoEncriptado[i] = lineaNueva;

            
            lineaNueva = ""; 
            
            for (int j = TextoEncriptado[i].length() - 1; j > -1; j--) {
                
                lineaChar[j] = TextoEncriptado[i].charAt(j); 
                
                lineaNueva += lineaChar[j]; 
            }
            
            TextoEncriptado[i] = lineaNueva;
            

            
            lineaNueva = ""; 
            
            for (int j = 0; j < TextoEncriptado[i].length(); j++) {
                
                if (TextoEncriptado[i].charAt(j) >= 48 && TextoEncriptado[i].charAt(j) <= 57) { 
                    
                    lineaChar[j] = (char) (TextoEncriptado[i].charAt(j)); 

                } else {
                    
                    lineaChar[j] = (char) (TextoEncriptado[i].charAt(j) - Desplazo); 
                }
                
                lineaNueva += lineaChar[j]; 
            }
            
            TextoEncriptado[i] = lineaNueva; 
         
        }

        return TextoEncriptado;
    }
}
