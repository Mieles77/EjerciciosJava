package presentacion;

import datos.BDVehiculo;
import dominio.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import logica.ParkingManager;
import java.util.Scanner;

/**
 * @author Jairo F
 */
public class Main {

    public static Scanner escaner = new Scanner(System.in);
    public static BDVehiculo bdV = new BDVehiculo();
    public static ArrayList<Ticket> tickets = new ArrayList<>(); // Lista de tickets
    public static ParkingManager parqueadero = new ParkingManager();
    
    public static void main(String[] args) {
        int op;
        
        do {            
            System.out.println("\n" + "=".repeat(40));
            System.out.println("       PARQUEOS AUTOMATICOS");
            System.out.println("=".repeat(40));
            System.out.println("1. REGISTRAR CARRO");
            System.out.println("2. REGISTRAR MOTO");
            System.out.println("3. REGISTRAR BICICLETA");
            System.out.println("4. VER VEHICULOS REGISTRADOS");
            System.out.println("5. VER FACTURAS GENERADAS");
            System.out.println("0. SALIR");
            System.out.print("OPCION: ");
            op = escaner.nextInt();
            escaner.nextLine(); // Limpiar buffer
            
            switch (op) {
                case 1:
                    registrar(1);
                    break;
                case 2:
                    registrar(2);
                    break;
                case 3:
                    registrar(3);
                    break;
                case 4:
                    verVehiculos();
                    break;
                case 5:
                    verFacturas();
                    break;
                case 0:
                    System.out.println("\n¡GRACIAS POR USAR EL SISTEMA!");
                    break;
                default:
                    System.out.println("\n OPCION INVALIDA");
            }
            
        } while (op != 0);
        
        escaner.close();
    }
    
    private static void registrar(int op) {
        String auxMarca, auxPlaca, auxTipo;
        int auxEntero, auxEntero2;
        boolean cambios = false;
        Vehiculo vehiculo = null;
        
        System.out.println("\n--- REGISTRO DE VEHICULO ---");
        System.out.print("INGRESE LA PLACA: ");
        auxPlaca = escaner.nextLine();
        
        if (bdV.buscar(auxPlaca) != null) {
            System.out.println("PLACA YA REGISTRADA");
            return;
        }
        
        switch (op) {
            case 1: // Auto
                System.out.print("INGRESE LA MARCA: ");
                auxMarca = escaner.nextLine();
                System.out.print("INGRESE EL MODELO: ");
                auxEntero = escaner.nextInt();
                System.out.print("INGRESE CANTIDAD DE PUERTAS: ");
                auxEntero2 = escaner.nextInt();
                escaner.nextLine();
                vehiculo = new Auto(auxPlaca, auxMarca, auxEntero, auxEntero2);
                break;
                
            case 2: // Moto
                System.out.print("INGRESE LA MARCA: ");
                auxMarca = escaner.nextLine();
                System.out.print("INGRESE EL CILINDRAJE: ");
                auxEntero = escaner.nextInt();
                escaner.nextLine();
                vehiculo = new Moto(auxPlaca, auxMarca, auxEntero);
                break;
                
            case 3: // Bicicleta
                System.out.print("INGRESE EL TIPO (Ruta/Montaña/Cross): ");
                auxTipo = escaner.nextLine();
                System.out.println("¿TIENE CAMBIOS?");
                System.out.println("1. SI");
                System.out.println("2. NO");
                System.out.print("OPCION: ");
                auxEntero = escaner.nextInt();
                escaner.nextLine();
                if (auxEntero == 1) {
                    cambios = true;
                }
                vehiculo = new Bicicleta(auxPlaca, auxTipo, cambios);
                break;
        }
        
        // Agregar vehículo a la BD
        bdV.adicionarVehiculo(vehiculo);
        System.out.println("VEHICULO REGISTRADO EXITOSAMENTE");
        
        // Generar factura inmediatamente
        generarFactura(vehiculo);
    }
    
    private static void generarFactura(Vehiculo vehiculo) {
        System.out.println("\n--- GENERANDO FACTURA ---");
        System.out.print("INGRESE HORAS DE PERMANENCIA: ");
        int horas = escaner.nextInt();
        escaner.nextLine();
        
        // Calcular fechas
        LocalDateTime horaEntrada = LocalDateTime.now();
        LocalDateTime horaSalida = horaEntrada.plusHours(horas);
        
        // Generar ticket
        Ticket ticket = parqueadero.generarTicket(horaEntrada, horaSalida, vehiculo);
        tickets.add(ticket); // Guardar en la lista
        
        // Imprimir factura
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           FACTURA DE PARQUEO");
        System.out.println("=".repeat(40));
        parqueadero.imprimirTicket(ticket);
        System.out.println("=".repeat(40));
    }
    
    private static void verVehiculos() {
        System.out.println("\n--- VEHICULOS REGISTRADOS ---");
        var lista = bdV.listarTodos();
        
        if (lista.isEmpty()) {
            System.out.println("NO HAY VEHICULOS REGISTRADOS");
            return;
        }
        
        System.out.println("=".repeat(60));
        for (Vehiculo v : lista) {
            System.out.println("• " + v.toString());
        }
        System.out.println("=".repeat(60));
        System.out.println("TOTAL: " + lista.size() + " vehiculos");
    }
    
    private static void verFacturas() {
        System.out.println("\n--- FACTURAS GENERADAS ---");
        
        if (tickets.isEmpty()) {
            System.out.println("NO HAY FACTURAS GENERADAS");
            return;
        }
        
        System.out.println("=".repeat(70));
        for (Ticket t : tickets) {
            System.out.println("Ticket #" + t.getIdTicket() + " | Placa: " + t.getPlaca() + 
                             " | Tipo: " + t.getTipo() + " | Horas: " + t.getDuracion() + 
                             " | Costo: $" + t.getCostoTotal());
        }
        System.out.println("=".repeat(70));
        System.out.println("TOTAL: " + tickets.size() + " facturas");
    }
}