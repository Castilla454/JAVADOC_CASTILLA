public class EjercicioEjemploUno {

    /**
     * Esta clase representa un ejemplo de uso de Javadoc en IntelliJ IDEA.
     * Proporciona métodos y campos para demostrar el uso de la documentación.
     */
    public class Etiquetas_javadoc {
        /**
         * Este método realiza una operación específica con dos parámetros.
         *
         * @param a Primer número entero.
         * @param b Segundo número entero.
         * @return La suma de los dos números.
         * @throws IllegalArgumentException Si alguno de los parámetros es negativo.
         */
        public int sumar(int a, int b) throws IllegalArgumentException {
            if (a < 0 || b < 0) {
                throw new IllegalArgumentException("Los números deben ser no negativos");
            }
            return a + b;
        }
        /**
         * Campo que almacena información adicional para esta clase.
         */
        private String informacionAdicional;
    }

}
