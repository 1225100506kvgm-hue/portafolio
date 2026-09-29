public class arreglos {

    static int K = 7; // Cambia el 7: último dígito de tu matrícula + 1

    public static void main(String[] args) {
        System.out.println(" FASE 1 ");
        fase1();

        System.out.println("\n FASE 2 ");
        fase2();

        System.out.println("\n FASE 3 ");
        fase3();
    }

    // ---------------- FASE 1 ----------------
    static void fase1() {
        int[] lecturas = {10, -5, 20, K * 2, -1, 30, 0, 15};

        // Tarea 1.1: recorrido inverso corregido
        for (int i = lecturas.length - 1; i >= 0; i--) {
            if (lecturas[i] > 0) {
                System.out.println("Lectura positiva: " + lecturas[i]);
            }
        }

        /* Tarea 1.2: Justificación teórica
         * En Java los arreglos se indexan desde 0, por lo que un arreglo
         * de n elementos tiene índices válidos de 0 a n-1. La propiedad
         * .length devuelve la cantidad de elementos (aquí 8), no la
         * posición del último. En el código original el ciclo iniciaba en
         * i = lecturas.length (8), pero el último índice válido es 7, así
         * que lecturas[8] lanza ArrayIndexOutOfBoundsException. Se corrige
         * iniciando en lecturas.length - 1.
         */
    }

    // ---------------- FASE 2 ----------------
    static void fase2() {
        int[][] ventas = new int[3][];
        ventas[0] = new int[K];      // Vendedor 1
        ventas[1] = new int[K + 1];  // Vendedor 2
        ventas[2] = new int[2];      // Vendedor 3

        // Tarea 2.1: cada fila se recorre con su propia longitud
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                ventas[i][j] = (i + 1) * (j + 1);
            }
        }

        // Tarea 2.2: suma total de todos los elementos
        int suma = 0;
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                suma += ventas[i][j];
            }
        }
        System.out.println("Suma total: " + suma);

        /* Tarea 2.3: Ventaja de memoria del Jagged Array
         * Una matriz tradicional N x M reserva N*M celdas, aunque algunas
         * filas necesiten menos columnas, y las celdas sobrantes quedan
         * desperdiciadas. Un jagged array reserva para cada fila solo el
         * tamaño que necesita, por lo que ocupa menos memoria cuando los
         * datos de cada fila no son homogéneos.
         */
    }

    // ---------------- FASE 3 ----------------
    static void fase3() {
        int[][][] cubo = new int[2][K][K];

        // Inicialización
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < K; j++)
                for (int k = 0; k < K; k++)
                    cubo[i][j][k] = i + j + k + 1;

        // Tarea 3.1: while corregido
        System.out.println(" Tarea 3.1 ");
        int i = 0;
        while (i < 2) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < K; k++) {
                    if (cubo[i][j][k] % 3 == 0) {
                        System.out.println("Múltiplo encontrado en: "
                                + i + "," + j + "," + k);
                    }
                }
            }
            i++; // Lo que faltaba: sin esto i siempre vale 0 y el ciclo no termina
        }

        /* Tarea 3.1: El while se congela porque la variable de control i
         * nunca cambia de valor. La condición (i < 2) es siempre verdadera,
         * así que el ciclo se repite indefinidamente. Se corrige
         * incrementando i al final de cada iteración con i++.
         */

        // Tarea 3.2: refactorización con for-each
        System.out.println(" Tarea 3.2 ");
        int contador = 0;
        int posI = 0;
        for (int[][] plano : cubo) {
            int posJ = 0;
            for (int[] fila : plano) {
                int posK = 0;
                for (int valor : fila) {
                    if (valor % 3 == 0) {
                        System.out.println("Múltiplo encontrado en: "
                                + posI + "," + posJ + "," + posK);
                        contador++;
                    }
                    posK++;
                }
                posJ++;
            }
            posI++;
        }
        System.out.println("Total de múltiplos de 3: " + contador);

        /* Tarea 3.3: Limitación del for-each al modificar valores
         * En un for-each sobre int[][][], la variable del nivel más
         * interno (int valor) es una COPIA del elemento, no una referencia
         * a la celda del arreglo. Por eso asignar valor = valor * 2 solo
         * cambia la copia local y el arreglo original no se modifica.
         * Además, el for-each no expone los índices, así que no se puede
         * escribir cubo[i][j][k] = ... ni saber la posición sin llevar
         * contadores manuales. Para modificar el contenido hay que usar
         * el for tradicional con índices.
         */
    }
}