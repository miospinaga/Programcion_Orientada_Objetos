package Figuras;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Validación de los datos ingresados en las ventanas.
 */
public class Util {

    /** Devuelve el número positivo del campo, o null si hay error (y muestra la alerta). */
    public static Double leerPositivo(Component padre, JTextField campo, String nombre) {
        String texto = campo.getText().trim();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(padre, "Debe ingresar el valor de: " + nombre,
                    "Error", JOptionPane.ERROR_MESSAGE);
            campo.requestFocus();
            return null;
        }
        try {
            double valor = Double.parseDouble(texto.replace(',', '.'));
            if (valor <= 0) {
                JOptionPane.showMessageDialog(padre, nombre + " debe ser mayor que cero.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                campo.requestFocus();
                return null;
            }
            return valor;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(padre, nombre + " no es un n\u00famero v\u00e1lido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            campo.requestFocus();
            return null;
        }
    }
}
