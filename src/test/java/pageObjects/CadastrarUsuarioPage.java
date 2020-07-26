package pageObjects;

import static org.junit.Assert.assertTrue;
import static utils.Utils.driver;
import static utils.Utils.elementoExiste;
import static utils.Utils.recuperarDado;

import java.io.IOException;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import utils.Utils;

public class CadastrarUsuarioPage {

	// Construtor
	public CadastrarUsuarioPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Elementos

	@FindBy(xpath = "//ul[@class='navbar-nav ml-auto']/li[1]")
	private WebElement btnCadastre;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement inputUsuarioCadastro;

	@FindBy(xpath = "//input[@name='pass']")
	private WebElement inputSenha;

	@FindBy(xpath = "//input[@name='confirmpass']")
	private WebElement inputConfirmarSenha;
	
	@FindBy(xpath = "//button[@class='login100-form-btn']")
	private WebElement btnCadastrar;

	@FindBy(xpath = "//*[contains(@class, \"alert-validate\")]//input[@name='username']")
	private WebElement alertValidateUsuario;

	@FindBy(xpath = "//*[contains(@class, \"alert-validate\")]//input[@name='pass']")
	private WebElement alertValidateSenha;

	@FindBy(xpath = "//*[contains(@class, \"alert-validate\")]//input[@name='confirmpass']")
	private WebElement alertValidateConfirmarSenha;

	
	// Classe para geração de username Fake
	Faker faker = new Faker(new Locale("pt-BR"));
	String id = faker.code().ean8();
	String username = faker.name().username()+"."+ id;
	
	// Métodos
	
	public void gravarNomeUsuario() throws IOException {
		Utils.gravarTexto(username, "nome_usuario");
	}
 
	public void clicarBotaoCadastre() throws IOException {
		btnCadastre.click();
	}

	public void informarUsuarioCadastro() throws IOException {
		inputUsuarioCadastro.sendKeys(username);
	}
	
	public void informarEGravarUsuario() throws IOException {
		String nomeUsuario = username;
		Utils.gravarTexto(nomeUsuario, "nome_usuario");
		inputUsuarioCadastro.sendKeys(nomeUsuario);
	}
	
	public void informarUsuarioGravado() throws IOException {
		inputUsuarioCadastro.sendKeys(recuperarDado("nome_usuario"));
	}

	public void informarSenhaCadastro(String senha) {
		inputSenha.sendKeys(senha);
	}

	public void informarConfimaSenha(String confirmaSenha) {
		inputConfirmarSenha.sendKeys(confirmaSenha);
	}
	
	public void clicarBotaoCadastrar() {
		btnCadastrar.click();
	}

	public void validarAlertCampoUsuario() {
		assertTrue(elementoExiste(alertValidateUsuario));
	}

	public void validarAlertCampoSenha() {
		assertTrue(elementoExiste(alertValidateSenha));
	}

	public void validarAlertCampoConfirmarSenha() {
		assertTrue(elementoExiste(alertValidateConfirmarSenha));
	}

}
