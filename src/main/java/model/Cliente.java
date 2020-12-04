package model;

import lombok.*;
import model.contas.Conta;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Cliente {

    private String nome, rg, cpf;
    private LocalDate dataNascimento;
    private Integer senha;
    private Conta contaCorrente, contaPoupanca;

    public Cliente(String cpf, String nome, String rg, LocalDate dataNascimento, Integer senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public void saque(Double valorSaque, int conta, int senha){
        Conta c;
        if(this.senha != senha){
            System.out.println("Senha inválida!");
            return;
        }

        if(conta<1 || conta>2) {
            System.out.println("Erro ao realizar o saque");
            return;
        }
        else if(conta == 1)
            c = contaCorrente;
        else
            c = contaPoupanca;

        if(c.getSaldo()<valorSaque){
            System.out.println("** Você não possui saldo suficiente para realizar esse saque **");
        }
        else{
            System.out.println("Sacando R$"+ valorSaque);
            c.setSaldo(c.getSaldo()-valorSaque);
            System.out.println("Saque realizado...\n Novo saldo: "+
                    NumberFormat.getCurrencyInstance().format(c.getSaldo()));
        }
    }

    public void deposito(Double valorDeposito, int conta){
        Conta c;

        if(conta<1 || conta>2) {
            System.out.println("Erro ao realizar o deposito");
            return;
        }
        else if(conta == 1)
            c = contaCorrente;
        else
            c = contaPoupanca;

        System.out.println("Realizando depósito");
        c.setSaldo(c.getSaldo()+valorDeposito);
        System.out.println("Novo saldo: "+ NumberFormat.getCurrencyInstance().format(c.getSaldo()));

    }

    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return "\nCliente: { Nome: "+nome+" | CPF: "+cpf+" | RG: "+rg + "| Data de Nascimento: "+
                dataNascimento.format(formatador)+" }";
    }
}
