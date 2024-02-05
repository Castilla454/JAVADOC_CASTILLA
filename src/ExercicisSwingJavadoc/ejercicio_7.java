package ExercicisSwingJavadoc;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Calculadora de Edad.
 * Este programa permite calcular la edad de una persona al ingresar su fecha de nacimiento.
 *
 * @author Alejandro Castilla Batista
 * @version 1.0
 */
public class ejercicio_7 {

    /**
     * Método principal que inicia la aplicación y muestra la interfaz gráfica para la introducción
     * de la fecha de nacimiento.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Edad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("##-##-####");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JFormattedTextField birthDateField = new JFormattedTextField(formatter);
        birthDateField.setColumns(20);

        JButton calculateButton = getCalculateButton(birthDateField, frame);

        JPanel panel = new JPanel();
        panel.add(birthDateField);
        panel.add(calculateButton);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /**
     * Obtiene un botón configurado para calcular la edad al hacer clic.
     *
     * @param birthDateField El campo de texto con el formato de fecha utilizado.
     * @param frame El frame en el cual se mostrará el mensaje del cálculo de la edad.
     * @return El botón configurado con la acción para calcular la edad.
     */
    public static JButton getCalculateButton(JFormattedTextField birthDateField, JFrame frame) {
        JButton calculateButton = new JButton("Calcular Edad");
        calculateButton.addActionListener(e -> {
            String birthDateStr = birthDateField.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date birthDate = sdf.parse(birthDateStr);
                int age = calculateAge(birthDate);
                JOptionPane.showMessageDialog(frame, "Tu edad es " + age + " años.");
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        });
        return calculateButton;
    }

    /**
     * Calcula la edad en años.
     * La calcula restando el año actual al año de nacimiento, ajustando por el día del año.
     *
     * @param birthDate La fecha de nacimiento proporcionada.
     * @return La edad calculada como un entero.
     */
    public static int calculateAge(Date birthDate) {
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }
}
