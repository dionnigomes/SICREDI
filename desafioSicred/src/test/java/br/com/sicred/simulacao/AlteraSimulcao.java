package br.com.sicred.simulacao;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import io.restassured.http.ContentType;

public class AlteraSimulcao {
	
//	@BeforeEach
//	public void beforeEach() {
//		//Configurando os dados da API rest para inserção
//	       baseURI = "http://localhost:8080/";
//	       port = 8080;
//	       basePath = "/api";
//	}

	@Test
	@DisplayName("Altera uma simulação")
    public void testAlteraSimulacao()
    {
	     
       //Altera uma simulação
       given()
       	.contentType(ContentType.JSON)
       	.body("{\r\n"
       			+ "  \"nome\": \"Fulano de Tal Alterado\",\r\n" //nome alterado
       			+ "  \"cpf\": 97093236014,\r\n"
       			+ "  \"email\": \"email@email.com\",\r\n"
       			+ "  \"valor\": 1600,\r\n" //valor alterado
       			+ "  \"parcelas\": 3,\r\n"
       			+ "  \"seguro\": true\r\n"
       			+ "}")
       	       	
       	.when()
       		.put("http://localhost:8080/api/v1/simulacoes/97093236014")
		.then()
			.assertThat()
				.statusCode(200);
              
    }

	@Test
	@DisplayName("Tentar consultar uma simulaçao inexistente")
    public void testAlteraSimulacaoFaltaInformacao()
    {
	     
       given()
       	.contentType(ContentType.JSON)
       	.body("{\r\n"
       			+ "  \"nome\": \"Fulano de Tal Alterado\",\r\n" //nome alterado
       			//+ "  \"cpf\": 97093236014,\r\n"
       			+ "  \"email\": \"email@email.com\",\r\n"
       			+ "  \"valor\": 1600,\r\n" //valor alterado
       			//+ "  \"parcelas\": 3,\r\n"
       			+ "  \"seguro\": true\r\n"
       			+ "}")
       	       	
       	.when()
       		.put("http://localhost:8080/api/v1/simulacoes/97093236014")
		.then()
			.assertThat()
				.statusCode(404);       
    }

	@Test
	@DisplayName("Tentar consultar uma simulaçao inexistente")
    public void testAlteraSimulacaoExistente()
    {
	     
       given()
       	.contentType(ContentType.JSON)
       	.body("{\r\n"
       			+ "  \"nome\": \"Fulano de Tal Alterado\",\r\n" //nome alterado
       			+ "  \"cpf\": 97093236014,\r\n"
       			+ "  \"email\": \"email@email.com\",\r\n"
       			+ "  \"valor\": 1600,\r\n" //valor alterado
       			+ "  \"parcelas\": 3,\r\n"
       			+ "  \"seguro\": true\r\n"
       			+ "}")
       	       	
       	.when()
       		.put("http://localhost:8080/api/v1/simulacoes/97093236014")
		.then()
			.assertThat()
				.body("cpf", equalTo("97093236014"))
					.statusCode(409);
              
    }

}
