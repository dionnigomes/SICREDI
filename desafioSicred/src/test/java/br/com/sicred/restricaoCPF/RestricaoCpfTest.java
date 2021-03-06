package br.com.sicred.restricaoCPF;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
/**
 * Unit test for simple App.
 */

@DisplayName(value = "Testes de API rest do módulo de restrição de CPF")
public class RestricaoCpfTest 
{
    /**
     * Rigorous Test :-)
     */
	@Test
	@DisplayName("Validar se um CPF tem restrição ou não")
    public void testVerificaCpfRestrito()
    {
		//Configurando os dados da API rest para restrições
       //baseURI = "http://localhost:8080/";
       //port = 8080;
       //basePath = "/api";
       
       //buscar CPF para verificarção de restrição
       given()
       		.get("http://localhost:8080/api/v1/restricoes/97093236014")
   		.then()
   			.assertThat()
   			.body("mensagem", equalTo("O CPF 97093236014 tem problema"))
   			.statusCode(200); 
       		       
    }
}
