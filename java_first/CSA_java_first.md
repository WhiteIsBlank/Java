# 第一次CSA作业

## 选择题

BBDCD

## 编程题

1、  杨辉三角形(在主函数中调⽤⽅法打印)

```java
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
```

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/adfefa19-612d-4833-8a61-af116e706d96)

2、根据输入求输出-求位数、逆序输出

```java
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
```

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/98072fc2-7bf9-4285-a98e-378763474893)

3、  回⽂数判断

```java
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
```

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/774cdf2a-ba04-46d3-9de0-6c29aade2d35)

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/fc180fbb-f3aa-4ab8-a09f-31e885b0d6bc)

4、水仙花数

```java
public class ShuiXianHua {
    public static void main(String[] args) {
        ShuiXianHua();
    }
    public static void ShuiXianHua() { //思考哪些数是水仙花
        System.out.println("水仙花数有这些：");
        for(int i = 100;i < 999;i++){
            int bai = i/100;
            int shi = i / 10 % 10;
            int ge = i % 10;
            if(bai*bai*bai + shi*shi*shi + ge*ge*ge == i){
                System.out.printf("%d ",i);
            }
        }
    }
}
```

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/5f34f1e2-c398-46b3-8bbe-76dd3e005ed7)

5、编写程序计算一个包含10个整数的数组中所包含元素的最小值和最大值之和

```java
import java.util.Scanner;
public class arraysDemo {
    public static void main(String[] args) {
        arraysDemo();
    }
    public static void arraysDemo() {
        System.out.println("输入10个整数：");
        int length = 10;
        int[] array = new int[10];
        for (int i = 0; i < length; i++) {
            Scanner scanner = new Scanner(System.in);
            array[i] = scanner.nextInt();
        }
        int max = array[0];
        int min = array[0];
        for(int i = 0;i < length;i++){
            if(array[i] >= max){
                max = array[i];
            }
            if(array[i] <= min){
                min = array[i];
            }
        }
        System.out.println("打印两个 最值");
        System.out.printf("最大值：%d\n",max);
        System.out.printf("最小值：%d\n",min);
        System.out.printf("最大值和最小值的和：%d\n",max+min);
    }
}
```

![](https://github.com/WhiteIsBlank/Picture/assets/116374553/031a4f91-0875-4bdc-889a-c3e45de70070)

