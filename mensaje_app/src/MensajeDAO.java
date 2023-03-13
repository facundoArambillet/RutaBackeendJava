import java.sql.*;

public class MensajeDAO {
    public static void crearMensaje(Mensaje mensaje) {
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "Insert into mensaje(mensaje,autor,fecha) Values(?,?,CURRENT_TIMESTAMP)";
                ps = conexion.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setString(2,mensaje.getAutor());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }
        catch (SQLException error){
            System.out.println(error);
        }
    }
    public static void leerMensaje() {
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM mensajes_app.mensaje";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();
                while(rs.next()){
                    System.out.print("\n[ID: "+rs.getInt("id")+" | ");
                    System.out.print("mensaje: -"+rs.getString("mensaje")+" | ");
                    System.out.print("fecha: -"+rs.getString("fecha")+" | ");
                    System.out.print("Autor: "+rs.getString("autor")+" ]\n ");
                }
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }
        catch (SQLException error){
            System.out.println(error);
        }
    }
    public static void actualizarMensaje(Mensaje nuevoMensaje, int id) {
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = String.format("UPDATE mensajes_app.mensaje SET mensaje = ?, autor = ?, fecha = ? WHERE mensaje.id = %d", id);
                ps = conexion.prepareStatement(query);
                ps.setString(1, nuevoMensaje.mensaje);
                ps.setString(2, nuevoMensaje.autor);
                ps.setDate(3, new java.sql.Date(nuevoMensaje.fecha.getTime()));
                ps.executeUpdate();

                System.out.println("Mensaje Actualizado");
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        }
        catch (SQLException error){
            System.out.println(error);
        }
    }
    public static void borrarMensaje() {

    }
}
