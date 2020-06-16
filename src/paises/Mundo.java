/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paises;

import com.google.gson.*;

/**
 *
 * @author ESGEN
 */
public class Mundo {

    private long total_cases;
    private long total_recovered;
    private long total_unresolved;
    private long total_deaths;
    private long total_new_cases_today;
    private long total_new_deaths_today;
    private long total_active_cases;
    private long total_serious_cases;
    private long total_affected_countries;

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
    public Mundo(JsonObject json) {
        JsonArray jsonArr = json.get("results").getAsJsonArray();

        for (JsonElement obj : jsonArr) {
            JsonObject gsonObj = obj.getAsJsonObject();
            
            this.total_cases = gsonObj.get("total_cases").getAsLong();
            this.total_recovered = gsonObj.get("total_recovered").getAsLong();
            this.total_unresolved = gsonObj.get("total_unresolved").getAsLong();
            this.total_deaths = gsonObj.get("total_deaths").getAsLong();
            this.total_new_cases_today = gsonObj.get("total_new_cases_today").getAsLong();
            this.total_new_deaths_today = gsonObj.get("total_new_deaths_today").getAsLong();
            this.total_active_cases = gsonObj.get("total_active_cases").getAsLong();
            this.total_serious_cases = gsonObj.get("total_serious_cases").getAsLong();
            this.total_affected_countries = gsonObj.get("total_affected_countries").getAsLong();
        }
    }

    public long getTotal_cases() {
        return total_cases;
    }

    public long getTotal_recovered() {
        return total_recovered;
    }

    public long getTotal_unresolved() {
        return total_unresolved;
    }

    public long getTotal_deaths() {
        return total_deaths;
    }

    public long getTotal_new_cases_today() {
        return total_new_cases_today;
    }

    public long getTotal_new_deaths_today() {
        return total_new_deaths_today;
    }

    public long getTotal_active_cases() {
        return total_active_cases;
    }

    public long getTotal_serious_cases() {
        return total_serious_cases;
    }

    public long getTotal_affected_countries() {
        return total_affected_countries;
    }

}
