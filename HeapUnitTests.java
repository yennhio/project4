import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HeapUnitTests {
    public static void main (String[] args){

        int[] test = new int[20];
        int i = 0;
    try {
      File myObj = new File("test.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextInt()) {
        int data = myReader.nextInt();
        test[i] = data;
        i++;
      }

      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    MaxHeapInterface<Integer> oat = new MaxHeap<Integer>();
    for (int j=0; j<test.length;j++)
      oat.add(test[j]);
  
    String unsmart;
    unsmart = "Heap built using sequential insertions: " + oat.toArray();

    String count = oat.keepCount();

    for (int j=0; j<10;j++)
      oat.removeMax();

    String removal;
    removal = "Heap after 10 removals: " + oat.toArray();

    try {
        File myObj = new File("test_output.txt");
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
        myWriter.write(unsmart + "\n" + count + "\n" + removal + "\n\n");
        myWriter.write(optimal2 + "\n" + count4 + "\n" + removal4 + "\n\n");
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        
      }

    }
}