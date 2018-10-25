package leetcode.ex3longestsubstring;

import java.util.*;

/**
 * 返回最长子串的大小
 */
public class StringSolution {
    /**
     * 传统暴力解法
     * time O(N^3)
     * space O(min(n,m)) n为字符串长度 m为字符集合
     * 1.从索引0开始,遍历[1,n-1] 得到从0开始而不重复串的长度
     * 2.依次从[1,n-1] 开始执行步骤1 这样得到从每个索引开始 到后面不重复串的长度
     * 3.统计得出答案
     * 4.使用一个方法 判断[i,j]之间是否有重复字符 时间复杂度O(N)
     *
     * 缺点分析：
     * 查询[i,j]之间是否有重复字符串 查询耗费时间过大
     */
    public static int lengthOfLongestSubstring_0(String s){
        int n = s.length();
        int maxLength = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                char currentChar = s.charAt(j);
                if(!searchRepeat(s,i,j)){
                    int currentLength = j-i+1;
                    if(currentLength>maxLength){
                        maxLength = currentLength;
                    }
                }else{
                    break;
                }
            }
        }
        return maxLength;
    }

    /**
     *查找[l,r]之间是否有重复字符 时间复杂度O(N)
     */
    private static boolean searchRepeat(String s,int l,int r){
        Set<Character> set = new HashSet<>();
        for(int i=l;i<=r;i++){
            char currentChar = s.charAt(i);
            if( set.contains(currentChar) ) {
                return true;
            } else{
                set.add(currentChar);
            }
        }
        return false;
    }
    /**
     * 暴力解法优化1.使用hash表 将查找复杂度降低到O(1)
     * time O(N^2)
     * space O(min(m,n)) 字母集m和字符串的最大长度
     * 假设字符串为"abcaeeb"
     * 1.从索引0开始 遍历其后元素到 求从索引0开始 直到出现重复字符的最大长度 此时从索引0开头最长为 abc
     * 2.对每个索引i都进行如1的操作
     * 3.统计 得出答案
     *
     * 缺点分析：
     * 1.实际上没有必要每次都从把j从i开始算
     * 2.因为第i次循环已经可以得出从i开始,最大不重复串是[i,j'-1]
     * 3.这样下一步计算从i+1开始最大不重复串 j应该是从上一步的j'开始 即j=j'
     */
    public static int lengthOfLongestSubstring_1(String s){
        int n = s.length();
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>(); //使用哈希集合 优化查找时间
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){ //注意[i,i]情况 初始的处理巧妙
                char currentChar = s.charAt(j);
                if(!set.contains(currentChar)){ //当前元素不存在于[i,j-1]中
                    int currentLength = j-i+1; //从i开始到当前长度
                    if(currentLength>maxLength){
                        maxLength=currentLength;
                    }
                    set.add(currentChar);//添加当前元素到集合
                }else{ //如果当前元素已经存在于[i,j-1]之中了 那么就不用查后面的元素了
                    break;
                }
            }
            set.clear();//清空集合
        }
        return maxLength;
    }
    /**
     *滑动窗口法:
     * time O(2N)
     * space O( min(n,m) )
     * 假设字符串为"abcaeeb"
     * 1.求从索引0开始的字符,最长不重复串 "abc"  的长度
     * 2.分别求从索引1~n-1开始的字符,最长不重复串的长度
     * 3.统计 得出答案
     * 在暴力解法优化上
     * 第i次循环 已经得出索引i开始的字符 最长不重复串索引是 [i,j-1]
     * 第i=i+1次循环 j的索引应该从 j'开始 而不是从i+1开始
     * 并且第i=i+1次循环 应该剔除集合中第i个元素
     */

    public static int lengthOfLongestSubstring_2(String s){
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int maxLength = 0;
        int i=0,j=0;
        while( i<n && j<n){
            char currentChar = s.charAt(j);
            if(!set.contains(currentChar)){
                int currentLength = j-i+1;
                if(currentLength>maxLength){
                    maxLength = currentLength;
                }
                set.add(currentChar);
                j++;
            }else{
                char iCurrentChar = s.charAt(i);
                set.remove(iCurrentChar);
                i++;
            }
        }
        return maxLength;
    }
    /**
     * 滑动窗口解法的基础上优化
     * 第i次循环 已经得出索引i开始的字符 最长不重复串索引是 [i,j-1] 与j重复的字符索引为i'
     * 下一次循环 j的索引应该从 j'开始 并且i要从i=i'+1开始 而不是i=i+1
     * 这样集合的处理就变得尤为最要,如何将集合的0~i'元素都踢掉呢,改成使用Map<Character,Integer>
     * time O(n)
     * space O( min(m,n) )
     */

    public static int lengthOfLongestSubstring_3(String s){
        int n = s.length();
        int maxLength =0;
        int i=0,j=0;
        Map<Character,Integer> map = new HashMap<>();
        //在[i...j)之间查找是否有包含和[j]处的值相等的元素 设它下标为i'
        while( j<n ){
            char currentChar = s.charAt(j);
            if(!map.containsKey(currentChar)){ //Map中不包含这个元素,适当更新
                int currentLength = j-i+1;
                if(currentLength>maxLength)
                    maxLength = currentLength;
            }else{//[0...j)之间找到和[j]处相等的值
                int target =map.get(currentChar);
                if(target>=i) { //处于[i..j)直接,i直接变成i'+1
                    i = target + 1;
                }else{ //处于[0...i)直接 应该和不包含这个元素的情况一致处理
                    int currentLength = j-i+1;
                    if(currentLength>maxLength)
                        maxLength = currentLength;
                }
            }
            map.put(currentChar,j);
            j++;
        }
        return maxLength;
    }
    //上述方法中 优化,改成ASCII字符表 直接存储index['c'] = j;
    //如何巧妙存储char 和 索引的关系
    //我们将 index[currentChar]=j+1 这样当value=0代表找不到
    //每次查找到的 target-1=实际索引
    public static int lengthOfLongestSubstring_4(String s){
        int n = s.length(),maxLength=0;
        int[] index = new int[128];
        //[i,j)直接查找是否有和[j]一样的

        for(int j=0,i=0;j<n;j++){
            char currentChar = s.charAt(j); //" "
            int target = index[currentChar]; //
            if(target-1>=i){
                i = target;
            }else{
                int currentLength = j-i+1;
                if(currentLength>maxLength)
                    maxLength = currentLength;
            }
            index[currentChar]=j+1;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_4("pwwkew"));//3
        System.out.println(lengthOfLongestSubstring_4("dvdf"));//3
        System.out.println(lengthOfLongestSubstring_4("bbb"));//1
        System.out.println(lengthOfLongestSubstring_4("tmmzuxt"));//5
        System.out.println(lengthOfLongestSubstring_4(" "));//1
    }
}
