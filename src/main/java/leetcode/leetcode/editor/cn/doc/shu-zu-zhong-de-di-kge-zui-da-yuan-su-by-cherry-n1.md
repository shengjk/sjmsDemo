# 题目描述

在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

**示例 1:**

```
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
```

**示例 2:**

```
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
```

## 1.暴力解法

直接调用库函数`Arrays.sort(nums)`,这个函数是从小到大进行排序。以示例2为例，`[3,2,3,1,2,4,5,5,6]`排序完为`[1,2,2,3,3,4,5,5,6]`
,要得到排序后第4个最大元素，就是要得到正序排序后的倒数第4个元素！即为`nums[nums.length-k] = nums[9-4]= 5`;
不掉用库函数也可以自己写一个快速排序，正好复习一下快速排序！

```
class Solution {
    void quickSort(int[] nums,int low, int high){
        if(low < high){
            // index为寻找基准元素的正确索引
            int index = getIndex(nums,low,high);
            //对index之前和index之后的数组进行相同的操作使得整个数组变得有序
            quickSort(nums,low,index-1);
            quickSort(nums,index+1,high);
        }
    }
    int getIndex(int[] nums, int low, int high){
        //基准数据
        int temp = nums[low];
        while(low < high){
            //当队尾的元素大于等于基准元素时，向前挪动指针
            while(low<high && nums[high]>=temp) high--;
            //若队尾元素小于基准元素了，将其值赋值给low位置的值
            nums[low] = nums[high];
            //当队头的元素小于等于基准元素时，向后挪动指针
            while(low<high && nums[low]<=temp) low++;
            //若队头元素大于基准元素了，将其值赋值给high位置的值
            nums[high] = nums[low];
        }
        //跳出循环时low==high 此时low位置就是temp元素的正确位置啦
        nums[low] = temp;
        return low; //返回这个排序好元素的正确位置
    }
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }
}
```

## 2.基于快速排序的选择方法

在方法1上的改进！其实我们每次调用getIndex方法，都可以确定某一个元素的最终位置p,若这个位置p正好为倒数第k个下标，则直接返回该元素就可以了！其他元素正确排序位置我们就不要管啦！如果这个位置p的位置小于目标下标，那我们就递归右子区间，否则递归左子区间。原先快速排序要递归两个区间，现在只要递归一个区间了，提高了时间效率！此外，我们可以我们可以引入随机化来加速这个过程，即每次的基准元素我们是随机找的，而不是固定的最左边的元素，它的时间代价的期望是
O(n)。

```
class Solution {
    //基于快速排序的选择方法
    Random random = new Random();
    int quickSort(int[] nums,int low, int high,int target){       
        // index为寻找基准元素的正确索引
        int index = getRandomIndex(nums,low,high);
        if(index == target)  return nums[index];
        else{
            return index < target? quickSort(nums,index+1,high,target):quickSort(nums,low,index-1,target);
        }              
    }
    int getRandomIndex(int[] nums, int low, int high){
        int r = random.nextInt(high - low + 1) + low; //random.nextInt(n)返回介于(0,n]的随机数
        swap(nums,low,r); //将随机获取的那个值与low值交换～
        return getIndex(nums,low,high);
    }
    int getIndex(int[] nums, int low, int high){
        //基准数据
        int temp = nums[low];
        while(low < high){
            //当队尾的元素大于等于基准元素时，向前挪动指针
            while(low<high && nums[high]>=temp) high--;
            //若队尾元素小于基准元素了，将其值赋值给low位置的值
            nums[low] = nums[high];
            //当队头的元素小于等于基准元素时，向后挪动指针
            while(low<high && nums[low]<=temp) low++;
            //若队头元素大于基准元素了，将其值赋值给high位置的值
            nums[high] = nums[low];
        }
        //跳出循环时low==high 此时low位置就是temp元素的正确位置啦
        nums[low] = temp;
        return low; //返回这个排序好元素的正确位置
    }
    void swap(int[] nums,int i,int j){ //交换i和j对应位置的值
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length-k;
        return quickSort(nums,0,nums.length-1,target);
    }
}
```

- 时间复杂度：O(n)
- 空间复杂度：O(logn)

## 3.通过优先队列实现大顶堆/小顶堆

（1）构造有len个元素的**大顶堆**，然后再 poll() 出 k-1 个元素，此时最堆大堆的堆顶元素就是数组中的第 k 个最大元素

```
class Solution {
    //通过优先队列构建大顶堆
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len,(a,b)->b-a); //构造有len个元素的大顶堆
        for(int num: nums){ //把 len 个元素都放入一个最大堆中
            minHeap.offer(num);
        }
        for(int i=0;i<k-1;i++){ //然后再 poll() 出 k-1 个元素
            minHeap.poll();
        }
        return minHeap.peek(); //此时最堆大堆的堆顶元素就是数组中的第 k 个最大元素
    }
}
```

（2）构造有len个元素的**小顶堆**，然后再 poll() 出 len-k 个元素，此时最小堆只剩下 k 个元素，堆顶元素就是数组中的第 k 个最大元素

```
class Solution {
    //通过优先队列构建最小堆
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len); //构造有len个元素的小顶堆
        for(int num: nums){ //把 len 个元素都放入一个最小堆中
            minHeap.offer(num);
        }
        for(int i=0;i<len-k;i++){ //然后再 poll() 出 len - k 个元素
            minHeap.poll();
        }
        return minHeap.peek(); //此时最小堆只剩下 k 个元素，堆顶元素就是数组中的第 k 个最大元素
    }
}
```

注：构造小顶堆可以不需要把len个元素都存进去，可以只存k个元素，这样时间复杂度为 O(Nlogk)

```
class Solution {
    //求第K个最大元素 构建最小堆 时间复杂度 O(Nlogk)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
        for(int num: nums){
            if(minHeap.maxSubBSTSize() < k){
                minHeap.offer(num);
            }else{
                if(num > minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }
        return minHeap.peek();
    }           
}
```
