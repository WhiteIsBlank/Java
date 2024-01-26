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