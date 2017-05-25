package main;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CasadoBiscoito {
	private WebDriver driver;

	@Before
	public void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

		driver = new ChromeDriver();
	}

	@Test
	public void login() throws InterruptedException {

		try {
			driver.get("http://hmg.geoportal3d.com.br:8090/CasaDoBiscoitoTeste");
			WebElement campoDeTexto = driver.findElement(By.name("formLogin:login"));
			WebElement campoDeSenha = driver.findElement(By.name("formLogin:senha"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			campoDeTexto.sendKeys("adm");
			campoDeSenha.click();
			campoDeSenha.sendKeys("123456");
			
			WebElement botaoSalvar = driver.findElement(By.id("formLogin:j_idt20"));
			botaoSalvar.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebElement negociacoes = driver.findElement(By.id("j_idt20:negociacao"));
			negociacoes.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
			WebElement addNegociacoes = driver.findElement(By.id("j_idt27:novasNegociacoes"));
			addNegociacoes.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebElement nome = driver.findElement(By.id("formNegociacao:nome"));
			nome.sendKeys("Teste automatico Selenium");
			WebElement data = driver.findElement(By.id("formNegociacao:data_input"));
			data.sendKeys("24/06/2017");
			WebElement hora = driver.findElement(By.id("formNegociacao:horaVigencia_input"));
			hora.sendKeys("05:00");
		
			Actions actions = new Actions(driver);
			
			WebElement fabricantes = driver.findElement(By.id("formNegociacao:fabricante"));
			actions.moveToElement(fabricantes);
			actions.click();
			actions.sendKeys("a",Keys.ENTER);
			actions.build().perform();
			
					
			
			WebElement salvar = driver.findElement(By.id("formNegociacao:j_idt87"));
			actions = new Actions(driver);
			actions.moveToElement(salvar);
			actions.click();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			addNegociacoes.click();
			
			
			
		}

		catch (org.openqa.selenium.StaleElementReferenceException ex) {
			ex.printStackTrace();
		}
	}
	
	@After
	public void encerra() {
		driver.close();
	}
}
