import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("----------------------");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1. Crear Mensaje");
            System.out.println("2. Listar Mensajes");
            System.out.println("3. Actualizar Mensaje");
            System.out.println("4. Eliminar Mensaje");
            System.out.println("5. Salir");
            //Leemos la opcion del usuario
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.leerMensaje();
                    break;
                case 3:
                    MensajeService.actualizarMensaje();
                    break;
                case 4:
                    MensajeService.borrarMensaje();
                    break;
                default:
                    break;
            }

        } while (opcion != 5);



        Conexion conexion = new Conexion();

        try(Connection cnx = conexion.get_connection()) {

        }
        catch(Exception error) {
            System.out.println(error);
        }
    }
}