import javax.swing.*;
import java.io.*;

class Cancion {
    private String[] letra; //Arreglo con las letras de cada día
    private ImageIcon[] imagen; //Arreglo con la imagen de cada día

    Cancion(){ //Método constructor. Da valores con la letra de la canción y la imagen de cada día
        letra = new String[12];
        imagen = new ImageIcon[12];
        letra[0] = "El primer día de navidad mi amor me regaló: una perdiz en un peral";
        letra[1] = "El segundo día de navidad mi amor me regaló: dos tortolas";
        letra[2] = "El tercer día de navidad mi amor me regaló: tres gallinas francesas";
        letra[3] = "El cuarto día de navidad mi amor me regaló: cuatro pájaros llamando";
        letra[4] = "El quinto día de navidad mi amor me regaló: cinco anillos de oro";
        letra[5] = "El sexto día de navidad mi amor me regaló: seis ocas poniendo";
        letra[6] = "El séptimo día de navidad mi amor me regaló: siete cisnes nadando";
        letra[7] = "El octavo día de navidad mi amor me regaló: ocho criadas ordenando";
        letra[8] = "El noveno día de navidad mi amor me regaló: nueve señoras bailando";
        letra[9] ="El décimo día de navidad mi amor me regaló: diez señores brincando";
        letra[10] = "El undécimo día de navidad mi amor me regaló: once gaiteros tocando";
        letra[11] ="El duodécimo día de navidad mi amor me regaló: doce tamborileros tamboreando";

        imagen[0] = new ImageIcon("image1.png");
        imagen[1] = new ImageIcon("image2.png");
        imagen[2] = new ImageIcon("image3.png");
        imagen[3] = new ImageIcon("image4.png");
        imagen[4] = new ImageIcon("image5.png");
        imagen[5] = new ImageIcon("image6.png");
        imagen[6] = new ImageIcon("image7.png");
        imagen[7] = new ImageIcon("image8.png");
        imagen[8] = new ImageIcon("image9.png");
        imagen[9] = new ImageIcon("image10.png");
        imagen[10] = new ImageIcon("image11.png");
        imagen[11] = new ImageIcon("image12.png");
    }

    public String getLetra(int dia){ // Método que retorna el texto de la letra para un día específico
        return letra[dia-1];
    }

    public ImageIcon getImagen(int dia){ // Método que retorna la imagen para un día específico
        return imagen[dia-1];
    }
}

public class Principal {
    public static void main(String[] args) {
        int opc; // Determina el día seleccionado
        String continuar; // Variable para controlar si continúa la ejecución
        JFrame frame = new JFrame("Proyecto 1"); // Creación del marco principal
        Cancion obj_cancion = new Cancion(); // Nuevo objeto Cancion. Se ejecuta el constructor

        JOptionPane.showMessageDialog(frame, "Los 12 días de navidad");
        do{
            opc = 0;
            try{
                // Se lee el día correspondiente
                opc = Integer.parseInt(JOptionPane.showInputDialog(frame, "Introduzca un dia[1-12]:", "12 días de navidad", 1));
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(frame, "Error de formato: " + e.getMessage(), "Excepcion", JOptionPane.WARNING_MESSAGE);
            }catch(Exception e){
                JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Excepcion", JOptionPane.WARNING_MESSAGE);
            }

            if(opc > 0 && opc < 13){ // Para que el índice esté dentro del rango
                for(int i=opc; i>0; i--){ // Para imprimir todos los días anteriores
                    try{
                        // Aquí se muestra la ventana con la letra y el ícono correspondiente.
                        JOptionPane.showMessageDialog(frame, obj_cancion.getLetra(i), "Cancion", JOptionPane.INFORMATION_MESSAGE, obj_cancion.getImagen(i)); 
                    }catch(ArrayIndexOutOfBoundsException e){
                        JOptionPane.showMessageDialog(frame, "Valor fuera de rango: " + e.getMessage(), "Excepcion", JOptionPane.WARNING_MESSAGE);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Excepcion", JOptionPane.WARNING_MESSAGE);
                    }
                }}

            try{
                continuar = JOptionPane.showInputDialog(frame, "Escriba 'si' para continuar");
            }catch(Exception e){
                JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Excepcion", JOptionPane.WARNING_MESSAGE);
                continuar = "si"; // Asignado para que no se detenga la ejecución y continúe con el ciclo.
            }
        }while(continuar.equals("si")); // Determina si sale o no
        System.exit(0); // Detiene la ejecución
    }
}
