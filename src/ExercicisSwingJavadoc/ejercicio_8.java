package ExercicisSwingJavadoc;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * La clase <code>ejercicio_8</code> extiende JFrame y representa una ventana que permite
 * cambiar la intensidad de un cuadrado verde mediante un JSlider.
 *
 * <p>El cuadrado cambia de color verde oscuro a verde claro según el valor del JSlider.</p>
 *
 * @author Alejandro Castilla Batista
 * @version 1.0
 */
public class ejercicio_8 extends JFrame {

    private JSlider slider;
    private JPanel panel;

    /**
     * Construye una nueva instancia de la clase <code>ejercicio_8</code>.
     * Establece las propiedades de la ventana JFrame y agrega los elementos necesarios.
     */
    public ejercicio_8() {
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        agregarSlider();
        agregarPanel();

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                panel.setBackground(new Color(0, slider.getValue() * 255 / 100, 0));
            }
        });

        setVisible(true);
    }

    /**
     * Agrega un JSlider a la ventana con configuraciones específicas.
     */
    public void agregarSlider() {
        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBounds(0, 20, 280, 50);
        add(slider, BorderLayout.NORTH);
    }

    /**
     * Agrega un JPanel al centro de la ventana con un color de fondo inicial verde.
     */
    public void agregarPanel() {
        panel = new JPanel();
        panel.setBounds(100, 100, 80, 50);
        panel.setBackground(Color.GREEN);
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    /**
     * Punto de entrada principal para la aplicación.
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        new ejercicio_8();
    }
}
