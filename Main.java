package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private final FileOutput outFile = new FileOutput("animals.txt");
    private final FileInput inFile = new FileInput("animals.txt");

    public static void main(String[] args) throws inputTypeVerifier{
        new Main();
    }

    public Main() throws inputTypeVerifier{
        ArrayList<Talkable> zoo = new ArrayList<>();
        Scanner keyboard = new Scanner (System.in);
        boolean addMoreAnimals = true;
        
        while (addMoreAnimals == true) {
            boolean validChoice = false;
            String choice = "";
            while (validChoice == false) {
                System.out.print("Would you like to add a dog, cat, or student: ");
                choice = keyboard.nextLine();
                if (!choice.equalsIgnoreCase("cat") && !choice.equalsIgnoreCase("dog") && !choice.equalsIgnoreCase("student")) {
                    throw new inputTypeVerifier();
                }
                else {
                    validChoice = true;
                }   
            }

            animalInput input = new animalInput(choice);
            if (choice.equalsIgnoreCase("dog"))
            {
                zoo.add(input.dog());
            }
            else if (choice.equalsIgnoreCase("cat")) {
                zoo.add(input.cat());          
            }
            else if (choice.equalsIgnoreCase("student")) {
                zoo.add(input.student());
            }

            System.out.println("Enter another animal (Y/N): ");
            String cont = keyboard.nextLine();   
            while (!cont.equalsIgnoreCase("y") && !cont.equalsIgnoreCase("n") )
            {
                System.out.print("Please enter yes or no (Y/N) ");
                cont = keyboard.nextLine(); 
            }
            if (cont.equalsIgnoreCase("n"))
            {
                addMoreAnimals = false;
            }           
        }        

        for (Talkable thing : zoo) {
            printOut(thing);
        }
        outFile.fileClose();

        System.out.println("\n*** Reading/printing entire file using fileRead method\n");

        inFile.fileRead();
        inFile.fileClose();

        System.out.println("\n*** Reading/printing one line at a time using fileReadLine method\n");

        FileInput indata = new FileInput("animals.txt");
        String line;
        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
    }

    public void printOut(Talkable p) {
        System.out.println(p.getName() + " says = " + p.talk());
        outFile.fileWrite(p.getName() + "|" + p.talk());
    }
}
