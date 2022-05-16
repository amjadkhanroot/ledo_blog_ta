package com.amjadcode.ledo_blog_ta;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LedoBlogTaApplication {

    public static void main(String[] args) throws UnirestException, JSONException {
        SpringApplication.run(LedoBlogTaApplication.class, args);

        getNewCases();
    }

    public static void getNewCases() throws UnirestException, JSONException {

        String urlOverHttps = "https://services6.arcgis.com/bKYAIlQgwHslVRaK/arcgis/rest/services/VWPlacesCasesHostedView/FeatureServer/0/query" +
                "?f=json&where=(NewAdded%20%3D%201)%20AND%20(NewAdded%3E0)&returnGeometry=false&spatialRel=esriSpatialRelIntersects&outFields=*" +
                "&outStatistics=%5B%7B%22statisticType%22%3A%22sum%22%2C%22onStatisticField%22%3A%22Confirmed%22%2C%22outStatisticFieldName%22%3A%22value%22%7D%5D&outSR=102100&resultType=standard&cacheHint=true";

        JSONArray totalNewCases
                = Unirest.get(urlOverHttps)
                .header("accept", "application/json")
                .asJson().getBody().getObject().getJSONArray("features");

        int value = -1;
        for (int i = 0; i < totalNewCases.length(); i++) {

            if (!totalNewCases.getJSONObject(i).getJSONObject("attributes").isNull("value"))
                value = totalNewCases.getJSONObject(i).getJSONObject("attributes").getInt("value");
        }
            System.out.println(value);
    }

}
