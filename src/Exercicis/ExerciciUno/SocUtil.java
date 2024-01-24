package Exercicis.ExerciciUno;
/**

 * @author Alejandro Castilla
 * @version 1.39, 02/28/97

 */

public class SocUtil {

    /**
     * Metodo para comprobar si un numero es capicua o no
     *       @param numero numero introducido del cual vamos a comprobar si es capikua o no
     *           @return copia --> variable int donde se almacenara el numero al reves.
     *           @throws EsNegatiuEX si el numero es menor a 0
     *          @see Exercicis.ExerciciUno.EsNegatiuEX#EsNegatiuEX() (Object)
     *          @deprecated usa {@link Exercicis.ExerciciUno#esCapikua(java.lang.String)} en el seu lloc desde la version 1.35
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
     * Metodo para comprobar si un numero es capicua o no
     *       @param numero numero introducido del cual vamos a comprobar si es capikua o no
     *           @return cadNum --> el numero al reves.
     *           @throws EsNegatiuEX si el numero es menor a 0
     *          @see Exercicis.ExerciciUno.EsNegatiuEX#EsNegatiuEX() (Object)
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
     * Metodo para comprobar si un numero esprimo o no
     *       @param numero numero introducido del cual vamos a comprobar si es capikua o no
     *           @return true --> Si el numero es primo. <br> false -->Si el numero es falso.
     *           @throws EsNegatiuEX si el numero es menor a 0
     *          @see Exercicis.ExerciciUno.EsNegatiuEX#EsNegatiuEX() (Object)
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
     * Metodo para calcular el factorial de un numero
     *       @param numero numero introducido del cual vamos a calcular el factorial
     *           @return fact --> factorial del numero introducido
     *           @throws EsNegatiuEX si el numero es menor a 0
     *          @see Exercicis.ExerciciUno.EsNegatiuEX#EsNegatiuEX() (Object)
     * @see <a href="http://www.sangakoo.com/es/temas/el-factorial-de-un-numero" >Sangaku Maths</a>
     */
    public static long getFactorial(int numero) throws EsNegatiuEX {

        if (numero < 0) {
            throw new EsNegatiuEX("no es pot calcular el factorial d'un número negatiu");
        }
        long fact = 1L;
        while (numero > 1) {
            fact *= numero;
            numero --;
        }
        return fact;
    }

}
