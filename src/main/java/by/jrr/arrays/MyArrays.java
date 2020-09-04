package by.jrr.arrays;

public class MyArrays {

    {

    }

    int i;
    int[] k;
    int[] j, l;
    int[] f, a[]; // a[][]
    int[][] d;

    Object[] obja, objb[];
    String[] str;

    // new and SIZE REQUIRED!!!!
    //array creation expressions
    int[] ints = new int[10];
    boolean[] booleans = new boolean[4];
    Object[] objects = new Object[3];
    Object[] objectsS = new String[3];
    MyClass[] myClasses = new MyClass[7];

    //array initializers
    int[] intA = new int[]{1, 2, 3, 4, 5};
    boolean[] booleanA = {true, false, true};
    String[] stringsA = {"a", "a", "a", "a", "a", "a"};
    MyClass[] myClassA = {new MyClass(), new MyClass(), new MyClass()};

    int[] zeroLength = new int[0];

    public void refiedDemo() {
        String[] strings = {"a", "a", "a", "a", "a", "a"};
        Object[] obj = strings.clone();
        obj[0] = new Object();
        obj[1] = 4f;

    }


}
