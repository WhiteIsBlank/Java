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