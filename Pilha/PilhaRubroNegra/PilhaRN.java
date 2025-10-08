package PilhaRubroNegra;

public class PilhaRN implements PilhaRNInterface {

    private Object[] elementos;
    private int topoVermelho;
    private int topoPreto;
    private int capacidade;
    private static final int capacidade_pilha = 10;

    public PilhaRN() {
        this.capacidade = capacidade_pilha;
        this.elementos = new Object[capacidade_pilha];
        this.topoPreto = capacidade_pilha;
        this.topoVermelho = -1;
    }

    public boolean vazioVermelho() {
        return this.topoVermelho == -1;
    }

    public int sizeVermelho() {
        return this.topoVermelho + 1;
    }

    public Object topVermelho() throws PilhaVaziaExcecao {
        if (vazioVermelho()) {
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia.");
        }
        return this.elementos[this.topoVermelho];
    }

    public Object popVermelho() throws PilhaVaziaExcecao {
        if (vazioVermelho()) {
            throw new PilhaVaziaExcecao("A pilha vermelha está vazia.");
        }
        Object elemento = this.elementos[this.topoVermelho];
        this.elementos[this.topoVermelho--] = null;

        if (this.capacidade > capacidade_pilha && (sizeVermelho() + sizePreto()) <= (this.capacidade / 3)) { // reduz
            int capacidadeNova = Math.max(this.capacidade / 2,  capacidade_pilha);
            redimensionar(capacidadeNova);
        }

        return elemento;
    }

    public void pushVermelho(Object o) {
        if (isFull()) {
            redimensionar(this.capacidade * 2);
        }
        this.elementos[++this.topoVermelho] = o;
    }

    public boolean vazioPreto() {
        return this.topoPreto == this.capacidade;
    }

    public int sizePreto() {
        return this.capacidade - this.topoPreto;
    }

    public Object topPreto() throws PilhaVaziaExcecao {
        if (vazioPreto()) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia.");
        }
        return this.elementos[this.topoPreto];
    }

    public Object popPreto() throws PilhaVaziaExcecao {
        if (vazioPreto()) {
            throw new PilhaVaziaExcecao("A pilha preta está vazia.");
        }
        
        Object elemento = this.elementos[this.topoPreto];
        this.elementos[this.topoPreto++] = null;

        if (this.capacidade > capacidade_pilha && (sizeVermelho() + sizePreto()) <= (this.capacidade / 3)) { // reduz
            int capacidadeNova = Math.max(this.capacidade / 2,  capacidade_pilha);
            redimensionar(capacidadeNova);
        }

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