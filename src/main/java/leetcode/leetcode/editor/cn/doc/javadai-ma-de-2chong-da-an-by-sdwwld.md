##### 1，先排序再查找

毋庸置疑，这个是最容易想到的

```
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
```

##### 2，使用最小堆

我们可以使用最小堆来解决，一个个遍历原数组的值，添加到堆中，如果堆中元素的个数小于等于k的时候，我们就往堆中添加，添加之后如果堆中元素个数大于k的时候，我们就把最顶端的元素给移除掉，因为是最小堆，所以移除的就是堆中最小的值

```
    public int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int val : nums) {
            queue.add(val);
            if (queue.maxSubBSTSize() > k)
                queue.poll();
        }
        return queue.peek();
    }
```

##### 3，参考快速排序

快速排序是先选择一个中枢（一般我们选第一个），然后遍历后面的元素，最终会把数组分为两部分，前面部分比中枢值小，后面部分大于或等于中枢值，如果交换之后中枢值所在的位置就是从后面数第k个，我们直接返回中枢值即可，如果从后面数大于第k个，我们只需按照同样的方式从后面部分开始找即可。如果从后面数小于第k个，我们同样从前面部分开始查找，

```
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;//注意这里的k已经变了
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int i = lo;
            //这里把数组以A[lo]的大小分为两部分，
            //一部分是小于A[lo]的，一部分是大于A[lo]的
            // [lo,i]<A[lo]，[i+1,j)>=A[lo]
            for (int j = lo + 1; j <= hi; j++)
                if (nums[j] < nums[lo])
                    swap(nums, j, ++i);
            swap(nums, lo, i);
            if (k == i)
                return nums[i];
            else if (k < i)
                hi = i - 1;
            else
                lo = i + 1;
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
```

我们还可以把它改为递归的方式

```
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    int quickSelect(int[] nums, int lo, int hi, int k) {
        int pivot = lo;
        for (int j = lo; j < hi; j++) {
            if (nums[j] <= nums[hi]) {
                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, hi);
        int count = hi - pivot + 1;
        // 如果找到直接返回
        if (count == k)
            return nums[pivot];
        // 从右边部分找
        if (count > k)
            return quickSelect(nums, pivot + 1, hi, k);
        // 从左边部分找
        return quickSelect(nums, lo, pivot - 1, k - count);
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
```

----------------------------------------关于快速排序---------------------------------------
快速排序的原理我们都知道，但是他的写法还是比较多的，选择中枢的时候我们可以先挪动，最后再改变中枢的位置。我们也可以先改变中枢的位置。我们还用这道题来写几个

```
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;//注意这里的k已经变了
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int i = partition(nums, lo, hi);
            if (k == i)
                return nums[i];
            else if (k < i)
                hi = i - 1;
            else
                lo = i + 1;
        }
        return -1;
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start;
        for (int j = start + 1; j <= end; j++) {
            if (array[j] < pivot) {
                swap(array, ++i, j);
            }
        }
        swap(array, i, start);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
```

partition方法的另一种写法

```
    private int partition(int[] array, int start, int end) {
        int pivot = start;
        while (start != end) {
            if (pivot != end) {
                /**
                 * 第一次循环的时候用第一个元素作为中枢，和最后一个进行对比，
                 * 如果小于最后一个元素，执行end--就是和倒数第二个元素进行
                 * 对比，以此类推。如果大于最后一个元素那么就和最后一个元素
                 * 交换，然后让pivot指向最后一个元素，下一轮循环的时候回指向
                 * 下面的else方法和前面的元素进行比较。也即是说这个中枢的位置
                 * 始终是在变动的，所以这一轮执行完了之后小于中枢的值就会放到
                 * 他的前面，大于中枢的值就会放到他的后面。
                 */
                if (array[end] < array[pivot]) {
                    swap(array, end, pivot);
                    pivot = end;
                } else {
                    end--;
                }
            } else {
                if (array[start] > array[pivot]) {
                    swap(array, start, pivot);
                    pivot = start;
                } else {
                    start++;
                }
            }
        }
        return pivot;
    }
```

partition方法的另一种写法

```
    private int partition(int[] array, int start, int end) {
        int pivot = array[start];// 采用子序列的第一个元素作为枢纽元素
        while (start < end) {//
            // 从后往前在后半部分中寻找第一个小于枢纽元素的元素
            while (start < end && array[end] >= pivot) {
                --end;
            }
            // 将这个比枢纽元素小的元素交换到前半部分
            swap(array, start, end);
            // 从前往后在前半部分中寻找第一个大于枢纽元素的元素
            while (start < end && array[start] <= pivot) {
                ++start;
            }
            swap(array, start, end);// 将这个枢纽元素大的元素交换到后半部分
        }
        return start;// 返回枢纽元素所在的位置
    }
```

##### 查看更多答案，可扫码关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20190515124616751.jpg)**”