package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    private static final int [] sorted = new int[]{1,2,3,4,5};
    private static final int [] unSorted = new int[]{5,2,1,3,4};
    private static final int [] empty = new int[0];

    @Test
    public void testSortMustReturnSortedArrayWhenGetUnsorted(){
        Bubble.sort(unSorted);
        assertArrayEquals(sorted,unSorted);
    }

    @Test
    public void testSortMustReturnSameArrayWhenGetSorted(){
        Bubble.sort(sorted);
        assertArrayEquals(sorted,sorted);
    }

    @Test
    public void testSortMustReturnSameArrayWhenGetEmpty(){
        Bubble.sort(empty);
        assertEquals(0,empty.length);
    }
}