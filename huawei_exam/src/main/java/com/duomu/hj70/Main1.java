package com.duomu.hj70;

import java.util.*;

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            List<matrix> list = new LinkedList<>();
            for (int i = 0; i < n; i++){
                int mcur = in.nextInt();
                int ncur = in.nextInt();
                list.add(new matrix(mcur, ncur));
            }
            Deque<matrix> stack = new LinkedList<>();
            int res = 0;
            String s = in.next();
            for (int i = s.length() - 1; i >= 0; i--){
                if (s.charAt(i) == ')'){
                    stack.offerLast(new matrix(-1,-1));
                }else if (s.charAt(i) == '('){
                    res += helper(stack);
                }else{
                    int cur = (int)(s.charAt(i) - 'A');
                    stack.offerLast(list.get(cur));
                }
            }
            System.out.println(res);
        }
    }

    private static int helper(Deque<matrix> stack){
        matrix pre = stack.pollLast();
        int res = 0;
        while(true){
            matrix cur = stack.pollLast();
            if (cur.helper()) break;
            res += pre.mul(cur);
            pre = new matrix(pre.m, cur.n);
        }
        stack.offerLast(pre);
        return res;
    }
}

class matrix{
    int m;
    int n;
    matrix(int m, int n){
        this.m = m;
        this.n = n;
    }
    int mul(matrix m2){
        return (this.m * this.n * m2.n);
    }
    boolean helper(){
        return this.m == -1;
    }
}
