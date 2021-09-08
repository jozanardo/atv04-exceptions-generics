/**
 * Classe para tratamentos de arrays genericos.
 *
 * @param <T> o tipo generico
 */
public abstract class ArraysUtil<T> {

    /**
     * Metodo para verificar se um array generico esta ordenado.
     *
     * @param elementos array generico
     * @param <T> o tipo generico
     * @return "true" caso esteja ordenado e "false" caso contrario
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            for (int j = i; j < elementos.length; j++) {
                if (elementos[j].compareTo(elementos[i]) < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
