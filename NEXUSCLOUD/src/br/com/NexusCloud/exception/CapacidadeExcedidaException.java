package br.com.NexusCloud.exception;

// Exceção CHECKED: estende Exception, então o compilador obriga tratar (try-catch) ou declarar (throws). RA: 000000
public class CapacidadeExcedidaException extends Exception {

    // Repassa a mensagem de erro para a classe pai. RA: 000000
    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem);
    }
}
