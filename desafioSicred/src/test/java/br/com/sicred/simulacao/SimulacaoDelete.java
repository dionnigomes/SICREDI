package br.com.sicred.simulacao;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SimulacaoDelete {
	
//	@BeforeEach
//	public void BeforeEach() {
//		//Configurando os dados da API rest para inserção
//	       baseURI = "http://localhost:8080/";
//	       port = 8080;
//	       basePath = "/api";
//	}
	
	@Test
	@DisplayName("Exclue uma simulação")
    public void testDeletaSimulacao()
    {
			
       //Deleta uma simulação
		given()
      	.delete("http://localhost:8080/api/v1/simulacoes/22" )
		.then()
			.assertThat()
				.statusCode(200);
              
    }

}
