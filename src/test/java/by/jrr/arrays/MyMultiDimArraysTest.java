package by.jrr.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMultiDimArraysTest {

    @Test
    public void multDemo1() {
        var myMultiDimArrays = new MyMultiDimArrays();
        myMultiDimArrays.setIntsOfIntsFlex();

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setHiddenSecond() {
        int[][] hiddenSecond = {{1, 2, 7}}; //actually one dims
        assertEquals(1, hiddenSecond.length);

        hiddenSecond[1] = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("breakpoint");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setHiddenSecond2() {
        int[][] hiddenSecond = new int[][]{new int[]{1, 2, 7}}; //actually one dims
        assertEquals(1, hiddenSecond.length);

        hiddenSecond[1] = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("breakpoint");
    }

    @Test
    public void ThreeDimsWrong() {
        Object[][] obj[] = {{{"string is na"}, {null}, {new Object(), new Integer(3)}}};
        System.out.println();
        assertEquals(1, obj.length);
        assertEquals(3, obj[0].length);
    }

    @Test
    public void TwoDims() {
        int[][] ints = {{1, 2, 3}, {4, 5, 6, 7}};
        System.out.println();
        assertEquals(2, ints.length);
        assertEquals(3, ints[0].length);
        assertEquals(4, ints[1].length);
    }
    @Test
    public void ThreeDims() {
        int[][][] ints = {{{1, 2, 3}, {4, 5, 6, 7}}, {{1, 2, 3}, {4, 5, 6, 7}}};
        System.out.println();
        assertEquals(2, ints.length);
        // TODO: 04/09/20 more asserts
    }
    @Test
    public void ThreeDimsVer2() {
        int[][] ints[] = {{{1, 2, 3}, {4, 5, 6, 7}}, {{1, 2, 3}, {4, 5, 6, 7}}};
        System.out.println();
        assertEquals(2, ints.length);
        // TODO: 04/09/20 more asserts
    }

    @Test
    public void BonusAttention() {
        int[] ints = new int[]{1,2,3};
        Object obj = ints;
//        Object[] objects = ints;
    }
}
