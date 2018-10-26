package leetcode.ex20validateparentheses;

/**
 * 检查字符串中括号()是否配对,使用计算法,遍历所有元素,初始化计数count=0
 *     当前元素是左括号,计数+1
 *     当前元素时右括号,计数-1
 * (({a,b}[ee]())){{()}}
 */
public class SimpleValidateParentheses {
    public static boolean isValid(String s){
        int n = s.length();
        int count = 0;
        for(int i=0;i<n;i++){
            char current = s.charAt(i);
            if(current=='('){
                count++;
            }else if(current==')'){
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println( isValid("((x))") );//true
        System.out.println( isValid("(12)()") );//true
        System.out.println( isValid("") );//true
        System.out.println( isValid("(()))") );//false
    }
}
