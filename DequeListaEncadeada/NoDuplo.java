public class NoDuplo {
    private Object elemento;
    private NoDuplo proximo;
    private NoDuplo anterior;

    public NoDuplo(Object elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }

    public Object getElemento() { return elemento; }
    public NoDuplo getProximo() { return proximo; }
    public NoDuplo getAnterior() { return anterior; }

    public void setProximo(NoDuplo proximo) { this.proximo = proximo; }
    public void setAnterior(NoDuplo anterior) { this.anterior = anterior; }
}