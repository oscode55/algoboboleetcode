package leetcode.ex859buddystring;

import util.Util;

/**
 * @Author: myname
 * @Date: 2018/11/7 9:17
 * 给定两个由小写字母构成的字符串 A 和 B ，
 * 只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 */
public class BuddyString {
    /**
     *
     * @param A
     * @param B
     * @return
     * time: O(N)
     * space: O(1)
     * 长度必须相等 否则不可能实现交换一处位置相等的情况
     * 分两种情况:
     *   1.A与B相等 这样只需要保证A串中 有相同的字符
     *   2.A与B串不等 这样需要保证A与B串只有两个地方的字符不同,并且交换后相等
     *     使用字符相减 如果这两个索引位置相减 得到两个差 两个差的和等于0就符合
     */
    public static boolean buddyString(String A,String B) {
        int n = A.length();
        if(n!=B.length()) //两串长度不等
            return false;

        int count = 0;//统计几处索引下字符不一致
        int sum = 0;//辅助判断是否存在交换相等的情况
        int[] indexes = new int[26];//只有26个字母的情况

        //若A串和B串完全相等,只需判断A中是否有相同的字符
        if(A.equals(B)){
            for(int i=0;i<n;i++){
                char currChar = A.charAt(i);
                int index = indexes[currChar-'a'];
                if(index==0) {//不存在这个字符则添加
                    indexes[currChar - 'a'] = i + 1;
                }else{ //存在这个字符
                    return true;
                }
            }
        }else{//字符串不完全相同,判断是否存在交换相等情况 且只能有两个位置不同
            for(int j=0;j<n;j++){
                char currA = A.charAt(j);
                char currB = B.charAt(j);
                int sub = currA - currB;
                if(sub!=0){
                    count++;
                    sum+=sub;
                }
            }
            if( count==2 && sum==0 ){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(buddyString("aa","aa"));//true
        System.out.println(buddyString("ab","ab"));//false
    }
}
