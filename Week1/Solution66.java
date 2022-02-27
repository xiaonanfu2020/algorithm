/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

 

示例 1：

输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1;i>=0;i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i]+1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] tmp = new int[n+1];
        tmp[0]=1;

        return tmp;
    }
}