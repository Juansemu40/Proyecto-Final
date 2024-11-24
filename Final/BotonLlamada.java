public class BotonLlamada extends Boton {
    public BotonLlamada(int piso) {
        super(piso);
    }

    @Override
    public void presionar(SistemaControl control) {
        System.out.println("Botón de llamada presionado en el piso " + piso);
        control.agregarSolicitud(piso);
    }
}