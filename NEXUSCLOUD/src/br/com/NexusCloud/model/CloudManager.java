package br.com.NexusCloud.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// "Banco de dados" principal: associa cada Cliente ao conjunto de Servidores dele. RA: 000000
public class CloudManager {

    // Map baseado em Hash (HashMap): chave = Cliente, valor = Set de Servidores sem duplicatas e sem ordem. RA: 000000
    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // Registra um cliente com um conjunto vazio de servidores (não sobrescreve se já existir). RA: 000000
    public void registrarCliente(Cliente c) {
        bancoDeDados.putIfAbsent(c, new HashSet<>());
    }

    // Adiciona um servidor ao cliente; registra o cliente antes, se necessário. RA: 000000
    public void adicionarServidor(Cliente c, Servidor s) {
        bancoDeDados.computeIfAbsent(c, k -> new HashSet<>()).add(s);
    }

    // Soma o preço/hora dos servidores LIGADOS do cliente, usando Streams. RA: 000000
    public double calcularFaturaAtiva(Cliente c) {
        return bancoDeDados.getOrDefault(c, new HashSet<>()) // conjunto do cliente (vazio se não existir). RA: 000000
                .stream()                                   // abre o fluxo de servidores. RA: 000000
                .filter(Servidor::isStatusLigado)           // deixa passar APENAS servidores ligados. RA: 000000
                .mapToDouble(Servidor::getPrecoPorHora)     // extrai o preço por hora. RA: 000000
                .sum();                                     // soma o total. RA: 000000
    }

    // Getter do banco de dados. RA: 000000
    public Map<Cliente, Set<Servidor>> getBancoDeDados() {
        return bancoDeDados;
    }
}
