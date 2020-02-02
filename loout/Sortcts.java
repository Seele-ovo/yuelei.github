import java.util.Arrays;

public class Sortcts {
    private static int count = 0;
    //冒泡排序
    //相邻的两个数字进行排序
    //最大排序次数最大数组长度-1
    //因为每一次排序都是找到最大下标所以每次排序次数都会减小
    public static void main(String[] args) {
        int[] arr = new int[]{82,46,57,77,13,32,61,2,20};
        radixSort(arr);
        //System.out.println(82 / 1 %10);
        System.out.println(Arrays.toString(arr));
    }
    //冒泡排序
    public static void srort01(){
        int[] array = new int[] {3, 9, -1, 10, -2};//原始数组
        //冒泡排序简单来说就是相邻的两个数进行比较大的向后挪，数组的长度 - 1确定需要冒泡的次数
        //数组 - 1 - i 需要对比的次数因为每一次循环都会找到最大的数字所以每次需要对比的数字减一
        //如果此次循环并未发生交换说明数据已经有序
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            //内层循环的次数逐渐减少一次
            for (int j = 0; j < (array.length - 1) - i; j++) {
                //对相邻的两个元素进行判断
                if (array[j] > array[j + 1]) {
                    //发生交换了
                    flag = true;
                    int temp = array[j + 1];//当前的数字大储存在临时变量中
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
                if (! flag) {
                    break;
                }else {
                    flag = false;
                }
            }
        }
    }
    //选择排序
    public static void srotr02(){
        int[] arr = new int[]{101,34,119,1};//原始数组
        int t = -1;
        int index = -1;
        //确定排序次数
        for (int i = 0; i < arr.length - 1; i++) {
            //假定当前的数据是最小的数据
            int temp = arr[i];
            //确定寻找的次数
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (temp > arr[j]) {
                    //记录当前下标
                    System.out.println(j);
                    temp = arr[j];
                    index = j;//记录下标
                }
            }
            //循环结束替换位置
            t = arr[i];//记录当前的位置的数据
            arr[i] = arr[index];
            arr[index] = t;
        }
        System.out.println("排序后的数据");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
    //插入排序
    public static void insetSotrt(){
        int[] arr = new int[]{101,34,119,1,6};//原始数组
        //[34,101,119,1,-2]第一次排序
        //[34,101,119,1,-2]第二次排序
        //[1,34,101,119,6]第三次排序
        //[1,34,101,119,6]第四次排序
        //确定循环次数
        for (int i = 0; i < arr.length - 1; i++) {
            //取出第当前数据的下一条数据
            int temp = arr[i + 1];
            //获取要当前位置前面的下标
            int index = i;
            //死循环判断
            while (index >= 0 && temp < arr[index]){
                //下标不能为负数
                //当前的数据小于前面的数据
                //前面的数据后移一位
                arr[index + 1] = arr[index];
                index--;//继续判断
            }
            //结束循环后插入
            arr[index + 1] = temp;
        }
        //打印
        System.out.println(Arrays.toString(arr));
    }
    //希尔排序
    public static void shellSort(){
        //分组，在组内进行冒泡比较
        //反向冒泡
        int temp = 0;
        //原始数组
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0,-1};
        //确定分几组
        for (int i = arr.length / 2; i > 0 ; i /= 2) {
            //确定每组的数据的个数
            for (int j = i; j < arr.length; j++) {
                //开始进行比较
                //j - i 确定第一个元素下标
                //k -= j 保证跳出循环
                for (int k = j - i; k >= 0 ; k -= i) {
                    //根据步长来进行判断
                    if (arr[k] < arr[k + i]) {
                        temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }
            }
        }
        System.out.println("排序后的数组");
        System.out.println(Arrays.toString(arr));
    }
    //希尔排序2
    public static void shellSort2(){
        //先分组在排序
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //第一组[8,3][9,5][1,4][7,6][2,0]
            //排序后结果为[3,5,1,6,0,8,9,4,7,2]
        //第二组排序[3,1,0,9,7][5,6,8,4,2]
            //[]
            //0,1,3,7,9,2,4,5,6,8
        //希尔排序的作用就是排序前先按步进行比较，只要最后的结果为分为一组就行
        for (int i = arr.length / 2; i > 0 ; i /= 2) {
            //每一组进行比较，每一组比较一次换下一组，但是要考虑与前面的进行比较因为可能这组可能不是最小，小的尽量向前移动
            for (int j = i; j < arr.length; j++) {
                //获取要比较的数据
                int temp = arr[j];
                int index = j;//用于向前进行判断
                //用于判断是否小，减少进入循环的次数
                if (temp < arr[index - i]) {
                    //判断下标是否越界并且当前的数小于步长的数
                    while (index - i >= 0 && temp < arr[index - i]){
                        arr[index] = arr[index - i];//大的数据移动到当前数据的位置
                        index -= i;//向前进行比较尽量将小的数据向前移动，如果不打则位置腾出
                    }
                    arr[index] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    //快速排序
    public static void qSort(int[] arr, int head, int tail){
        //取中间点排，递归排序
        //利用递归的与判断的方式进行排序的，先取出一个中间值根据中间值进行判断在递归操作知道俩值相等
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        if (i >= j) {
            return;
        }
        int temp = 0;
        while (i <= j){

            while (arr[i] < pivot){
                i++;
            }
            //如果退出那就代表找到比中间大的数字了开始找比中间值小的数字
            while (arr[j] > pivot){
                j--;
            }
            //如果退出那就代表找到比中间小的数字了开始找比中间值小的数字
            //交换
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                //交换完之后需要向前向后移动
                i++;
                j--;
            }else if (i == j) {
                i++;//用于退出循环
            }
        }
        qSort(arr,head, j);
        qSort(arr, i, tail);
    }
    //归并排序
    public static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        //一个大问题分成小问题，两个数组之间排序
        //需要用到递归所以需要一个出口否则会出现无限递归
        if (start >= end) {
            //拆分完毕开始合并
            return;
        }
        //计算当前长度并且用当前长度计算出中间值
        int len = end - start, pim = (len >> 1) + start;
        int start1 = start, end1 = pim;
        int start2 = pim + 1, end2 = end;
        merge_sort_recursive(arr,result,start1, end1);
        merge_sort_recursive(arr,result,start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2){
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        //将剩下的数据依次添加进数组中
        while (start1 <= end1){
            result[k++] = arr[start1++];
        }
        while (start2 <= end2){
            result[k++] = arr[start2++];
        }
        for (int i = start; i <= end; i++) {
            arr[i] = result[i];
        }
        //计算开始与结束
//        int len = end - start, mid = (len >> 1) + start;
//        int start1 = start, end1 = mid;
//        int start2 = mid + 1, end2 = end;
//        merge_sort_recursive(arr, result, start1, end1);
//        merge_sort_recursive(arr, result ,start2, end2);
//        //开始合并
//        int k = start;
//        while (start1 <= end1 && start2 <= end2){
//            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
//        }
//        while (start1 <= end1){
//            result[k++] = arr[start1++];
//        }
//        while (start2 <= end2){
//            result[k++] = arr[start2++];
//        }
//        for (int i = start; i <= end ; i++) {
//            arr[i] = result[i];
//        }
    }
    //基数排序
    public static void radixSort(int[] arr){
        //获取最大数组长度
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int leng = (max + "").length();//获取最大数的位数
        //创建一个桶用于存放数据
        int[][] bucket = new int[10][arr.length];
        //
        int k = 0;//取值

        int[] order=new int[20];//用于保存每个桶里有多少个数字
        //需要分割次数
        int n = 1;
        for (int i = 0; i < leng; i++) {
            for (int j = 0; j < arr.length; j++) {
                //获取每个数字的个位数
                int digit = (arr[j] / n) % 10;
                bucket[digit][order[digit]] = arr[j];//放在对应的位置
                /**
                 * bucket[下标][order[digit]] = arr[j];
                 * order[digit]记录每个桶的长度用于取数据一维数组
                 * order[8] = 如果每一次找到8这个位置就加1同理
                 * */
                order[digit]++;//计算每个桶中有多少值
            }
            //分组完毕开始将数据放入原数组中,一个桶一个桶的向原数组装进去
            for (int j = 0; j < arr.length; j++) {
                if (order[j] != 0) {
                    for (int l = 0; l < order[j]; l++) {
                        arr[k++] = bucket[j][l];
                    }
                }
                order[j]=0;//将桶里计数器置0，用于下一次位排序
            }
            k = 0;//结束后重置为0
            n*=10;//清空桶
        }
    }
}
