import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ascensor ascensor = new Ascensor();
        SistemaControl sistemaControl = new SistemaControl(ascensor);

        int opcion;
        do {
            System.out.println("\n=== Menú de Control del Ascensor ===");
            System.out.println("1. Llamar al elevador");
            System.out.println("2. Seleccionar piso de destino");
            System.out.println("3. Abrir puertas");
            System.out.println("4. Cerrar puertas");
            System.out.println("5. Procesar solicitudes pendientes");
            System.out.println("6. Mostrar estado del ascensor");
            System.out.println("7. Presionar botón de emergencia");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el piso actual para llamar al ascensor: ");
                    int pisoLlamada = scanner.nextInt();
                    BotonLlamada botonLlamada = new BotonLlamada(pisoLlamada);
                    botonLlamada.presionar(sistemaControl);
                    break;

                case 2:
                    System.out.print("Ingrese el piso de destino: ");
                    int pisoDestino = scanner.nextInt();
                    BotonDestino botonDestino = new BotonDestino(pisoDestino);
                    botonDestino.presionar(sistemaControl);
                    break;

                case 3:
                    sistemaControl.getAscensor().abrirPuertas();
                    break;

                case 4:
                    sistemaControl.getAscensor().cerrarPuertas();
                    break;

                case 5:
                    if (!sistemaControl.haySolicitudesPendientes()) {
                        System.out.println("No hay solicitudes pendientes.");
                    } else {
                        sistemaControl.procesarSolicitudes();
                    }
                    break;

                case 6:
                    System.out.println("\n=== Estado del Ascensor ===");
                    System.out.println("Piso actual: " + ascensor.getPisoActual());
                    System.out.println("Puertas abiertas: " + (ascensor.isPuertasAbiertas() ? "Sí" : "No"));
                    System.out.println("En movimiento: " + (ascensor.isEnMovimiento() ? "Sí" : "No"));
                    break;

                case 7: // Nueva opción para el botón de emergencia
                    BotonEmergencia botonEmergencia = new BotonEmergencia();
                    botonEmergencia.presionar(sistemaControl);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}