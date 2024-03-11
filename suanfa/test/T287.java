package suanfa.test;

import java.util.HashSet;
import java.util.Set;

public class T287 {
    /**
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
     *
     *
     *
     * 示例 1：
     * 输入：nums = [1,3,4,2,2]
     * 输出：2
     *
     * 示例 2：
     * 输入：nums = [3,1,3,4,2]
     * 输出：3
     *
     *
     * 提示：
     * 1 <= n <= 105
     * nums.length == n + 1
     * 1 <= nums[i] <= n
     * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    //暴力解题方法:
    public static int findDuplicate(int[] nums) {
        int[] temp = new int[]{};
        for (int i = 0; i <= nums.length-1; i++) { //0-4
            for (int j = i+1; j <= nums.length-1; j++) { //1-4
                if(nums[j] == nums[i]){ //3
                    return nums[i];
                }
            }
        }
        return -1;
    }

    //哈希表
    public static int findDuplicate1(int[] nums) {
        Set<Integer> temp = new HashSet<>();
        for (int num : nums) {
            if(temp.contains(num)){
                return num;
            }
            temp.add(num);
        }
        return -1;
    }

    //二分法
    public static int findDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int mid = (left + right) /2;
        int count = 0;

        while (left < right){
            for (int num : nums) {
                if(num <= mid){
                    count ++;
                }
            }
            if(count > mid){
                right = mid;
            }else{
                left = mid +1;
            }
        }
        return left;
    }

    //链表成环
    public static int findDuplicate3(int[] nums) {
        int slow = nums[0];
        int faster = nums[nums[0]];
        while(slow != faster){
            slow = nums[slow];
            faster = nums[nums[faster]];
        }

        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}
