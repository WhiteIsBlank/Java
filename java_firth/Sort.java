import java.util.Scanner;

public class Sort {
    public static void printArr(int arr[]){
        for(int i = 0;i < arr.length;i++){
            if(i == arr.length- 1){
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i]+",");
            }
        }
        System.out.println();
    }
    public static void swap(int arr[],int x,int y){
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] =temp;
    }
    public static void bubblingSort(int arr[]){
        //冒泡排序，两两比较，把最大（最小）放到最后
        for(int i = arr.length - 1;i > 0;i--){
            for(int j = 0;j < i;j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public static void insertSort(int arr[]){
        //插入排序，是从第一个开始，依次放入，将数据与前面有规律的数据进行比对
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = i + 1;j > 0;j--){
                if(arr[j] < arr[j-1]){
                    swap(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
    }
    public static void quickSort(int arr[]){
        //快速排序：就是在整个序列中，找到当前序列最大最小放到最前位置
        for(int i = 0;i < arr.length;i++){
            int max = i;
            for(int j = i+1;j < arr.length;j++){
                if(arr[max] > arr[j]){
                    max = j;
                }
            }
            if(max!=i){
                swap(arr,i,max);
            }
        }
    }
    public static void merge(int arr[],int left,int right){
        int m = right - left + 1;//确定存放排好序的数组的大小
        int[] b = new int[m];
        int i = 0,left0 = left;//left0是为了确定原来的其实数组的的位置，然后将排好序的数列放到其中去
        int mid = (right + left)/2;
        int k = mid + 1;
        while((left <= mid)&&(k <= right)){
            if(arr[left]<arr[k]){
                b[i++] = arr[left++];
            }else{
                b[i++] = arr[k++];
            }
        }
        if(left > mid) {//如果第二个序列有剩余
            for(int j = k;j <= right;j++){
                b[i++] = arr[j];
            }
        }
        if(k > right){//如果第一个排序有剩余
            for(int j = left;j <= mid;j++){
                b[i++] = arr[j];
            }
        }
        //将排序好的序列放到放到a中
        for(int j = 0;j < m;j++){
            arr[left0++] = b[j];
        }
    }
    public static void mergeSort(int arr[],int left,int right){//左右划分，当只有一个的时候返回
        //合并排序：取中间值，然后依次这样取中间那个进行排序，然后将排好序的序列进行合并，此时是左右两边都排好序的，所以定义合并函数
        //利用递归排序来写
        if(left == right){
            return;
        }
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,right);
        }
    }
    public static void heapify(int arr[],int n,int i){//一个树子节点和父节点，其中n是数组大小，如果大于n就不存在这个数据
        int largest = i;
        int lson = (i*2)+1;//左子节点
        int rson = (i*2)+2;//右子节点
        if(lson < n && arr[lson] > arr[largest]){
            largest = lson;
        }
        if(rson < n&&arr[rson] > arr[largest]){
            largest = rson;
        }
        if(largest != i){//以此表明其中有个孩子比他大
            swap(arr,i,largest);//第一回维护交换
            heapify(arr,n,largest);//循环递归，以此维护所有的错误顺序
        }
    }
    public static void heapSort(int arr[],int n){
        //就是将最后一个元素与第一个元素交换位置，并且删除最后一个元素，将其放到数组的最后，一直这样循环
        int i;
        //建堆，将输入的序列建成堆，开始创建(n/2-1)
        for(i= n/2-1;i >=0;i--){
            heapify(arr,n,i);
        }
        //排序
        for(i = n - 1;i > 0;i--){//将最后一个元素与第一个元素相互交换
            swap(arr,i,0);
            heapify(arr,i,0);//然后从第一个元素开始维护堆的性质
        }
    }
    public static void main(String[] args) {
        int arr[] = {5,9,10,0,5,3,9,7,11,30};
        int select;
        Scanner scanner = new Scanner(System.in);
        System.out.println("选择那种排序方式：");
        select = scanner.nextInt();
        switch (select){
            case 1:
                System.out.println("冒泡排序：");
                bubblingSort(arr);
                printArr(arr);
                break;
            case 2:
                System.out.println("插入排序：");
                insertSort(arr);
                printArr(arr);
                break;
            case 3:
                System.out.println("快速排序：");
                quickSort(arr);
                printArr(arr);
                break;
            case 4:
                System.out.println("合并排序：");
                mergeSort(arr,0,arr.length-1);
                printArr(arr);
                break;
            case 5:
                System.out.println("堆排序：");
                heapSort(arr, arr.length);
                printArr(arr);
                break;
            default:
                System.out.println("请输入正确选项！！！");
        }
    }
}
