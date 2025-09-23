package PilhaRubroNegra;

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

    public int size() {
        return sizeVermelho() + sizePreto();
    }

    private boolean isFull() {
        return (this.topoVermelho + 1) == this.topoPreto;
    }

    private void verificarReducao() {
        if (this.capacidade > CAPACIDADE_INICIAL && size() <= (this.capacidade / 3)) {
            int capacidadeNova = Math.max(this.capacidade / 2,  CAPACIDADE_INICIAL);
            redimensionar(capacidadeNova);
        }
    }

    private void redimensionar(int novaCapacidade) {
        Object[] novoArray = new Object[novaCapacidade];

        /*for (int i = 0; i <= this.topoVermelho; i++) {
            novoArray[i] = this.elementos[i];
        }*/
        if (sizeVermelho() > 0) System.arraycopy(this.elementos, 0, novoArray, 0, this.topoVermelho + 1);

        int novoTopoPreto = novaCapacidade - sizePreto();

        /*for (int i = 0; i < sizePreto(); i++) {
            novoArray[novoTopoPreto + i] = this.elementos[this.topoPreto + i];
        }*/
        if (sizePreto() > 0) System.arraycopy(this.elementos, this.topoPreto, novoArray, novoTopoPreto, sizePreto());

        this.elementos = novoArray;
        this.capacidade = novaCapacidade;
        this.topoPreto = novoTopoPreto;
    }
}