```
/**
 * Project:
 * Author : zhaozhen
 * Email  : 
 * Date   : 2020/9/19
 * 
 * 
 * 解题思路: 常规题目 层次遍历+使用一个标识符 step++ 来通过奇偶数确定层次遍历的方向
 * 
 * 
 */
public class leetcode103 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null){
            queue.add(root);
            int step = 0;
            while(queue.size() != 0){
                ArrayList<Integer> temp = new ArrayList<>();
                int size = queue.size();
                for(int i = 0;i < size;i++){
                    TreeNode cur = queue.poll();
                    temp.add(cur.val);
                    if(cur.left != null){
                        queue.add(cur.left);
                    }
                    if(cur.right != null){
                        queue.add(cur.right);
                    }
                }
                if(step % 2 == 1){ //右到左
                    Collections.reverse(temp);
                }
                res.add(temp);
                step++;
            }
        }

        return res;
    }
}

```