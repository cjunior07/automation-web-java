package stepsDefinitions;

import static utils.Utils.paginaContemTexto;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageObjects.CadastrarUsuarioPage;

public class CadastrarUsuarioSteps {
	
	CadastrarUsuarioPage CadastrarUsuarioPage = new CadastrarUsuarioPage();
	
	@Dado("^que acesso a funcionalidade Cadastre-se$")
	public void queAcessoAFuncionalidadeCadastreSe() throws Exception {
	    CadastrarUsuarioPage.clicarBotaoCadastre();
	}
	
	@Quando("^nao preencho o campo usuario$")
	public void naoPreenchoOCampoUsuario() throws Exception {
	}
	
	@Quando("^preencho o campo usuario com usuario Fake valido$")
	public void preenchoOCampoUsuarioComUsuarioFakeValido() throws Exception {
		CadastrarUsuarioPage.informarEGravarUsuario();
	}
	
	@Quando("^preencho o campo usuario com usuario Fake cadastrado$")
	public void preenchoOCampoUsuarioComUsuarioFakeCadastrado() throws Exception {
		CadastrarUsuarioPage.informarUsuarioGravado();
	}

	@Quando("^preencho o campo usuario com usuario Fake$")
	public void preenchoOCampoUsuarioComUsuarioFake() throws Exception {
	   CadastrarUsuarioPage.informarUsuarioCadastro();
	}

	@Quando("^preencho a senha a ser cadastrada com \"([^\"]*)\"$")
	public void preenchoASenhaASerCadastradaCom(String senha) throws Exception {
	    CadastrarUsuarioPage.informarSenhaCadastro(senha);
	}

	@Quando("^preencho a confirmacao de senha a ser cadastrada com \"([^\"]*)\"$")
	public void preenchoAConfirmacaoDeSenhaASerCadastradaCom(String confirmaSenha) throws Exception {
	    CadastrarUsuarioPage.informarConfimaSenha(confirmaSenha);
	}
	
	@Quando("^clico em cadastrar$")
	public void clicoEmCadastrar() throws Exception {
	    CadastrarUsuarioPage.clicarBotaoCadastrar();
	}

	@Entao("^vejo o alert no campo do usuario$")
	public void vejoOAlertNoCampoDoUsuario() throws Exception {
	    CadastrarUsuarioPage.validarAlertCampoUsuario();
	}

	@Entao("^vejo o alert no campo Senha$")
	public void vejoOAlertNoCampoSenha() throws Exception {
	    CadastrarUsuarioPage.validarAlertCampoSenha();
	}

	@Entao("^vejo o alert no campo Confirmar Senha$")
	public void vejoOAlertNoCampoConfirmarSenha() throws Exception {
	    CadastrarUsuarioPage.validarAlertCampoConfirmarSenha();
	}

	@Entao("^vejo a mensagem de \"([^\"]*)\"$")
	public void vejoAMensagemDe(String text) throws Exception {
	   paginaContemTexto(text);
	}

	@Entao("^vejo a tela de login$")
	public void vejoATelaDeLogin() throws Exception {
		paginaContemTexto("Login");
	}
}
