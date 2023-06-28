package lkhwtk.leetcode385;

/**
 * 385. 迷你语法分析器
 * 本题题目很不好理解，实际不难。NestedInteger就是作为一个工具类，不用实现它，也不用管它怎么实现自己的逻辑
 * 本题在提交执行的时候，把NestedIntegerLocal都换成NestedInteger，线上是有问题还是有特殊处理不太好说，总之
 * 可以直接new NestedInteger() 这个接口
 */
public class Solution {
    /**递归函数通过字符数组和cur下标确定要处理的位置*/
    private char[] chars;
    private int cur = 0;
    public NestedInteger deserialize(String s) {
        chars = s.toCharArray();
        //本身不是一个集合而是一个整数的情况
        if(chars[0]!='[') {
            //下边两种方式返回都可以，这里就是测试下setInteger这个方法
            NestedInteger nest = new NestedIntegerLocal();
            nest.setInteger(Integer.valueOf(s));
            return nest;
            //return new NestedIntegerLocal(Integer.valueOf(s));
        }
        //调用递归函数返回根集合，注意：按照题目，如果要处理的字符串是一个列表，则一定是以[开始，这个时候，
        // getNest方法里边就不用遍历第一个和最后一个元素，开始和结束符号：[ ] 没有意义
        return getNest();
    }
    public NestedInteger getNest(){
        NestedInteger nest = new NestedIntegerLocal();
        //num用于缓存用逗号分割的整数类型的值
        int num = 0;
        //当前记录的整数的符号，1代表整数，-1代表负数
        int sign = 1;
        //while条件中表明不遍历最后一个元素
        while(cur!=chars.length-1){
            //直接自增，不遍历第一个元素
            cur ++;
            //需要单独处理五种情况
            if(chars[cur]==','){
                //逗号直接下一次
                continue;
            }else if(chars[cur]=='['){
                //遇到[递归获取子集合
                nest.add(getNest());
            }else if(chars[cur]==']'){
                //遇到]返回对象
                return nest;
            }else if(chars[cur]=='-'){
                //负号返回一个-1用于做乘法
                sign = -1;
            }else{
                //是数字的情况，字符'0'的ASCII码是48，可以直接-48，在当前数字遍历完之前，每拿出来一个字符转成整数之后，都需要*sign，
                num = 10*num + sign * (chars[cur]-'0');
                //如果下一个字符是,或者]说明当前数字已经记录完了，需要加入集合中
                if(chars[cur+1]==','||chars[cur+1]==']'){
                    nest.add(new NestedIntegerLocal(num));
                    num = 0;
                    sign = 1;
                }
            }
        }
        return null;
    }
}
