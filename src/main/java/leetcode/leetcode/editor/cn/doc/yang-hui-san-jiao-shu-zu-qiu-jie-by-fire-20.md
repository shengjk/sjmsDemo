### 解题思路
利用规律，找到i和j的关系

### 代码

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        // 两个for循环进行
        int[][] nums = new int[numRows + 1][ numRows + 1];   
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i ++){
        List<Integer> Inlist = new ArrayList<Integer>();
        for (int j = 0; j <= i; j++){
            if(j == 0 || i == j){
                nums[i][j] = 1;
               
            }else{
                if(i >= 1){
                 nums[i][j] = nums[i-1][j] + nums[i-1][j-1];
                
                }
            }
           //上面用i去制约了j，这里每一行的个数都可以使用i来表示的
             Inlist.add(nums[i][j]);
            
   
        }
        list.add(new ArrayList(Inlist));
        }
        return list;
        
    }
}
```