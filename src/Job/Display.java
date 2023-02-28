package Job;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * 25/02/23
 * @author jobde
 */
public class Display extends JFrame {
    
    private final Archivo ATxt, AVge;
    private JPanel panel;
    private JButton GuardarVGE, Encriptar, LeerTexto,Descifrar , LeerV, GuardarTexto;
    private JTextArea AreaEntrada, AreaEncriptar;
    private JLabel laBelTitulo,lEncriptado,laBelEntrada;
    
    

    public Display() {
        //Display
        
        super("Encifrador de Archivos");
        setSize(1420, 900);
        
        setLocationRelativeTo(null); 
        
        setResizable(false);
        
        
        ATxt = new Archivo("TextoPlano", ".txt");
        AVge = new Archivo("TextoEncryptado", ".vge");
        
        
        
        ventana();

        //Para terminar el programa
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void ventana() {
        
        panel = new JPanel();
        
        panel.setBackground(Color.BLACK);
        
        panel.setLayout(null);
        
        this.add(panel); 

        iniciarAreaTxt();
        iniciarAreaVge();

    }

    private void iniciarAreaTxt() {
        
        laBelTitulo = new JLabel("Encriptador y Descriptador por José Job de Jesús Estrada Mata", JLabel.CENTER);
        laBelTitulo.setForeground(Color.WHITE);
        laBelTitulo.setBounds(0, 5, 800, 30);
        
        
        laBelEntrada = new JLabel("Ingresa el texto que quieras Encriptar:", JLabel.CENTER);
        laBelEntrada.setForeground(Color.WHITE);
        laBelEntrada.setBounds(23, 33, 753, 10);
        
        
        //Cuadros de texto
        AreaEntrada = new JTextArea();   
        AreaEntrada.setBounds(10, 80, 760, 250);
        AreaEntrada.setText(ATxt.leerArchivo());
        
        JScrollPane Cuadro1 = new JScrollPane(AreaEntrada, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); //El componente Text Area va estar dentro del deslizador, por lo tanto este se va adaptar a la clase JScrollPane
        Cuadro1.setBounds(10, 80, 760, 250); //Posicion y Dimension del deslizador (Los mismos que los del area del componente)

        //BOTON
        GuardarTexto = new JButton("Guardar");
        GuardarTexto.setBackground(Color.WHITE);
        GuardarTexto.setBounds(10, 350, 130, 30);
       
        GuardarTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ATxt.escribirArchivo(AreaEntrada.getText());
                JOptionPane.showMessageDialog(null, "Su entrada ha sido guardada exitosamente en esta direccion:"
                        + "\n" + ATxt.getPath());
            }
        });
        
        
        Encriptar = new JButton("Encriptar");
        Encriptar.setBackground(Color.WHITE);
        Encriptar.setBounds(150, 350, 130, 30);
       
        Encriptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AreaEncriptar.setText(new Encriptar(AreaEntrada.getText()).getSalidaCifrada());
                JOptionPane.showMessageDialog(null, "Su entrada ha sido encryptada exitosamente");
            }
        });
        LeerTexto = new JButton("Leer fichero .txt");
        LeerTexto.setBackground(Color.WHITE);
        LeerTexto.setBounds(580, 350, 190, 30);
     
        LeerTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AreaEntrada.setText(ATxt.leerArchivo());
                JOptionPane.showMessageDialog(null, "El fichero de texto puede leerse");
            }
        });

        panel.add(laBelTitulo);
        panel.add(laBelEntrada);
        panel.add(GuardarTexto);
        panel.add(Cuadro1);
        panel.add(Encriptar);
        panel.add(LeerTexto);
        
    }

    private void iniciarAreaVge() {
        
        lEncriptado = new JLabel("Encriptado: ", JLabel.CENTER);
        lEncriptado.setForeground(Color.WHITE);
        lEncriptado.setBounds(10, 400, 780, 15);
        
        
        //cUADRO TEXTO
        AreaEncriptar = new JTextArea();
        AreaEncriptar.setEditable(true);
        AreaEncriptar.setBounds(10, 420, 760, 250);
        AreaEncriptar.setText(AVge.leerArchivo());
        
        JScrollPane Cuadro2 = new JScrollPane(AreaEncriptar, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); //El componente Text Area va estar dentro del deslizador, por lo tanto este se va adaptar a la clase JScrollPane
        Cuadro2.setBounds(10, 420, 760, 250); //Posicion y Dimension del deslizador (Los mismos que los del area del componente)
        
        
        GuardarVGE = new JButton("Guardar");
        GuardarVGE.setBackground(Color.white);
        GuardarVGE.setBounds(10, 690, 130, 30);
        
        GuardarVGE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AVge.escribirArchivo(AreaEncriptar.getText());
                JOptionPane.showMessageDialog(null, "Se guardo correctamente en :"
                        + "\n" + AVge.getPath());
            }

        });
        Descifrar = new JButton("Descifrar");
        Descifrar.setForeground(Color.BLACK);
        Descifrar.setBackground(Color.WHITE);
        Descifrar.setBounds(150, 690, 130, 30);
        
        Descifrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AreaEntrada.setText(new Encriptar(AreaEncriptar.getText()).getSalidaDescifrada());
                JOptionPane.showMessageDialog(null, "Operación realizada");
            }
        });
        LeerV = new JButton("Leer fichero .vge");
        
        LeerV.setBackground(Color.WHITE);
        
        LeerV.setBounds(580, 690, 190, 30);
       
        LeerV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                AreaEncriptar.setText(AVge.leerArchivo());
                
                JOptionPane.showMessageDialog(null, "Se pudo leer VGE");
                
            }
        });

        panel.add(lEncriptado);
        panel.add(GuardarVGE);
        panel.add(Descifrar);
        panel.add(LeerV);
        panel.add(Cuadro2);

    }

}
    

