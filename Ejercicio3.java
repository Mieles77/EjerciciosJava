import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ENTRADA
        System.out.print("Ingrese un numero entero: ");
        int numero = scanner.nextInt();
        int cont=0;

        for(int i=1; i<=numero; i++) {
            if(numero % i == 0) {
                System.out.printf("%d es un divisor de %d %n", i, numero);
                cont++;
            }
        }
        System.out.printf("El numero %d tiene %d divisores %n", numero, cont);
    }
}
