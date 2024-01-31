package Exercicis.ExerciciTres;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 * Clase que representa una aplicación de formulario de inscripción.
 * Utiliza componentes de interfaz gráfica de usuario (GUI) de Swing.
 * @author Alejandro Castilla
 * @version 1.39, 02/28/97

 */

public class Exercici3 {

    /**
     * Método principal que inicia la aplicación y crea la interfaz de usuario.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     */


    public static void main(String[] args) {
        JFrame ventana = new JFrame("Formulario de Inscripción");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(700, 400);

        //Crear título
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titulo = new JLabel("Formulario de inscripción");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panelTitulo.add(titulo);

        //Crear campo de texto Nombre
        JPanel panelNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel textoNombre = new JLabel("Nombre: ");
        JTextField campoNombre = new JTextField(20);
        panelNombre.add(textoNombre);
        panelNombre.add(campoNombre);

        JPanel panelEdad = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel textoEdad = new JLabel("Edad: ");
        SpinnerNumberModel modeloSpinnerEdad = new SpinnerNumberModel(18, 18, 99, 1);
        JSpinner spinnerEdad = new JSpinner(modeloSpinnerEdad);
        panelEdad.add(textoEdad);
        panelEdad.add(spinnerEdad);

        //Crear lista selección província
        JPanel panelProvincia = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel textoProvincia = new JLabel("Provincia: ");
        JComboBox<String> listaProvincias = new JComboBox<>();
        listaProvincias.addItem("Castellón");
        listaProvincias.addItem("Valencia");
        listaProvincias.addItem("Alicante");
        listaProvincias.setSelectedItem("Valencia");
        listaProvincias.setPreferredSize(new Dimension(200, 25));

        listaProvincias.setMaximumSize(listaProvincias.getPreferredSize());
        panelProvincia.add(textoProvincia);
        panelProvincia.add(listaProvincias);

        //Crea el panel del radioButton
        JPanel panelGenero = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel textoGenero = new JLabel("Sexo: ");
        JRadioButton radioButtonMasculino = new JRadioButton("Masculino");
        JRadioButton radioButtonFemenino = new JRadioButton("Femenino");
        JRadioButton radioButtonOtro = new JRadioButton("Otro");
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(radioButtonMasculino);
        grupoGenero.add(radioButtonFemenino);
        grupoGenero.add(radioButtonOtro);

        panelGenero.add(textoGenero);
        panelGenero.add(radioButtonMasculino);
        panelGenero.add(radioButtonFemenino);
        panelGenero.add(radioButtonOtro);

        JButton buttonEnviar = new JButton("Enviar");

        //Crea panel del checkBox de aceptar publicidad
        JPanel panelPublicidad = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JCheckBox checkBoxPublicidad = new JCheckBox("Acepta la publicidad");

        checkBoxPublicidad.addItemListener(new ItemListener() {
            @Override

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    buttonEnviar.setEnabled(true);
                } else {
                    buttonEnviar.setEnabled(false);
                }
            }
        });

        panelPublicidad.add(checkBoxPublicidad);

        //Crea boton de enviar
        JPanel panelEnviar = new JPanel(new FlowLayout(FlowLayout.CENTER));

        buttonEnviar.setEnabled(false);


        buttonEnviar.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(ventana,
                        "¿Quieres aceptar los datos del formulario?",
                        "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(ventana, "Has confirmado los datos");
                } else if (respuesta == JOptionPane.CANCEL_OPTION) {
                    System.exit(0);
                }
            }
        });
        // Crea un JDialog para confirmar el cierre de la ventana principal
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ventana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override

            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                int confirmarCierre = JOptionPane.showOptionDialog(ventana,
                        "¿Quieres salir de la aplicación?",
                        "Confirmar Cierre", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (confirmarCierre == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Cambia el color de fondo de la ventana principal
        ventana.getContentPane().setBackground(Color.WHITE);

        // Cambia el ícono de la ventana principal
        ImageIcon iconoVentanaPrincipal = new ImageIcon("icono_ventana_principal.png");
        ventana.setIconImage(iconoVentanaPrincipal.getImage());

        // ... (Código anterior sin cambios)


        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        JCheckBoxMenuItem menuItemNombre = new JCheckBoxMenuItem("Campo nombre");
        menuItemNombre.setSelected(true);
        menuItemNombre.addItemListener(e -> {
            boolean seleccionado = e.getStateChange() == ItemEvent.SELECTED;
            panelNombre.setVisible(seleccionado);
        });

        JCheckBoxMenuItem menuItemEdad = new JCheckBoxMenuItem("Campo Edad");
        menuItemEdad.setSelected(true);
        menuItemEdad.addItemListener(e -> {
            boolean seleccionado = e.getStateChange() == ItemEvent.SELECTED;
            panelEdad.setVisible(seleccionado);
        });

        JCheckBoxMenuItem menuItemProvincia = new JCheckBoxMenuItem("Campo Provincia");
        menuItemProvincia.setSelected(true);
        menuItemProvincia.addItemListener(e -> {
            boolean seleccionado = e.getStateChange() == ItemEvent.SELECTED;
            panelProvincia.setVisible(seleccionado);
        });

        JCheckBoxMenuItem menuItemGenero = new JCheckBoxMenuItem("Campo Genero");
        menuItemGenero.setSelected(true);
        menuItemGenero.addItemListener(e -> {
            boolean seleccionado = e.getStateChange() == ItemEvent.SELECTED;
            panelGenero.setVisible(seleccionado);
        });

        menu.add(menuItemNombre);
        menu.add(menuItemEdad);
        menu.add(menuItemProvincia);
        menu.add(menuItemGenero);

        menuBar.add(menu);
        ventana.setJMenuBar(menuBar);

        buttonEnviar.setPreferredSize(new Dimension(350, 50));
        buttonEnviar.setMaximumSize(buttonEnviar.getPreferredSize());
        panelEnviar.add(buttonEnviar);

        ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS));

        ventana.getContentPane().add(titulo);

        ventana.getContentPane().add(panelNombre);

        ventana.getContentPane().add(panelEdad);

        ventana.getContentPane().add(panelProvincia);

        ventana.getContentPane().add(panelGenero);

        ventana.getContentPane().add(panelPublicidad);

        ventana.getContentPane().add(panelEnviar);


        ventana.setVisible(true);
    }







}
