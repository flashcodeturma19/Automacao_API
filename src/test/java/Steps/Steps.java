package Steps;

import Metodos.Requisicoes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	Requisicoes r = new Requisicoes();

	@Given("que realize uma chamada na rota Post {string}")
	public void que_realize_uma_chamada_na_rota_post(String rota) {
	
		r.postInsereUmaNovaSimulacao(rota);
	}

	@When("preencha o arquivo Json com os parametros obrigatorios")
	public void preencha_o_arquivo_json_com_os_parametros_obrigatorios() {
		r.preencher_Json();
	}

	@Then("cadastro de inadimplente sera inserido com sucesso {int}")
	public void cadastro_de_inadimplente_sera_inserido_com_sucesso(Integer statuscode) {
	 r.validarStatusCode(statuscode);
	}

}
