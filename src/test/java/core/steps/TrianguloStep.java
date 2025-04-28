package core.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import core.pages.TrianguloPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class TrianguloStep {
    
    private TrianguloPage page;
    @SuppressWarnings("unused")
    private String tipoTriangulo = "";
    
    @Given("que el usuario ha abierto la aplicación de identificación de triángulos")
    public void queElUsuarioHaAbiertoLaAplicaciónDeIdentificaciónDeTriángulos() {
        // el aplicativo se encarga de precargar la página
        page = new TrianguloPage();
    }

    @When("el usuario ingresa el dato {string}")
    public void elUsuarioIngresaElDato(String dato) {
        page.ingresarNombre(dato);
        page.presionarBotonVerificar();
    }
 
    @When("el {string} ingresa los lados {string}, {string} y {string}")
    public void elUsuarioIngresaLosLados(String usuario, String lado1, String lado2, String lado3) {
        page.ingresarNombre(usuario);
        page.ingresarLadoA(lado1);
        page.ingresarLadoB(lado2);
        page.ingresarLadoC(lado3);
        this.tipoTriangulo = page.obtenerTriangulo(lado1, lado2, lado3);
    }

    @When("el usuario presiona el botón de verificación")
    public void elUsuarioPresionaElBotónDeVerificación() {
        page.presionarBotonVerificar();
    }

    @Then("debe mostrar el tipo de triángulo como {string}")
    public void debeMostrarElTipoDeTriánguloComo(String tipoTriangulo) {
        assertEquals(tipoTriangulo, tipoTriangulo);
    }

    @Then("debe mostrar un mensaje de error {string}")
    public void debeMostrarElMensaje(String mensaje) {
        String msg = page.obtenerMensaje();
        assertEquals(mensaje, msg);
    }
}
