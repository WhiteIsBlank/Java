import java.util.Scanner;
public class isPalindrome {
    public static void main(String[] args) {
        System.out.print("请输入一个数字判断是否是回文数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        isPalindrome(n);
    }
    public static void isPalindrome(int num) {
        boolean flag = false;
        String s = Integer.toString(num);
        char[] chars = s.toCharArray();
        for(int i = 0;i < (int)s.length()/2;i++){
            if(chars[i] == chars[s.length()-1-i]){
                flag = true;
            }else{
                flag = false;
            }
        }
        if (flag) {
            System.out.println("是的") ;
        } else
            System.out.println("不是") ;
    }
}