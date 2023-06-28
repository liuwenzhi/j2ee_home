package 输入练习;

import java.util.Scanner;

/**
 * 备注：本题没有说明整形数字占几个字节，用int类型只能跑完50%的测试用例，用long能全跑完。
 * byte	1字节，char	2字节，short	2字节，int	4字节，float	4字节
 * long	8字节，double	8字节，boolean	至少1字节
 */
public class Test11 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            System.out.println(a+b);
        }
    }
}
