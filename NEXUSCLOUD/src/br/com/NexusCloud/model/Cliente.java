package br.com.NexusCloud.model;

import java.util.Objects;

// Classe POJO que representa o cliente da NexusCloud. RA: 000000
public class Cliente {

    // CPF: é o dado lógico que define a identidade do cliente. RA: 000000
    private String cpf;

    // Nome (razão social) do cliente. RA: 000000
    private String nome;

    // Construtor que recebe todos os atributos. RA: 000000
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Getter do CPF. RA: 000000
    public String getCpf() {
        return cpf;
    }

    // Setter do CPF. RA: 000000
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Getter do nome. RA: 000000
    public String getNome() {
        return nome;
    }

    // Setter do nome. RA: 000000
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Dois clientes são iguais se tiverem o mesmo CPF (e não o mesmo endereço de memória). RA: 000000
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                       // mesma referência => iguais. RA: 000000
        if (o == null || getClass() != o.getClass()) return false; // null ou tipo diferente => diferentes. RA: 000000
        Cliente outro = (Cliente) o;                      // cast seguro após a checagem de tipo. RA: 000000
        return Objects.equals(cpf, outro.cpf);            // compara apenas o CPF. RA: 000000
    }

    // hashCode precisa ser coerente com equals: usa somente o CPF. RA: 000000
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    // toString facilita a leitura em logs e prints. RA: 000000
    @Override
    public String toString() {
        return "Cliente{cpf='" + cpf + "', nome='" + nome + "'}";
    }
}
