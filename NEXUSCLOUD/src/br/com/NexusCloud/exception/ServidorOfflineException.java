package br.com.NexusCloud.exception;

// Exceção UNCHECKED: estende RuntimeException, então o compilador não obriga try-catch nem throws. RA: 000000
public class ServidorOfflineException extends RuntimeException {

    // Repassa a mensagem de erro para a classe pai. RA: 000000
    public ServidorOfflineException(String mensagem) {
        super(mensagem);
    }
}
