package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.LoginPage;
import pages.PremiumPage;

public class CPs {
    //atributos
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private PremiumPage premiumPage;
    private WebDriver driver;
    private String browser = "CHROME"; //Este valor eventualmente se vera modificado
    private String propertyDriver = "webdriver.chrome.driver";
    private String urlDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private String url = "https://www.spotify.com/";

    @BeforeMethod
    public void preparacionTests(){
        homePage = new HomePage(driver);
        homePage.conexionBrowser(browser,propertyDriver,urlDriver);
        registerPage = new RegisterPage(homePage.getDriver());
        loginPage = new LoginPage(homePage.getDriver());
        premiumPage = new PremiumPage(homePage.getDriver());

        homePage.cargarPaginas(url);
        homePage.maximizarBrowser();
    }

    @Test
    public void CP001_registro_fallido_captcha_en_blanco(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro("david.barcia@tsoftglobal.com","david.barcia@tsoftglobal.com", "12367567er","porodbs","11","Noviembre","1992");
        Assert.assertEquals("Confirma que no eres un robot.",registerPage.obtenerErrorCaptchaVacio());
    }
    @Test
    public void CP002_Registro_Fallido_Password_Corta(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro("david.barcia@tsoftglobal.com","david.barcia@tsoftglobal.com", "12","porodbs","11","Noviembre","1992");
        Assert.assertEquals("Tu contraseña es demasiado corta.",registerPage.obtenerErrorPasswordCorta());
    }
    @Test
    public void CP003_Iniciar_Fallido_Usuario_No_Registrado(){
        homePage.irAIniciarSesion();
        loginPage.completarFormularioIniciarSesion("david.barcia@tsoftglobal.com","146285234");
        Assert.assertEquals("Nombre de usuario o contraseña incorrectos.",loginPage.obtenerErrorLogin());
    }
    @Test
    public void CP004_Iniciar_Fallido_Sesion_Celular_Numero_Corto() {
        homePage.irAIniciarSesion();
        loginPage.formularioLoginCelular("+56","9364");
        Assert.assertEquals("Comprueba el número de teléfono.",loginPage.obtenerErrorNumeroCorto());
    }
    @Test
    public void CP005_Iniciar_Fallido_Sesion_Celular_Por_Letras() {
        homePage.irAIniciarSesion();
        loginPage.formularioLoginCelular("+56","asd");
        Assert.assertEquals("Solo se pueden poner números.",loginPage.obtenerErrorIngresoLetras());
    }
    @Test
    public void CP006_Iniciar_Sesion_Espera_Codigo() {
        homePage.irAIniciarSesion();
        loginPage.formularioLoginCelular("+56","950578183");
        Assert.assertEquals("Introducir tu código",loginPage.obtenerIngresoNumeroCorrecto());
    }

    @Test
    public void CP007_Seguimiento_de_premium() {
        homePage.irAPremium();
        premiumPage.seguimientoPremium();
        Assert.assertEquals("Para continuar, inicia sesión en Spotify.",premiumPage.obtenerSolicitudDeCrearCuenta());
    }


}
