package br.com.NexusCloud.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.NexusCloud.exception.CapacidadeExcedidaException;
import br.com.NexusCloud.exception.ServidorOfflineException;

// Classe que representa um servidor virtual da NexusCloud. RA: 000000
public class Servidor {

    // IP: dado lógico que define a identidade do servidor. RA: 000000
    private String ip;

    // Capacidade total de RAM (GB). RA: 000000
    private double ramTotal;

    // Preço cobrado por hora de uso. RA: 000000
    private double precoPorHora;

    // Status do servidor: false = desligado (estado inicial). RA: 000000
    private boolean statusLigado;

    // Lista cronológica de containers; inicializada na declaração para evitar NullPointerException. RA: 000000
    private List<Container> containers = new ArrayList<>();

    // Construtor: o servidor "nasce" desligado (statusLigado = false). RA: 000000
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip;
        this.ramTotal = ramTotal;
        this.precoPorHora = precoPorHora;
        this.statusLigado = false;
    }

    // Liga o servidor. RA: 000000
    public void ligar() {
        this.statusLigado = true;
    }

    // Desliga o servidor. RA: 000000
    public void desligar() {
        this.statusLigado = false;
    }

    // Aloca um container aplicando a política Fail-Fast (valida tudo antes de adicionar). RA: 000000
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {
        // Regra 1 (unchecked): servidor desligado não aceita containers. RA: 000000
        if (!statusLigado) {
            throw new ServidorOfflineException("Erro: Não é possível alocar containers em um servidor desligado.");
        }
        // Regra 2 (checked): RAM em uso + RAM do novo container não pode passar da RAM total. RA: 000000
        if (calcularRamEmUso() + c.getRamNecessaria() > ramTotal) {
            throw new CapacidadeExcedidaException("Falha Crítica: Memória RAM insuficiente no servidor " + ip + ".");
        }
        // Passou nas duas validações: adiciona na lista interna. RA: 000000
        containers.add(c);
    }

    // Soma a RAM de todos os containers usando Streams (sem for/while). RA: 000000
    public double calcularRamEmUso() {
        return containers.stream()                    // transforma a lista em um fluxo. RA: 000000
                .mapToDouble(Container::getRamNecessaria) // extrai a RAM de cada container como double. RA: 000000
                .sum();                               // soma tudo (0.0 se a lista estiver vazia). RA: 000000
    }

    // Getter do IP. RA: 000000
    public String getIp() {
        return ip;
    }

    // Setter do IP. RA: 000000
    public void setIp(String ip) {
        this.ip = ip;
    }

    // Getter da RAM total. RA: 000000
    public double getRamTotal() {
        return ramTotal;
    }

    // Setter da RAM total. RA: 000000
    public void setRamTotal(double ramTotal) {
        this.ramTotal = ramTotal;
    }

    // Getter do preço por hora. RA: 000000
    public double getPrecoPorHora() {
        return precoPorHora;
    }

    // Setter do preço por hora. RA: 000000
    public void setPrecoPorHora(double precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    // Getter do status (padrão "is" para boolean). RA: 000000
    public boolean isStatusLigado() {
        return statusLigado;
    }

    // Setter do status. RA: 000000
    public void setStatusLigado(boolean statusLigado) {
        this.statusLigado = statusLigado;
    }

    // Getter da lista de containers. RA: 000000
    public List<Container> getContainers() {
        return containers;
    }

    // Dois servidores são iguais se tiverem o mesmo IP. RA: 000000
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                       // mesma referência. RA: 000000
        if (o == null || getClass() != o.getClass()) return false; // null ou outro tipo. RA: 000000
        Servidor outro = (Servidor) o;                    // cast após validação. RA: 000000
        return Objects.equals(ip, outro.ip);              // compara só o IP. RA: 000000
    }

    // hashCode coerente com equals: baseado apenas no IP. RA: 000000
    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }

    // Representação textual do servidor. RA: 000000
    @Override
    public String toString() {
        return "Servidor{ip='" + ip + "', ramTotal=" + ramTotal + ", ligado=" + statusLigado + "}";
    }
}
