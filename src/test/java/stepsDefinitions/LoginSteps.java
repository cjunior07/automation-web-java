package stepsDefinitions;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageObjects.LoginPage;

public class LoginSteps {
	
	LoginPage LoginPage = new LoginPage();
	
	@Dado("^preencho o campo usuario com \"([^\"]*)\"$")
	public void preenchoOCampoUsuarioCom(String usuario) throws Exception {
	    LoginPage.informarUsuario(usuario);
	}

	@Quando("^preencho o campo senha com \"([^\"]*)\"$")
	public void preenchoOCampoSenhaCom(String senha) throws Exception {
	    LoginPage.informarSenha(senha);
	}

	@Quando("^clico no botao para logar$")
	public void clicoNoBotaoParaLogar() throws Exception {
	    LoginPage.clicarBotaoEntre();
	}

	@Entao("^vejo a página inicial do sistema$")
	public void vejoAPaginaInicialDoSistema() throws Exception {
	    LoginPage.validarPaginaInicial();
	}

}
