import java.util.Arrays;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import org.junit.Test;

public class MaxHeapClient<T> {
  public static void main(String[] args) {
    int[] original = new int[6];
    int i = 0;
    try {
      File myObj = new File("test.txt");
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

    System.out.println(Arrays.toString(original));
    
    MaxHeapInterface<Integer> test = new MaxHeap<>();
    for (int j=0; j<original.length;j++)
      test.add(original[j]);
    
    int[] heaped = new int[6];
    heaped[0] = test;
    
    System.out.println(heaped);
    
    

  }

}