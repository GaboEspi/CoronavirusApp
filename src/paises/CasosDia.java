/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paises;


import java.util.*;

/**
 *
 * @author ESGEN
 */
public class CasosDia {
    //3/06/20":{"
    private String fecha;
//    private long new_daily_cases;
//    private long new_daily_deaths;
//    private long total_cases;
//    private long total_recoveries;
//    private long total_deaths;
    
    private Map mapCasosDia;

    public CasosDia(String fecha, long new_daily_cases, long new_daily_deaths, long total_cases, long total_recoveries, long total_deaths) {
        this.mapCasosDia = new HashMap();
        this.fecha = fecha;
        this.mapCasosDia.put("new_daily_cases", new_daily_cases);
        this.mapCasosDia.put("new_daily_deaths", new_daily_deaths);
        this.mapCasosDia.put("total_cases", total_cases);
        this.mapCasosDia.put("total_recoveries", total_recoveries);
        this.mapCasosDia.put("total_deaths", total_deaths);
        
//        mapCasosDia.entrySet()
    }

    public String getFecha() {
        return fecha;
    }

    public long getDato(String dato) {
        return (long) this.mapCasosDia.get(dato);
    }
    
//    public long getNew_daily_cases() {
//        return new_daily_cases;
//    }
//
//    public long getNew_daily_deaths() {
//        return new_daily_deaths;
//    }
//
//    public long getTotal_cases() {
//        return total_cases;
//    }
//
//    public long getTotal_recoveries() {
//        return total_recoveries;
//    }
//
//    public long getTotal_deaths() {
//        return total_deaths;
//    }

    
    
    
}
