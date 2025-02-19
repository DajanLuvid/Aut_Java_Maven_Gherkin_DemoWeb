package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends PageBase {

    public Home(WebDriver homeDriver){
        super(homeDriver);
    }

    public String tituloPagina = "Swag Labs";
    private String nombreUsuario = "standard_user";
    private String claveUsuario = "secret_sauce";

    private By localizadorUsuario = By.id("user-name");
    private By localizadorClave = By.id("password");
    private By localizadorLogin = By.id("login-button");

    ///
    /// Ingresará el nombre de usuario
    ///
    public void ingresarUsuario(){
        this.escribirElemento(localizadorUsuario,nombreUsuario);
    }

    public void ingresarClave(){
        this.escribirElemento(localizadorClave,claveUsuario);
    }

    public void clicLogin(){
        this.clicElemento(localizadorLogin);
    }

    public String obtenerTituloPaginaHome(){
        try {
            return this.obtenerTituloPagina();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
