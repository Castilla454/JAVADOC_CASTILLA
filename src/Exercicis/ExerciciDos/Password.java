package Exercicis.ExerciciDos;

/**
 * La siguiente clase se utiliza para la administración de contraseñas.
 * Puede ser utilizada para comprobar la fortaleza de contraseñas actuales o para generar nuevas.
 *
 * @author Alejandro Castilla
 * @version 1.5, 02/28/97
 */
public final class Password {

    private final static int LONG_DEF = 8;

    private int longitud;
    private String contrasenya;

    /**
     * Obtiene la longitud actual de la contraseña.
     *
     * @return longitud - la longitud establecida anteriormente.
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Asigna una nueva longitud a la contraseña.
     *
     * @param longitud - nueva longitud para asignar a la variable.
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    /**
     * Obtiene la contraseña actual.
     *
     * @return contrasenya - la contraseña establecida anteriormente.
     */
    public String getContrasenya() {
        return contrasenya;
    }

    /**
     * Genera aleatoriamente una nueva contraseña basada en la longitud especificada.
     *
     * @return password - La contraseña generada aleatoriamente.
     * @see Math#random()
     * @see Math#floor(double)
     */
    public String generaPassword() {
        String password = "";
        for (int i = 0; i < longitud; i++) {
            int eleccion = ((int) Math.floor(Math.random() * 3 + 1));

            if (eleccion == 1) {
                char minusculas = (char) ((int) Math.floor(Math.random() * (123 - 97) + 97));
                password += minusculas;
            } else {
                if (eleccion == 2) {
                    char mayusculas = (char) ((int) Math.floor(Math.random() * (91 - 65) + 65));
                    password += mayusculas;
                } else {
                    char numeros = (char) ((int) Math.floor(Math.random() * (58 - 48) + 48));
                    password += numeros;
                }
            }
        }
        return password;
    }
    /**
     * Comprueba si la contraseña es fuerte.
     *
     * @return true - si la contraseña es fuerte, false - si la contraseña es débil.
     * @see String#charAt
     */

    public boolean esFuerte() {
        int cuentanumeros = 0;
        int cuentaminusculas = 0;
        int cuentamayusculas = 0;

        for (int i = 0; i < contrasenya.length(); i++) {
            if (contrasenya.charAt(i) >= 97 && contrasenya.charAt(i) <= 122) {
                cuentaminusculas += 1;
            } else {
                if (contrasenya.charAt(i) >= 65 && contrasenya.charAt(i) <= 90) {
                    cuentamayusculas += 1;
                } else {
                    cuentanumeros += 1;
                }
            }
        }
        if (cuentanumeros >= 5 && cuentaminusculas >= 1 && cuentamayusculas >= 2) {
            return true;
        } else {
            return false;
        }
    }
    /**
     *@deprecated usa el metode esFuerte en el seu lloc desde la version 1.2
     */
    public boolean esFort() {
        int cuentanumeros = 0;
        int cuentaminusculas = 0;
        int cuentamayusculas = 0;

        for (int i = 0; i < contrasenya.length(); i++) {
            if (contrasenya.charAt(i) >= 97 && contrasenya.charAt(i) <= 122) {
                cuentaminusculas += 1;
            } else {
                //Javadoc ___14;
                if (contrasenya.charAt(i) >= 65 && contrasenya.charAt(i) <= 90) {
                    cuentamayusculas += 1;
                } else {
                    cuentanumeros += 1;
                }
            }
        }
        if (cuentanumeros >= 3 && cuentaminusculas >= 1 && cuentamayusculas >= 1) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Constructor por defecto que crea una contraseña con longitud predeterminada.
     */
    public Password() {
        this(LONG_DEF);
    }


    /**
     * Constructor que permite especificar la longitud de la contraseña al crear una nueva instancia.
     *
     * @param longitud - la longitud de la nueva contraseña.
     */
    public Password(int longitud) {
        this.longitud = longitud;
        contrasenya = generaPassword();
    }
}