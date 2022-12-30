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

    By locatorTxtUsuario = By.id("login-username");
    By locatorTxtContrasenia = By.id("login-password");
    By locatorRecuerda = By.xpath("//label[@for='login-remember']");
    By locatorBtnIniciarSesion = By.id("login-button");
    By locatorErrorLogin = By.xpath("//span[contains(text(),'Nombre de usuario o contraseña incorrectos.')]")   ;
    By locatorBtnLoginCelular = By.xpath("//button[@data-testid='phone-login']");
    By locatorTxtSectorCelular = By.id("phonelogin-country");
    By locatorTxtCelular = By.id("phonelogin-phonenumber");
    By locatorRecuerdaCelular = By.xpath("//label[@for='phonelogin-remember']");
    By locatorBtnSiguiente = By.id("phonelogin-button");
    By locatorErrorNumeroCorto = By.xpath("//span[contains(text(),'Comprueba el número de teléfono.')]");
    By locatorNumeroCorrecto= By.xpath("//p[contains(text(),'Introducir tu código')]");
    By locatorNoLetras = By.id("error-phone-number-non-digit");//Solo se pueden poner números.

    //Realizar acciones en el sitio

    public void completarFormularioIniciarSesion(String usuario, String password){

        //Completar Formulario

        esperaxSegundos(2000);
        agregarTexto(esperarAElementoWeb(locatorTxtUsuario), usuario);
        agregarTexto(esperarAElementoWeb(locatorTxtContrasenia),password);
        esperaxSegundos(1000);
        ScrollElementoWeb(esperarAElementoWeb(locatorRecuerda));
        click(esperarAElementoWeb(locatorRecuerda));
        ScrollElementoWeb(esperarAElementoWeb(locatorBtnIniciarSesion));
        click(esperarAElementoWeb(locatorBtnIniciarSesion));
        esperaxSegundos(1000);
    }
    public void formularioLoginCelular(String sector,String celular){

        //ingreso a login Ceular
        esperaxSegundos(2000);
        click(esperarAElementoWeb(locatorBtnLoginCelular));
        esperaxSegundos(2000);
        //acciones en login celular
        agregarTexto(esperarAElementoWeb(locatorTxtSectorCelular),sector);
        agregarTexto(esperarAElementoWeb(locatorTxtCelular),celular);
        ScrollElementoWeb(esperarAElementoWeb(locatorRecuerdaCelular));
        click(esperarAElementoWeb(locatorRecuerdaCelular));
        esperaxSegundos(1000);
        click(esperarAElementoWeb(locatorBtnSiguiente));
        esperaxSegundos(1000);
    }

    public String obtenerErrorLogin(){
        return obtenerTexto(esperarAElementoWeb(locatorErrorLogin));
    }
    public String obtenerErrorNumeroCorto(){
        return obtenerTexto(esperarAElementoWeb(locatorErrorNumeroCorto));
    }
    public String obtenerIngresoNumeroCorrecto(){
        return obtenerTexto(esperarAElementoWeb(locatorNumeroCorrecto));
    }
    public String obtenerErrorIngresoLetras(){
        return obtenerTexto(esperarAElementoWeb(locatorNoLetras));
    }
}
