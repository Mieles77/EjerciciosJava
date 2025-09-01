import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //DATOS DE ENTRADA
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        System.out.print("Ingrese su salario mensual: ");
        double salario = scanner.nextDouble();

        //PROCESAMIENTO
        double salarioAnual = salario * 12;
        System.out.println("-----------------------------------");
        int dobleEdad = edad * 2;
        System.out.printf("Nombre: %s %nEdad: %d %nSalario anual: %.2f %n", nombre, edad, salarioAnual);
        System.out.printf("El doble de su edad es: %d %n", dobleEdad);
    }
}