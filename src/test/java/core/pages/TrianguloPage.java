package core.pages;

import org.openqa.selenium.Alert;

import core.locators.TringuloLocator;
import core.utils.Action;
import core.utils.Core;

public class TrianguloPage extends Action {

    private TringuloLocator locator = new TringuloLocator();

    public void ingresarNombre(String value) {
        sendKeys(locator.inputUsername, value);
    }

    public void ingresarLadoA(String value) {
        sendKeys(locator.inputLadoA, value);
    }

    public void ingresarLadoB(String value) {
        sendKeys(locator.inputLadoB, value);
    }

    public void ingresarLadoC(String value) {
        sendKeys(locator.inputLadoC, value);
    }

    public String obtenerTriangulo(String ladoA, String ladoB, String ladoC) {
        String msg = script("var t = new Triangle("+ladoA+", "+ladoB+", "+ladoC+"); determine_type(t); return t.desc;");
        return msg;
    }

    public void presionarBotonVerificar() {
        click(locator.btnCheck);
    }
    
    public String obtenerMensaje() {
        Alert alert = Core.getDriver().switchTo().alert();
        String mensaje = alert.getText();
        alert.accept();
        return mensaje;
    }
}
