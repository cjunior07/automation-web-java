package pageObjects;

import static utils.Utils.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class LoginPage {

	// Construtor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Elementos

	@FindBy(xpath = "//input[@name='username']")
	private WebElement inputUsuario;

	@FindBy(xpath = "//input[@name='pass']")
	private WebElement inputSenha;
	
	@FindBy(xpath = "//*[text()[contains(.,'Entre')]]")
	private WebElement btnEntre;
	
	@FindBy(id = "tabela")
	private WebElement tabela;
	
	// Métodos
	
	public void informarUsuario(String usuario) {
		inputUsuario.sendKeys(usuario);
	}
	
	public void informarSenha(String senha) {
		inputSenha.sendKeys(senha);
	}
	
	public void clicarBotaoEntre() {
		btnEntre.click();
	}
	
	public void validarPaginaInicial() throws Exception {
		Utils.aguardarVisibilidade(true, 15, tabela);
	}
	
	

}
