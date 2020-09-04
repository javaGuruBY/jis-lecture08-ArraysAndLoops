package by.jrr.arrays;

public class MyMultiDimArrays {

    int[][] intsOfIntsFix = new int[2][3]; // {{*, *, *}, {*, *, *}}
    int[][] intsOfIntsFlex = new int[2][];// {{?}, {?}}
    int[][] intsOfIntsFixInitialized = {{1, 2, 7}, {1, 2, 3, 4, 5, 6, 7}};
    int[][] intsOf, intsOfInts[];

    public void setIntsOfIntsFlex() {
        intsOfIntsFlex[0] = new int[3];
        intsOfIntsFlex[1] = new int[]{1,2,3,4,5,6,7};
        System.out.println("breakpoint"); //{{*, *, *}, {1, 2, 3, 4, 5, 6, 7}}
    }

    public void access() {
        int i = intsOfIntsFixInitialized[1][3]; //4
//        intsOfInts[1][2][0];
    }
}
