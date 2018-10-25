package leetcode.ex1twosum;


import java.util.HashMap;
import java.util.Map;

/**
 *ex01: 两数之和问题
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 示例：
 *  给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
 */
public class TwoSum {
    /**
     * 暴力解法: 对于每个元素 遍历剩余部分
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     */
    public static int[] twoSum(int[] nums, int target){

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if( nums[i]+nums[j] == target ){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 两遍哈希表 将元素先存入哈希表
     * 遍历元素 查找哈希表中是否存在符合
     * 时间复杂度: O(n) 放入哈希表,查找只要O(1)
     * 空间复杂度: O(n) 放入n个元素
     */
    public static int[] twosumByTwiceHash(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            //该目标元素不能是nums[i]本身 如果没有后半部分判断 那么 所查找的目标元素和当前元素是同一个
            if(map.containsKey(complement) && map.get(complement)!=i ){
                return new int[] {i,map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表
     * 迭代时将元素插入到表，并检查表中是否有对应目标元素
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static int[] twosumByOnceHash(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            //不需要判断,因为不可能放进去和当前一样的元素
            if(map.containsKey(complement) ){
                return new int[] {i,map.get(complement)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int target = 10;
        int[] array=new int[]{1,8,2,3,4,5,6,7};//测试数据
//        System.out.println(Arrays.toString( twoSum(array,10) ));
//        System.out.println(Arrays.toString(twosumByTwiceHash(array,2)));
    }
}
