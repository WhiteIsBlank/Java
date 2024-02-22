class MyDate{
    int year;
    int month;
    int day;
    public MyDate(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
abstract class Employee{
    private String name;
    private int number;
    private MyDate birthday;
    public Employee(String name,int number,MyDate birthday){
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday +
                '}';
    }
    public abstract int earnings();
}
class CreateEmployee extends Employee{
    int salary;

    public CreateEmployee(String name, int number, MyDate birthday,int salary) {
        super(name, number, birthday);
        this.salary = salary;
    }

    @Override
    public int earnings() {
        return salary;
    }

}
public class Employ {
    public static void main(String[] args) {
        MyDate myDate = new MyDate(2024,2,22);
        CreateEmployee employee = new CreateEmployee("Java",123456,myDate,10000);
        String string = employee.toString();
        System.out.println(string);
    }
}
