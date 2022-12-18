package utils;

// La clase base online las acciones selenium (wrapper)

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    //atributos
    protected WebDriver driver;

    protected JavascriptExecutor js;

    protected Select select;
    private WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
    //Metodos
    public BaseClass(WebDriver driver){
        this.driver = driver;

    }

    //Enmascarar las Acciones (metodos) de selenium

    public WebElement BuscarElementoWeb(By localizador){
        return this.driver.findElement(localizador);
    }
    public void  cargarPaginas(String url){
        this.driver.get(url);
    }

    //conectar el driver al browser

    public WebDriver conexionBrowser(String browser, String propertyDriver, String rutaDriver){
        switch (browser){
            case"CHROME":
                System.setProperty(propertyDriver, rutaDriver);
                this.driver = new ChromeDriver();
                return this.driver;
            case"EDGE":
                System.setProperty(propertyDriver, rutaDriver);
                this.driver = new EdgeDriver();
                return  this.driver;
            case"FIREFOX":
                System.setProperty(propertyDriver, rutaDriver);
                this.driver = new FirefoxDriver();
                return this.driver;
            default:
                this.driver = null;
                return this.driver;
        }
    }

    //scroll
    public void ScrollElementoWeb(By localizador){
        js = (JavascriptExecutor) this.driver;

        js.executeScript("arguments[0].scrollIntoView();", this.driver.findElement(localizador));
    }

    public void ScrollElementoWeb(WebElement elemento){
        js = (JavascriptExecutor) this.driver;

        js.executeScript("arguments[0].scrollIntoView();", elemento);
    }


    //obtener Texto
    public String obtenerTexto(WebElement elemento){
        return elemento.getText();
    }
    public String obtenerTexto(By localizador){
        return this.driver.findElement(localizador).getText();
    }

    //Submit
    public void submitFormulario(By localizador){
        this.driver.findElement(localizador).submit();
    }

    //agregar Texto
    public void agregarTexto(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }

    public void agregarTexto(By localizador, String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }

    //maximizar
    public void maximizarBrowser(){
        driver.manage().window().maximize();
    }

    //Tiempo de espera

    //por segundos
    public void esperaxSegundos(int milisegundos){
        try{
            Thread.sleep(milisegundos);
        } catch (Exception ex){
            System.out.println("Fallo la espera en milisegundos");
        }
    }

    //espera en base a evento
    public WebElement esperarAElementoWeb(By localizador){
        wait = new WebDriverWait(this.driver, 20);

        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    //click
    public void click (WebElement elemento){
        elemento.click();
    }

    public void click(By localizador){
        this.driver.findElement(localizador).click();
    }

    public void seleccionarDDLPorTexto(WebElement elemento, String texto){
        select = new Select(elemento);
        select.selectByVisibleText(texto);
    }
    public void cerrarBrowser(){
        this.driver.quit();
    }

}

