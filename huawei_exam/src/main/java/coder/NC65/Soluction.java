package coder.NC65;
/**
 * 斐波那契数列：0、1、1、2、3、5、8、13、21、34...
 * 注意和以前接触的斐波那契数列存在不同，这里存在一个第0项
 */
public class Soluction {
    /**
     * 递归实现斐波那契数列，注意这种方式会使计算量呈现指数性增长，参考数据结构教材304页树形解析的说明
     */
    public int Fibonacci(int n) {
        if(n<=1){
            return n;
        }else{
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }

    /**
     * 采用动态规划的方式实现斐波那契数列，避免出现计算量指数增长
     * 通过一种记录的方式拿到n之后，能统计到n-1和n-2
     */
    public int Fibonacci1(int n) {
        //第一步：0和1返回对应的n
        if(n<=1){
            return n;
        }
        int last = 1;
        int nextToLast = 0;
        int answer = 1;
        //这部分不难理解，把前几次循环的结果自己写出来就能看懂，i从1开始，不能缺少任何一步累加过程
        for(int i=1;i<n;i++){
            answer = last+nextToLast;
            //在每次循环的过程中，算好answer的值之后，要把last和nextToLast两个值计算成下一次循环要被累加的值
            nextToLast = last;
            last = answer;
        }
        return answer;
    }
    public static void main(String[] args){
        Soluction soluction = new Soluction();
        System.out.println(soluction.Fibonacci1(3));
    }
}
