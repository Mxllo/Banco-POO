package service;

import lombok.NonNull;
import model.Cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClientServices {

    private static boolean checkDataNascimento;

    public static LocalDate formatarData(String data) {
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate localDate = LocalDate.parse(data, formatador);
            setValidDataNascimento(false);
            return localDate;
        } catch (Exception ex) {
            System.out.println("Data de Nascimento inválida");
        }
        return null;
    }

    public static boolean checagemCliente(String cpfValidar,@NonNull ArrayList<Cliente> clientes) {
        List<String> cpf = new ArrayList<>();

        for (Cliente cliente : clientes)
            cpf.add(cliente.getCpf());

        return cpf.contains(cpfValidar);
    }

    public static Cliente buscarCliente(String cpfBusca,@NonNull ArrayList<Cliente> clientes) {
        List<String> cpf = new ArrayList<>();

        for (Cliente cliente : clientes)
            cpf.add(cliente.getCpf());

        return clientes.get(cpf.indexOf(cpfBusca));
    }

    public static boolean isValidDataNascimento() {
        return checkDataNascimento;
    }

    public static void setValidDataNascimento(boolean checkDataNascimento) {
        ClientServices.checkDataNascimento = checkDataNascimento;
    }
}

