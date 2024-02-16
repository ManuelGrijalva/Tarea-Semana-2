import java.util.Random;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[][] ventas = new int[5][12];
        Random random = new Random();

        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                ventas[i][j] = random.nextInt(10000) + 1;
            }
        }
        System.out.println("Matriz de ventas por filas:");
        Arrays.stream(ventas).forEach(fila -> {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        });
        System.out.println("\nMatriz de ventas ordenada por columna 1 (Enero):");
        int[] columna1 = Arrays.stream(ventas).mapToInt(fila -> fila[0]).toArray();
        Arrays.sort(columna1);
        System.out.println(Arrays.toString(columna1));

        System.out.println("\nVentas mayores a 5000 en el mes de Marzo (Columna 2):");
        IntStream ventasMarzo = Arrays.stream(ventas).flatMapToInt(fila -> Arrays.stream(fila, 2, 3));
        ventasMarzo.filter(venta -> venta > 5000).forEach(System.out::println);

    }
}