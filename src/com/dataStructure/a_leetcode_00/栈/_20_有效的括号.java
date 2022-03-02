package com.dataStructure.a_leetcode_00.栈;


import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {

    public static void main(String[] args) {
        System.out.println(isValid("()"));          // true
        System.out.println(isValid("()[]{}"));      // true
        System.out.println(isValid("(]"));          // false
        System.out.println(isValid("([)]"));        // false
        System.out.println(isValid("{[]}"));        // true
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i = 0; i<len; i++){
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '[') {  // 左字符进栈
                stack.push(c);
            }else {                                 // 右字符出栈
                if (stack.size() == 0) {
                    return false;                   // 栈为空表示没有左字符与右字符匹配
                }else {
                    char cap = stack.pop();
                    if((c == ')' && cap == '(') || (c == '}' && cap == '{') || (c == ']' && cap == '[')) {
                        continue;
                    }else{                          // 左字符与右字符不匹配
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();                     // 循环完成之后，判断栈是否为空
    }


    public boolean isValid2(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            s.replace("{}", "");
            s.replace("[]", "");
            s.replace("()", "");
        }
        return s.isEmpty();
    }
}
