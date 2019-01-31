
package us.mattgreen;

import java.util.Scanner;

public class animalInput {
    private String animal;
    Scanner keyboard = new Scanner (System.in);
    
    public animalInput(String a) {
        animal = a;
    }
 
    public Dog dog() {
        System.out.print("Dog name: ");
        String dName = keyboard.nextLine();
        System.out.print("Is " + dName + " happy: (Y/N) ");
        String dHappy = keyboard.nextLine();   
        while (!dHappy.equalsIgnoreCase("y") && !dHappy.equalsIgnoreCase("n") )
        {
            System.out.print("Please enter yes or no (Y/N) ");
            dHappy = keyboard.nextLine(); 
        }
        boolean isHappy;
        if (dHappy.equalsIgnoreCase("y"))
        {
            isHappy = true;
        }
        else {
            isHappy = false;
        }
        Dog dog = new Dog(isHappy, dName);
        return dog;
    }
    
    public Cat cat() {
        System.out.print("Cat name: ");
        String cName = keyboard.nextLine();
        int deadMice = 8500000;
        do {
            try {
                System.out.print("How many mice has " + cName + " killed : ");
                String mKilled = keyboard.nextLine();   
                deadMice = Integer.parseInt(mKilled);
            }
            catch (NumberFormatException e){
                System.out.println("That is not a number");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Bad number format.");
            }
        } while (deadMice == 8500000);

        Cat cat = new Cat(deadMice, cName);
        return cat;
    }
    
    public Student student() {
        System.out.print("Student's name: ");
        String sName = keyboard.nextLine();
        int studentAge = 8500000;
        do {
            try {
                System.out.print("Student's age: ");
                String sAge = keyboard.nextLine(); 
                studentAge = Integer.parseInt(sAge);
            }
            catch (NumberFormatException e){
                System.out.println("That is not a number");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Bad number format.");
            }
        } while (studentAge == 8500000);        
        Student student = new Student(studentAge, sName);
        return student;
    }
}
