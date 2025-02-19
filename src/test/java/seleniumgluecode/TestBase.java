package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import pages.Carrito;
import pages.Compras;
import pages.Home;

///
/// Clase que tiene las referencias a las clases Paginas y al driver en ejecucion real
///
public class TestBase {

    protected WebDriver testBaseDriver = Hook.getDriver();
    protected Home testBaseHome = new Home(testBaseDriver);
    protected Compras testBaseCompras = new Compras(testBaseDriver);
    protected Carrito testBaseCarrito = new Carrito(testBaseDriver);
}
