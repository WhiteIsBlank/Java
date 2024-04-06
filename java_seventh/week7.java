import java.util.*;

public class week7 {
    static Random random = new Random();
    public static void test(){
        System.out.println(task1("abba","dog dog dog dog"));
        System.out.println(task2(new int[]{2,3,1,0,2,5,3}));
        for(int i=0;i<5;i++){
            int target = random.nextInt(15) - 3;
    System.out.println("target:"+target+"\tresult"+task3(new int[]
                    {0,4,5,6,8},target));
        }
    }
    public static List<Integer> findIndexies(char pt[],int target){
        List<Integer> indecies = new ArrayList<>();
        char t = pt[target];
        for(int i = target+1;i < pt.length;i++){
            if(t == pt[i])
                indecies.add(i);
        }
        return indecies;
    }
    public static boolean task1(String pattern,String str){
        char pt[] = pattern.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c:pt){
            set.add(c);
        }
        Character se[] = set.toArray(new Character[0]).clone();
        String pandaun[] = new String[set.size()];
        String s[] = str.split(" ");
        boolean visit[] = new boolean[s.length];
        int flag = 0;
        for(int i = 0;i < s.length;i++){
            for(int m = 0;m < set.size();m++){
                if(se[m] == pt[i]){
                    pandaun[m] = s[i];
                }
            }
            if(visit[i] == false){
                List<Integer> list = findIndexies(pt,i);
                visit[i] = true;
                for(int j = 0;j < list.size();j++){
                    if(s[i].equals(s[list.get(j)])){
                        visit[list.get(j)] = true;
                    }else{
                        flag = 1;
                        break;
                    }
                }
            }else if(visit[i] == true){
                continue;
            }
            if(flag == 1){
                break;
            }
        }
        Set<String> mm = new HashSet<>();
        for(String st : pandaun){
            mm.add(st);
        }
        if(flag == 1 || mm.size() != pandaun.length){
            return false;
        }else{
            return true;
        }
    }
    public static int task2(int[] num){
        int res = 0;
        for(int i = 0;i < num.length;i++){
            for(int j = i + 1;j < num.length;j++){
                if(num[i] == num[j]){
                    res = 1;
                    break;
                }
            }
            if(res == 1){
                return num[i];
            }
        }
        return 0;
    }
    public static int task3(int nums[],int target){
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -mid;
    }
    public static void main(String[] args) {
        test();
    }
}
