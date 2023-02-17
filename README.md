# HW7 Flashcard Displayer

## Overview

The `FlashcardDisplayer` program displays the flashcards given in user input file. It will display the card with highest priority and change card's priority if user answer correctly or incorrectly.
The program also can:
- Allow user to specify the file to load and store the flashcards in
- Allow user to go through the flashcards as many times as they wish
- Save user's progress on the flashcards
- Check if the user answered correctly

## Usage
To use the `FlashcardDisplayer` program, run the following commands after downloading the code:
```
$ javac *.java
$ java FlashcardDisplayer
```

The program will ask which file user want to  to load and store the flashcards in. For example, we can type the `Cards.txt`. Then the program will print guidelines,rules and start display the first card's front (which is `Hanoi` in this example):
```
Welcome to Geography Flashcard!
We will display a word (city, animal,..)
You will answer which countries it belongs to
We will check if you entered the correct answer
and ask you to save or continue
Saving will update the information in the file you provided.
LET'S GO!
Press 1 to next; 2 to save
Card: 
Hanoi
```

User then type their answer and the program will check if the answer is right or wrong and change the card's priority based on that. The program will print the correctness and ask user to continue or save:

```
Card: 
Hanoi
$ Vietnam
Correct! The answer is Vietnam
Press 1 to next; 2 to save.
```

The program will make sure user input choice ("1" or "2") correctly. If user's input is incorrect, it will ask the user to input again. For example:
```
Press 1 to next; 2 to save.
$ hello
Incorrect input! Press 1 to next; 2 to save.
$ 1
Card: 
Kangaroo
```

The program will continue to display the card with highest priority. When the user want to save it, the program will save it in the same file, which in this case is `Cards.txt`:

```
Press 1 to next; 2 to save.
2
Process has been saved! See you soon!
```

## Rubric
Here we discuss how our project meets the rubric requirements of HW7
### README clear and complete
Yes, our README is clear and complete.
### Flashcard class has all required methods
We have all required methods in `Flashcard.java`:
1. `getFrontText` : lines 25-27
2. `getBackText` : lines 33-35
3. `getPriority` : lines 41-43
4. `compareTo` : lines 51-61
5. `toString` : lines 67-69
6. `setPriority`: lines 75-82

# PriorityQueue interface methods implemented and tested
We implements and tests PriorityQueue interface methods in `FlashcardPQ.java`
Implement:
1. `add`: lines 58-69
2. `poll`: lines 74-86
3. `peek`: lines 111-116
4. `isEmpty`: lines 119-124
5. `clear`: lines 127-129
6. `toString`: lines 135-141

Test: 
1. `add`: lines 176-179
2. `poll`: lines 180-188
3. `peek`: lines 189-197
4. `isEmpty`: lines 198-201
5. `clear`: lines 202-206
6. `toString`: lines 207-210

### At least 5 new flashcards provided
We have 10 flashcards, see in `Cards.txt`

### User can specify flashcard file
User can specify flashcard file when running program. Refer in the `Usage` for more instruction
```
Enter file you want to load and store the flashcards in
$ Cards.txt
```

### Program saves the state of the flashcards to the same file
User can saves the state of the flashcards to the same file by typing "2". Here is the piece of code (lines 94-99):
```java
else if (userChoice.equals("2")) {
    this.saveFlashcards();
    correctInput = true;
    continueORNot = false;
    System.out.println("Process has been saved! See you soon!");
}
```

### displayFlashcards continuously loops until user indicates to stop
User can indicates to stop by typing 2. The program will ask user to continue or save. If user continues, the program will display the highest priority card. And if the user type correctly ("1" or "2" the program will ask the user to type again). Here is a piece of code. See the full code in lines 71-105
```java
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
```
### displayFlashcards checks answers
Our program will check the user answer and say if it is correct or incorrect. Here is the piece of code lines 75-85:
```java
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
```
### displayFlashcards updates priorities
The program updates priorities based on user answer correctness. And rearrange the cards position based on its priority.
```java
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
```
### JavaDocs style method comments
We did the JavaDocs style method comments