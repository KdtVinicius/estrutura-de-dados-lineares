package PilhaRubroNegra;
import PilhaRubroNegra.PilhaVaziaExcecao;

public interface PilhaRNInterface {
    // pilha vermelha
    void pushVermelho(Object o);
    Object popVermelho() throws PilhaVaziaExcecao;
    Object topVermelho() throws PilhaVaziaExcecao;
    boolean isEmptyVermelho();
    int sizeVermelho();

    // pilha preta
    void pushPreto(Object o);
    Object popPreto() throws PilhaVaziaExcecao;
    Object topPreto() throws PilhaVaziaExcecao;
    boolean isEmptyPreto();
    int sizePreto();

    //  ambas pilhas
    int size();
}