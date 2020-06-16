/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paises;

import java.util.*;
import com.google.gson.*;

/**
 *
 * @author ESGEN
 */
public class Pais {

    private String pais;
    private CasosDia casoDia;
    private List<CasosDia> casosDia;

    /*
    {"countrytimelinedata":[{"info":{
		    "ourid":32,
		    "title":"Colombia",
		    "code":"CO",
		    "source":"https://thevirustracker.com/colombia-coronavirus-information-co"
         }}],
    "timelineitems":[{
    "3/06/20":{"new_daily_cases":1,"new_daily_deaths":0,"total_cases":1,"total_recoveries":0,"total_deaths":0},
    "3/07/20":{"new_daily_cases":0,"new_daily_deaths":0,"total_cases":1,"total_recoveries":0,"total_deaths":0},
    "stat":"ok"}]}
     */
    public Pais(JsonObject json) {
        casosDia =  new ArrayList();
        this.pais = null;
        JsonArray jsonArr = json.get("countrytimelinedata").getAsJsonArray();
        for (JsonElement obj : jsonArr) {
            JsonObject jsonObjInfo = obj.getAsJsonObject();
            jsonObjInfo = jsonObjInfo.get("info").getAsJsonObject();
            this.pais = (String)jsonObjInfo.get("code").getAsString();
        }

//        this.pais = pais;
        jsonArr = json.get("timelineitems").getAsJsonArray();

        for (JsonElement obj1 : jsonArr) {
            JsonObject jsonObj = obj1.getAsJsonObject();
//            JsonArray jsonArr2 = jsonObj.getAsJsonArray();
//            for(JsonElement obj : jsonArr2){
//                JsonObject jsonObjDias = obj.getAsJsonObject();
            ArrayList<Integer> codes = new ArrayList<Integer>();
            for (Map.Entry<String,JsonElement> entry : jsonObj.entrySet()) {
//                JsonObject jsonObjDias = entry.getValue().getAsJsonObject();

                if(entry.getKey().equals("stat")){
                    break;
                }
                JsonObject jsonObjDia = entry.getValue().getAsJsonObject();
                String fecha = entry.getKey();//jsonObjDias.get(key);
                long new_daily_cases = jsonObjDia.get("new_daily_cases").getAsLong();
                long new_daily_deaths = jsonObjDia.get("new_daily_deaths").getAsLong();
                long total_cases = jsonObjDia.get("total_cases").getAsLong();
                long total_recoveries = jsonObjDia.get("total_recoveries").getAsLong();
                long total_deaths = jsonObjDia.get("total_deaths").getAsLong();

                casoDia = new CasosDia(fecha, new_daily_cases, new_daily_deaths, total_cases, total_recoveries, total_deaths);
                casosDia.add(casoDia);
            }
        }
    }

    public String getPais() {
        return pais;
    }

    
    public List<CasosDia> getCasosDia() {
        return casosDia;
    }
    
    public long datoDia(String fecha, String dato){
        long datoo = -1;
        for(CasosDia casoD : casosDia){
            if(casoD.getFecha().equals(fecha)){
                casoD.getDato(dato);
            }
        }
        return datoo;
    }
    
    public long datoDiaUltimo(String dato){
        long datoo = -1;       
        CasosDia casoD  = casosDia.get(casosDia.size()-1);
        datoo = casoD.getDato(dato);
        return datoo;
    }
    
    public String getFecha(){
        CasosDia casoD  = casosDia.get(casosDia.size()-1);
        return casoD.getFecha();
    }
    
    

}
