package Automacao_Pratica;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import junit.framework.Assert;

public class Logar {
	
	String url;
	WebDriver driver;

	/*	
@Before
public void iniciar() {
	url = "http://automationpractice.com/index.php";
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Paulo.Miguel\\eclipse-workspace\\Projeto_Automacao\\drives\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
}

@After

public void finalizar() {
	driver.quit();
}

*/
@Dado("^que cliente acessa o site da automacao pratica$")
public void que_cliente_acessa_o_site_da_automacao_pratica() throws Throwable {

	driver.get(url);
	driver.manage().window().maximize();

}

@Quando("^clico em entrar$")
public void clico_em_entrar() throws Throwable {
	driver.findElement(By.cssSelector("a.login")).click();
 
}

@Entao("^efetuo login corretamente$")
public void efetuo_login_corretamente() throws Throwable {
	driver.findElement(By.id("email")).sendKeys("paulo.info13@gmail.com");
	driver.findElement(By.id("passwd")).sendKeys("julia123");
	driver.findElement(By.id("SubmitLogin")).click();
	assertEquals("MY ACCOUNT", driver.findElement(By.cssSelector("h1.page-heading")).getText());	
}


@Quando("^aciono o botao entrar informando um usuario invalido$")
public void aciono_o_botao_entrar_informando_um_usuario_invalido() throws Throwable {
	driver.findElement(By.cssSelector("a.login")).click();
	driver.findElement(By.id("email")).sendKeys("paulo.info13@xxx");
	driver.findElement(By.id("passwd")).sendKeys("julia123");
	driver.findElement(By.id("SubmitLogin")).click();

}

@Entao("^valido mensagem de erro$")
public void valido_mensagem_de_erro() throws Throwable {
	
	assertEquals("Invalid email address.", driver.findElement(By.xpath(".//li[contains(normalize-space(.), 'Invalid email address.')]")).getText());
}



@Quando("^aciono o botao entrar informando uma senha invalida$")
public void aciono_o_botao_entrar_informando_uma_senha_invalida() throws Throwable {
	
	driver.findElement(By.cssSelector("a.login")).click();
	driver.findElement(By.id("email")).sendKeys("paulo.info13@gmail.com");
	driver.findElement(By.id("passwd")).sendKeys("123");
	driver.findElement(By.id("SubmitLogin")).click();


}

@Entao("^valido mensagem de senha incorreta$")
public void valido_mensagem_de_senha_incorreta() throws Throwable {
	
	assertEquals("Invalid password.", driver.findElement(By.xpath(".//li[contains(normalize-space(.), 'Invalid password.')]")).getText());
	 
}


@Quando("^aciono o botao entrar informando uma senha incorreta$")
public void aciono_o_botao_entrar_informando_uma_senha_incorreta() throws Throwable {
	
	driver.findElement(By.cssSelector("a.login")).click();
	driver.findElement(By.id("email")).sendKeys("paulo.info13@gmail.com");
	driver.findElement(By.id("passwd")).sendKeys("julia125");
	driver.findElement(By.id("SubmitLogin")).click();

  
}

@Entao("^valido mensagem de autenticacao falhou$")
public void valido_mensagem_de_autenticacao_falhou() throws Throwable {
	
	assertEquals("Authentication failed.", driver.findElement(By.xpath(".//li[contains(normalize-space(.), 'Authentication failed.')]")).getText());
 
}





















}