package seleniumgluecode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

///
/// Implementacion de los enunciados de los Features.
/// Extiende de TestBase por que esa clase contiene referencias a las clases paginas
///
public class Test extends TestBase{

    @Given("El usuario esta en la Home de Swag Labs")
    public void elUsuarioEstaEnLaHomeDeSwagLabs() {
        Assert.assertEquals(
                "Los campos no son iguales",
                this.testBaseHome.tituloPagina ,
                this.testBaseHome.obtenerTituloPagina());
    }
    @When("Ingresa sus credenciales de usuario")
    public void ingresaSusCredencialesDeUsuario() {
        this.testBaseHome.ingresarUsuario();
        this.testBaseHome.ingresarClave();
        this.testBaseHome.clicLogin();
    }
    @When("Accede a la pagina de compras")
    public void accedeALaPaginaDeCompras() {
        Assert.assertEquals(
                "Los campos no son iguales",
                this.testBaseCompras.tituloPagina ,
                this.testBaseCompras.obtenerTituloPagina());
    }
    @When("Selecciona el producto {string}")
    public void seleccionaElProducto(String productoAgregar) {
        Assert.assertTrue("No detecta productos",this.testBaseCompras.paginaTieneProductos());
        this.testBaseCompras.obtenerNumeroElementoLista(productoAgregar);
        Assert.assertTrue(
                "No se encontró el producto: " + productoAgregar ,
                this.testBaseCompras.numeroProducto > 0);

        this.testBaseCompras.seleccionarBotonAnadirCarrito();
    }
    @When("Deselecciona el producto {string}")
    public void deseleccionaElProducto(String productoRemover) {
        this.testBaseCompras.obtenerNumeroElementoLista(productoRemover);
        Assert.assertTrue(
                "No se encontró el producto: " + productoRemover ,
                this.testBaseCompras.numeroProducto > 0);

        this.testBaseCompras.seleccionarBotonRemoverCarrito();
    }
    @When("Da clic en la opcion de {string}")
    public void daClicEnLaOpcionDe(String nombrePagina) throws InterruptedException {
        this.testBaseCompras.agregarEsperaForzada(1);
        switch (nombrePagina){
            case "cart":
                this.testBaseCarrito.clicEnBotonCarrito();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + nombrePagina);
        }
            
    }
    @Then("Accede a la pagina con el titulo {string}")
    public void accedeALaPaginaConElTitulo(String tituloPagina) throws InterruptedException {
        Assert.assertEquals(
                "Los titulos no coinciden",
                tituloPagina,
                this.testBaseCarrito.obtenerTituloFormulario());
        this.testBaseCarrito.agregarEsperaForzada(1);
    }


}
