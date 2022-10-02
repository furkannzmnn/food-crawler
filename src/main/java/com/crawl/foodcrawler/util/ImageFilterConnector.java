package com.crawl.foodcrawler.util;

import com.crawl.foodcrawler.dto.getir.response.Root;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ImageFilterConnector {
    public static Root getHttpURLConnectionCuisine(String filter) throws IOException {
        URL url = new URL("https://food-client-api-gateway.getirapi.com/restaurants/filter");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("POST");

        httpConn.setRequestProperty("authority", "food-client-api-gateway.getirapi.com");
        httpConn.setRequestProperty("accept", "*/*");
        httpConn.setRequestProperty("accept-language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
        httpConn.setRequestProperty("content-type", "application/json");
        httpConn.setRequestProperty("dnt", "1");
        httpConn.setRequestProperty("language", "tr");
        httpConn.setRequestProperty("origin", "https://getir.com");
        httpConn.setRequestProperty("referer", "https://getir.com/");
        httpConn.setRequestProperty("sec-ch-ua", "\"Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105\"");
        httpConn.setRequestProperty("sec-ch-ua-mobile", "?0");
        httpConn.setRequestProperty("sec-ch-ua-platform", "\"macOS\"");
        httpConn.setRequestProperty("sec-fetch-dest", "empty");
        httpConn.setRequestProperty("sec-fetch-mode", "cors");
        httpConn.setRequestProperty("sec-fetch-site", "cross-site");
        httpConn.setRequestProperty("true-client-ip", "46.1.246.196");
        httpConn.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");


        httpConn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
        writer.write("{\"lat\":41.0081823,\"lon\":28.9716674,\"skip\":0,\"limit\":200,\"sort\":3,\"cuisines\":[\"" + filter + "\"]}");
        writer.flush();
        writer.close();
        httpConn.getOutputStream().close();
        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        final String response = s.hasNext() ? s.next() : "";
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response, Root.class);
    }

}
