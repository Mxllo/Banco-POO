package service;

import java.time.LocalDate;

import static service.ClientServices.*;

public class ClientSaver {

    public static String getClientName(){
        String nome;
        do {
            Console.print("Informe o nome do cliente: ");
            nome = Inputs.scanString();
            if (nome.equals(""))
                Console.println("Digite um Nome para o Cliente");
        } while (nome.equals(""));
        return nome;
    }

    public static String getClientCpf(){
        String cpf;
        do {
            Console.print("Informe o CPF do cliente (Somente numeros): ");
            cpf = Inputs.scanString();
            if (!ValidaCPF.isValidCPF(cpf))
                Console.println("CPF Inválido");
        } while (!ValidaCPF.isValidCPF(cpf));
        return cpf;
    }

    public static LocalDate getDataNascimento(){
        LocalDate dataNascimento;
        setValidDataNascimento(true);
        do {
            Console.print("Informe a data de nascimento do Cliente (DD/MM/AAAA): ");
            String nascimentoString = Inputs.scanString();
            dataNascimento = formatarData(nascimentoString);
        } while (isValidDataNascimento());
        return dataNascimento;
    }

    public static String getClientRg(){
        Console.print("Informe o Rg do cliente (Opcional): ");
        return Inputs.scanString();
    }

    public static Integer getClientPassword(){
        int senha;
        do {
            Console.print("Informe a senha do cliente (Somente Numeros - De 4 a 8 digitos): ");
            senha = Inputs.scanInteger();
            if (senha <= 999)
                Console.println("Digite uma senha válida!");

        } while (senha <= 999);
        return senha;
    }
}
