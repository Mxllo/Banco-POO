package service;

import lombok.NonNull;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputs {

    public static String scanString(){
        String string = "";
        try {
            Scanner s = new Scanner(System.in);
            string = s.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Entrada inválida!");
        }catch (Exception e){
            System.out.println("Erro - " + e);
            e.printStackTrace();
        }
        return string;
    }

    public static Integer scanInteger(){
        int integer = 0;
        try {
            Scanner s = new Scanner(System.in);
            integer = s.nextInt();

        }catch (InputMismatchException e){
            System.out.println("Entrada inválida!");
        }catch (Exception e){
            System.out.println("Erro - " + e);
            e.printStackTrace();
        }
        return integer;
    }

    public static Long scanLong(){
        long lng = 0L;
        try {
            Scanner s = new Scanner(System.in);
            lng = s.nextLong();

        }catch (InputMismatchException e){
            System.out.println("Entrada inválida!");
        }catch (Exception e){
            System.out.println("Erro - " + e);
            e.printStackTrace();
        }
        return lng;
    }

    public static Double scanDouble(){
        double dbl = 0D;
        try {
            Scanner s = new Scanner(System.in);
            dbl = s.nextDouble();

        }catch (InputMismatchException e){
            System.out.println("Entrada inválida!");
        }catch (NullPointerException e) {
            System.out.println("Entrada Nula");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("Erro - " + e);
            e.printStackTrace();
        }
        return dbl;
    }
}
