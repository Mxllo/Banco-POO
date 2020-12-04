package core;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Banco banco = new Banco();
    boolean loopPrincipal = true, menuBancoAtivo = true;

    public void menu(){

    Integer opcao = null;
    Scanner s;

       while (loopPrincipal) {
            while (menuBancoAtivo) {

                    System.out.println("\n----- Sistema do Banco -----");
                    System.out.println(" [1] - Serviços (Saque e Depósito) \n " +
                            "[2] - Cadastro de Conta \n " +
                            "[3] - Cadastro e Exclusão de Clientes \n " +
                            "[4] - Sair");
                    System.out.println("Digite a opção desejada: ");
                try {
                    s = new Scanner(System.in);
                    opcao = s.nextInt();
                    menuBancoAtivo = false;

                }catch(InputMismatchException ex){
                    System.out.println("Digite um valor de 1 a 4");
                }catch (Exception ex) {
                    System.out.println("Erro - " + ex);
                }
            }
            assert opcao != null;

           switch (opcao) {
               case 1 -> {
                   selecionarServico();
                   menuBancoAtivo = true;
               }
               case 2 -> {
                   try {
                       banco.abrirConta();
                   } catch (InputMismatchException ex) {
                       System.out.println("Valor digitado inválido");
                   }catch(NullPointerException ex){
                       System.out.println("Cliente não encontrado");
                   }catch (Exception ex) {
                       System.out.println("Erro - " + ex);
                   }
                   menuBancoAtivo = true;
               }
               case 3 -> {
                   selecionarCadastroExclusao();
                   menuBancoAtivo = true;
               }
               case 4 -> {
                   System.out.println("Deseja realmente sair do Programa? (S/N)");
                   if (checagem())
                       loopPrincipal = false;
                   else
                       menuBancoAtivo = true;
               }
               default -> System.out.println("Opção não existe");
           }
       }
    }


    private void selecionarServico() {
        int opcaoMenu = 0;
        boolean contadorMenu = true;
        Scanner s;

        do {
                System.out.println("\n----- Deseja realizar qual serviço -----");
                System.out.println(" [1] - Saque \n [2] - Deposito \n [3] - Voltar");
                System.out.println("Digite a opção desejada: ");
            try {
                s = new Scanner(System.in);
                opcaoMenu = s.nextInt();
                contadorMenu = false;

            } catch(InputMismatchException ex){
                System.out.println("Digite um valor de 1 a 3");
            }catch (Exception ex) {
                System.out.println("Erro - " + ex);
            }
        }while (contadorMenu);

        switch(opcaoMenu){
            case 1:
                try{
                banco.realizarSaque();
                } catch (InputMismatchException ex) {
                    System.out.println("Valor digitado inválido");
                }catch(NullPointerException ex){
                    System.out.println("Cliente não encontrado");
                } catch (Exception ex) {
                    System.out.println("Erro - " + ex);
                }
                break;
            case 2:
                try{
                banco.realizarDeposito();
                } catch (InputMismatchException ex) {
                    System.out.println("Valor digitado inválido");
                }catch(NullPointerException ex){
                    System.out.println("Cliente não encontrado");
                } catch (Exception ex) {
                    System.out.println("Erro - " + ex);
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Erro");
        }
    }

    private void selecionarCadastroExclusao() {
        int opcaoMenu = 0;
        boolean contadorMenu = true;
        Scanner s;


        do {

                System.out.println("\n----- Deseja realizar qual serviço -----");
                System.out.println(" [1] - Cadastrar \n [2] - Excluir \n [3] - Voltar");
                System.out.println("Digite a opção desejada: ");
            try {
                s = new Scanner(System.in);
                opcaoMenu = s.nextInt();
                contadorMenu = false;

            }catch(InputMismatchException ex){
                System.out.println("Digite um valor de 1 a 3");
            }catch (Exception ex) {
                System.out.println("Erro - " + ex);
            }

        }while (contadorMenu);

        switch(opcaoMenu){
            case 1:
                try{
                banco.cadastrarCliente();
                } catch (InputMismatchException ex) {
                    System.out.println("Valor digitado inválido - Cliente não cadastrado");
                } catch (Exception ex) {
                    System.out.println("Erro - " + ex +"\n Cliente não cadastrado");
                }
                break;
            case 2:
                try{
                banco.excluirCliente();
                } catch (InputMismatchException ex) {
                    System.out.println("Valor digitado inválido");
                } catch (Exception ex) {
                    System.out.println("Erro - " + ex);
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Erro");
        }
    }

    public boolean checagem(){
        String validar;
        Scanner s;

        try{
            s = new Scanner(System.in);
            validar = s.nextLine();
            if(validar.contains("S") || validar.contains("s")){
                System.out.println("Saindo do programa...");
                return true;
            }else return false;

        }catch(InputMismatchException ex){
            System.out.println("Digite S ou N");
        }catch (Exception ex) {
            System.out.println("Erro - " + ex);
        }
        return true;
    }

}
