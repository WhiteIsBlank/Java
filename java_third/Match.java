import java.util.Scanner;

public class Match {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] words = new String[n];
        int sum = 0;
        int flag = 0;
        for(int i = 0 ;i < n;i++){
            words[i] = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder(S);
            for(int j = 0;j < words[i].length();j++){
                flag = 0;
                for(int k = 0;k < stringBuilder.length();k++){
                    if(words[i].charAt(j) == stringBuilder.charAt(k)){
                        stringBuilder.setCharAt(k,' ');
                        flag = 1;
                    }
                }
                if(flag == 0){
                    break;
                }
            }
            if(flag == 1){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
