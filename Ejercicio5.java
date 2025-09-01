import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ENTRADA
        System.out.println("Ingrese base del rectangulo:  ");
        double base = scanner.nextDouble();
        System.out.println("Ingrese altura del rectangulo:  ");
        double altura = scanner.nextDouble();

        System.out.printf("El area del rectangulo es: %.2f %n", areaRectangulo(base, altura));

    }
    public static double areaRectangulo(double base, double altura){
        return base * altura;
    }
}