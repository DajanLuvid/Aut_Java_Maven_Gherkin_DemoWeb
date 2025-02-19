package seleniumgluecode;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {

    ///
    /// Objeto estatico que va a cargar con el driver en ejecución real
    ///
    private static WebDriver hookDriver;

    private String urlInicial = "https://www.saucedemo.com/";

    ///
    /// Metodo que se ejecuta antes de cada Feature y Scenarios
    ///
    @Before
    public void setUp(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Program Files\\chromedriver\\chromedriver-133.0.6943.53-win64\\chromedriver.exe");
        hookDriver = new ChromeDriver();
        hookDriver.get(urlInicial);
        hookDriver.manage().window().maximize();
    }

    ///
    /// Metodo que se ejecuta despues de cada Feature y Scenarios
    ///
    @After
    public void tearDown(){
        hookDriver.quit();
    }

    ///
    /// Metodo estatico para acceder al driver en ejecucion real
    ///
    public static WebDriver getDriver(){
        return hookDriver;
    }

}
