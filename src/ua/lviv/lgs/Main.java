package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<Fraction> fractions;

    public static void main(String[] args) {
        VerkhovnaRada vr = VerkhovnaRada.getInstance();

        boolean isExit = false;
        while (!isExit) {
            System.out.println("Введіть:");
            System.out.println("1 щоб додати фракцію");
            System.out.println("2 щоб видалити конкретну фракцію");
            System.out.println("3 щоб вивести усі фракції");
            System.out.println("4 щоб очистити конкретну фракцію");
            System.out.println("5 щоб вивести конкретну фракцію");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    vr.addFraction();
                    break;
                case 2:
                case 4:
                    vr.removeFraction();
                    break;
                case 3:
                    vr.displayAllFractions();
                    break;
                case 5:
                    vr.displayFraction();
                    break;
                case 11:
                    isExit = true;
                    break;
                default:
                    System.out.println("Некоректний ввід, спробуйте ще раз");
                    break;
            }
        }
    }

}
