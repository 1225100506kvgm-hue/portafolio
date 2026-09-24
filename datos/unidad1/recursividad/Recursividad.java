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

    public static void main(String[] args) {

        saludo("Katya Valentina", 10);
    }
}