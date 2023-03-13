import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MensajeService {
    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba su mensaje: ");
        String mensaje = sc.nextLine();

        System.out.println("Escriba su nombre: ");
        String nombre = sc.nextLine();

        Date fecha = new Date();
        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutor(nombre);
        registro.setFecha(fecha);
        MensajeDAO.crearMensaje(registro);
    }
    public static void leerMensaje() {
        MensajeDAO.leerMensaje();
    }
    public static void actualizarMensaje() {
        Scanner sc = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println("Escriba el id: ");
        int id = scan.nextInt();

        System.out.println("Escriba su mensaje: ");
        String mensaje = sc.nextLine();

        System.out.println("Escriba su nombre: ");
        String nombre = sc.nextLine();

        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutor(nombre);
        Date nuevaFecha = new Date();
        registro.setFecha(nuevaFecha);
        MensajeDAO.actualizarMensaje(registro,id);
    }
    public static void borrarMensaje() {

    }
}
