package utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import io.qameta.allure.Allure;

public class Utils {

	public static ChromeDriver driver;

	public static void acessarSistema() {
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");

		// Removendo log do selenium e chromedriver
		System.setProperty("webdriver.chrome.silentOutput", "true");
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.inmrobo.tk/accounts/login/");
	}

	public static void addEnvironmentAllure() {
		try {
			File env = new File("./target/allure-reports/environment.properties");
			BufferedWriter as = new BufferedWriter(new FileWriter(env));
			as.write("Analista: Claudio da L. A. Junior");
			as.newLine();
			as.write("E-mail: Junior.Andrade.360@hotmail.com");
			as.newLine();
			as.write("Navegador = Chrome");
			as.newLine();
			as.write("Desafio = INMETRICS");
			as.newLine();
			as.write("Sistema Operacional = " + System.getProperty("os.name").toLowerCase());
			as.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void capturarTela(Scenario scenario) {
		File screenshot = gerarScreenShot(scenario);
		embedScreenshot(screenshot, scenario.getName());
		addEnvironmentAllure();
	}

	public static File gerarScreenShot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");

		File imagem = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem,
					(new File("./target/allure-reports", scenario.getName() + " - " + scenario.getStatus() + ".png")));
		} catch (Exception e) {

		}

		return imagem;
	}

	public static void embedScreenshot(File file, String description) {
		Path content = Paths.get(file.getPath());
		try (InputStream is = Files.newInputStream(content)) {
			Allure.addAttachment(description, is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void aguardarVisibilidade(Boolean visibilidade, Integer tempoEspera, WebElement elemento)
			throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, tempoEspera);

		if (visibilidade = true) {
			wait.until(ExpectedConditions.visibilityOf(elemento));
		} else {
			wait.until(ExpectedConditions.invisibilityOf(elemento));
		}

	}

	public static void esperarPagina(int tempo) throws Exception {
		for (int i = 0; i < tempo; i++) {
			Thread.sleep(1000);
		}
	}

	public static void paginaContemTexto(String text) throws Exception {
		esperarPagina(1);
		boolean existe = driver.getPageSource().contains(text);
		if (existe == false) {
			System.out.println("Nao encontrei a string" + text);
		}
		assertTrue(existe);

	}
	
	public static void paginaNaoContemTexto(String text) throws Exception {
		esperarPagina(1);
		boolean existe = driver.getPageSource().contains(text);
		if (existe == true) {
			System.out.println("Encontrei a string" + text);
		}
		assertFalse(existe);
	}

	public static boolean elementoExiste(WebElement elemento) {
		boolean existe = false;
		try {
			existe = elemento.isEnabled();
		} catch (NoSuchElementException e) {
			existe = false;
		}
		return existe;
	}

	public static String caminhoProjeto() {
		String diretorio = System.getProperty("user.dir");
		return diretorio;
	}

	public static void gravarTexto(String texto, String caminho) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(
				new FileWriter(caminhoProjeto() + "\\src\\test\\resources\\massa\\" + caminho + ".txt", false));
		buffWrite.append(texto);
		buffWrite.close();
	}

	public static String recuperarDado(String file) throws IOException {
		String ultimo = "";
		try {
			InputStream is = new FileInputStream(caminhoProjeto() + "\\src\\test\\resources\\massa\\" + file + ".txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line = "";
			while (line != null) {
				line = br.readLine();
				if (line != null) {
					ultimo = line;
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ultimo;
	}

	public static void validarAlertaCampoJavaScript(WebElement elemento, String msg) {
		String validationMessage = elemento.getAttribute("validationMessage");
		Assert.assertEquals(validationMessage, msg);

	}

	public static String geraCPF() {

		int digito1 = 0, digito2 = 0, resto = 0;
		String nDigResult;
		String numerosContatenados;
		String numeroGerado;

		Random numeroAleatorio = new Random();

		// numeros gerados
		int n1 = numeroAleatorio.nextInt(10);
		int n2 = numeroAleatorio.nextInt(10);
		int n3 = numeroAleatorio.nextInt(10);
		int n4 = numeroAleatorio.nextInt(10);
		int n5 = numeroAleatorio.nextInt(10);
		int n6 = numeroAleatorio.nextInt(10);
		int n7 = numeroAleatorio.nextInt(10);
		int n8 = numeroAleatorio.nextInt(10);
		int n9 = numeroAleatorio.nextInt(10);

		int soma = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

		int valor = (soma / 11) * 11;

		digito1 = soma - valor;

		// Primeiro resto da divisão por 11.
		resto = (digito1 % 11);

		if (digito1 < 2) {
			digito1 = 0;
		} else {
			digito1 = 11 - resto;
		}

		int soma2 = digito1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

		int valor2 = (soma2 / 11) * 11;

		digito2 = soma2 - valor2;

		// Primeiro resto da divisão por 11.
		resto = (digito2 % 11);

		if (digito2 < 2) {
			digito2 = 0;
		} else {
			digito2 = 11 - resto;
		}

		// Conctenando os numeros
		numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + "." + String.valueOf(n4)
				+ String.valueOf(n5) + String.valueOf(n6) + "." + String.valueOf(n7) + String.valueOf(n8)
				+ String.valueOf(n9) + "-";

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		numeroGerado = numerosContatenados + nDigResult;

		//System.out.println("CPF Gerado " + numeroGerado);

		return numeroGerado;
	}
}
