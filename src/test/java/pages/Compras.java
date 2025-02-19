package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Compras extends PageBase{

    public Compras(WebDriver comprasDriver){
        super(comprasDriver);
    }

    public String tituloPagina = "Swag Labs";
    public int numeroProducto = 0;
    private List<WebElement> tituloProductos;
    private List<WebElement> bloquesProductos;
    private By localizadorTitulosProductos = By.className("inventory_item_name");
    private By localizadorBloquesProductos = By.className("inventory_item_description");
    private By localizadorBotonAnadirCarrito = By.xpath(".//button[contains(text(),'Add to cart')]");
    private By localizadorBotonRemoverCarrito = By.xpath(".//button[contains(text(),'Remove')]");
    private By localizadorTituloProducto = By.className("inventory_item_name");

    public String obtenerTituloPaginaCompras(){
        try {
            return this.obtenerTituloPagina();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean paginaTieneProductos(){
        tituloProductos = this.obtenerListaElementos(localizadorTitulosProductos);
        bloquesProductos = this.obtenerListaElementos(localizadorBloquesProductos);
        return !bloquesProductos.isEmpty();
    }

    ///
    /// Le asigna a la variables @numeroProducto el valor del numero de orden que tiene en la lista de productos segun el titulo del producto
    ///
    public void obtenerNumeroElementoLista(String tituloProducto){
        try {
            numeroProducto = 0;
            if(bloquesProductos.isEmpty()){return;}

            for (WebElement bloqueproducto : bloquesProductos){
                numeroProducto++;
                String titulo = bloqueproducto.findElement(localizadorTituloProducto).getText();
                if(titulo.equals(tituloProducto)){break;}
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void seleccionarBotonAnadirCarrito(){
        try {
            int contadorInterno = 0;
            if(numeroProducto == 0){return;}

            for (WebElement bloqueproducto : bloquesProductos){
                contadorInterno++;

                if(contadorInterno == numeroProducto){

                    WebElement agregarBoton = bloqueproducto.findElement(localizadorBotonAnadirCarrito);
                    System.out.println("Botón encontrado en producto numero: " + numeroProducto);
                    agregarBoton.click();
                    return;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void seleccionarBotonRemoverCarrito(){
        try {
            int contadorInterno = 0;
            if(numeroProducto == 0){return;}

            for (WebElement bloqueproducto : bloquesProductos){
                contadorInterno++;

                if(contadorInterno == numeroProducto){

                    WebElement removerBoton = bloqueproducto.findElement(localizadorBotonRemoverCarrito);
                    System.out.println("Botón Remover encontrado en producto numero: " + numeroProducto);
                    removerBoton.click();
                    return;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
