public class DequeSimplesmenteEncadeado implements DequeInterface {

    private No head;
    private No tail;
    private int tamanho;

    public DequeSimplesmenteEncadeado() {
        head = null;
        tail = null;
        tamanho = 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

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
        No novoNo = new No(elemento);
        if (estaVazia()) {
            head = novoNo;
            tail = novoNo;
        } else {
            novoNo.setProximo(head);
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
        tamanho--;

        if (estaVazia()) {
            tail = null;
        }
        return elementoRemovido;
    }

    public void inserirFim(Object elemento) {
        No novoNo = new No(elemento);
        if (estaVazia()) {
            head = novoNo;
            tail = novoNo;
        } else {
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

        if (tamanho == 1) {
            head = null;
            tail = null;
        } else {
            No atual = head;
            while (atual.getProximo() != tail) {
                atual = atual.getProximo();
            }
            tail = atual;
            tail.setProximo(null);
        }

        tamanho--;
        return elementoRemovido;
    }
}