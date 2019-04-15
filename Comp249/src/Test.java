import java.util.Objects;

public class Test     {
    private int number;
    private double num;

    public Test() {
    }

    public Test(int number, double num) {
        this.number = number;
        this.num = num;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return number == test.number &&
                Double.compare(test.num, num) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, num);
    }

    @Override
    public String toString() {
        return "Test{" +
                "number=" + number +
                ", num=" + num +
                '}';
    }


    public static void main(String[] args) {


    }

}
