import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HeapUnitTests {

        MaxHeapInterface<Integer> oatmeal = new MaxHeap<Integer>();

        @Test
        public void testAdd(){
            for (int i=0; i<10; i++)
                oatmeal.add(i);

            assertEquals("9, 8, 5, 6, 7, 1, 4, 0, 3, 2,...", oatmeal.toArray());
        }


}