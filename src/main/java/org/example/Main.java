package org.example;


public class Main {
    
    public static void main(String[] args) {
        System.out.println("Second commit!");
        
        Cat firstCat = new Cat("Boris","black", 2);
        Cat secondCat = new Cat("Murzik","wight", 3);

        System.out.println("Данные первого кота: " + firstCat.getName() + ", " 
                + firstCat.getColor() + ", " + firstCat.getAge());
        System.out.println("Данные второго кота: " + secondCat.getName() + ", "
                + secondCat.getColor() + ", " + secondCat.getAge());
        System.out.println("Данные второго кота: " + secondCat.getName() + ", "
                + secondCat.getColor() + ", " + secondCat.getAge());
    }
}