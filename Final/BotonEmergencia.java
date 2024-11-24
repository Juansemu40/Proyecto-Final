public class BotonEmergencia extends Boton {
    public BotonEmergencia() {
        super(-1); // El valor -1 indica que este botón no está asociado a ningún piso.
    }

    @Override
    public void presionar(SistemaControl control) {
        System.out.println("¡Botón de emergencia presionado! Deteniendo el ascensor...");
        control.detenerAscensor(); // Llama al método de emergencia en el sistema de control.
    }
}
