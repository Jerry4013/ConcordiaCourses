package chapter16;

import java.util.Objects;

public class Person {
    private String name;
    private double height;
    private double weight;
    private String color;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.height, height) == 0 &&
                Double.compare(person.weight, weight) == 0 &&
                Objects.equals(name, person.name) &&
                Objects.equals(color, person.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, height, weight, color);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Person(String name, double hight, double weight, String color) {

        this.name = name;
        this.height = hight;
        this.weight = weight;
        this.color = color;
    }
}
