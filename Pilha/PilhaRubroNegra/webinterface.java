package PilhaRubroNegra;
import java.util.Scanner;

public class webinterface {

    public static void main(String[] args) {
        PilhaRNInterface pilha = new PilhaRN();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            System.out.print("escolha uma opção: ");
            String comando = scanner.nextLine().toLowerCase();

            try {
                switch (comando) {
                    case "pv":
                        System.out.print("digite o valor para a pilha vermelha: ");
                        String valorV = scanner.nextLine();
                        pilha.pushVermelho(valorV);
                        System.out.println("'" + valorV + "' inserido na pilha vermelha.");
                        break;
                    case "pp":
                        System.out.print("digite o valor para a pilha preta: ");
                        String valorP = scanner.nextLine();
                        pilha.pushPreto(valorP);
                        System.out.println("'" + valorP + "' inserido na pilha preta.");
                        break;
                    case "popv":
                        Object removidoV = pilha.popVermelho();
                        System.out.println("elemento removido da vermelha: " + removidoV);
                        break;
                    case "popp":
                        Object removidoP = pilha.popPreto();
                        System.out.println("elemento removido da preta: " + removidoP);
                        break;
                    case "topv":
                        System.out.println("topo da vermelha: " + pilha.topVermelho());
                        break;
                    case "topp":
                        System.out.println("topo da preta: " + pilha.topPreto());
                        break;
                    case "status":
                        exibirStatus(pilha);
                        break;
                    case "sair":
                        System.out.println("encerrando o programa...até logo");
                        scanner.close();
                        return;
                    default:
                        System.out.println("comando inválido! tente novamente.");
                        break;
                }
            } catch (PilhaVaziaExcecao e) {
                System.out.println("oops!... " + e.getMessage());
            } catch (Exception e) {
                System.out.println("oops!...algo de inesperado aconteceu: " + e.getMessage());
            }
            System.out.println("----------------------------------------");
        }
    }

    private static void exibirMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("comandos da pilha vermelha:");
        System.out.println("  pv   - Push (inserir) na vermelha");
        System.out.println("  popv - Pop (remover) da vermelha");
        System.out.println("  topv - Top (consultar topo) da vermelha");
        System.out.println("\ncomandos da pilha preta:");
        System.out.println("  pp   - push (inserir) na preta");
        System.out.println("  popp - pop (remover) da preta");
        System.out.println("  topp - top (consultar topo) da preta");
        System.out.println("\noutros comandos:");
        System.out.println("  status - ver o estado atual das pilhas");
        System.out.println("  sair   - encerrar o programa");
    }

    private static void exibirStatus(PilhaRNInterface pilha) {
        System.out.println("\n--- STATUS ATUAL ---");
        System.out.println("pilha vermelha:");
        System.out.println("  vazia: " + pilha.isEmptyVermelho());
        System.out.println("  tamanho: " + pilha.sizeVermelho());
        if (!pilha.isEmptyVermelho()) {
            System.out.println("  topo: " + pilha.topVermelho());
        }

        System.out.println("\npilha preta:");
        System.out.println("  vazia: " + pilha.isEmptyPreto());
        System.out.println("  tamanho: " + pilha.sizePreto());
        if (!pilha.isEmptyPreto()) {
            System.out.println("  topo: " + pilha.topPreto());
        }

        System.out.println("  Tamanho total: " + pilha.size());
    }
}