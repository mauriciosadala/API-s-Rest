package com.example.RestAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class Service {

    public String preverTempo(){
        String dadosMetereologicos = "";
        String apiUrl = "http://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=d2cb00ee3f46ff555ba32c3ed8c735e2";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosMetereologicos =  responseEntity.getBody();
        }
        else { dadosMetereologicos = "Falha ao obter dados metereologicos" + responseEntity.getStatusCode();

        }
        return dadosMetereologicos;
    }

}
