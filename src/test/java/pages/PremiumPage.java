package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class PremiumPage extends BaseClass {

    public PremiumPage(WebDriver driver) {
        super(driver);
    }

    //localizadores

    By locatorBtnPremium3 = By.xpath("//div/span[contains(text(),'Obtén 3 meses')]");
    By locatorCrearCuenta = By.xpath("//div/p[@id='login-to-continue']");//Para continuar, inicia sesión en Spotify.

    public void seguimientoPremium(){

        esperaxSegundos(2000);
        click(esperarAElementoWeb(locatorBtnPremium3));
        esperaxSegundos(2000);
    }

    public String obtenerSolicitudDeCrearCuenta(){
        return obtenerTexto(esperarAElementoWeb(locatorCrearCuenta));
    }

}
