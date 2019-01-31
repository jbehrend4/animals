package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private final FileOutput outFile = new FileOutput("animals.txt");
    private final FileInput inFile = new FileInput("animals.txt");

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        ArrayList<Talkable> zoo = new ArrayList<>();
        Scanner keyboard = new Scanner (System.in);

        boolean validChoice = false;
        String choice = "";
        while (validChoice == false) {
          try {
            System.out.print("Would you like to add a dog, cat, or student: ");
            choice = keyboard.nextLine();
          }
          catch (Exception e) {
              System.out.println("That y was not a valid entry.");
          }
          finally {
              if (choice.equalsIgnoreCase("cat") || choice.equalsIgnoreCase("dog") || choice.equalsIgnoreCase("student")) {
                  validChoice = true;
              }
              else {
                  System.out.println("That was not a valid entry.");
              }   
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
