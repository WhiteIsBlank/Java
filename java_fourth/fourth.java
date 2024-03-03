import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fourth {
    public static final int MAX_SIZE = 100;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入想要解决的问题：");
        int n = scanner.nextInt();
        switch (n){
            case 1:
                System.out.println("整数反转");
                IntReverse();
                break;
            case 2:
                System.out.println("爬楼梯");
                Climb();
                break;
            case 3:
                System.out.println("求子集");
                Subset();
        }
    }

    public static void IntReverse(){
        Scanner scanner = new Scanner(System.in);
        int flag = 0;//是否是负数
        long x = scanner.nextLong();
        if(x < 0){
            flag = -1;
            x = Math.abs(x);
        }else{
            flag =1;
        }
        String str = new StringBuilder(Long.toString(x)).reverse().toString();
        int new_x = Integer.parseInt(str);
        if(flag == -1){
            if(new_x > Math.pow(2,32) - 1){
                System.out.println(0);
            }else{
                System.out.println(-new_x);
            }
        }else{
            if(new_x > Math.pow(2,32)){
                System.out.println(0);
            }else{
                System.out.println(new_x);
            }
        }
    }
    public static void Climb(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x,y,ans;
        ans = 0;
        for(x = 0;x <= n;x++){
            for(y = 0;y <= n;y++){
                if(x*1 + y*2 == n){
                    ans += Factorial(x+y)/(Factorial(x)*Factorial(y));
                }
            }
        }
        System.out.println(ans);
    }
    public static int Factorial(int n){
        if(n == 1 || n == 0){
            return 1;
        }else{
            return n*Factorial(n-1);
        }
    }
    public static void Subset() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // 加入空集
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(nums[i]);
                result.add(subset);
            }
        }
        System.out.println(result);
    }
}
