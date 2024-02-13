import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("<-------第一题------->");
        Book book = new Book();
        book.name = "Java Program";
        book.writer = "John Smith";
        book.year = 2022;
        book.month = 2;
        book.day = 13;
        book.price = 100.0;
        book.displayInfo();
        System.out.println("<-------第二题------->");
        Car car = new Car();
        car.speed = 80;
        car.color = "Green";
        car.brand = "大众";
        car.wheels = 4;
        System.out.println("车轮的个数是："+car.wheels);
        car.OvercrowdedOrNot(3);
        System.out.println("----------------------------------");
        Truck truck = new Truck();
        truck.speed = 60;
        truck.color = "Blue";
        truck.brand = "一汽解放";
        truck.wheels = 6;
        System.out.println("车轮的个数是："+truck.wheels);
        truck.OvercrowdedOrNot(1);
        truck.OverloadOrNot(3000);
        System.out.println();
        System.out.println("车轮的个数是："+car.wheels);
        car.OvercrowdedOrNot(7);
        System.out.println("----------------------------------");
        System.out.println("车轮的个数是："+truck.wheels);
        truck.OvercrowdedOrNot(1);
        truck.OverloadOrNot(7000);
        System.out.println("<-------第三题------->");
        Calculator calculator = new Calculator();
        System.out.println("Addition:"+calculator.add(5,2));
        System.out.println("Subtracion:"+calculator.subtract(5,2));
        System.out.println("Multiplicatioin:"+calculator.multiply(5,2));
        calculator.divide(5,2);
        calculator.divide(5,0);
        System.out.println("<-------第四题------->");
        String[] strs1 = {"flower","flow","flight"};
        String ans1 = longestCommonPrefix(strs1);
        System.out.println(ans1);
        System.out.println("----------------------------------");
        String[] strs2 =  {"dog","racecar","car"};
        String ans2 = longestCommonPrefix(strs2);
        System.out.println(ans2);
    }
    //第四题
    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        int flag = 0;
        for(int i = 0;i < strs[0].length();i++){
            char ch = strs[0].charAt(i);//获取第i哥字符
            for(int j = 1;j < strs.length;j++){
                if(ch != strs[j].charAt(i)){
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }else{
                ans += ch;
            }
        }
        return ans;
    }
}
class Book{
    String name;//标题
    String writer;//作者
    double price;//书籍价格
    int year,month,day;//出版日期
    public void displayInfo(){
        System.out.println("Title:"+name+",Author:"+writer+",Date:"+year+"."+month+"."+day+",Price:"+price);
    }
}
class Vehicle{
    String brand;
    String color;
    double speed;
    int wheels;
}
class Car extends Vehicle{
    int loader = 5;
    void start(){
        System.out.println("Car is started");
    };
    void accelerate(int speed){
        System.out.println("Car is accelerating at speed "+speed+" km/h");
        if(speed > 60){
            System.out.println("Speeding has already happened.Speed limit 60km/h");
        }
    }
    void OvercrowdedOrNot(int ActualLoader){
        if(ActualLoader > loader){
            System.out.println("这是一辆汽车，能载"+loader+"人，实载"+ActualLoader+"人，你超员了！！！");
        }else{
            System.out.println("这是一辆汽车，能载"+loader+"人，实载"+ActualLoader+"人");
        }
    }
    void brake(){
        System.out.println("Car is braking");
    }
}
class Truck extends Vehicle{
    int loader = 3;
    double payload = 5000;
    void start(){
        System.out.println("Truck is started.");
    }
    void accelerate(int speed){
        System.out.println("Truck is accelerating at speed "+speed+" km/h");
        if(speed > 60){
            System.out.println("Speeding has already happened.Speed limit 60km/h");
        }
    }
    void OverloadOrNot(int ActualMannned){
        if(ActualMannned <= payload){
            System.out.println("这是一辆卡车，核载"+payload+"kg,你已装载"+ActualMannned+"kg");
        }else{
            System.out.println("这是一辆卡车，核载"+payload+"kg,你已装载"+ActualMannned+"kg,你超载了！！！");
        }
    }
    void OvercrowdedOrNot(int ActualLoader){
        if(ActualLoader > loader){
            System.out.println("这是一辆卡车，能载"+loader+"人，实载"+ActualLoader+"人，你超员了！！！");
        }else{
            System.out.println("这是一辆卡车，能载"+loader+"人，实载"+ActualLoader+"人");
        }
    }
    void brake(){
        System.out.println("Truck is braking");
    }
}
class Calculator{
    double add(double a,double b) {
        return a+b;
    }
    double subtract(double a,double b){
        return a-b;
    }
    double multiply(double a,double b){
        return a*b;
    }
    void divide(double a,double b){
        if(b == 0){
            System.out.println("Divisor cannot be zero!!!");
        }else{
            System.out.println("Division:"+a/b);
        }
    }
}
