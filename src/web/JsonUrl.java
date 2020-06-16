/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

    enlaces api json
pais:       https://api.thevirustracker.com/free-api?countryTimeline=CO
global:     https://api.thevirustracker.com/free-api?global=stats

paises:
{"paises":["CO", "US", "MX", "BR", "CL", "VE"]}

 */


package web;

//import com.google.gson.Gson;
import com.google.gson.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author ESGEN
 */
public class JsonUrl {
    
    public static JsonObject obtieneJson(String pais){
        JsonObject jSon = null;
        try {
            URL url = new URL("https://api.thevirustracker.com/free-api?countryTimeline="+pais);
            jSon = obtieneJson(url);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return jSon;
        }
    }
    
    public static JsonObject obtieneJson() {
        JsonObject jSon = null;
        try {
            URL url = new URL("https://api.thevirustracker.com/free-api?global=stats");
            jSon = obtieneJson(url);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return jSon;
        }
    }
    private static JsonObject obtieneJson(URL url) {
        JsonObject json = null;
        try {
            //creamos una URL donde esta nuestro webservice
//            URL url = new URL("https://api.thevirustracker.com/free-api?global=stats");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //indicamos por que verbo HTML ejecutaremos la solicitud
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            if (conn.getResponseCode() != 200) {
                //si la respuesta del servidor es distinta al codigo 200 lanzaremos una Exception
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            //creamos un StringBuilder para almacenar la respuesta del web service
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = br.read()) != -1) {
                sb.append((char) cp);
            }
            //en la cadena output almacenamos toda la respuesta del servidor
            String output = sb.toString();
            //convertimos la cadena a JSON a traves de la libreria GSON
            json = new Gson().fromJson(output, JsonObject.class);
            
            
//            //imprimimos como Json
//            System.out.println("salida como JSON" + json);
//            //imprimimos como String
//            System.out.println("salida como String : " + output+"\n\n");
//            
//            JsonArray jsonArr = json.get("results").getAsJsonArray();
//            long total_casos = 0;
//            
//            for(JsonElement obj : jsonArr){
//                JsonObject gsonObj = obj.getAsJsonObject();
//                total_casos = gsonObj.get("total_cases").getAsLong();
//            }
//            
//            System.out.println("total casos: "+total_casos);

            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            return json;
        }
    }
    
    
    /*    
    {
        "results":[
           {
              "total_cases":6384205,
              "total_recovered":2920953,
              "total_unresolved":2255875,
              "total_deaths":377797,
              "total_new_cases_today":21009,
              "total_new_deaths_today":606,
              "total_active_cases":17247,
              "total_serious_cases":2720432,
              "total_affected_countries":213,
              "source":{
                 "url":"https://thevirustracker.com/"
              }
           }
        ],
        "stat":"ok"
     }
    */
    
    
}
