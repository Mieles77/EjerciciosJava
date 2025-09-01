import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ENTRADA
        System.out.print("Ingrese un numero entero: ");
        int numero = scanner.nextInt();
        int multiplo = 0;

        while(multiplo <= 5){
            System.out.printf("%d x %d = %d %n", numero, multiplo, numero * multiplo);
            multiplo++;
        }

    }
}
