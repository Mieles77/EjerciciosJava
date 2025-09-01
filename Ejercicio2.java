import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ENTRADA
        System.out.print("Ingrese un dia de la semana (1-7): ");
        int dia = scanner.nextInt();

        
        if (dia < 1 || dia > 7) {
            System.out.println("El numero ingresado no corresponde a un dia de la semana");
        }
        else {
            if(dia >= 1 && dia <= 5) {
                System.out.println("Es un dia laboral");
            }
            else {
                System.out.println("Es fin de semana");
            }

        }
    }

}