package PilhaArray;

public class testePilha {
    public static void main(String[] args) {
        // Use a interface como tipo da variável. Boa prática!
        PilhaInterface minhaPilha = new PilhaArray(); // Começa com a capacidade padrão

        System.out.println("Pilha recém-criada está vazia? " + minhaPilha.isEmpty()); // Deve ser true
        System.out.println("Tamanho inicial: " + minhaPilha.size()); // Deve ser 0

        // Testando push
        System.out.println("\nEmpilhando 3 elementos...");
        minhaPilha.push("Primeiro");
        minhaPilha.push("Segundo");
        minhaPilha.push(123); // Pode ser qualquer Object

        System.out.println("Pilha está vazia agora? " + minhaPilha.isEmpty()); // Deve ser false
        System.out.println("Tamanho atual: " + minhaPilha.size()); // Deve ser 3

        // Testando top
        try {
            System.out.println("Elemento no topo (sem remover): " + minhaPilha.top()); // Deve ser 123
            System.out.println("Tamanho após o top: " + minhaPilha.size()); // Deve continuar 3
        } catch (PilhaVaziaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Testando pop (LIFO - Last In, First Out)
        System.out.println("\nDesempilhando tudo...");
        try {
            System.out.println("Saiu: " + minhaPilha.pop()); // Deve sair 123
            System.out.println("Saiu: " + minhaPilha.pop()); // Deve sair "Segundo"
            System.out.println("Saiu: " + minhaPilha.pop()); // Deve sair "Primeiro"
        } catch (PilhaVaziaExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Pilha está vazia no final? " + minhaPilha.isEmpty()); // Deve ser true

        // Testando a exceção
        System.out.println("\nTentando dar pop em uma pilha vazia...");
        try {
            minhaPilha.pop();
        } catch (PilhaVaziaExcecao e) {
            System.out.println("SUCESSO! Capturamos a exceção esperada: " + e.getMessage());
        }
    }
}