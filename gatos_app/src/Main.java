import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        int opcion_menu = -1;
        String[] botones = {"1. Ver gatos","2. Salir"};

        do {
            String opcion = (String) JOptionPane.showInputDialog(null,"Gatito java","Menu principal",
                    JOptionPane.INFORMATION_MESSAGE,null,botones,botones[0]);

            //Validamos que opcion eligio el usuario
            for (int i = 0; i < botones.length; i++) {
                if(opcion.equals(botones[i])) {
                    opcion_menu = i +1;
                }
            }

            switch(opcion_menu) {
                case 1:
                    try {
                        GatosService.verGatos();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    break;
            }


        }while(opcion_menu != 2);

    }
}