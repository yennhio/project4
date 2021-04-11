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

        @Test
        public void testCount() {
            for (int i=0; i<10; i++)
                oatmeal.add(i);
            
            assertEquals("Number of swaps in the heap creation: 19", oatmeal.keepCount());
        }

        Integer[] snowman = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12};

       @Test
       public void testReheap() {
        MaxHeapInterface<Integer> pinetree = new MaxHeap<Integer>(snowman);
        assertEquals("12, 11, 7, 9, 10, 6, 1, 8, 4, 2,...", pinetree.toArray());
       }

}