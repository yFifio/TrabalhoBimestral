
package br.com.clinica.app;

import br.com.clinica.estruturas.FilaDeAtendimento;
import br.com.clinica.estruturas.PilhaHistoricoAtendimentos;
import br.com.clinica.modelo.Paciente;
import java.util.Scanner;

public class GerenciadorClinica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaDeAtendimento fila = new FilaDeAtendimento();
        PilhaHistoricoAtendimentos historico = new PilhaHistoricoAtendimentos();
        boolean executando = true;

        System.out.println("Bem-vindo ao Sistema de Gerenciamento da Clínica!");

        while (executando) {
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            int opcao = lerOpcaoValida(scanner);

            if (opcao == 1) {
                adicionarNovoPaciente(scanner, fila);
            } else if (opcao == 2) {
                atenderProximoPaciente(fila, historico);
            } else if (opcao == 3) {
                fila.mostrarFila();
            } else if (opcao == 4) {
                historico.mostrarHistorico();
            } else if (opcao == 5) {
                executando = false;
                System.out.println("\nSaindo do sistema. Até logo!");
            } else {
                System.out.println("\n[ERRO] Opção inválida. Por favor, escolha um número entre 1 e 5.");
            }
        }

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n===================================================");
        System.out.println("1. Adicionar novo paciente à fila");
        System.out.println("2. Atender próximo paciente");
        System.out.println("3. Exibir fila de atendimento");
        System.out.println("4. Exibir histórico de atendimentos");
        System.out.println("5. Sair");
        System.out.println("===================================================");
    }

    private static int lerOpcaoValida(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("\n[ERRO] Entrada inválida. Por favor, digite um número inteiro.");
            System.out.print("Escolha uma opção: ");
            scanner.next();
        }
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    private static void adicionarNovoPaciente(Scanner scanner, FilaDeAtendimento fila) {
        System.out.println("\n--- Adicionar Novo Paciente ---");
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Idade do paciente: ");
        int idade = lerOpcaoValida(scanner);

        System.out.print("Sintoma do paciente: ");
        String sintoma = scanner.nextLine();

        Paciente novoPaciente = new Paciente(nome, idade, sintoma);
        fila.adicionarPaciente(novoPaciente);

        System.out.println("\nPaciente '" + nome + "' adicionado à fila com sucesso!");
    }

    private static void atenderProximoPaciente(FilaDeAtendimento fila, PilhaHistoricoAtendimentos historico) {
        if (fila.estaVazia()) {
            System.out.println("\nNão há pacientes na fila para atender.");
        } else {
            Paciente pacienteAtendido = fila.atenderPaciente();
            historico.adicionarAoHistorico(pacienteAtendido);
            System.out.println("\n--- Atendimento Realizado ---");
            System.out.println("Paciente atendido: " + pacienteAtendido.exibirInfo());
            System.out.println("-----------------------------");
        }
    }
}