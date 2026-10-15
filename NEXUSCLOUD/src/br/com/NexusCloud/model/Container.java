package br.com.NexusCloud.model;

import java.util.Objects;

// Classe POJO que representa uma aplicação (container) rodando em um servidor. RA: 000000
public class Container {

    // ID: dado lógico que define a identidade do container. RA: 000000
    private String id;

    // Quantidade de RAM (GB) que o container precisa para rodar. RA: 000000
    private double ramNecessaria;

    // Construtor com todos os atributos. RA: 000000
    public Container(String id, double ramNecessaria) {
        this.id = id;
        this.ramNecessaria = ramNecessaria;
    }

    // Getter do ID. RA: 000000
    public String getId() {
        return id;
    }

    // Setter do ID. RA: 000000
    public void setId(String id) {
        this.id = id;
    }

    // Getter da RAM necessária. RA: 000000
    public double getRamNecessaria() {
        return ramNecessaria;
    }

    // Setter da RAM necessária. RA: 000000
    public void setRamNecessaria(double ramNecessaria) {
        this.ramNecessaria = ramNecessaria;
    }

    // Dois containers são iguais se tiverem o mesmo ID. RA: 000000
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                       // mesma referência. RA: 000000
        if (o == null || getClass() != o.getClass()) return false; // tipo diferente ou null. RA: 000000
        Container outro = (Container) o;                  // cast após validação. RA: 000000
        return Objects.equals(id, outro.id);              // compara só o ID. RA: 000000
    }

    // hashCode coerente com equals: baseado apenas no ID. RA: 000000
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Representação textual do container. RA: 000000
    @Override
    public String toString() {
        return "Container{id='" + id + "', ramNecessaria=" + ramNecessaria + "}";
    }
}
