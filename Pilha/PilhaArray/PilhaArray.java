package PilhaArray;

public class PilhaArray implements PilhaInterface {

    private Object[] elementos;
    private int topo;

    public PilhaArray() {
        elementos = new Object[10];
        topo = -1;
    }

    public Object pop() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("Não é possível remover de uma pilha vazia.");
        }

        Object topoAntigo = elementos[topo];
        elementos[topo--] = null;

        return topoAntigo;
    }

    public Object top() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("Não é possível remover de uma pilha vazia.");
        }

        return  elementos[topo];
    }

    public void push(Object o) throws PilhaCheiaExcecao {
        if (isFull()) {
            throw new PilhaCheiaExcecao("Não é possível empilhar em uma pilha cheia.");
        }

        elementos[++topo] = o;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == elementos.length - 1;
    }

    public int size() {
        return topo + 1;
    }
}