public class DequeDuplamenteEncadeado implements DequeInterface {

    private NoDuplo head;
    private NoDuplo tail;
    private int tamanho;

    public DequeDuplamenteEncadeado() {
        head = null;
        tail = null;
        tamanho = 0;
    }

    public int tamanho() { return tamanho; }

    public boolean estaVazia() { return tamanho == 0; }

    public Object primeiro() throws DequeVazioException {
        if (estaVazia()) {
            throw new DequeVazioException("deque vazio");
        }
        return head.getElemento();
    }

    public Object ultimo() throws DequeVazioException {
        if (estaVazia()) {
            throw new DequeVazioException("deque vazio");
        }
        return tail.getElemento();
    }

    public void inserirInicio(Object elemento) {
        NoDuplo novoNo = new NoDuplo(elemento);
        if (estaVazia()) {
            head = novoNo;
            tail = novoNo;
        } else {
            novoNo.setProximo(head);
            head.setAnterior(novoNo);
            head = novoNo;
        }
        tamanho++;
    }

    public Object removerInicio() throws DequeVazioException {
        if (estaVazia()) {
            throw new DequeVazioException("deque vazio");
        }

        Object elementoRemovido = head.getElemento();
        head = head.getProximo();

        if (head != null) {
            head.setAnterior(null);
        } else {
            tail = null;
        }

        tamanho--;
        return elementoRemovido;
    }

    public void inserirFim(Object elemento) {
        NoDuplo novoNo = new NoDuplo(elemento);
        if (estaVazia()) {
            head = novoNo;
            tail = novoNo;
        } else {
            novoNo.setAnterior(tail);
            tail.setProximo(novoNo);
            tail = novoNo;
        }
        tamanho++;
    }

    public Object removerFim() throws DequeVazioException {
        if (estaVazia()) {
            throw new DequeVazioException("deque vazio");
        }

        Object elementoRemovido = tail.getElemento();
        tail = tail.getAnterior();

        if (tail != null) {
            tail.setProximo(null);
        } else {
            head = null;
        }

        tamanho--;
        return elementoRemovido;
    }
}