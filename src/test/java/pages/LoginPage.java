package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class LoginPage extends BaseClass{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //las pages tienen por objetivo Centralizar los localizador y acciones de pagina

    //localizador

    By locatorUsuario = By.id("login-username");
    By locatorContrasenia = By.id("login-password");
    By locatorRecuerda = By.xpath("//label[@for='login-remember']");
    By locatorBtnIniciarSesion = By.id("login-button");
    By locatorErrorLogin = By.xpath("//span[contains(text(),'Nombre de usuario o contraseña incorrectos.')]")   ;

    //Realizar acciones en el sitio

    public void completarFormularioIniciarSesion(String usuario, String password){

        //Completar Formulario

        esperaxSegundos(5000);
        ScrollElementoWeb(esperarAElementoWeb(locatorUsuario));
        agregarTexto(esperarAElementoWeb(locatorUsuario), usuario);
        ScrollElementoWeb(esperarAElementoWeb(locatorContrasenia));
        agregarTexto(esperarAElementoWeb(locatorContrasenia),password);
        esperaxSegundos(1000);
        ScrollElementoWeb(esperarAElementoWeb(locatorRecuerda));
        click(esperarAElementoWeb(locatorRecuerda));
        ScrollElementoWeb(esperarAElementoWeb(locatorBtnIniciarSesion));
        click(esperarAElementoWeb(locatorBtnIniciarSesion));
        esperaxSegundos(1000);
    }
    public String obtenerErrorLogin(){
        return obtenerTexto(esperarAElementoWeb(locatorErrorLogin));
    }
}
