package stepsDefinitions;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageObjects.LoginPage;
import pageObjects.ManterFuncionarioPage;

public class ManterFuncionarioSteps {
	
	LoginPage LoginPage = new LoginPage();
	ManterFuncionarioPage MTPage = new ManterFuncionarioPage();

	
	@Dado("^que acesso o sistema com o usuario \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void queAcessoOSistemaComOUsuarioESenha(String usuario, String senha) throws Exception {
	    LoginPage.informarUsuario(usuario);
	    LoginPage.informarSenha(senha);
	    LoginPage.clicarBotaoEntre();
	}
	
	@Quando("^pesquiso pelo fucnionario \"([^\"]*)\"$")
	public void pesquisoPeloFucnionario(String nome) throws Exception {
	    MTPage.pesquisarFuncionario(nome);
	}

	@Quando("^clico em novo funcionario$")
	public void clicoEmNovoFuncionario() throws Exception {
	    MTPage.acessarNovoFuncionario();
	}
	
	@Quando("^preencho o campo NOME com \"([^\"]*)\"$")
	public void preenchoOCampoNOMECom(String nome) throws Exception {
	    MTPage.preencherNome(nome);
	}

	@Quando("^preencho o campo CPF com \"([^\"]*)\"$")
	public void preenchoOCampoCPFCom(String cpf) throws Exception {
		MTPage.preencherCPFinvalido(cpf);
	}
	
	@Quando("preencho o campo CPF com valor valido$")
	public void preenchoOCampoCPFCom() throws Exception {
		MTPage.preencherCPF();
	}

	@Quando("^seleciono o SEXO com \"([^\"]*)\"$")
	public void selecionoOSEXOCom(String sexo) throws Exception {
		MTPage.selecionarSexo(sexo);
	}

	@Quando("^preencho o campo ADMISSAO com \"([^\"]*)\"$")
	public void preenchoOCampoADMISSAOCom(String admissao) throws Exception {
		MTPage.preencherAdmissao(admissao);
	}

	@Quando("^preencho o campo CARGO com \"([^\"]*)\"$")
	public void preenchoOCampoCARGOCom(String cargo) throws Exception {
		MTPage.preencherCargo(cargo);
	}

	@Quando("^preencho o campo SALARIO com \"([^\"]*)\"$")
	public void preenchoOCampoSALARIOCom(String salario) throws Exception {
		MTPage.preencherSalario(salario);
	}

	@Quando("^seleciono o TIPO DE CONTRATACAO com \"([^\"]*)\"$")
	public void selecionoOTIPODECONTRATACAOCom(String contratacao) throws Exception {
		MTPage.selecionarTipoContratacao(contratacao);
	}
	
	@Quando("^preencho o NOME com \"([^\"]*)\"$")
	public void preenchoONOMECom(String nome) throws Exception {
	    MTPage.preencherNomeEGuardar(nome);
	}

	@Quando("^preencho o CPF com valor valido$")
	public void preenchoOCPFComValorValido() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    MTPage.preencherCPFEGuardar();
	}

	@Quando("^preencho o ADMISSAO com \"([^\"]*)\"$")
	public void preenchoOADMISSAOCom(String admissao) throws Exception {
	    MTPage.preencherAdmissaoEGuardar(admissao);
	}

	@Quando("^preencho o CARGO com \"([^\"]*)\"$")
	public void preenchoOCARGOCom(String cargo) throws Exception {
	    MTPage.preencherCargoEGuardar(cargo);
	}

	@Quando("^clico em enviar$")
	public void clicoEmEnviar() throws Exception {
	    MTPage.clicarBotaoEnviar();
	}
	
	@Quando("^clico em editar no funcionario \"([^\"]*)\"$")
	public void clicoEmEditarNoFuncionario(String funcionario) throws Exception {
	   MTPage.clicarEmEditarFucnionario(funcionario);
	}
	
	@Entao("^vejo a mensagem de \"([^\"]*)\" no campo \"([^\"]*)\"$")
	public void vejoAMensagemDeNoCampo(String msg, String campo) throws Exception {
	    MTPage.validarCampos(msg, campo);
	}
	
	@Entao("^vejo o alerta de CPF invalido$")
	public void vejoOAlertaDeCPFInvalido() throws Exception {
	    MTPage.validarAlertaCPFInvalido();
	}
	
	@Entao("^vejo a mensagem de sucesso e o funcionario listado$")
	public void vejoAMensagemDeSucessoEOFuncionarioListado() throws Exception {
	    MTPage.validarFuncionarioCadastrado();
	}

	@Entao("^vejo o funcionario editado listado$")
	public void vejoOFuncionarioEditadoListado() throws Exception {
	    MTPage.validarFuncionarioEditado();
	}
	
	@Quando("^clico em excluir no funcionario \"([^\"]*)\"$")
	public void clicoEmExcluirNoFuncionario(String funcionario) throws Exception {
	    MTPage.clicarEmExcluirFucnionario(funcionario);
	}

	@Entao("^vejo mensagem de sucesso e valido a exclusao do funcionario$")
	public void vejoMensagemDeSucessoEValidoAExclusaoDoFuncionario() throws Exception {
	    MTPage.validarFuncionarioExcluido();
	}
}
