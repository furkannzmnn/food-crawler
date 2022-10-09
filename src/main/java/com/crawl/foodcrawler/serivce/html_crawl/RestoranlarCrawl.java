package com.crawl.foodcrawler.serivce.html_crawl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RestoranlarCrawl {

    private static final String URL = "https://getir.com/yemek/restoranlar";
    int retryCount = 0;

    private final ObjectMapper objectMapper;

    public void crawlProps() {

        final Connection connect = Jsoup.connect(URL);
        Map<String, String> header = new HashMap<>();
        header.put("authority", "getir.com");
        header.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        header.put("accept-language", "tr-TR,tr;q=0.9,en-US;q=0.8,en;q=0.7");
        header.put("cache-control", "max-age=0");
        header.put("cookie", "cookiePermissions={\"essential\":true}; language=tr; _gcl_au=1.1.1800248312.1664659130; ajs_anonymous_id=%2257c9c333-aa5f-4174-86a0-e184fd5ebf20%22; isWarehouseRequestSended=false; newAddress=true; _gid=GA1.2.1918038585.1665172491; deviceId=9ae7c257-db72-4c41-bafa-07984afda438; refreshToken=e1e610cb-d2ed-4030-8d7d-9378e92bd5a0; defaultToken=166517269895557bffbe58d1055f2cf7bf3cdb0d664f1839e6c3dbd0e8553c49668c8ae7a2f5d; gsm=%7B%22countryCode%22%3A%2290%22%2C%22gsmWithoutCountryCode%22%3A%225373933128%22%7D; userId=5f721358204f740007673e08; accessToken=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbmNyeXB0ZWREYXRhIjoiTXY5c0QzT3BMVGFkeTltaEU3YVBRVVp1N2pMRS9uWjZkWGVjUE1kblB1MjBYaXk0VktiMkM0QnhBWkJQeFdxMGIwaFdiaDAxOVArQy9UcjAvQUtaSVJYU1lubzR0VzJ1Qkg3cW5PTjZqUDlQLy9QRzhMN2VkYmxXTm1id0FVN2U3RUIvNThyN25HTW55YlpSaE9tTjVTUUVQVnpGYm1JNUhCMnZueXk0MFNCZjVRbGtiVjVxUGRVZ0NxejVMQWUxUjBZdWJ2TFJyQkpGd3AxMkQ1ODkrZUhSK3ZiTkNlZERDT28wK1RlOEd3cG5vQlNVVnA1cFdTVWV4MldUWU95SEtyOFluSUdzbnVtaGt2V0tVRFdKOUE9PSIsImlhdCI6MTY2NTIzMDgyMCwiZXhwIjoxNjY1MjU5NjIwLCJpc3MiOiJhdXRoLXNlcnZpY2UifQ.mDuQTWmlM7u3oMN5ZPdUxBjsQqc4r8IT8PzVM_pk-vA; accessTokenExpiresAt=1665259620; appType=GETIR_FOOD; _ga_1GZP24F3YP=GS1.1.1665230823.5.1.1665235538.58.0.0; _ga=GA1.2.376331963.1664659130; cto_bundle=_GkheF9EJTJGSlJ4Y0tseDltOG53JTJGSHpuNWM3RlBWdU1jck5qMHdCaGdsWTk1bGpRJTJGMjclMkZWYU1PNSUyRkp0RzVtYW1xd0htcjZBekJoRXBzeXlJTmRoeEhtNEcyU3ZFZVM5aFVxUVJFTE5HRTQ0RHY4aloyNFBsbjM2Nm05clRoRTQ5bU1tbkRsR3UzdiUyQnAxMnFLNmQ1N0dzVVNmbEElM0QlM0Q; trueClientIp=159.146.57.29; selectedAddressId=634195a5b89735cca0f037ae; location=%7B%22lat%22%3A41.02106800513196%2C%22lon%22%3A28.672284297645096%2C%22id%22%3A%22634195a5b89735cca0f037ae%22%2C%22name%22%3A%22Ev%22%2C%22createdAt%22%3A%222022-10-08T15%3A22%3A13.331Z%22%2C%22address%22%3A%22Talatpa%C5%9Fa%2C%201035.%20Sk.%20No%3A26%2C%2034513%20Beylikd%C3%BCz%C3%BC%20Osb%2FEsenyurt%2F%C4%B0stanbul%2C%20T%C3%BCrkiye%22%2C%22aptNo%22%3A%2226%22%2C%22doorNo%22%3A%224%22%2C%22floor%22%3A%223%22%2C%22streetAddress%22%3A%2226%201035.%20Sokak%2C%20Talatpa%C5%9Fa%2C%20Beylikd%C3%BCz%C3%BC%20Osb%22%2C%22city%22%3A%22Beylikd%C3%BCz%C3%BC%20Osb%22%2C%22state%22%3A%22%C4%B0stanbul%22%2C%22country%22%3A%22T%C3%BCrkiye%22%2C%22addressType%22%3A1%2C%22emojiId%22%3A19%2C%22emojiURL%22%3A%22https%3A%2F%2Fcdn.getir.com%2Fmisc%2Femoji%2Fhouse.png%22%2C%22postCode%22%3A%2234513%22%7D");
        header.put("dnt", "1");
        header.put("sec-ch-ua", "\"Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105\"");
        header.put("sec-ch-ua-mobile", "?0");
        header.put("sec-ch-ua-platform", "\"macOS\"");
        header.put("sec-fetch-dest", "document");
        header.put("sec-fetch-mode", "navigate");
        header.put("sec-fetch-site", "same-origin");
        header.put("sec-fetch-user", "?1");
        header.put("upgrade-insecure-requests", "1");
        header.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");

        connect.headers(header);

        try {
            retryCount++;
            final Document document = connect.get();
            final Element body = document.body();
            final Node json = body.getElementById("__NEXT_DATA__").childNode(0);
            final String data = json.attributes().get("data");

            // data nesnesi anasayfadaki tüm restoran id'lerini dönüyor

        } catch (IOException e) {
            if (retryCount < 4) {
                crawlProps();
            }else {
                e.printStackTrace();
                throw new RuntimeException("ops");
            }
        }

    }
}
