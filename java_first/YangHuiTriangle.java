import java.util.Scanner;
public class YangHuiTriangle {
    public static void main(String[] args) {
        System.out.print("请输入想要打印的等腰三角形的行数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        showTriangle(n);
    }
    public static void showTriangle(int n){
//n为行数
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n-1-i;j++){
                System.out.print(" ");
            }
            StringBuilder str = new StringBuilder();
            for(int k = 0;k < 2*i+1;k++){
                str.append('*');
            }
            System.out.println(str);
        }
    }
}