public class Ascensor {
    private int pisoActual;
    private boolean puertasAbiertas;
    private boolean enMovimiento;

    public Ascensor() {
        this.pisoActual = 1; // Inicia en el piso 1
        this.puertasAbiertas = false;
        this.enMovimiento = false;
    }

    public void moverAlPiso(int pisoDestino) {
        if (!puertasAbiertas) {
            enMovimiento = true;
            System.out.println("Moviendo del piso " + pisoActual + " al piso " + pisoDestino + "...");
            pisoActual = pisoDestino;
            enMovimiento = false;
            System.out.println("Ascensor llegó al piso " + pisoDestino);
        } else {
            System.out.println("Cierre las puertas antes de mover el ascensor.");
        }
    }

    public void abrirPuertas() {
        if (!enMovimiento) {
            puertasAbiertas = true;
            System.out.println("Puertas abiertas.");
        } else {
            System.out.println("No se pueden abrir puertas mientras el ascensor está en movimiento.");
        }
    }

    public void cerrarPuertas() {
        puertasAbiertas = false;
        System.out.println("Puertas cerradas.");
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public boolean isPuertasAbiertas() {
        return puertasAbiertas;
    }

    public boolean isEnMovimiento() {
        return enMovimiento;
    }
    public void setEnMovimiento(boolean enMovimiento) {
        this.enMovimiento = enMovimiento;
    }
}