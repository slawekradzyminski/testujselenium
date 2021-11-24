package pl.testuj.unit.executable;

import java.util.Scanner;

public class MainPlayground {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please provide number a");
        int a = Integer.parseInt(in.nextLine());

        System.out.println("Please provide number b");
        int b = Integer.parseInt(in.nextLine());
        int c = a + b;

        System.out.println("a+b=" + c);
    }


}
