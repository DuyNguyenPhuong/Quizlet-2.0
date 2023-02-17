import java.util.*;


public class FlashcardPQ implements PriorityQueue<Flashcard> {
  

   ArrayList<Flashcard> flashCards = new ArrayList<Flashcard>();


   /**
    * Heapify Up: Rearrange the Max Heap ArrayList to the right position 
    * @param newPos (int) Position of the added of the item
    */
   private void heapifyUp(int newPos) {
    if (newPos <=0){
      return;
    }
    else if (flashCards.get(newPos).compareTo(flashCards.get(parent(newPos)))!=1){
      return;
    }
    else{
      swap(flashCards.get(newPos), flashCards.get(parent(newPos)));
      heapifyUp(parent(newPos));
    }
  }

    /**
     * Swap the information of 2 different cards
     * @param card1 (Flashcard) 1st card
     * @param card2 (Flashcard) 2nd card
     */
    public void swap(Flashcard card1, Flashcard card2) {
      int tempPrioty = card1.priority;
      String tempFront = card1.front;
      String tempBack = card1.back;
      card1.priority = card2.priority;
      card1.front = card2.front;
      card1.back = card2.back;
      card2.priority = tempPrioty;
      card2.front = tempFront;
      card2.back = tempBack;
  }
    /**
     * Calculate the parent position of giving position
     * @param childPos (int) the position of the child
     * @return (int) the position of the parent
     */
    public int parent(int childPos) {
      if (childPos <= 0) { return -1; }
      int parentPosition = (childPos-1)/2;
      return parentPosition;
    }
   
    /**
     * Adds the given item to the queue.
     * @param item (Flashcard) item we want to add
     */
    public void add(Flashcard item){
      if (flashCards.size() == 0){
        flashCards.add(item);
        return;
      }
      else{
        flashCards.add(item);
        int curPos = flashCards.size() -1;
        heapifyUp(curPos);
        return;
      }
    }

    /** Removes the first item according to compareTo from the queue, and returns it.
     * Returns null if the queue is empty.
     */
    public Flashcard poll(){
      if (this.isEmpty()){
        return null;
      }
      int tempPri = flashCards.get(0).priority;
      String tempFront = flashCards.get(0).front;
      String tempBack = flashCards.get(0).back;
      Flashcard removeCard = new Flashcard(tempPri, tempFront, tempBack);
      swap(flashCards.get(0), flashCards.get(flashCards.size()-1));
      flashCards.remove(flashCards.size()-1);
      heapifyDown(0);
      return removeCard;
    }
    
    /**
     * Heapify Down: Rearrange the Max Heap ArrayList to the right position 
     * @param newPos (int) Position of the added of the item
     */
    public void heapifyDown(int newPos) {
      int largest = newPos;
        int l = 2 * newPos + 1;
        int r = 2 * newPos + 2;
        int n = flashCards.size();
        if (l < n && flashCards.get(l).priority > flashCards.get(newPos).priority){
          largest = l;
        }
        if (r < n && flashCards.get(r).priority > flashCards.get(largest).priority)
            largest = r;
        if (largest != newPos) {
            swap(flashCards.get(newPos), flashCards.get(largest));
            heapifyDown(largest);
        }
    }

    /** Returns the first item according to compareTo in the queue, without removing it.
     * Returns null if the queue is empty.
     */
    public Flashcard peek(){
      if (this.isEmpty() == true){
        return null;
      }
      return flashCards.get(0);
    }
    
    /** Returns true if the queue is empty. */
    public boolean isEmpty(){
      if (flashCards.size() == 0){
        return true;
      }
      return false;
    }
    
    /** Removes all items from the queue. */
    public void clear(){
      flashCards.clear();
    }

    /**
     * Creates a String of the priority queue to save to the file in the correct format
     * @return a string to save to a file
     */
    public String toString() {
      String total = "";
      for (int i =0; i < flashCards.size(); i++){
        total += flashCards.get(i).toString();
      }
      return total;
    }
    /**
     * In the main method we creates 11 cards and tests all the method
     * @param args
     */
    public static void main(String[] args) {
      FlashcardPQ test = new FlashcardPQ();
      Flashcard card1 = new Flashcard(10, "Hanoi", "Vietnam");
      Flashcard card2 = new Flashcard(7 , "Washington", "America");
      Flashcard card3 = new Flashcard(5 , "Beijing", "China");
      Flashcard card4 = new Flashcard(57, "Ottawa", "Canada");
      Flashcard card5 = new Flashcard(72 , "Brasilia", "Brazil");
      Flashcard card6 = new Flashcard(48 , "Apia", "Samoa");
      Flashcard card7 = new Flashcard(73 , "Lion", "Africa");
      Flashcard card8 = new Flashcard(6, "Panda", "Asia");
      Flashcard card9 = new Flashcard(42 , "Kangaroo", "Australia");
      Flashcard card10 = new Flashcard(60, "Banh my", "Vietnam");
      Flashcard card11 = new Flashcard(1000, "Bun Cha", "Vietnam");
      test.add(card1);
      test.add(card2);
      test.add(card3);
      test.add(card4);
      test.add(card5);
      test.add(card6);
      test.add(card7);
      test.add(card8);
      test.add(card9);
      test.add(card10);
      test.add(card11);
      test.toString();
      Scanner myObj = new Scanner(System.in);
      while(true){
        System.out.println("1-add, 2-poll, 3-peek, 4-isEmpty, 5-clear, 6-toString, 7 - exit");
        System.out.println("Enter test choice");
        String userChoice = myObj.nextLine();
        if (userChoice.equals("1")){
          System.out.println("Test the add method:");
          System.out.println(test.flashCards.get(0).toString());
        }
        else if (userChoice.equals("2")){
          System.out.println("Test the poll method:");
          if (test.isEmpty() == true){
            System.out.println("You have no flashcards");
          }
          else{
            System.out.println(test.poll().toString());
          }
        }
        else if (userChoice.equals("3")){
          System.out.println("Test the peek method:");
          if (test.peek() == null){
            System.out.println("You have no flashcards");
          }
          else{
            System.out.println(test.peek().toString());
          }
        }
        else if (userChoice.equals("4")){
          System.out.println("Test the isEmpty method:");
          System.out.println(test.isEmpty());
        }
        else if (userChoice.equals("5")){
          System.out.println("Test the clear method (print nothing becaue the array is clear):");
          test.clear();
          System.out.println(test.toString());
        }
        else if (userChoice.equals("6")){
          System.out.println("Test the toString method (if you do this after choice 6(clear) it will print nothing):");
          System.out.println(test.toString());
        }
        else if (userChoice.equals("7")){
          break;
        }
        else{
          System.out.println("Input is incorrect. Do it again.");
        }
      }
    }
}