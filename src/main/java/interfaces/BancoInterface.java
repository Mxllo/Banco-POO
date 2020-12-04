package interfaces;

import model.Cliente;

import java.time.LocalDate;
import java.util.InputMismatchException;

public interface BancoInterface {

    void abrirConta() throws InputMismatchException;

    void cadastrarCliente();

    void realizarSaque();

    void realizarDeposito();

    void excluirCliente();

}
