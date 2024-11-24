import java.util.LinkedList;
import java.util.Queue;

public class SistemaControl {
    private Ascensor ascensor;
    private Queue<Integer> solicitudes;

    public SistemaControl(Ascensor ascensor) {
        this.ascensor = ascensor;
        this.solicitudes = new LinkedList<>();
    }

    public void agregarSolicitud(int pisoDestino) {
        final int LIMITE_PISOS = 10;

        // Validación para no permitir pisos fuera del rango
        if (pisoDestino < 1 || pisoDestino > LIMITE_PISOS) {
            System.out.println("Error: El piso " + pisoDestino + " no es válido. El rango de pisos es de 1 a "
                    + LIMITE_PISOS + ".");
            return;
        }

        if (!solicitudes.contains(pisoDestino)) {
            solicitudes.add(pisoDestino);
            System.out.println("Solicitud al piso " + pisoDestino + " añadida.");
        } else {
            System.out.println("El piso " + pisoDestino + " ya está en la lista de solicitudes.");
        }
    }

    public void procesarSolicitudes() {
        while (!solicitudes.isEmpty()) {
            int siguientePiso = solicitudes.poll();
            ascensor.moverAlPiso(siguientePiso);
            ascensor.abrirPuertas();
            ascensor.cerrarPuertas();
        }
    }

    public boolean haySolicitudesPendientes() {
        return !solicitudes.isEmpty();
    }

    public Ascensor getAscensor() {
        return ascensor;
    }

    public void detenerAscensor() {
        if (ascensor.isEnMovimiento()) {
            System.out.println("El ascensor estaba en movimiento. Deteniéndose...");
            ascensor.setEnMovimiento(false); // Detenemos el movimiento.
        }
        ascensor.abrirPuertas(); // Abrimos las puertas para seguridad.
        solicitudes.clear(); // Limpiamos todas las solicitudes pendientes.
        System.out.println(
                "El ascensor ha sido detenido y las puertas se han abierto. Solicitudes pendientes canceladas.");
    }
}