![image.png](https://pic.leetcode-cn.com/1602330754-TeQLhy-image.png)

```
class Solution {
    public int[][] merge(int[][] intervals) {
        
        //先进行一个判空
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //对数组开始时区进行排序。
       Arrays.sort(intervals, ((v1, v2) -> v1[0] - v2[0]));

        //创建栈
        Stack<Integer> stack = new Stack<Integer>();
        //A代表栈顶开始时区，B代表栈顶结束时区。
        //先将第一个时区数组放入栈，方便接下来的操作。  
        int  A = intervals[0][0];
        int B = intervals[0][1];
        stack.push(A);
        stack.push(B);
      
        //遍历时区
        for(int i = 1; i < intervals.length; i++){
            //a,b是即将进行判断的时区
            int a = intervals[i][0];
            int b = intervals[i][1];

            //如果栈顶结束时区大于判断的开始时区，
            //说明有交叉需要合并
            if(B >= a){
                //合并栈顶弹栈，更新位B,中最大的即可，同时将最大的压入栈。被合并一个，counts--
                stack.pop();
                B = (int)Math.max(B,b);
                stack.push(B);
            }else if(B < a){
                //如果没有交叉，不需要合并，那么a,b入栈更新即可。
                stack.push(a);
                stack.push(b);
                A = a;
                B = b;
            }
        }

        //因为时区必定成双存在，倒叙遍历弹栈放入ans数组中即可。
        int [][] ans = new int[stack.maxSubBSTSize()/2][2];
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i][1] = stack.pop();
            ans[i][0] = stack.pop();
        }

        return ans;
    }
}
```
