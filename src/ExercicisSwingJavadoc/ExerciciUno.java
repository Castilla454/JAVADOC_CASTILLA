package ExercicisSwingJavadoc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa un formulario de inicio de sesión con Password Field.
 */
public class ExerciciUno {

    private JFrame ventana;

    /**
     * Constructor que inicializa la interfaz gráfica del formulario de inicio de sesión.
     */
    public ExerciciUno() {
        // Crear la ventana
        ventana = new JFrame("WELCOME");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300);

        // Configurar la fuente para el título
        Font titleFont = new Font("Source Code Pro", Font.BOLD, 24);

        // Crear y configurar el título
        JLabel titleLabel = new JLabel("WELCOME");
        titleLabel.setFont(titleFont);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Crear y configurar el campo de nombre de usuario
        JPanel panelNombre = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usuario = new JTextField(10);
        panelNombre.add(usernameLabel);
        panelNombre.add(usuario);

        // Crear y configurar el campo de contraseña (Password Field)
        JPanel panelPassword = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField contrasenya = new JPasswordField(10);
        panelPassword.add(passwordLabel);
        panelPassword.add(contrasenya);

        // Crear y configurar el botón de inicio de sesión
        JButton loginButton = new JButton("Log In");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarInicioSesion(usuario.getText(), new String(contrasenya.getPassword()));
            }
        });

        // Configurar el diseño y agregar componentes
        ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS));
        ventana.getContentPane().add(titleLabel);
        ventana.getContentPane().add(panelNombre);
        ventana.getContentPane().add(panelPassword);
        ventana.getContentPane().add(loginButton);
    }

    /**
     * Método para realizar la acción de inicio de sesión.
     * Muestra un JOptionPane con los resultados del inicio de sesión.
     *
     * @param username Nombre de usuario.
     * @param password Contraseña.
     */
    private void realizarInicioSesion(String username, String password) {
        // Lógica de validación de inicio de sesión
        boolean loginExitoso = ("admin".equals(username) && "1234".equals(password));

        // Mostrar resultados en un JOptionPane
        mostrarMensaje(loginExitoso ? "You're in!" : "Incorrect access.");
    }

    /**
     * Método para mostrar un JOptionPane de tipo Show Message Dialog con el mensaje dado.
     *
     * @param message Mensaje a mostrar en el diálogo.
     */
    private void mostrarMensaje(String message) {
        JOptionPane.showMessageDialog(ventana, message);
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExerciciUno exerciciUno = new ExerciciUno();
                exerciciUno.mostrarVentana();
            }
        });
    }

    /**
     * Método para mostrar la ventana del formulario de inicio de sesión.
     */
    public void mostrarVentana() {
        ventana.setVisible(true);
    }
}
