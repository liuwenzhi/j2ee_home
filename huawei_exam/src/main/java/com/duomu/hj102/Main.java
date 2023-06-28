package com.duomu.hj102;

import java.util.*;

/**
 * 题目描述
 * 如果统计的个数相同，则按照ASCII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
 *
 * 实现以下接口：
 * 输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）
 * 按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出
 * 清空目前的统计结果，重新统计
 * 调用者会保证：
 * 输入的字符串以‘\0’结尾。
 * 输入描述:
 * 输入一串字符。
 *
 * 输出描述:
 * 对字符中的
 * 各个英文字符（大小写分开统计），数字，空格进行统计，并按照统计个数由多到少输出,如果统计的个数相同，则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
 *
 * 示例1
 * 输入
 * aadddccddc
 * 输出
 * dca
 */
class CharacterTest{
    /**字符信息*/
    private char ch;
    /**出现次数*/
    private int num;

    public CharacterTest(char ch,int num){
        this.ch = ch;
        this.num = num;
    }
    public static final Comparator<CharacterTest> SORT = new Increase();
    /**
     * 重写比较器，如果两个字符出现次数不等，小的排在前边大的排在后边
     * 如果出现次数相等，则按照ascii码排序
     */
    private static class Increase implements Comparator<CharacterTest> {
        public int compare(CharacterTest ch1, CharacterTest ch2) {
            if(ch1.num!=ch2.num){
                //按照出现次数降序排序
                return ch2.num - ch1.num;
            }else{
                //按照ASCII码升序排序
                return ch1.ch - ch2.ch;
            }
        }
    }
    @Override
    public String toString() {
        return ch+"";
    }
}
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            Map<Character,Integer> map = new HashMap<>();
            //字符统计后按照key value的方式存入map
            for(int i=0;i<line.length();i++){
                if(map.containsKey(line.charAt(i))){
                    map.put(line.charAt(i),map.get(line.charAt(i))+1);
                }else{
                    map.put(line.charAt(i),1);
                }
            }
            CharacterTest[] cts = new CharacterTest[map.size()];
            Set<Character> set = map.keySet();
            int k = 0;
            for(Character character:set){
                cts[k] = new CharacterTest(character,map.get(character));
                k++;
            }
            Arrays.sort(cts,CharacterTest.SORT);
            for(int i=0;i<cts.length;i++){
                System.out.print(cts[i]);
            }
            System.out.println();
        }
        scanner.close();
    }
}
