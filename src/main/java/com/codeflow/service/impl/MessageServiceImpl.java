package com.codeflow.service.impl;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.codeflow.dto.WhatsappDTO;
import com.codeflow.service.ClienteService;
import com.codeflow.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class MessageServiceImpl implements MessageService {

	 @Value("${phone.number}")
	 private String phoneNumber;
	
	 @Value("${API_KEY_WHATSGW}")
	 private String apiKey;
	 
	 @Value("${URL_WHATSGW}")
	 private String url;
	 
	 @Autowired
	 ObjectMapper objectMapper;
	 
	 
	 
	@Override
	public String postMessage(String message, String number) {	
		try {
		
		double randomId = Math.random();
		
		HttpClient client = HttpClient.newHttpClient();
		  
		WhatsappDTO whatsObj = new WhatsappDTO(apiKey, phoneNumber, number, String.valueOf(randomId) , "text", message);
		
        String jsonData = objectMapper.writeValueAsString(whatsObj);

        BodyPublisher requestBody = BodyPublishers.ofString(jsonData, StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .POST(requestBody)
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response: " + response.body());
        
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(response.body()).getAsJsonObject();

        // Obtém o valor da chave "result"
        String result = jsonObject.get("result").getAsString();
        return result;
        }catch (Exception e) {
        	System.out.println(e);
        	return "fail";
		}
    }
	

}
