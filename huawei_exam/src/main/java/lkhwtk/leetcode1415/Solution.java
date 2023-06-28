package lkhwtk.leetcode1415;

/**
 * 1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
 * 参考题解：长度为 n 的开心字符串中字典序第 k 小的字符串（看图写作）
 * 在题解给出的图中，可以这么来理解：如果根节点是a，那么子节点肯定是bc，如果根节点是b那么子节点肯定是ac
 * 如果根节点是c，那么子节点肯定是ab，这个套路适用于全部子树
 */
public class Solution {
    public String getHappyString(int n, int k) {
        //3*2^(n-1)，用左移*2来模拟
        int count=3<<(n-1);
        //如果k大于组合总数量，返回空字符串
        if(k>count) {
            return "";
        }
        char[] result=new char[n];
        //状态0,1,2分别表示a,b,c
        int[][] stateTab=new int[][]{{1,2},{0,2},{0,1}};
        //转移参数：0表示下一个取较小的字符，1表示下一个取较大的字符
        int index=0;
        //序号k-1,表示第k大
        int order=k-1;
        //通过位移计算节点第k大节点位于哪棵树，<=>order/2^(n-1)，位移过程中不用考虑是否带有符号，取值范围0,1,2，代表a,b,c
        int state= order>>(n-1);
        //确认是哪棵树之后，就可以得到第一个字母，index从0开始，取完当前值之后再自增
        result[index++]=(char)(state+'a');
        //获取其在树中的位置<=>order% 2^(n-1)，取余这个二进制算法记一下，2的n-1次幂-1再和order进行与操作
        int node=order&((1<<(n-1))-1);
        for(int i=n-2;i>=0;i--){
            //(node >> i) & 1取二进制第i位，state的初始值为节点所在树的根节点，这个时候可取的值是stateTab数组中state这一行的的元素
            //这里又是一个非常巧妙的位移设计，只取node二进制的第i位，0就是0,1就是1，对应startTab数组中下标0和1的位置，基于stateTab的设计，
            //做到了0取小的，1取大的，可以参考本题解中的黑体字部分理解这一块，for循环中，i从n-2开始到0结束，不是从n-1开始到1结束，因为第
            //一位字母已经确认，从第二个字母开始找，state是每一次确认的上一个字母在stateTab数组中的行，第一次进入循环，state是25行计算的
            //树的根节点，每次循环中state的值都会改变，每次换到stateTab另一个行去取值
            state=stateTab[state][(node >> i) & 1];
            result[index++]=(char)(state+'a');
        }
        return String.valueOf(result);

    }

    public static void main(String[] args){
        /*int tree = 2;
        System.out.println(tree >> 1);
        System.out.println((tree >> 1)&1);
        System.out.println(tree >> 0);
        System.out.println((tree >> 0)&1);*/
        System.out.println((char)(1+'a'));
    }
}
