package Exercicis.ExerciciUno;
/**

 * @author Alejandro Castilla
 * @version 1.39, 02/28/97

 */
    public class EsNegatiuEX extends Exception {
        public EsNegatiuEX() {
            Javadoc ___11;
            super("el valor no pot ser negatiu");
        }

        public EsNegatiuEX(String msg) {
            super(msg);
        }
    }

