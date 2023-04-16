package ua.lviv.lgs;

import java.util.*;
import java.util.stream.Collectors;

public class Fraction {
    private ArrayList<Deputy> deputies;
    private String fractionName;

    public Fraction(String fractionName) {
        this.fractionName = fractionName;
        deputies = new ArrayList<>();
    }

    public String getFractionName() {
        return fractionName;
    }

    public void setFractionName(String fractionName) {
        this.fractionName = fractionName;
    }


    public void addDeputy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter weight: ");
        int weight = scanner.nextInt();
        System.out.println("Enter height: ");
        int height = scanner.nextInt();
        System.out.print("Enter deputy first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter deputy last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter deputy age: ");
        int age = scanner.nextInt();
        System.out.print("Enter deputy bribe amount: ");
        int bribeAmount = scanner.nextInt();
        System.out.print("Is the deputy a bribe taker? ");
        boolean bribeTaker = scanner.nextBoolean();
        Deputy deputy = new Deputy(weight, height, firstName, lastName, age, bribeTaker);
        deputies.add(deputy);
    }

    public void removeDeputy() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deputy last name: ");
        String name = scanner.nextLine();
        //
        List<Deputy> deputiesToRemove = deputies
                .stream()
                .filter(deputy -> deputy.getLastName().equals(name))
                .collect(Collectors.toList());
        if (deputiesToRemove.isEmpty()) {
            System.out.println("No deputy with the last name " + name + " found");
        } else {
            deputies.removeAll(deputiesToRemove);
            System.out.println("Deputy removed");
        }
    }


    public void printBribeTakers() {
        List<Deputy> bribeTakers = deputies
                .stream()
                .filter(Deputy::isBribeTaker)
                .collect(Collectors.toList());
        System.out.println("Bribe takers: " + bribeTakers);
    }

    public void printBiggestBribeTaker() {
        Deputy biggestBribeTaker = deputies
                .stream()
                .filter(Deputy::isBribeTaker)
                .max(Comparator.comparingInt(Deputy::getBribeSize))
                .orElse(null);
        System.out.println("Biggest bribe taker: " + biggestBribeTaker);
    }

    public void printDeputies() {
        System.out.println("Deputies:");
        deputies.stream()
                .map(Deputy::getLastName)
                .forEach(System.out::println);
    }

    public void clear() {
        deputies.clear();
        System.out.println("Fraction cleared.");
    }


}
