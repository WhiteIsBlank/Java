import java.util.Scanner;
public class reserseSUM {
    public static void main(String[] args) {
        System.out.print("请输入一个正整数：");
        Scanner scanner = new Scanner(System.in);
        String Str = scanner.nextLine();
        System.out.printf("您输入的正整数的位数是：%d\n",Str.length());
        reverseSUM(Str);
    }
    public static void reverseSUM(String s) {
//用数组完成 转换工具如下
        int n = s.length();
        char[] chars = s.toCharArray();
        for(int i = 0;i < (int)n/2;i++){
            char temp;
            temp = chars[i];
            chars[i] = chars[n-1-i];
            chars[n-1-i] = temp;
        }
        String s1 = String.valueOf(chars);
        System.out.print("您输入的整数的位数是：");
        System.out.println(s1);
    }
}