package service;

import model.Cliente;
import model.contas.Conta;

import java.text.NumberFormat;
import java.util.InputMismatchException;

import static service.Console.*;
import static service.Inputs.*;

public class BancoServices {

    public static String checkAccountType(int tipoDeConta){
        String soutTipoDeConta;
        if (tipoDeConta < 1 || tipoDeConta > 2) {
            println("Opção digitada não encontrada!");
            return null;
        } else if (tipoDeConta == 1)
            soutTipoDeConta = "Conta Corrente";
        else
            soutTipoDeConta = "Conta Poupança";

        return soutTipoDeConta;
    }

    public static void addSaldo(int tipoDeConta, int contadorNumeroConta, Cliente cliente){
        Double saldo = 0.00;
        if (checagem("Digite o saldo a ser adicionado: ")) {
            try {
                saldo = scanDouble();
            } catch (InputMismatchException ex) {
                println("Saldo 0 adicionado para a conta");
            }
        } else
            println("Saldo 0 adicionado para a conta");

        if (tipoDeConta == 1) {
            cliente.setContaCorrente(new Conta(saldo, contadorNumeroConta));
            println("Saldo inicial da conta: " +
                    NumberFormat.getCurrencyInstance().format(cliente.getContaCorrente().getSaldo()));
        } else {
            cliente.setContaPoupanca(new Conta(saldo, contadorNumeroConta));
            println("Saldo inicial da conta: " +
                    NumberFormat.getCurrencyInstance().format(cliente.getContaPoupanca().getSaldo()));
        }
    }

    public static boolean checagem(String mensagem) {
        String validar = scanString();

        if(validar == null) {
            println("Opção Inválida, resposta N selecionada por padrão");
            return false;
        }
        else if (validar.contains("S") || validar.contains("s")) {
            println(mensagem);
            return true;
        } else return false;
    }

    public static boolean checkContaExistente(int tipoDeConta, Cliente cliente){
        if (tipoDeConta < 1 || tipoDeConta > 2) {
            println("Tipo de conta inválido");
            return false;
        } else if (tipoDeConta == 1) {
            if (cliente.getContaCorrente() == null) {
                println("Conta corrente não cadastrada para " + cliente.getNome());
                return false;
            }
        } else if (cliente.getContaPoupanca() == null) {
            println("Conta poupança não cadastrada para " + cliente.getNome());
            return false;
        }
        return true;
    }
}
