package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


///
/// Clase que contiene los metodos comunes a todas las paginas
///
public class PageBase {

    private WebDriver pageBaseDriver;

    public PageBase(WebDriver homeDriver) {
        this.pageBaseDriver = homeDriver;
    }

    ///
    /// Obtiene el nombre de la pagina donde se encuentre actualmente el driver
    ///
    public String obtenerTituloPagina(){
        try{
            return pageBaseDriver.getTitle();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    ///
    /// Obtiene el texto de un elemento si se puede
    ///
    public String obtenerTextoElemento(By seleccion){
        try{
            return pageBaseDriver.findElement(seleccion).getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    ///
    /// Devuelve TRUE si el elemento se muestra en la pantalla actual
    ///
    public Boolean elementoExiste(By seleccion){
        try{
            return pageBaseDriver.findElement(seleccion).isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    ///
    /// Permite hacer clic en elementos que lo soportan
    ///
    public void clicElemento(By seleccion){
        try {
            pageBaseDriver.findElement(seleccion).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    ///
    /// Permite escribir sobre elementos que lo permiten: @texto es lo que se escribira
    ///
    public void escribirElemento(By seleccion, String texto){
        try {
            pageBaseDriver.findElement(seleccion).sendKeys(texto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    ///
    /// Permite obtener una lista con los elementos segun el localizador
    ///
    public List<WebElement> obtenerListaElementos(By seleccion){
        try {
            return pageBaseDriver.findElements(seleccion);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    ///
    /// Esperar implicitamente segun segundos indicados
    ///
    public void agregarEsperaImplicita(int segundos){
        if(segundos < 1){return;}
        pageBaseDriver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
    }

    ///
    /// Metodo poco recomendado, pero es temporal en este caso.
    ///
    public void agregarEsperaForzada(int segundos) throws InterruptedException {
        Thread.sleep(segundos* 1000L);
    }


}
