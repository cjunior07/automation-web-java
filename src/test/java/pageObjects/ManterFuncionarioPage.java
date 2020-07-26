package pageObjects;

import static utils.Utils.driver;
import static utils.Utils.paginaContemTexto;
import static utils.Utils.paginaNaoContemTexto;
import static utils.Utils.recuperarDado;
import static utils.Utils.validarAlertaCampoJavaScript;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.Utils;

public class ManterFuncionarioPage {

	// Construtor
	public ManterFuncionarioPage() {
		PageFactory.initElements(driver, this);
	}

	// Elementos

	@FindBy(xpath = "//*[text()[contains(.,'Novo Funcionário')]]")
	private WebElement btnNovoFuncionario;

	@FindBy(xpath = "//*[contains(@class, \"cadastrar\")]")
	private WebElement btnEnviar;

	@FindBy(id = "inputNome")
	private WebElement inputNome;

	@FindBy(id = "cpf")
	private WebElement inputCPF;

	@FindBy(id = "slctSexo")
	private WebElement selectSexo;

	@FindBy(id = "inputAdmissao")
	private WebElement inputAdmissao;

	@FindBy(id = "inputCargo")
	private WebElement inputCargo;

	@FindBy(id = "dinheiro")
	private WebElement inputSalario;

	@FindBy(id = "clt")
	private WebElement radioCLT;

	@FindBy(id = "pj")
	private WebElement radioPJ;

	public void acessarNovoFuncionario() {
		btnNovoFuncionario.click();
	}

	public void clicarBotaoEnviar() throws Exception {
		btnEnviar.click();
	}

	public void preencherCPF() throws Exception {
		String cpf = Utils.geraCPF();
		inputCPF.sendKeys(cpf);
	}

	public void preencherNomeEGuardar(String nome) throws IOException {
		inputNome.clear();
		inputNome.sendKeys(nome);
		Utils.gravarTexto(nome, "nome_funcionario");
	}

	public void preencherAdmissaoEGuardar(String admissao) throws IOException {
		inputAdmissao.clear();
		inputAdmissao.sendKeys(admissao);
		Utils.gravarTexto(admissao, "admissao_funcionario");
	}

	public void preencherCargoEGuardar(String cargo) throws IOException {
		inputCargo.clear();
		inputCargo.sendKeys(cargo);
		Utils.gravarTexto(cargo, "cargo_funcionario");
	}

	public void preencherCPFEGuardar() throws Exception {
		String cpf = Utils.geraCPF();
		inputCPF.clear();
		inputCPF.sendKeys(cpf);
		Utils.gravarTexto(cpf, "cpf_funcionario");
	}
	
	public void preencherNome(String nome) {
		inputNome.sendKeys(nome);
	}

	public void preencherCPFinvalido(String cpfInvalido) throws Exception {
		inputCPF.sendKeys(cpfInvalido);
	}

	public void selecionarSexo(String sexo) {
		Select select = new Select(selectSexo);
		select.selectByVisibleText(sexo);
	}

	public void preencherAdmissao(String admissao) {
		inputAdmissao.sendKeys(admissao);
	}

	public void preencherCargo(String cargo) {
		inputCargo.sendKeys(cargo);
	}

	public void preencherSalario(String salario) {
		inputSalario.clear();
		inputSalario.sendKeys(salario);
	}

	public void selecionarTipoContratacao(String contratacao) {
		switch (contratacao.toUpperCase()) {
		case "CLT":
			radioCLT.click();
			break;
		case "PJ":
			radioPJ.click();
			break;
		default:
			break;
		}
	}

	public void validarCampos(String msg, String campo) {
		switch (campo.toUpperCase()) {
		case "NOME":
			validarAlertaCampoJavaScript(inputNome, msg);
			break;
		case "CPF":
			validarAlertaCampoJavaScript(inputCPF, msg);
			break;
		case "SEXO":
			validarAlertaCampoJavaScript(selectSexo, msg);
			break;
		case "ADMISSAO":
			validarAlertaCampoJavaScript(inputAdmissao, msg);
			break;
		case "CARGO":
			validarAlertaCampoJavaScript(inputCargo, msg);
			break;
		case "SALARIO":
			validarAlertaCampoJavaScript(inputSalario, msg);
			break;
		case "CONTRATACAO":
			validarAlertaCampoJavaScript(radioCLT, msg);
			break;

		default:
			Assert.assertEquals(
					"Selecione algum dos campos obrigatórios: Nome, CPF, Sexo, Admissao, Cargo, Salario ou Contracacao",
					campo);
			break;
		}
	}

	public void validarAlertaCPFInvalido() {
		String alerta = driver.switchTo().alert().getText();
		Assert.assertEquals(alerta, "CPF Invalido!");
	}

	public void validarFuncionarioCadastrado() throws Exception {
		String nomeFuncionario = recuperarDado("nome_funcionario");
		String cpfFuncionario = recuperarDado("cpf_funcionario");
		String admissaoFuncionario = recuperarDado("admissao_funcionario");
		String cargoFuncionario = recuperarDado("cargo_funcionario");
		paginaContemTexto("Usuário cadastrado com sucesso");
		paginaContemTexto(nomeFuncionario);
		paginaContemTexto(cpfFuncionario);
		paginaContemTexto(admissaoFuncionario);
		paginaContemTexto(cargoFuncionario);
	}
	
	public void validarFuncionarioEditado() throws Exception {
		String nomeFuncionario = recuperarDado("nome_funcionario");
		String cpfFuncionario = recuperarDado("cpf_funcionario");
		String admissaoFuncionario = recuperarDado("admissao_funcionario");
		String cargoFuncionario = recuperarDado("cargo_funcionario");
		paginaContemTexto("Informações atualizadas com sucesso");
		paginaContemTexto(nomeFuncionario);
		paginaContemTexto(cpfFuncionario);
		paginaContemTexto(admissaoFuncionario);
		paginaContemTexto(cargoFuncionario);
	}

	public void clicarEmEditarFucnionario(String funcionario) {
		driver.findElementByXPath("//*[text()[contains(.,'" + funcionario + "')]]/../td[6]/a[2]/button").click();
	}
	
	public void clicarEmExcluirFucnionario(String funcionario) {
		driver.findElementByXPath("//*[text()[contains(.,'" + funcionario + "')]]/../td[6]/a[1]/button").click();
	}
	
	public void validarFuncionarioExcluido() throws Exception {
		String nomeFuncionario = recuperarDado("nome_funcionario");
		String cpfFuncionario = recuperarDado("cpf_funcionario");
		String admissaoFuncionario = recuperarDado("admissao_funcionario");
		String cargoFuncionario = recuperarDado("cargo_funcionario");
		paginaContemTexto("Funcionário removido com sucesso");
		paginaNaoContemTexto(nomeFuncionario);
		paginaNaoContemTexto(cpfFuncionario);
		paginaNaoContemTexto(admissaoFuncionario);
		paginaNaoContemTexto(cargoFuncionario);
	}
}
