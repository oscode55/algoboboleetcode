package leetcode.ex20validateparentheses;

import java.util.HashMap;
import java.util.Stack;
import java.util.Map;
/**
 * 有效的括号
 * 给定一个只包括'(',')','{','}','[',']'的字符串
 * 1.左括号必须用相同的右括号闭合
 * 2.左括号必须以争取的顺序闭合
 */
public class ValidateParentheses {
    /**
     * 使用栈结构,遍历字符串({})(({}[]))
     *   若当前符号为左括号则推入栈,
     *   若为右括号则弹栈并与当前对比,是否配对
     *     如果不配对,则字符串是非法的表达式
     *     如果配对,则继续遍历,直到完
     *   检查栈
     *     如果栈不为空,则代表有左括号没有找到配对的右括号,非法
     *     如果栈为空,则代表所有左括号都找到配对的右括号,合法
     */
    public static boolean isValidMe(String s){
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char currentChar = s.charAt(i);
            if( currentChar=='(' || currentChar=='[' || currentChar=='{'){
                stack.push(currentChar);
            }else{
                if(stack.isEmpty())
                    return false;
                char popChar = stack.pop();
                if( !isOk(popChar,currentChar)){
                    return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
    private static boolean isOk(char x,char y){
        if( (x=='{'&&y=='}') || (x=='['&&y==']') || (x=='('&&y==')') ){
            return true;
        }
        return false;
    }
    //代码优化,左括号和右括号 可以使用Key-Value 哈希表
    public static boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++){
            char current = s.charAt(i);
            if( map.containsKey(current) ){//左括号
                stack.push(current);
            }else{ //当前是右括号 和 弹栈元素(左) 对比
                if( stack.isEmpty()) return false;//右括号元素多出来了
                char topElement = stack.pop();
                char rightElement = map.get(topElement);//应该匹配的右括号类型
                if(current!=rightElement)
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println( isValid("{}[]{{}}") );//true
        System.out.println( isValid("()") );//true

    }
}
