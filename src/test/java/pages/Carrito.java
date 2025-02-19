package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Carrito extends PageBase{

    private By localizadorBotonCarrito = By.id("shopping_cart_container");
    private By localizadorTituloFormulario = By.className("title");

    public Carrito(WebDriver carritoDriver) {
        super(carritoDriver);
    }

    public void clicEnBotonCarrito(){
        this.clicElemento(localizadorBotonCarrito);
    }

    public String obtenerTituloFormulario(){
        return this.obtenerTextoElemento(localizadorTituloFormulario);
    }


}
