package datos.unidad1.recursividad;

public class Recursividad {

    public static void saludo(String nombre, int total) {

        if(total <= 0)
            return;
        else {
            System.out.println("Hola " + nombre);
            saludo(nombre, total - 1);
        }
    }

    public static void cuentaRegresiva(int n){
    
   if(n < 0) {
        return;
   }else {
        System.out.print(n + " ");
        cuentaRegresiva(n-1);
    }
}

/**
/ Funcion que realiza cuenta regresiva de acuerdon a un valor entero
*25 Septiembre
*Katya Valentina
*/

    public static int sumaRecursiva(int[] datos, int tam) {
        // Caso base: si el índice es menor que 0, ya recorrimos todo el arreglo y aportamos 0
        if (tam < 0) {
            return 0;
        } else {
            // Suma el elemento actual y pasa al anterior índice (tam - 1)
            return datos[tam] + sumaRecursiva(datos, tam - 1);
        }
    }


       
    public static void main(String[] args) {
        saludo("Katya Valentina", 10);
        cuentaRegresiva(100);
        int[] datos = {3, 4, 5, 6, 7, 8};
        int resultado = sumaRecursiva(datos, datos.length - 1);  
        System.out.println("La suma de los elementos es: " + resultado);   

    }
}

