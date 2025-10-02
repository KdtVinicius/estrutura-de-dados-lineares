package PilhaRubroNegra;

public class PilhaRNTeste {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO TESTES DA PILHA RUBRO-NEGRA ---");

        PilhaRNInterface pilha = new PilhaRN();

        // --- CENÁRIO 1: Testes básicos de estado inicial e pilhas individuais ---
        System.out.println("\nCENÁRIO 1: Testes de Estado Inicial e Pilhas Individuais");
        System.out.println("isEmptyVermelho() (esperado: true): " + pilha.isEmptyVermelho());
        System.out.println("isEmptyPreto() (esperado: true): " + pilha.isEmptyPreto());
        System.out.println("Size total (esperado: 0): " + pilha.size());

        // Testando a pilha vermelha isoladamente
        pilha.pushVermelho("V1");
        pilha.pushVermelho("V2");
        System.out.println("\nApós 2 pushs na vermelha:");
        System.out.println("Size Vermelho (esperado: 2): " + pilha.sizeVermelho());
        System.out.println("Top Vermelho (esperado: V2): " + pilha.topVermelho());
        System.out.println("Saiu da Vermelha (esperado: V2): " + pilha.popVermelho());
        System.out.println("Size Vermelho (esperado: 1): " + pilha.sizeVermelho());
        pilha.popVermelho(); // Esvazia

        // Testando a pilha preta isoladamente
        pilha.pushPreto("P1");
        pilha.pushPreto("P2");
        System.out.println("\nApós 2 pushs na preta:");
        System.out.println("Size Preto (esperado: 2): " + pilha.sizePreto());
        System.out.println("Top Preto (esperado: P2): " + pilha.topPreto());
        System.out.println("Saiu da Preta (esperado: P2): " + pilha.popPreto());
        System.out.println("Size Preto (esperado: 1): " + pilha.sizePreto());
        pilha.popPreto(); // Esvazia
        System.out.println("Size total (esperado: 0): " + pilha.size());

        // --- CENÁRIO 2: Teste de Crescimento (Duplicação do Array) ---
        System.out.println("\nCENÁRIO 2: Teste de Crescimento (de 10 para 20)");
        pilha = new PilhaRN(); // Reinicia a pilha

        // Enchemos o array de capacidade 10
        for (int i = 1; i <= 6; i++) {
            pilha.pushVermelho("V" + i);
        }
        for (int i = 1; i <= 4; i++) {
            pilha.pushPreto("P" + i);
        }
        System.out.println("Pilha cheia. Size (esperado: 10): " + pilha.size());
        System.out.println("Top Vermelho (esperado: V6): " + pilha.topVermelho());
        System.out.println("Top Preto (esperado: P4): " + pilha.topPreto());

        // O próximo push (não importa a cor) deve disparar o redimensionamento
        System.out.println("\nEmpilhando o 11º elemento");
        pilha.pushPreto("P5"); // Dispara o "--- Redimensionando de 10 para 20 ---"

        System.out.println("Após redimensionar:");
        System.out.println("Size total (esperado: 11): " + pilha.size());
        System.out.println("Size Vermelho (esperado: 6): " + pilha.sizeVermelho());
        System.out.println("Size Preto (esperado: 5): " + pilha.sizePreto());
        System.out.println("Top Vermelho (esperado: V6): " + pilha.topVermelho());
        System.out.println("Top Preto (esperado: P5): " + pilha.topPreto());

        // --- CENÁRIO 3: Teste de Redução (Metade do Array) ---
        System.out.println("\nCENÁRIO 3: Teste de Redução (de 20 para 10)");
        System.out.println("Removendo elementos... A redução deve ocorrer quando o tamanho for <= 6 (20/3).");

        // Atualmente, size = 11. Vamos remover 5 elementos.
        pilha.popPreto(); // size = 10
        pilha.popPreto(); // size = 9
        pilha.popVermelho(); // size = 8
        pilha.popVermelho(); // size = 7
        pilha.popVermelho(); // size = 6. O pop DISPARA a verificação, que redimensiona.

        System.out.println("\nApós a redução:");
        System.out.println("Size total (esperado: 6): " + pilha.size());
        System.out.println("Size Vermelho (esperado: 3): " + pilha.sizeVermelho());
        System.out.println("Size Preto (esperado: 3): " + pilha.sizePreto());
        System.out.println("Top Vermelho (esperado: V3): " + pilha.topVermelho());
        System.out.println("Top Preto (esperado: P2): " + pilha.topPreto());


        // --- CENÁRIO 4: Teste de Exceções ---
        System.out.println("\nCENÁRIO 4: Teste de Exceções");
        pilha = new PilhaRN(); // Reinicia a pilha

        try {
            pilha.popVermelho();
        } catch (PilhaVaziaExcecao e) {
            System.out.println("SUCESSO! Exceção da pilha vermelha vazia capturada: " + e.getMessage());
        }

        try {
            pilha.popPreto();
        } catch (PilhaVaziaExcecao e) {
            System.out.println("SUCESSO! Exceção da pilha preta vazia capturada: " + e.getMessage());
        }
    }
}