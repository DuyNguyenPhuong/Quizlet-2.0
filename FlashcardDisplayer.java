import java.util.*;
import java.io.*;

public class FlashcardDisplayer {
    FlashcardPQ cards = new FlashcardPQ();
    String fileName;

    /**
     * Creates a FlashcardDisplayer with the flashcards in file. 
     * File has one flashcard per line. Each line is formatted as:
     * priority,front,back
     * @param inputFile The file with the flashcards saved
     */
    public FlashcardDisplayer(String inputFile) {
        fileName = inputFile;
        File input = new File(inputFile);
        Scanner scanner = null;
        try {
            scanner = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitline = line.split(",");
            cards.add(new Flashcard(Integer.parseInt(splitline[0]), splitline[1], splitline[2]));
        }
        scanner.close();
    }
    
    /**
     * Writes out all flashcards to the same file
     * they were read from so that they can be loaded by
     * the FlashcardDisplayer(String file) constructor. 
     * The FlashcardDisplayer will still have 
     * all the same flashcards after this method is called 
     * as it did before the method was called.
     */
    public void saveFlashcards() {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(cards.toString());
            myWriter.close();
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }

    /**
     * Continuously displays flashcards to the user
    * and checks their answers, updating the priority
    * of each flashcard based on if the user answered 
    * correctly or not. Displays the highest priority
    * flashcard first. Ends when the user enters 'save'.
    */
    public void displayFlashcards(){
        System.out.println("Welcome to Geography Flashcard!");
        System.out.println("We will display a word (city, animal,..)");
        System.out.println("You will answer which countries it belongs to");
        System.out.println("We will check if you entered the correct answer");
        System.out.println("and ask you to save or continue");
        System.out.println("Saving will update the information in the file you provided.");
        System.out.println("LET'S GO!");
        System.out.println("Press 1 to next; 2 to save");
        

        Scanner myObj = new Scanner(System.in);
        boolean continueORNot = true;
        while(continueORNot == true){
            System.out.println("Card: ");
            System.out.println(cards.peek().front);
            String userAns = myObj.nextLine();
            if (userAns.equals(cards.peek().back)){
                System.out.println("Correct! The answer is " + cards.peek().back);
                System.out.println("Press 1 to next; 2 to save.");
                cards.peek().priority -=1;

            }
            else{
                System.out.println("Incorrect! Press 1 to next; 2 to save.");
                cards.peek().priority +=2;
            }
            
            cards.add(cards.poll());        
            boolean correctInput = false;
            while (correctInput == false){
                String userChoice = myObj.nextLine();
                if (userChoice.equals("1")){
                    correctInput = true;
                }
                else if (userChoice.equals("2")) {
                    this.saveFlashcards();
                    correctInput = true;
                    continueORNot = false;
                    System.out.println("Process has been saved! See you soon!");
                }
                else{
                    correctInput = false;
                    System.out.println("Incorrect input! Press 1 to next; 2 to save.");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner myObj2 = new Scanner(System.in);
        System.out.println("Enter file you want to load and store the flashcards in");
        String userFile = myObj2.nextLine();
        FlashcardDisplayer quiz = new FlashcardDisplayer(userFile);
        quiz.displayFlashcards();
        myObj2.close();
    }
}
