import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection get_connection() {
        Connection conection = null;
      String  DB_USER  = "root";
      String  DB_PASSWORD = "123456789";
        try{
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app?useSSL=false&serverTimezone=UTC",DB_USER,DB_PASSWORD);
            if (conection != null) {
                System.out.println("Conexion exitosa");
            }
        }
        catch(SQLException error) {
            System.out.println(error);
        }
        return conection;
    }
}
