package QueueAndStack.Stack;

import java.util.Stack;

public class 逆波兰表达式求值 {
        public int evalRPN(String[] tokens) {
            Stack<Integer> num = new Stack<>();
            Integer res = 0;
            int first = 0;
            int second = 0;
            for(int i = 0;i < tokens.length;i ++){
                char ch = tokens[i].charAt(0);
                if(isNumber(tokens[i])){
                    num.push(Integer.parseInt(tokens[i]));
                } else if(ch == '+'){
                    res = num.pop() + num.pop();
                    num.push(res);
                } else if(ch == '-'){
                    first = num.pop();
                    second = num.pop();
                    res = second - first;
                    num.push(res);
                } else if(ch == '*'){
                    res = num.pop() * num.pop();
                    num.push(res);
                } else if(ch == '/'){
                    first = num.pop();
                    second = num.pop();
                    res = second / first;
                    num.push(res);
                }
            }
            return num.pop();
        }

        private static boolean isNumber(String s){  //防止负数的出现 -11 -23，不能通过判断首个符号是否为数字，看了答案没结果又去问了AI才搞清楚的
            return !(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
        }
}


/*
注意细节
细节也是成功的一部分
即使有了那些关键性想法而没有基础的严谨的作风也会失败
*/