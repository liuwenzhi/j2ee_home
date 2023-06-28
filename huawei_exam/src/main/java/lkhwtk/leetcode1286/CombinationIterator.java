package lkhwtk.leetcode1286;

/**
 * 1286. 字母组合迭代器
 * 参考题解：二进制编码，不用求出全排列
 * 注意题解中回复信息，有一个java版本代码。
 * 核心思路：假设原有入参字符串长度为4，计算组合长度为2，则先做出来一个1111，然后让1111递减，一直减到1100
 * 然后根据next的个数一次一次的取值，取值的时候需要将1100这样的数字再解码成具体的字母
 */
public class CombinationIterator {

    /**
     * 入参字符换长度对应的全1二进制编码数字，比如abcd:1111
     */
    private int code;
    /**
     * 入参组合字母长度
     */
    private int size;
    /**
     * 入参字符串字符数组
     */
    private char[] charArr;
    /**
     * 入参字符串长度
     */
    private int len;

    public CombinationIterator(String characters, int combinationLength) {
        this.charArr = characters.toCharArray();
        this.len = characters.length();
        //abcd->1111，1左移四位，然后-1
        this.code = (1 << len) - 1;
        this.size = combinationLength;
    }

    /**
     * 统计一个整数code里边，1的个数，最末位和1做与计算（实际是code直接和1做与计算），code每次右移一位
     */
    private int countOne(int code){
        int count = 0;
        while(code != 0){
            count = count +  (code & 1);
            code = code >> 1;
        }
        return count;
    }

    /**
     * 解码字母，11-ab
     */
    private String decode(int code){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int len = charArr.length;
        while(code != 0){
            if ((code & 1) == 1){
                //StringBuilder从0前边插入
                sb.insert(0, charArr[len -1 - idx]);
            }
            idx++;
            code = code >> 1;
        }
        return sb.toString();
    }

    /**
     * 取下一个组合，while循环让1111降到1100，然后一次取一个，取了之后code--，还要注意一个点：1100后边可能有三个1的情况，比如0111,1011，所以每次进入该方法都需要有while循环处理，
     * 然后包含1的个数还可能有1个1的情况，比如1000，所以一定要找到==size，题目的提示信息中，已经给出了：保证每次调用next时都会存在下一个字母组合，所以不用考虑更小的情况
     */
    public String next() {
        //让code递减，一直减到1的个数等于size（即：入参组合长度）
        while(code > 0 && countOne(code) != size){
            code--;
        }
        String next = decode(code);
        code--;
        return next;
    }

    /**
     * 判断是否存在下一个字母组合，注意size是入参长度，code在next方法中已经在不断递减，
     * 这里直接考虑从1111到1100这个过程中需要code做递减，能够满足code递减之后包含两个1，比如：1001,1100,1010,0101，就满足条件，如果在循环跳出后，最终code<0，则没有next了
     * 细节注意下：1100后边可能有三个1的情况，比如0111,1011，所以每次进入该方法都需要有while循环处理，然后包含1的个数还可能有1个1的情况，比如1000，所以一定要找到==size，
     * 另外在题目的提示信息中，已经给出了：保证每次调用next时都会存在下一个字母组合，所以不用考虑更小的情况
     */
    public boolean hasNext() {
        while(code > 0 && countOne(code) != size){
            code--;
        }
        return code > 0;
    }

    public static void main(String[] args){
        CombinationIterator combinationIterator = new CombinationIterator("abc",2);
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
    }
}
