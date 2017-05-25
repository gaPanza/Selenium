package main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CasadoBiscoito {
	private WebDriver driver;

	@Before
	public void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

		driver = new ChromeDriver();
	}
	
	@Test
	public void login() {
		
		driver.get("http://localhost:8080/CasaDoBiscoito");
		WebElement campoDeTexto = driver.findElement(By.name("formLogin:login"));
		WebElement campoDeSenha = driver.findElement(By.name("formLogin:senha"));
		campoDeTexto.sendKeys("adm");
		campoDeSenha.click();
		campoDeSenha.sendKeys("123456");
		campoDeTexto.submit();

		WebElement botaoSalvar = driver.findElement(By.id("formLogin:j_idt20"));
		botaoSalvar.click();

	}
	
	@After
	public void encerra(){
		driver.close();
	}
}
