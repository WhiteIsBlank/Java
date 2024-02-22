import java.util.Scanner;

public class Average {
    public static double Calculate(int N){
        Scanner scanner = new Scanner(System.in);
        int n = N;
        int sum = 0;
        do{
            sum += scanner.nextInt();
            N--;
        }while(N > 0);
        return  sum/n;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        int N = 0;
        int sum = 0;
        while(flag){
            try{
                N = scan.nextInt();
                if(N <= 0){
                    throw new IllegalArgumentException("N必须是正数或者0");
                }
                flag = false;
                System.out.println("平均数为："+Calculate(N));
            }catch (Exception e){
                System.out.println("输入异常: " + e.getMessage());
                scan.nextLine();
            }
        }
    }
}
