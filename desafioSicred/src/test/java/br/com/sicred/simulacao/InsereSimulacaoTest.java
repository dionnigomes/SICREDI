package br.com.sicred.simulacao;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


@DisplayName(value = "Testes de API rest do módulo de restrição de CPF")
public class InsereSimulacaoTest {
	
//	@BeforeEach
//	public void BeforeEach() {
//		//Configurando os dados da API rest para inserção
//	       baseURI = "http://localhost:8080";
//	       port = 8080;
//	       basePath = "/api";
//	}
	
	@Test
	@DisplayName("Insere uma nova simulação")
    public void testInsereNovaSimulacao()
    {
		       
       //Insere nova simulação
       given()
       	.contentType(ContentType.JSON)
       	.body("{\r\n"
       			+ "  \"nome\": \"Fulano de Tal\",\r\n"
       			+ "  \"cpf\": 97093236014,\r\n"
       			+ "  \"email\": \"email@email.com\",\r\n"
       			+ "  \"valor\": 1200,\r\n"
       			+ "  \"parcelas\": 3,\r\n"
       			+ "  \"seguro\": true\r\n"
       			+ "}")
       	       	
       	.when()
       		.post("http://localhost:8080/api/v1/simulacoes")
		.then()
			.assertThat()
				.statusCode(201);
              
    }

	@Test
	@DisplayName("Insere uma nova simulação")
    public void testInsereNovaSimulacaoJaExiste()
    {       
       //Insere nova simulação
       given()
       	.contentType(ContentType.JSON)
       	.body("{\r\n"
       			+ "  \"nome\": \"Fulano de Tal\",\r\n"
       			+ "  \"cpf\": 97093236014,\r\n"
       			+ "  \"email\": \"email@email.com\",\r\n"
       			+ "  \"valor\": 1200,\r\n"
       			+ "  \"parcelas\": 3,\r\n"
       			+ "  \"seguro\": true\r\n"
       			+ "}")
       	       	
       	.when()
       		.post("http://localhost:8080/api/v1/simulacoes")
		.then()
			.assertThat()
				.body("mensagem", equalTo("CPF duplicado"))
				.statusCode(400);
              
    }

	@Test
	@DisplayName("Insere uma nova simulação")
    public void testInsereNovaSimulacaoFaltaInformacao()
    {
	     
       //Tenta inserir uma nova simulação faltando informações, sem preenchimento de campos
       given()
       	.contentType(ContentType.JSON)
       	.body("{\r\n"
       			+ "  \"nome\": \"Fulano de Tal\",\r\n"
       			//+ "  \"cpf\": 97093236014,\r\n"
       			+ "  \"email\": \"email@email.com\",\r\n"
       			+ "  \"valor\": 1200,\r\n"
       			//+ "  \"parcelas\": 3,\r\n"
       			+ "  \"seguro\": true\r\n"
       			+ "}")
       	       	
       	.when()
       		.post("http://localhost:8080/api/v1/simulacoes")
		.then()
			.assertThat()
				.body("erros.parcelas", equalTo("Parcelas não pode ser vazio"))
				.body("erros.cpf", equalTo("CPF não pode ser vazio"))
				.statusCode(400);
              
    }

}
