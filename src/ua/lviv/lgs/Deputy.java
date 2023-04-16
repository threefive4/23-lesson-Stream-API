package ua.lviv.lgs;

import java.util.Scanner;

public class Deputy extends Human {

    private String firstName;
    private String lastName;
    private int age;
    private boolean bribeTaker;
    private int bribeSize;

    public Deputy(int weight, int height, String firstName, String lastName, int age, boolean bribeTaker) {
        super(weight, height);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bribeTaker = bribeTaker;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBribeTaker() {
        return bribeTaker;
    }

    public void setBribeTaker(boolean bribeTaker) {
        this.bribeTaker = bribeTaker;
    }

    public int getBribeSize() {
        return bribeSize;
    }

    public void setBribeSize(int bribeSize) {
        this.bribeSize = bribeSize;
    }

    public void giveBribe() {
        if (!bribeTaker) {
            System.out.println("Цей депутат не бере хабарів.");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть розмір хабаря: ");
            int bribe = scanner.nextInt();
            if (bribe > 5000) {
                System.out.println("Поліція ув'язнить депутата.");
            } else {
                bribeSize = bribe;
            }
        }
    }
}




