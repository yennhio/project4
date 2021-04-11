import java.util.Arrays;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files

public class MaxHeapClient<T> {
  public static void main(String[] args) {
    int[] original = new int[100];
    int i = 0;
    try {
      File myObj = new File("data_sorted.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextInt()) {
        int data = myReader.nextInt();
        original[i] = data;
        i++;
      }

      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    MaxHeapInterface<Integer> first = new MaxHeap<Integer>();
    for (int j=0; j<original.length;j++)
      first.add(original[j]);
  
    String sequential1;
    sequential1 = "Heap built using sequential insertions: " + first.toArray();

    String count = first.keepCount();

    for (int j=0; j<10;j++)
      first.removeMax();

    String sequential2;
    sequential2 = "Heap after 10 removals: " + first.toArray();

    try {
      File myObj = new File("answer.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    try {
      FileWriter myWriter = new FileWriter("answer.txt");
      myWriter.write(sequential1 + "\n" + count + "\n" + sequential2);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
    
  }

}