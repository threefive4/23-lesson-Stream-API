package ua.lviv.lgs;

import java.util.*;
import java.util.stream.Collectors;

public class VerkhovnaRada {
    private static VerkhovnaRada instance;

    private static ArrayList<Fraction> fractions = new ArrayList<>();
    ListIterator<Fraction> listFr = fractions.listIterator();

    public ArrayList<Fraction> getFractions() {
        return fractions;
    }

    public VerkhovnaRada() {
    }

    public static VerkhovnaRada getInstance() {
        if (instance == null) {
            instance = new VerkhovnaRada();
        }
        return instance;
    }

    public void addFraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the faction:");
        String fractionName = scanner.nextLine();
        Fraction newFraction = new Fraction(fractionName);
        if (fractions.stream().noneMatch(fraction -> fraction.getFractionName().equals(fractionName))) {
            fractions.add(newFraction);
            System.out.println("New newFraction added: " + fractionName);
        } else {
            System.out.println("Fraction with this name already exists");
        }
    }


    public void removeFraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the fraction:");
        String fractionName = scanner.nextLine();
        List<Fraction> fractionsToRemove = fractions
                .stream()
                .filter(fraction -> fraction.getFractionName().equals(fractionName))
                .collect(Collectors.toList());
        if (fractionsToRemove.isEmpty()) {
            System.out.println("Fraction " + fractionName + " are not found");
        } else {
            fractions.removeAll(fractionsToRemove);
            System.out.println("Fraction " + fractionName + " removed");
        }

    }

    public void displayAllFractions() {
        System.out.println("All fractions: ");
        fractions.stream()
                .map(Fraction::getFractionName)
                .forEach(System.out::println);

    }

    public void displayFraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter fraction name: ");
        String fractionName = scanner.nextLine();
        List<Fraction> showFraction = fractions
                .stream()
                .filter(fraction -> fraction.getFractionName().equals(fractionName))
                .collect(Collectors.toList());
        System.out.println("Fraction: " + showFraction);
    }

}