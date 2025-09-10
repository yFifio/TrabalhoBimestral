
package br.com.clinica.estruturas;

import br.com.clinica.modelo.Paciente;
import java.util.LinkedList;

public class FilaDeAtendimento {

    private LinkedList<Paciente> fila;

    public FilaDeAtendimento() {
        this.fila = new LinkedList<>();
    }

    public void adicionarPaciente(Paciente p) {
        fila.add(p);
    }

    public Paciente atenderPaciente() {
        return fila.poll();
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public void mostrarFila() {
        System.out.println("\n--- Fila de Atendimento Atual ---");
        if (estaVazia()) {
            System.out.println("A fila está vazia.");
        } else {
            for (Paciente paciente : fila) {
                System.out.println(paciente.exibirInfo());
            }
        }
        System.out.println("---------------------------------");
    }
}