import java.util.Scanner;

interface Compute{
    int computer(int n,int m);
}
class Add implements Compute{
    @Override
    public int computer(int n, int m){
        return n+m;
    }
}
class Sub implements Compute{
    @Override
    public int computer(int n,int m){
        return n-m;
    }
}
class Multiply implements Compute{
    @Override
    public int computer(int n,int m){
        return n*m;
    }
}
class Div implements Compute{
    @Override
    public int computer(int n, int m) {
        if(m == 0){
            return -1;
        }else{
         return n/m;
        }
    }
}
class UseCompute{
    public int useCom(Compute com,int one,int two){
        return com.computer(one,two);
    }
}
public class Test {

    public static void main(String[] args) {
        Compute com0 = new Add();
        Compute com1 = new Sub();
        Compute com2 = new Multiply();
        Compute com3 = new Div();
        UseCompute useCompute = new UseCompute();
        System.out.println("输入两个数:");
        Scanner scan =new Scanner(System.in);
        int one = scan.nextInt();
        int two = scan.nextInt();
        System.out.println("加法："+useCompute.useCom(com0,one,two));
        System.out.println("减法："+useCompute.useCom(com1,one,two));
        System.out.println("乘法："+useCompute.useCom(com2,one,two));
        System.out.println("除法："+useCompute.useCom(com3,one,two));
    }
}
