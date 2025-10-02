public class No {
    private Object elemento;
    private No proximo;

    public No(Object elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public Object getElemento() {
        return elemento;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}