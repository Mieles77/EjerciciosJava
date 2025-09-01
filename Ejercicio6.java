import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double[][] calificaciones = new double[3][3];
        double promedio = 0, promEstudiante = 0;

        //ENTRADA
        for(int i=0; i<3; i++) {//MATERIA
            for(int j=0; j<3; j++) { //ALUMNO
                System.out.printf("Ingrese la calificacion de la materia %d del alumno %d: ", i+1, j+1);
                    calificaciones[i][j] = scanner.nextDouble();
                }
            }

        System.out.println("ESTUDIANTE 1  ESTUDIANTE 2  ESTUDIANTE 3  PROMEDIO MATERIA");
        System.out.println("------------------------------------------------");
        for(int i=0; i<3; i++) {//MATERIA
            System.out.print("Materia "+(i+1)+":   ");
            for(int j=0; j<3; j++) { //ALUMNO
                promedio += calificaciones[i][j];
                System.out.print(calificaciones[i][j]+"        ");
                promedio += calificaciones[i][j];
            }
            System.out.println(promedio/3);            
        }
        System.out.println("------------------------------------------------");
        System.out.print("Promedio Estudiante: ");
        for(int j=0; j<3; j++) {
            for(int i=0; i<3; i++) {
                promEstudiante += calificaciones[i][j];
            }
            System.out.print(promEstudiante/3+"       ");
        } //ALUMNO


        scanner.close();
    }

 }

