import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    //结果
    List<List<Integer>> ansList = new ArrayList<List<Integer>>();
    int length;//数组长度
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.length = nums.length;
        List<Integer> tempList = new ArrayList();
        //新数组用于标记某个位置上的数是否使用
        int[] vis = new int[length];
        Arrays.sort(nums);
        dfs(nums,vis,tempList);
        return ansList;
    }
    private void dfs(int[] nums,int[] vis, List<Integer> list) {
        //结束出口
        if (list.size() == length) {
            List<Integer> temp = new ArrayList<Integer>(list);
            ansList.add(temp);
            return;
        }
        for(int i=0;i<length;i++) {
            if (vis[i] == 1) {
                continue;
            }
            // 判断同层是不是重复使用
            if(i >0 && nums[i]==nums[i-1] && vis[i-1] == 0) {
                continue;
            }
            list.add(nums[i]);
            vis[i] = 1;
            dfs(nums,vis,list);
            list.remove(list.size()-1);
            vis[i]=0;
        }

    }
}
// @lc code=end

