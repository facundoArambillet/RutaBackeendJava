import java.util.Date;

public class Mensaje {
    int id;
    String mensaje;
    String autor;
    Date fecha;
    public Mensaje() {

    }
    public Mensaje(String mensaje, String autor) {
    this.mensaje = mensaje;
    this.autor = autor;
    this.fecha = new Date();
    }



    public int getId() {
        return id;
    }
    public String getMensaje() {
        return mensaje;
    }
    public String getAutor() {
        return autor;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
