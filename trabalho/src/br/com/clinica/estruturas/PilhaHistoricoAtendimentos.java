
package br.com.clinica.estruturas;

import br.com.clinica.modelo.Paciente;
import java.util.Stack;

public class PilhaHistoricoAtendimentos {

    private Stack<Paciente> historico;

    public PilhaHistoricoAtendimentos() {
        this.historico = new Stack<>();
    }

    public void adicionarAoHistorico(Paciente p) {
        historico.push(p);
    }

    public Paciente verUltimoAtendido() {
        if (historico.isEmpty()) {
            return null;
        }
        return historico.peek();
    }

    public void mostrarHistorico() {
        System.out.println("\n--- Histórico de Atendimentos (do mais recente ao mais antigo) ---");
        if (historico.isEmpty()) {
            System.out.println("Nenhum paciente foi atendido ainda.");
        } else {
            for (int i = historico.size() - 1; i >= 0; i--) {
                Paciente paciente = historico.get(i);
                System.out.println(paciente.exibirInfo());
            }
        }
        System.out.println("-----------------------------------------------------------------");
    }
}