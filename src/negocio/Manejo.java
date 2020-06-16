/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.*;
import paises.*;
import static web.JsonUrl.obtieneJson;

/**
 *
 * @author ESGEN
 */
public class Manejo {
//    private String inicialesPais[];
    
    private List<Pais> paises;
    private Mundo mundo;
    private Pais pais;
    {
//        inicialesPais = new HashMap();
//        String inicialesPais[] = {"CO", "US", "MX", "BR", "CL", "VE", "IT", "ES"};
//        inicialesPais.put("Colombia", "CO");
        paises = new ArrayList();
    }
    public Manejo() {        
//        this.pais = new Pais(obtieneJson((String)inicialesPais.get("Colombia")));
        String inicialesPais[] = {"CO", "US", "MX", "BR", "CL", "VE", "IT", "ES"};
        for(String paiss : inicialesPais){
            this.pais = new Pais(obtieneJson(paiss));
            paises.add(pais);
        }
        this.mundo = new Mundo(obtieneJson());
    }
    
    public String infoPais(String pais, String info){
        String dato = null;
        for(Pais paiss : paises){
            if(paiss.getPais().equals(pais)){
                dato = paiss.datoDiaUltimo(info)+"";
                return dato;
            }
        }
        return dato;
    }
    
    public String infoMundo(String metodo){
//        "total_cases":6384205,
//        "total_recovered":2920953,
//        "total_unresolved":2255875,
//        "total_deaths":377797,
//        "total_new_cases_today":21009,
//        "total_new_deaths_today":606,
//        "total_active_cases":17247,
//        "total_serious_cases":2720432,
//        "total_affected_countries":213,
        switch(metodo){
            case "total_cases":
                return mundo.getTotal_cases()+"";
            case "total_recovered":
                return mundo.getTotal_recovered()+"";
            case "total_unresolved":
                return mundo.getTotal_unresolved()+"";
            case "total_deaths":
                return mundo.getTotal_deaths()+"";
            case "total_new_cases_today":
                return mundo.getTotal_new_cases_today()+"";
            case "total_new_deaths_today":
                return mundo.getTotal_new_deaths_today()+"";
            case "total_active_cases":
                return mundo.getTotal_active_cases()+"";
            case "total_serious_cases":
                return mundo.getTotal_serious_cases()+"";
            case "total_affected_countries":
                return mundo.getTotal_affected_countries()+"";
            default:
                return null;
        }
    }
    
    public String getFecha(){
        return pais.getFecha();
    }
    
    public ArrayList obtenerHistorico(String pais, String info){
        ArrayList<Long> array = new ArrayList();
        List<CasosDia> casosDia = new ArrayList();
        String dato = null;
        for(Pais paiss : paises){
            if(paiss.getPais().equals(pais)){
                casosDia = paiss.getCasosDia();
                break;
            }
        }
        casosDia.forEach((casoD) -> {
            array.add(casoD.getDato(info));
        });
        return array;
    }
    
}
