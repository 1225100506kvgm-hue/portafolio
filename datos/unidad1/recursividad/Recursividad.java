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

    public static void main(String[] args) {
        saludo("Katya Valentina", 10);
        cuentaRegresiva(100);
    }
}