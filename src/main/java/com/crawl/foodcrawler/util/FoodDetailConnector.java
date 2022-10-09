package com.crawl.foodcrawler.util;

import com.crawl.foodcrawler.dto.getir.response.Root;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public final class FoodDetailConnector {
        public static String getHttpURLConnectionCuisine(String productID) throws IOException {
            String response = null;
            try {
                URL url = new URL("https://food-client-api-gateway.getirapi.com/restaurants/products/" + productID);
                HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                httpConn.setRequestMethod("GET");


                httpConn.setRequestProperty("authority", "food-client-api-gateway.getirapi.com");
                httpConn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
                httpConn.setRequestProperty("accept-language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
                httpConn.setRequestProperty("cache-control", "max-age=0");
                httpConn.setRequestProperty("dnt", "1");
                httpConn.setRequestProperty("sec-ch-ua", "\"Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105\"");
                httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
                httpConn.setRequestProperty("sec-ch-ua-platform", "\"macOS\"");
                httpConn.setRequestProperty("sec-fetch-dest", "document");
                httpConn.setRequestProperty("sec-fetch-mode", "navigate");
                httpConn.setRequestProperty("sec-fetch-site", "none");
                httpConn.setRequestProperty("sec-fetch-user", "?1");
                httpConn.setRequestProperty("upgrade-insecure-requests", "1");
                httpConn.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");

                InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                        ? httpConn.getInputStream()
                        : httpConn.getErrorStream();
                Scanner s = new Scanner(responseStream).useDelimiter("\\A");
                response = s.hasNext() ? s.next() : "";
                return response;
            }catch (Exception e) {
                getHttpURLConnectionCuisine(productID);
            }
            return response;
        }



}
