public class BotonDestino extends Boton {
    public BotonDestino(int piso) {
        super(piso);
    }

    @Override
    public void presionar(SistemaControl control) {
        System.out.println("Botón de destino presionado para ir al piso " + piso);
        control.agregarSolicitud(piso);
    }
}