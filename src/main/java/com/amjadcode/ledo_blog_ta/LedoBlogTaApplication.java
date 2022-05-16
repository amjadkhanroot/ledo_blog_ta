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
    }



}
