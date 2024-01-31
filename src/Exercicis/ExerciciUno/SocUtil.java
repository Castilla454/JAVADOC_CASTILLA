package Exercicis.ExerciciUno;
/**
 * Clase de utilidad con métodos para realizar diversas operaciones relacionadas con números.
 *
 * @author Alejandro Castilla
 * @version 1.39, 02/28/97
 */
public class SocUtil {

    /**
     * Comprueba si un número es capicúa o no.
     *
     * @param numero Número introducido para comprobar si es capicúa.
     * @return true si el número es capicúa, false en caso contrario.
     * @throws EsNegatiuEX si el número es menor a 0.
     * @see Exercicis.ExerciciUno.EsNegatiuEX
     * @deprecated Utiliza el método esCapikua en su lugar desde la versión 1.35.
     */
    public static boolean esCapicua(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX();
        }
        int numAlReves = 0;
        int copia = numero;
        while (numero > 0) {
            numAlReves = numAlReves * 10 + numero % 10;
            numero /= 10;
        }
        return copia == numAlReves;
    }

    /**
     * Comprueba si un número es capicúa o no.
     *
     * @param numero Número introducido para comprobar si es capicúa.
     * @return true si el número es capicúa, false en caso contrario.
     * @throws EsNegatiuEX si el número es menor a 0.
     * @see Exercicis.ExerciciUno.EsNegatiuEX
     */
    public static boolean esCapikua(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX ();
        }
        String cadNum = numero + "";
        String numAlReves = (new StringBuilder(cadNum)).reverse().toString();
        return cadNum.equals(numAlReves);
    }

    /**
     * Comprueba si un número es primo.
     *
     * @param numero Número introducido para comprobar si es primo.
     * @return true si el número es primo, false en caso contrario.
     * @throws EsNegatiuEX si el número es menor a 0.
     * @see Exercicis.ExerciciUno.EsNegatiuEX
     */
    public static boolean esPrimer(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX();
        }
        int limit = numero / 2 + 1;
        int div = 2;
        while (div < limit) {
            if (numero % div == 0) {
                return false;
            }
            div++;
        }
        return true;
    }

    /**
     * Calcula el factorial de un número.
     *
     * @param numero Número introducido para calcular el factorial.
     * @return factorial del número introducido.
     * @throws EsNegatiuEX si el número es menor a 0.
     * @see Exercicis.ExerciciUno.EsNegatiuEX
     * @see <a href="http://www.sangakoo.com/es/temas/el-factorial-de-un-numero" >Sangaku Maths</a>
     */
    public static long getFactorial(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX("no es pot calcular el factorial d'un número negatiu");
        }
        long fact = 1L;
        while (numero > 1) {
            fact *= numero;
            numero--;
        }
        return fact;
    }
}
