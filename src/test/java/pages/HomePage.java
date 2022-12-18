package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class HomePage extends BaseClass {
    public  HomePage(WebDriver driver){
        super(driver);
    }

    //las pages tienen por objetivo Centralizar los localizador y acciones de pagina

    //localizador

    By locatorBtnRegistrarte = By.xpath("//button[contains(text(),'Registrarte')]");
    By locatorBtnLogin = By.xpath("//button[@data-testid='login-button']");

    //Acciones

    public void irARegistrarte(){
        click(esperarAElementoWeb(locatorBtnRegistrarte));
    }

    public void irAIniciarSesion(){
        click(esperarAElementoWeb(locatorBtnLogin));
    }

}
