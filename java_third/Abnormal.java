import java.util.Scanner;

public class Abnormal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double grade = scan.nextDouble();
        if(grade < 0 || grade > 100){
            throw new IllegalArgumentException("分数必须在0~100之间");
        }else{
            System.out.println("成绩是："+grade);
        }
    }
}
