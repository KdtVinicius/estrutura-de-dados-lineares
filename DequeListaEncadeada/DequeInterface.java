public interface DequeInterface {
    void inserirInicio(Object elemento);
    Object removerInicio() throws DequeVazioException;
    void inserirFim(Object elemento);
    Object removerFim() throws DequeVazioException;

    Object primeiro() throws DequeVazioException;
    Object ultimo() throws DequeVazioException;
    int tamanho();
    boolean estaVazia();
}