package by.jrr.arrays;

import java.util.Objects;

public class MyClass {

    public String val;

    public MyClass() {
    }

    public MyClass(String val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return Objects.equals(val, myClass.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
