public abstract class Boton {
    protected int piso;

    public Boton(int piso) {
        this.piso = piso;
    }

    public abstract void presionar(SistemaControl control);
}
