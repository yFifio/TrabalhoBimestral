package br.com.clinica.modelo;

public class Paciente {

    private static int proximoId = 1;

    private int id;
    private String nome;
    private int idade;
    private String sintoma;

    public Paciente(String nome, int idade, String sintoma) {
        this.id = proximoId++;
        this.nome = nome;
        this.idade = idade;
        this.sintoma = sintoma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String exibirInfo() {
        return "ID: " + this.id + " | Nome: " + this.nome + " | Idade: " + this.idade + " | Sintoma: " + this.sintoma;
    }
}