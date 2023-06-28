package com.duomu.hj25;
import java.util.*;
/**
 * 题目描述
 * 信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
 *
 * 采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。
 *
 * 请注意本题有多组输入用例。
 * 输入描述:
 * ﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~0xFFFFFFFF，序列个数不限
 *
 * 输出描述:
 * ﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I：
 *
 * I整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I为231，那么I包含了R<i>，条件满足 。
 *
 * 按R<i>从小到大的顺序:
 *
 * (1)先输出R<i>；
 *
 * (2)再输出满足条件的I的个数；
 *
 * (3)然后输出满足条件的I在I序列中的位置索引(从0开始)；
 *
 * (4)最后再输出I。
 *
 * 附加条件：
 *
 * (1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I，索引大的需要过滤掉
 *
 * (2)如果没有满足条件的I，对应的R<i>不用输出
 *
 * (3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)
 *
 *
 *
 * 序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
 *
 * 序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
 *
 * 输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
 *
 * 说明：
 *
 * 30----后续有30个整数
 *
 * 3----从小到大排序，第一个R<i>为0，但没有满足条件的I，不输出0，而下一个R<i>是3
 *
 * 6--- 存在6个包含3的I
 *
 * 0--- 123所在的原序号为0
 *
 * 123--- 123包含3，满足条件
 *
 * 示例1
 * 输入
 * 复制
 * 15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
 * 5 6 3 6 3 0
 * 输出
 * 复制
 * 30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            //序列I的个数，用整形接收
            int rn = sc.nextInt();
            //数组st存储序列I中的元素，这时候是使用字符串进行接收
            String[] st = new String[rn];
            for(int i=0;i<rn;i++){
                st[i] =sc.next();
            }
            //序列R的个数，用整形接收
            int jn = sc.nextInt();
            //用TreeSet存储序列R，也是使用整形进行接收序列中的元素，便于进行排序和去重，题目中说道存在相同的R<i>只保留较小的，所以这里还要去重
            TreeSet<Integer> set = new TreeSet<>();
            for(int i=0;i< jn;i++){
                set.add(sc.nextInt());
            }
            StringBuffer str = new StringBuffer();
            //遍历R序列的TreeSet集合
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()){
                //在这里进行类型转换，将整形转成String类型
                String e = iterator.next().toString();
                str.append(getRes(e,st));
            }
            //结果设置比较巧：把输出字符串按照空格拆分，得到一个数组长度，就是实际字符串长度做输出
            //注意一个细节：按照getRes的实现方式，在返回字符串的最后会有一个空格，这个不会被算到最
            //终的长度中去，可以参考下Test类中的内容，如果这个空格在开头，拆分后会单独算一个空字符，算到length里边来
            System.out.println(str.toString().split(" ").length+" "+str);
        }
    }
    /**
     * 调用该方法的循环遍历R<i>,该方法对I列表中每一个元素判断是否包含R<i>
     */
    public static StringBuffer getRes(String e,String[] st){
        StringBuffer res = new StringBuffer();
        //这里需要使用LinkedHashMap保证顺序，本题有一个坑点：在于这句话：(3)然后输出满足条件的I在I序列中的位置索引(从0开始)；
        //这个地方需要让i按照从小到大的顺序进行输出，用LinkedHashMap最方便，也可以参考hj8采用TreeMap。这里的i肯定不会重复，所以没有被合并。用LinkedHashMap最适合
        //TreeMap<Integer,String> map = new TreeMap<>();
        LinkedHashMap<Integer,String> map = new LinkedHashMap<>();
        for(int i=0;i<st.length;i++){
            if(st[i].contains(e)){
                map.put(i,st[i]);
            }
        }
        if(map.size()>0) {
            //拼接元素R<i>，R<i>被包含的次数
            res.append(e + " " + map.size() + " ");
        }
        for(Map.Entry entry : map.entrySet()){
            //拼接包含R<i>的I的位置和元素信息
            res.append(entry.getKey()+" "+entry.getValue()+" ");
        }
        return res;
    }
}
