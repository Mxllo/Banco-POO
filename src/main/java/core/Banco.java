package core;

import interfaces.BancoInterface;
import model.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;

import static service.ClientSaver.*;
import static service.ClientServices.*;
import static service.Console.*;
import static service.BancoServices.*;
import static service.Inputs.*;


public class Banco implements BancoInterface {

    public ArrayList<Cliente> clientes = new ArrayList<>();
    private int contadorNumeroConta = 1;

    @Override
    public void abrirConta() throws NullPointerException {
        String cpf;
        Cliente cliente;

        println("Deseja abrir qual tipo de conta: ");
        println("[1] - Conta Corrente \n[2] - Conta Poupança");
        int tipoDeConta = scanInteger();

        print("Digite o cpf do cliente que deseja abrir uma " +
                checkAccountType(tipoDeConta) + " (Somente numeros): ");

        cpf = scanString();

        if (checagemCliente(cpf, clientes)) {
            cliente = buscarCliente(cpf,clientes);
            println("Criando conta para: \n" + cliente);
            println("\nDeseja adicionar saldo na conta? (S/N)");
            addSaldo(tipoDeConta, contadorNumeroConta, cliente);
            contadorNumeroConta++;
        } else
            println("Cliente não encontrado");
    }

    @Override
    public void cadastrarCliente() {

        println("----- Cadastro de Cliente -----");

        String nome = getClientName();

        String cpf = getClientCpf();

        String rg = getClientRg();

        LocalDate dataNascimento = getDataNascimento();

        Integer senha = getClientPassword();

        if (checagemCliente(cpf, clientes))
            println("Cliente já cadastrado!");
        else {
            Cliente c = new Cliente(cpf, nome, rg, dataNascimento, senha);
            clientes.add(c);

            if(checagemCliente(cpf,clientes))
                println("Cliente cadastrado! \n");
            else
                println("Cliente não cadastrado! \n");
        }
    }

    @Override
    public void realizarSaque() {
        String cpf;
        Cliente cliente;
        int tipoDeConta;

        print("Digite o cpf do cliente que deseja realizar um saque (Somente numeros): ");

        cpf = scanString();

        if (checagemCliente(cpf, clientes)) {
            cliente = buscarCliente(cpf,clientes);
            println("Inicializando saque para: \n" + cliente);
            println("Deseja realizar realizar saque para qual conta? ");
            println("[1] - Conta Corrente \n[2] - Conta Poupança");

            tipoDeConta = scanInteger();

            if (!checkContaExistente(tipoDeConta, cliente))
                return;

            print("Digite a senha: ");
            int senha = scanInteger();

            println("\nDigite o valor a ser depositado: (Ex.: 10,50)");
            print("R$");
            cliente.saque(scanDouble(), tipoDeConta, senha);
        } else
            println("Cliente não encontrado");
    }

    @Override
    public void realizarDeposito() {
        String cpf;
        Cliente cliente;
        int tipoDeConta;

        print("Digite o cpf do cliente que deseja realizar um deposito (Somente numeros): ");

        cpf = scanString();

        if (checagemCliente(cpf, clientes)) {
            cliente = buscarCliente(cpf,clientes);

            println("Inicializando deposito para: \n" + cliente);
            println("Deseja realizar realizar o deposito para qual conta? ");
            println("[1] - Conta Corrente \n[2] - Conta Poupança");

            tipoDeConta = scanInteger();
            if (!checkContaExistente(tipoDeConta, cliente))
                return;

            println("\nDigite o valor a ser depositado: (Ex.: 10,50)");
            print("R$");

            cliente.deposito(scanDouble(), tipoDeConta);
        } else
            println("Cliente não encontrado");
    }

    @Override
    public void excluirCliente() {
        String cpf;

        println("----- Exclusão de cliente -----");
        print("Digite o cpf do cliente que deseja excluir (Somente numeros): ");

        cpf = scanString();

        if (checagemCliente(cpf, clientes)) {
            println(buscarCliente(cpf,clientes).toString());
            println("Deseja realmente excluir o cliente? (S/N) ");

            if (checagem("Excluindo cliente...")) {
                clientes.remove(buscarCliente(cpf,clientes));

                if (checagemCliente(cpf, clientes))
                    println("Cliente não foi removido");

                println("Cliente removido do sistema!");
            } else
                println("Cliente não foi removido");
        } else
            println("Cliente não encontrado");
    }

}