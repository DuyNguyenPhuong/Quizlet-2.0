import java.util.ArrayList;

public class Flashcard implements Comparable<Flashcard>{
  
  
  /**
   * Creates a new flashcard with the given
   * priority level, text for the front of the card (front),
   * and text for the back of the card (back).
   */
  
  int priority;
  String front;
  String back;
  public Flashcard(Integer priority, String front, String back){
    this.priority = priority;
    this.front = front;
    this.back = back;
  }

  /**
   * Gets the text for the front of this flashcard.
   * @return (String) the Front text
   */
  public String getFrontText(){
    return this.front;
  }
  
  /**
   * Gets the text for the Back of this flashcard.
   * @return (String) the Back text
   */
  public String getBackText(){
    return this.back;
  }
  
  /**
   * Gets the priority level of this flashcard.
   * @return (Integer) the priority
   */
  public Integer getPriority(){
    return this.priority;
  }

  /**
   * Compares the priority levels of the current flashcard and another flashcard
   * @param b (Flashcard) Flashcard we want to compare to
   * @return 1 if the flashcard's priority is larger than b's; 0 if it is equal
   * -1 if it is smaller
   */
  public int compareTo(Flashcard b){
    if (this.priority > b.priority){
      return 1;
    }
    else if (this.priority == b.priority){
      return 0;
    }
    else {
      return -1;
    }
  }

  /**
   * Returns a string in the format "priority,front,back\n"
   * @return (String) display of the card in format
   */
  public String toString() {
    return Integer.toString(this.priority) + "," + this.front + "," + this.back + "\n";
  }

  /**
   * Updates the priority of the card but doesn't allow priority to become negative.
   * @param newPrioriy (Integer) the new Priority
   */
  public void setPriority(Integer newPriority){
    if (newPriority >= 0) {
      this.priority = newPriority;
    }
    else {
      this.priority = 0;
    }
  }
}