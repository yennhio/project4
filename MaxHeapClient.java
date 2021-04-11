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

    int[] original2 = new int[100];
    int k = 0;
    try {
      File myObj2 = new File("data_random.txt");
      Scanner myReader2 = new Scanner(myObj2);
      while (myReader2.hasNextInt()) {
        int data2 = myReader2.nextInt();
        original2[k] = data2;
        k++;
      }

      myReader2.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    MaxHeapInterface<Integer> second = new MaxHeap<Integer>();
    for (int u=0; u<original2.length;u++)
      second.add(original2[u]);
    
    System.out.println(Arrays.toString(original2));
    System.out.println(second.toArray());
  
    String sequential3;
    sequential3 = "Heap built using sequential insertions: " + second.toArray();

    String count2 = second.keepCount();

    for (int j=0; j<10;j++)
      second.removeMax();

    String sequential4;
    sequential4 = "Heap after 10 removals: " + second.toArray();

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
      myWriter.write(sequential1 + "\n" + count + "\n" + sequential2 + "\n\n");
      myWriter.write(sequential3 + "\n" + count2 + "\n" + sequential4);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
    
  }

}