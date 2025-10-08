package PilhaRubroNegra;

public class PilhaRNTeste {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO TESTES DA PILHA RUBRO-NEGRA ---");

        PilhaRNInterface pilha = new PilhaRN();

        // estado inicial
        System.out.println("\nCENÁRIO 1: Testes de Estado Inicial e Pilhas Individuais");
        System.out.println("isEmptyVermelho() (esperado: true): " + pilha.isEmptyVermelho());
        System.out.println("isEmptyPreto() (esperado: true): " + pilha.isEmptyPreto());
        System.out.println("Size total (esperado: 0): " + pilha.size());

        // pilha vermelha
        pilha.pushVermelho("V1");
        pilha.pushVermelho("V2");
        System.out.println("\nApós 2 pushs na vermelha:");
        System.out.println("Size Vermelho (esperado: 2): " + pilha.sizeVermelho());
        System.out.println("Top Vermelho (esperado: V2): " + pilha.topVermelho());
        System.out.println("Saiu da Vermelha (esperado: V2): " + pilha.popVermelho());
        System.out.println("Size Vermelho (esperado: 1): " + pilha.sizeVermelho());
        pilha.popVermelho();

        // pilha preta
        pilha.pushPreto("P1");
        pilha.pushPreto("P2");
        System.out.println("\nApós 2 pushs na preta:");
        System.out.println("Size Preto (esperado: 2): " + pilha.sizePreto());
        System.out.println("Top Preto (esperado: P2): " + pilha.topPreto());
        System.out.println("Saiu da Preta (esperado: P2): " + pilha.popPreto());
        System.out.println("Size Preto (esperado: 1): " + pilha.sizePreto());
        pilha.popPreto();
        System.out.println("Size total (esperado: 0): " + pilha.size());

        // duplicação do array
        System.out.println("\nCENÁRIO 2: Teste de Crescimento (de 10 para 20)");
        pilha = new PilhaRN();

        for (int i = 1; i <= 6; i++) {
            pilha.pushVermelho("V" + i);
        }
        for (int i = 1; i <= 4; i++) {
            pilha.pushPreto("P" + i);
        }

        System.out.println("Pilha cheia. Size (esperado: 10): " + pilha.size());
        System.out.println("Top Vermelho (esperado: V6): " + pilha.topVermelho());
        System.out.println("Top Preto (esperado: P4): " + pilha.topPreto());

        System.out.println("\nEmpilhando o 11º elemento");
        pilha.pushPreto("P5");

        System.out.println("Após redimensionar:");
        System.out.println("Size total (esperado: 11): " + pilha.size());
        System.out.println("Size Vermelho (esperado: 6): " + pilha.sizeVermelho());
        System.out.println("Size Preto (esperado: 5): " + pilha.sizePreto());
        System.out.println("Top Vermelho (esperado: V6): " + pilha.topVermelho());
        System.out.println("Top Preto (esperado: P5): " + pilha.topPreto());

        // teste de redução
        System.out.println("\nCENÁRIO 3: Teste de Redução (de 20 para 10)");
        System.out.println("Removendo elementos... A redução deve ocorrer quando o tamanho for <= 6 (20/3).");

        pilha.popPreto();
        pilha.popPreto();
        pilha.popVermelho();
        pilha.popVermelho();
        pilha.popVermelho();

        System.out.println("\nApós a redução:");
        System.out.println("Size total (esperado: 6): " + pilha.size());
        System.out.println("Size Vermelho (esperado: 3): " + pilha.sizeVermelho());
        System.out.println("Size Preto (esperado: 3): " + pilha.sizePreto());
        System.out.println("Top Vermelho (esperado: V3): " + pilha.topVermelho());
        System.out.println("Top Preto (esperado: P2): " + pilha.topPreto());


        // teste de exceções
        System.out.println("\nCENÁRIO 4: Teste de Exceções");
        pilha = new PilhaRN();

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