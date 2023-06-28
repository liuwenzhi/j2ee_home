package com.duomu.hj95;

/**
 * 题目描述
 * 考试题目和要点：
 *
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
 *
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。
 *
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如6007.14，应写成“人民币陆仟零柒元壹角肆分“。
 * 4、10应写作“拾”，100应写作“壹佰”。例如，1010.00应写作“人民币壹仟零拾元整”，110.00应写作“人民币壹佰拾元整”
 * 5、十万以上的数字接千不用加“零”，例如，30105000.00应写作“人民币叁仟零拾万伍仟元整”
 *
 * 本题含有多组样例输入。
 *
 * 输入描述:
 * 输入一个double数
 *
 * 输出描述:
 * 输出人民币格式
 *
 * 示例1
 * 输入
 * 151121.15
 * 10012.02
 * 输出
 * 人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
 * 人民币壹万零拾贰元贰分
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 本题和hj42题有一定相似性
 */
public class Main{
    /**人民币汉字和数组下标对上，直接对应0~9*/
    private static String[] chineseNum = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    /**人民币单位，个，十，百，千，万，十万，百万，千万（十万百万千万直接用十百千单位即可，万位会单独拼接）*/
    private static String[] chineseUnit = {null,"拾","佰","仟","万","拾","佰","仟","亿"};
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            //zn是录入的整数部分，小数点左边数字
            String zn;
            //sn是录入的小数部分，小数点右边数字，sn有可能没有被初始化，这里附一个null值
            String sn=null;
            if(str.contains(".")){
                String[] split=str.split("\\.");
                zn=split[0];
                sn=split[1];
            }else{
                //如果录入数字没有小数点，则直接录入zn
                zn=str;
            }
            String res=format(zn);
            StringBuilder sb=new StringBuilder(res);
            if(!"人民币".equals(res)){
                //整数部分有数字后边就拼一个元
                sb.append("元");
            }
            if(sn==null||"00".equals(sn)) {
                //不包含小数位，拼接一个整
                sb.append("整");
            }else{
                //包含小数位拼一个角和分
                int jn=Integer.parseInt(String.valueOf(sn.charAt(0)));
                if(jn!=0){
                    sb.append(chineseNum[jn]);
                    sb.append("角");
                }
                int fn=Integer.parseInt(String.valueOf(sn.charAt(1)));
                if(fn!=0){
                    sb.append(chineseNum[fn]);
                    sb.append("分");
                }
            }
            System.out.println(sb.toString());
        }
    }
    /**
     * 对输入的整数部分进行格式化，小数部分有一个角分，不单独格式化处理，入参是整数部分
     */
    public static String format(String zn){
        //读数字以人民币开头
        StringBuilder sb=new StringBuilder("人民币");
        //0标志位，多个0读一个
        boolean hasZero=false;
        if("0".equals(zn)){
            //0元直接返回
            return sb.toString();
        }
        for(int i=0;i<zn.length();i++){
            //统计位数，位数到chineseUnit数组去读取，zn整数和数组顺序是正好反向的，数字低位是位数高位，需要到单位数组的高位中读取
            int unitIndex=zn.length()-i-1;
            //n:从左往右读数字，读成整数，注意读数字和上边的位数的配合，数字需要从前往后读，数位是从后往前读，比如1000，数字是1，第0位，位数是3，所以读成1千
            int n=Integer.parseInt(String.valueOf(zn.charAt(i)));
            switch(n){
                case 0:
                    if(!hasZero&&unitIndex!=4){
                        //4是万位，如果万位是0，后边需要接单位，不能置hasZero==0，这一点非常细，不设置这个会导致类似数字：100110.00
                        //30105000.00读不出万位
                        sb.append(chineseNum[0]);
                        hasZero=true;
                    }
                    break;
                case 1:
                    //1的特殊处理：1拾直接读拾，包括十位和十万位
                    if(!"拾".equals(chineseUnit[unitIndex])){
                        sb.append(chineseNum[1]);
                    }
                    hasZero=false;
                    break;
                default:
                    //除了0和1之外，其他数字直接拼，后边接单位
                    sb.append(chineseNum[n]);
                    hasZero=false;
                    break;
            }
            //chineseUnit[0]=null，个位后边不用拼单位，其他非数字后边都拼接一个单位
            if(chineseUnit[unitIndex]!=null){
                //除了个位外其它位不是0位拼单位
                if(!hasZero) sb.append(chineseUnit[unitIndex]);
            }
        }
        if(sb.charAt(sb.length()-1)=='零'){
            //最后一位是零不读
            return sb.substring(0,sb.length()-1);
        }else
            return sb.toString();
    }

}
