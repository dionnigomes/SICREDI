package br.com.sicred.simulacao;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class ConsultaSimulacao {
	
	@Test
	@DisplayName("Validar se um CPF tem restrição ou não")
    public void testConsultaSimulcaoPorCpf()
    {
		//Configurando os dados da API rest para restrições
       //baseURI = "http://localhost:8080/";
       //port = 8080;
       //basePath = "/api";
       
       //buscar CPF para verificarção de restrição
       given()
       		.get("http://localhost:8080/api/v1/simulacoes/97093236014")
   		.then()
   			.assertThat()
   				.statusCode(200);
       		       
    }
	
	@Test
	@DisplayName("Validar se um CPF tem restrição ou não")
    public void testConsultaSimulcaoPorCpfErrado()
    {
		//Configurando os dados da API rest para restrições
       //baseURI = "http://localhost:8080/";
       //port = 8080;
       //basePath = "/api";
       
       //buscar CPF para verificarção de restrição
       given()
       		.get("http://localhost:8080/api/v1/simulacoes/93093236014")
   		.then()
   			.assertThat()
   				.statusCode(404);
       		       
    }


}
