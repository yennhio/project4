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

    String removal;
    removal = "Heap after 10 removals: " + first.toArray();

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
    
    String sequential2;
    sequential2 = "Heap built using sequential insertions: " + second.toArray();

    String count2 = second.keepCount();

    for (int j=0; j<10;j++)
      second.removeMax();

    String removal2;
    removal2 = "Heap after 10 removals: " + second.toArray();

    Integer[] original3 = new Integer[100];
    int h = 0;
    try {
      File myObj3 = new File("data_sorted.txt");
      Scanner myReader3 = new Scanner(myObj3);
      while (myReader3.hasNextInt()) {
        int data3 = myReader3.nextInt();
        original3[h] = data3;
        h++;
      }

      myReader3.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    MaxHeapInterface<Integer> third = new MaxHeap<Integer>(original3);
  
    String optimal;
    optimal = "Heap built using optimal method: " + third.toArray();

    String count3 = third.keepCount();

    for (int j=0; j<10;j++)
      third.removeMax();

    String removal3;
    removal3 = "Heap after 10 removals: " + third.toArray();

    Integer[] original4 = new Integer[100];
    int n = 0;
    try {
      File myObj4 = new File("data_random.txt");
      Scanner myReader4 = new Scanner(myObj4);
      while (myReader4.hasNextInt()) {
        int data4 = myReader4.nextInt();
        original4[n] = data4;
        n++;
      }

      myReader4.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    MaxHeapInterface<Integer> fourth = new MaxHeap<Integer>(original4);
  
    String optimal2;
    optimal2 = "Heap built using optimal method: " + fourth.toArray();

    String count4 = fourth.keepCount();

    for (int j=0; j<10;j++)
      fourth.removeMax();

    String removal4;
    removal4 = "Heap after 10 removals: " + fourth.toArray();

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
      myWriter.write(sequential1 + "\n" + count + "\n" + removal + "\n\n");
      myWriter.write(sequential2 + "\n" + count2 + "\n" + removal2 + "\n\n");
      myWriter.write(optimal + "\n" + count3 + "\n" + removal3 + "\n\n");
      myWriter.write(optimal2 + "\n" + count4 + "\n" + removal4 + "\n\n");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
    
  }

}