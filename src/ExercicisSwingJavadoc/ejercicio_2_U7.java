package ExercicisSwingJavadoc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Clase que implementa una interfaz gráfica para el control de acceso mediante usuario y contraseña.
 * Permite cambiar el color de fondo y muestra una ventana emergente al realizar el login correctamente.
 *
 * <p>La contraseña y el usuario de ejemplo son "bugaboo" y "Gustavo" respectivamente.</p>
 *
 * @author Alejandro Castilla Batista
 * @version 1.0
 */
public class ejercicio_2_U7 implements KeyListener {

    private JFrame frame = new JFrame();
    private JPasswordField passwordField;
    private JTextField textoUser;
    private JFrame controllingFrame;
    final private Color COLORVERDE = new Color(189, 236, 182);
    final private Color COLORAZUL = new Color(178, 218, 250);
    private JFrame ventana = new JFrame();

    /**
     * Constructor que configura la interfaz gráfica y muestra la ventana principal.
     */
    public ejercicio_2_U7() {

        frame.setLayout(null);
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Control de acceso");
        frame.setResizable(false);
        frame.getContentPane().setBackground(COLORVERDE);
        Image icon = new ImageIcon(getClass().getResource("Gorila.png")).getImage();
        frame.setIconImage(icon);
        agregarLabels();
        agregarInteractuables();
        cerrar();
        frame.setVisible(true);
    }

    /**
     * Agrega etiquetas a la interfaz gráfica.
     */
    public void agregarLabels() {
        JLabel titulo = new JLabel("Welcome");
        titulo.setFont(new Font("Source Code Pro Light", Font.BOLD, 27));
        titulo.setBounds(100, 0, 200, 100);
        frame.add(titulo);

        JLabel user = new JLabel("USER");
        user.setBounds(50, 80, 50, 20);
        frame.add(user);

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(50, 120, 100, 20);
        frame.add(password);
    }

    /**
     * Agrega componentes interactivos a la interfaz gráfica.
     */
    public void agregarInteractuables() {
        textoUser = new JTextField();
        textoUser.setBounds(150, 80, 100, 20);
        frame.add(textoUser);

        passwordField = new JPasswordField(8);
        passwordField.setEchoChar('*');
        passwordField.setBounds(150, 120, 100, 20);
        passwordField.addKeyListener(this);
        frame.add(passwordField);

        JButton boton = new JButton("LOG IN");
        boton.setBounds(150, 150, 100, 30);
        boton.addActionListener(this::actionPerformed);
        frame.add(boton);

        JButton botonColor = new JButton("COLOR");
        botonColor.setBounds(20, 150, 90, 30);
        botonColor.addActionListener(this::cambiarColor);
        frame.add(botonColor);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.VK_ENTER == e.getKeyCode()){
            logIn();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Cambia el color de fondo de la ventana entre verde y azul.
     *
     * @param event El evento de acción.
     */
    public void cambiarColor(ActionEvent event) {
        Color colorActual = frame.getContentPane().getBackground();

        if (colorActual.getRGB() == COLORVERDE.getRGB()) {
            frame.getContentPane().setBackground(COLORAZUL);
        }

        if (colorActual.getRGB() == COLORAZUL.getRGB()) {
            frame.getContentPane().setBackground(COLORVERDE);
        }
    }

    /**
     * Realiza el login, verificando la contraseña y el usuario.
     */
    public void logIn(){

        char[] input = passwordField.getPassword();
        String user = textoUser.getText();

        if (isPasswordCorrect(input) && isCorrectUser(user)) {
            frame.dispose();
            ventanaEmergente();
        } else {
            JOptionPane.showMessageDialog(controllingFrame,
                    "Fail. You are not in",
                    "Warning",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Muestra una ventana emergente indicando que se ha iniciado sesión.
     */
    public void ventanaEmergente(){
        ventana.setLayout(null);
        ventana.setSize(500, 200);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Login");
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(frame);
        JLabel titulo = new JLabel("YOU ARE LOG IN");
        titulo.setFont(new Font("Source Code Pro Light", Font.BOLD, 33));
        titulo.setBounds(120, 0, 300, 100);
        ventana.add(titulo);
        JButton botonSalida = new JButton("EXIT");
        botonSalida.setBounds(200,100,100,40);
        ventana.add(botonSalida);
        botonSalida.addActionListener(this::salidaBoton);
        ventana.setVisible(true);
    }

    /**
     * Cierra la ventana emergente al hacer clic en el botón "EXIT".
     *
     * @param e El evento de acción.
     */
    public void salidaBoton(ActionEvent e){
        ventana.dispose();
    }

    /**
     * Realiza la acción de login al hacer clic en el botón "LOG IN".
     *
     * @param e El evento de acción.
     */
    public void actionPerformed(ActionEvent e) {
        logIn();
    }

    /**
     * Verifica si la contraseña ingresada es correcta.
     *
     * @param input La contraseña ingresada como array de caracteres.
     * @return `true` si la contraseña es correcta, `false` en caso contrario.
     */
    public static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect;
        char[] correctPassword = {'b', 'u', 'g', 'a', 'b', 'o', 'o'};

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals(input, correctPassword);
        }

        return isCorrect;
    }

    /**
     * Verifica si el usuario ingresado es correcto.
     *
     * @param user El usuario ingresado.
     * @return `true` si el usuario es correcto, `false` en caso contrario.
     */
    public static boolean isCorrectUser(String user) {
        boolean isCorrect = true;
        final String CORRECTUSER = "Gustavo";

        if (!user.equals(CORRECTUSER)) {
            isCorrect = false;
        }

        return isCorrect;
    }

    /**
     * Configura el cierre de la ventana principal, mostrando un cuadro de diálogo de confirmación.
     */
    public void cerrar(){
        try{
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    confirmarSalida();
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Muestra un cuadro de diálogo de confirmación al intentar cerrar la aplicación.
     */
    public void confirmarSalida() {
        Object[] opciones = {"Confirmar", "Cancelar"};
        int n = JOptionPane.showOptionDialog(controllingFrame,
                "Estas seguro de que quieres salir?",
                "Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[1]
        );

        switch (n) {
            case JOptionPane.YES_OPTION:
                System.exit(0);
                break;
            case JOptionPane.NO_OPTION:
                break;
        }
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        new ejercicio_2_U7();
    }
}




