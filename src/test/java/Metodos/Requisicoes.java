package Metodos;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Requisicoes extends Leitorjson {

	private Response response;
	String jsonBody;
	String nome ;
	long cpf ;
	String email;
	int valor ;
	int parcelas ;
	boolean seguro ;
	

	public void postInsereUmaNovaSimulacao(String endpoint) {
		JsonNode jsonNode = readJsonFile("massas.json");

		if (jsonNode == null) {
			System.out.println("Erro ao ler o arquivo JSON.");
			return;
		}

		// Extraindo os valores do JSON
		 nome = getStringValue(jsonNode, "nome");
		 cpf = jsonNode.path("cpf").asLong();
		 email = getStringValue(jsonNode, "email");
		 valor = getIntValue(jsonNode, "valor");
		 parcelas = getIntValue(jsonNode, "parcelas");
		 seguro = getBooleanValue(jsonNode, "seguro");
		 
		 // Construindo o objeto JSON para a requisição
		  jsonBody = String.format(
				"{\"nome\":\"%s\",\"cpf\":%d,\"email\":\"%s\",\"valor\":%d,\"parcelas\":%d,\"seguro\":%b}", nome, cpf,
				email, valor, parcelas, seguro);


		// Fazendo a requisição POST
		response = RestAssured.given().contentType(ContentType.JSON).body(jsonBody).when().log().all()
				.post(endpoint);

	
	}
	public void preencher_Json() {
		

		// Construindo o objeto JSON para a requisição
		  jsonBody = String.format(
				"{\"nome\":\"%s\",\"cpf\":%d,\"email\":\"%s\",\"valor\":%d,\"parcelas\":%d,\"seguro\":%b}", nome, cpf,
				email, valor, parcelas, seguro);

		System.out.println("Meu JSON depois da leitura: " + jsonBody);
	}
	public void validarStatusCode(int statuscode) {
		// Verificação da resposta
		response.then().statusCode(statuscode).log().all();
	}
}
