public class DequeTeste {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("--- TESTES DE DEMONSTRAÇÃO DO DEQUE (CONSOLE) ---");
        System.out.println("=================================================");

        // Executa a demonstração para a Lista Simplesmente Encadeada
        executarDemonstracao(new DequeSimplesmenteEncadeado(), "LISTA SIMPLESMENTE ENCANDEADA (O(N) no removerFim)");

        System.out.println("\n-------------------------------------------------");

        // Executa a demonstração para a Lista Duplamente Encadeada
        executarDemonstracao(new DequeDuplamenteEncadeado(), "LISTA DUPLAMENTE ENCANDEADA (Tudo O(1))");
    }

    /**
     * Executa um conjunto padronizado de testes para qualquer implementação de Deque.
     */
    private static void executarDemonstracao(DequeInterface deque, String titulo) {
        System.out.println("\n*** INICIANDO TESTES: " + titulo + " ***");

        try {
            // --- CENÁRIO 1: Testes básicos de estado inicial e inserção ---
            System.out.println("\n--- CENÁRIO 1: Estado Inicial e Inserções ---");
            System.out.println("Está vazia? (esperado: true): " + deque.estaVazia());
            System.out.println("Tamanho (esperado: 0): " + deque.tamanho());

            // 1. Inserir no Início
            deque.inserirInicio("Elemento A"); // [A]
            deque.inserirInicio("Elemento B"); // [B, A]
            System.out.println("Após inserir B, A (Inicio): Tamanho = " + deque.tamanho() + " | Primeiro = " + deque.primeiro());

            // 2. Inserir no Fim
            deque.inserirFim("Elemento C"); // [B, A, C]
            deque.inserirFim("Elemento D"); // [B, A, C, D]
            System.out.println("Após inserir C, D (Fim): Tamanho = " + deque.tamanho() + " | Último = " + deque.ultimo());


            // --- CENÁRIO 2: Testes de Remoção Mista ---
            System.out.println("\n--- CENÁRIO 2: Remoção Mista ---");

            // 3. Remover do Início
            Object remInicio = deque.removerInicio(); // Remove B -> [A, C, D]
            System.out.println("Removido do Início (esperado: B): " + remInicio);
            System.out.println("Novo Primeiro (esperado: A): " + deque.primeiro());

            // 4. Remover do Fim (Operação O(N) na lista simples!)
            Object remFim = deque.removerFim(); // Remove D -> [A, C]
            System.out.println("Removido do Fim (esperado: D): " + remFim);
            System.out.println("Novo Último (esperado: C): " + deque.ultimo());

            // 5. Novo conjunto de Inserção e Remoção
            deque.inserirInicio("X"); // [X, A, C]
            deque.inserirFim("Y");    // [X, A, C, Y]

            System.out.println("\nEstado Final (esperado: 4): " + deque.tamanho());
            System.out.println("Primeiro: " + deque.primeiro() + " | Último: " + deque.ultimo());


            // --- CENÁRIO 3: Esvaziamento e Exceção ---
            System.out.println("\n--- CENÁRIO 3: Esvaziamento ---");

            // Esvazia a fila
            System.out.println("Esvaziando o Deque:");
            while (!deque.estaVazia()) {
                Object p = deque.primeiro();
                Object u = deque.ultimo();
                // Alterna entre remover de um lado e do outro
                if (deque.tamanho() % 2 != 0) {
                    System.out.println(" -> Removido FIM: " + deque.removerFim() + " (Restam: " + deque.tamanho() + ")");
                } else {
                    System.out.println(" -> Removido INÍCIO: " + deque.removerInicio() + " (Restam: " + deque.tamanho() + ")");
                }
            }

            System.out.println("Após esvaziar, está vazia? (esperado: true): " + deque.estaVazia());

            // 6. Teste de Exceção
            System.out.println("\n--- CENÁRIO 4: Teste de Exceção ---");
            try {
                deque.removerInicio();
            } catch (DequeVazioException e) {
                System.out.println("SUCESSO! Exceção de remoção em Deque vazio capturada: " + e.getMessage());
            }

        } catch (DequeVazioException e) {
            System.err.println("ERRO INESPERADO: O teste falhou devido a uma exceção não esperada: " + e.getMessage());
        }
    }
}