import com.google.gson.Gson;
import okhttp3.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GatosService  {

    public static void verGatos() throws IOException {   //Generado desde postman
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .method("GET", null) //Cambiar el body por null
                .build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();
        json = json.substring(1,json.length());
        json = json.substring(0,json.length()-1);

        //Convierto los parametos que me devuelve en un objeto gato
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(json,Gatos.class);

        URL url = new URL(gatos.getUrl());
        BufferedImage imagen = ImageIO.read(url);
        ImageIcon fondoGato = new ImageIcon(imagen);
        if(fondoGato.getIconWidth() > 800) {
            Image fondo = fondoGato.getImage();
            Image imagenModificada = fondo.getScaledInstance(800,600, Image.SCALE_DEFAULT);
            fondoGato = new ImageIcon(imagenModificada);
        }
        String[] menu = {"1. Ver otra imagen","2. Favorito","3. Volver"};

        String id_gato = String.valueOf(gatos.getId());
        String opcion = (String) JOptionPane.showInputDialog(null,menu,id_gato,JOptionPane.INFORMATION_MESSAGE,fondoGato,
                menu,menu[0]);

        int seleccion = -1;

        for (int i = 0; i < menu.length; i++) {
            if (opcion.equals(menu[i])) {
                seleccion = i +1;
            }
        }

        switch (seleccion) {
            case 1:
                verGatos();
                break;
            case 2:
                favoritoGato(gatos);
                break;
            default:
                break;
        }

    }
    public static void favoritoGato(Gatos gato) {
        System.out.println("asd");
    }
}
