package chapter15.textBookTest;

import java.util.Objects;

public class MyClass {
    private int value;
    private String name;
    private Car car;

    public MyClass(){}
    public MyClass(int value, String name, Car car) {
        this.value = value;
        this.name = name;
        this.car = car;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", car=" + car +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return value == myClass.value &&
                Objects.equals(name, myClass.name) &&
                Objects.equals(car, myClass.car);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, name, car);
    }

    public int getValue() {

        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
