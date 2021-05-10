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

public class Contato {
	
	String url;
	WebDriver driver;

@Before
public void iniciarContato() {
	url = "http://automationpractice.com/index.php";
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Paulo.Miguel\\eclipse-workspace\\Projeto_Automacao\\drives\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
}

@After

public void finalizarContato() {
	driver.quit();
}

@Dado("^acesso a pagina de contato$")
public void acesso_a_pagina_de_contato() throws Throwable {
	driver.get(url);
	driver.manage().window().maximize();
}

@Quando("^preencho os campos obrigatorios$")
public void preencho_os_campos_obrigatorios() throws Throwable {
	driver.findElement(By.id("contact-link")).click();
	driver.findElement(By.id("id_contact")).click();
	driver.findElement(By.id("id_contact")).sendKeys("Customer service");
	driver.findElement(By.id("email")).sendKeys("paulo.info13@gmail.com");
	driver.findElement(By.id("id_order")).sendKeys("testetestetestetestetest");
	driver.findElement(By.id("fileUpload")).sendKeys("C:\\apk\\teste.txt");
	driver.findElement(By.id("message")).sendKeys("testetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetestetesteteste");
	driver.findElement(By.id("submitMessage")).click();
	
}

@Entao("^valido mensagem de sucesso$")
public void valido_mensagem_de_sucesso() throws Throwable {

	assertEquals("Your message has been successfully sent to our team.", driver.findElement(By.xpath(".//p[contains(normalize-space(.), 'Your message has been successfully sent to our team.')]")).getText());
}

}