package by.jrr.arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


import static org.junit.Assert.*;

public class MyArraysTest {

    Logger log = LoggerFactory.getLogger(MyArraysTest.class);

    @Test
    public void arrayDefaultValues() {
        var myArrays = new MyArrays();
        log.info("initial int value " + myArrays.ints[5]);
        log.info("initial obj value " + myArrays.objectsS[0]);
        assertEquals(0, myArrays.ints[5]);
        assertEquals(null, myArrays.objectsS[0]);
    }

    @Test
    public void arraysParent() {
        int[] ints = new int[10];
        boolean[] booleans = new boolean[10];
        String[] strings = new String[10];
        MyClass[] myClasses = new MyClass[10];
        MyClass[][] myTwoDimClasses = new MyClass[10][];

        log.info("parent: " + ints.getClass().getSuperclass().getName() + "\tclassname: " + ints.getClass().getName());
        log.info("parent: " + booleans.getClass().getSuperclass().getName() + "\tclassname: " + booleans.getClass().getName());
        log.info("parent: " + strings.getClass().getSuperclass().getName() + "\tclassname: " + strings.getClass().getName());
        log.info("parent: " + myClasses.getClass().getSuperclass().getName() + "\tclassname: " + myClasses.getClass().getName());
        log.info("parent: " + myTwoDimClasses.getClass().getSuperclass().getName() + "\tclassname: " + myTwoDimClasses.getClass().getName());

//        Type	Letter
//        boolean	Z
//        byte	    B
//        char	    C
//        short	    S
//        int	    I
//        long	    J
//        float	    F
//        double	D
//    any Object	L
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowException() {
        int[] ints = new int[10];
        assertEquals(10, ints.length);
        log.info("print: " + ints[10]);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void shouldThrowNSAException() {
        int[] zeroLength = new int[-1];
    }

    @Test
    public void cloning() {
        String[] strings = {"a", "a", "a", "a", "a", "a"};
        String[] copyStrings = strings.clone();
        assertFalse(strings == copyStrings);
        assertFalse(strings.equals(copyStrings));
        assertFalse(strings.hashCode() == copyStrings.hashCode());

        copyStrings[0] = "b";
        assertFalse(strings[0].equals(copyStrings[0]));

        int[] ints = new int[]{1, 2, 3, 4, 5};
        int[] copyInts = ints.clone();
        assertFalse(ints == copyInts);
        assertFalse(ints.equals(copyInts));
        assertFalse(ints.hashCode() == copyInts.hashCode());

        copyInts[0] = 99;
        assertFalse(ints[0] == copyInts[0]);


        MyClass[] myCl = {new MyClass("a"), new MyClass("a"), new MyClass("a"),};
        MyClass[] copyMyCl = myCl.clone();
        assertTrue(Arrays.equals(myCl, copyMyCl));

        copyMyCl[0].val = "b";
        assertTrue(myCl[0].equals(copyMyCl[0]));
        assertEquals("b", myCl[0].val);
        assertEquals("b", copyMyCl[0].val);


    }

    @Test(expected = ArrayStoreException.class)
    public void reifiedTest() {
        String[] strings = {"a", "a", "a", "a", "a", "a"};
        Object[] obj = strings.clone();
        obj[0] = new Object();
        obj[1] = 4f;
    }

    @Test
    public void covariantTest() {
        Number[] numbers = {1, 2.0, 4f, (byte) 7, (short) 3};
        numbers[1] = new Byte((byte) 3);
        numbers[1] = 45L;
    }

    @Test
    public void javaUtilArraysDemo() {
        String[] strings = {"a", "a", "a", "a", "a", "a"};
        String[] copyStrings = {"a", "a", "a", "a", "a", "a"};
        assertTrue(Arrays.equals(strings, copyStrings));
        assertTrue(Arrays.deepEquals(strings, copyStrings));
        assertFalse(strings.equals(copyStrings));
        assertFalse(strings.hashCode() == copyStrings.hashCode());
    }

    @Test
    public void javaUtilArraysDemoEqual() {
        int[][] ints = {{1, 2}, {3, 4}};
        int[][] equalInts = {{1, 2}, {3, 4}};
        assertFalse(Arrays.equals(ints, equalInts));//{Object1, Object2}.equals{Object3, Object4};
        assertTrue(Arrays.deepEquals(ints, equalInts));
    }

    @Test
    public void javaUtilArraysDemoCopy() {
        String[] strings = {"a"};

        String[] copyStrings = Arrays.copyOf(strings, 1);
        assertTrue(Arrays.equals(strings, copyStrings));
        assertEquals(strings[0], copyStrings[0]);

        copyStrings = Arrays.copyOf(strings, 2);
        assertFalse(Arrays.equals(strings, copyStrings));
        assertEquals(strings[0], copyStrings[0]);
        assertEquals(2, copyStrings.length);
        assertEquals(null, copyStrings[1]);
    }

    @Test
    public void javaUtilArraysDemoCopyRange() {
        // TODO: 04/09/20
    }

    // Lexicographical  - "dictionary order"
    // Prefix  - 12345 & 1235 : prefix = 123
    @Test
    public void javaUtilArraysDemoCompare() {
        String[] left1strings = {"a", "b", "c"};
        String[] right1Strings = {"a", "b", "c"};
        assertEquals(0, Arrays.compare(left1strings, right1Strings));

        String[] left2strings = {"a", "b", "c"};
        String[] right2Strings = {"a", "c", "b"};
        assertEquals(-1, Arrays.compare(left2strings, right2Strings));

        String[] left3strings = {"a", "c", "b"};
        String[] right3Strings = {"a", "b"};
        assertEquals(1, Arrays.compare(left3strings, right3Strings));


    }
    @Test
    public void javaUtilArraysDemoMismatch() {
        String[] left1strings = {"a", "b", "c"};
        String[] right1Strings = {"a", "b", "c"};
        assertEquals(-1, Arrays.mismatch(left1strings, right1Strings));

        String[] left2strings = {"a", "b", "c"};
        String[] right2Strings = {"a", "b", "d"};
        assertEquals(2, Arrays.mismatch(left2strings, right2Strings));

        String[] left3strings = {"a", "b"};
        String[] right3Strings = {"a", "b", "d"};
        assertEquals(2, Arrays.mismatch(left3strings, right3Strings));
    }


}
