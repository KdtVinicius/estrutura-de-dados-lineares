package PilhaRubroNegra;

public interface PilhaRNInterface {
    // pilha vermelha
    void pushVermelho(Object o);
    Object popVermelho() throws PilhaVaziaExcecao;
    Object topVermelho() throws PilhaVaziaExcecao;
    boolean vazioVermelho();
    int sizeVermelho();

    // pilha preta
    void pushPreto(Object o);
    Object popPreto() throws PilhaVaziaExcecao;
    Object topPreto() throws PilhaVaziaExcecao;
    boolean vazioPreto();
    int sizePreto();
}