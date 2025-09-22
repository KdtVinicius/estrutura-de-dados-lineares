package PilhaRubroNegra;
import PilhaRubroNegra.PilhaVaziaExcecao;

public class PilhaRN implements PilhaRNInterface {

    private Object[] elementos;
    private int topoVermelho;
    private int topoPreto;
    private int capacidade;
    private static final int CAPACIDADE_INICIAL = 10;

    public PilhaRN() {
        this.capacidade = CAPACIDADE_INICIAL;
        this.elementos = new Object[capacidade];
        this.topoVermelho = -1;
        this.topoPreto = capacidade;
    }

    public boolean isEmptyVermelho() {
        return this.topoVermelho == -1;
    }

    public int sizeVermelho() {
        return this.topoVermelho + 1;
    }

    public Object topVermelho() throws PilhaVaziaExcecao {
        if (isEmptyVermelho()) {
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia.");
        }
        return this.elementos[this.topoVermelho];
    }

    public Object popVermelho() throws PilhaVaziaExcecao {
        if (isEmptyVermelho()) {
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia.");
        }
        Object elemento = this.elementos[this.topoVermelho];
        this.elementos[this.topoVermelho--] = null;

        verificarReducao();

        return elemento;
    }

    public void pushVermelho(Object o) {
        if (isFull()) {
            redimensionar(this.capacidade * 2);
        }
        this.elementos[++this.topoVermelho] = o;
    }

    public boolean isEmptyPreto() {
        return this.topoPreto == this.capacidade;
    }

    public int sizePreto() {
        return this.capacidade - this.topoPreto;
    }

    public Object topPreto() throws PilhaVaziaExcecao {
        if (isEmptyPreto()) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia.");
        }
        return this.elementos[this.topoPreto];
    }

    public Object popPreto() throws PilhaVaziaExcecao {
        if (isEmptyPreto()) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia.");
        }
        Object elemento = this.elementos[this.topoPreto];
        this.elementos[this.topoPreto++] = null;

        verificarReducao();

        return elemento;
    }

    public void pushPreto(Object o) {
        if (isFull()) {
            redimensionar(this.capacidade * 2);
        }
        this.elementos[--this.topoPreto] = o;
    }

    private boolean isFull() {
        return (this.topoVermelho + 1) == this.topoPreto;
    }

    public int size() {
        return sizeVermelho() + sizePreto();
    }

    private void verificarReducao() {
        // cond adicional ? this.capacidade > CAPACIDADE_INICIAL
        if (size() <= (this.capacidade / 3)) {
            redimensionar(this.capacidade / 2);
        }
    }

    private void redimensionar(int novaCapacidade) {
        // cria o novo array
        Object[] novoArray = new Object[novaCapacidade];

        // copia da pilha vermelha
        for (int i = 0; i <= this.topoVermelho; i++) {
            novoArray[i] = this.elementos[i];
        }
        // if (this.topoVermelho + 1 >= 0) System.arraycopy(this.elementos, 0, novoArray, 0, this.topoVermelho + 1);

        // calcula a nova posição inicial da pilha preta no novo array.
        int novoTopoPreto = novaCapacidade - sizePreto();

        // copia a pilha preta
        for (int i = 0; i < sizePreto(); i++) {
            novoArray[novoTopoPreto + i] = this.elementos[this.topoPreto + i];
        }

        // atualiza as referências da classe para o novo array e seus parâmetros.
        this.elementos = novoArray;
        this.capacidade = novaCapacidade;
        this.topoPreto = novoTopoPreto;
    }
}