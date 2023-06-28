package com.duomu.hj87;

import java.util.Scanner;

/**
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 * 一、密码长度:
 * 5 分: 小于等于4 个字符
 * 10 分: 5 到7 字符
 * 25 分: 大于等于8 个字符
 * 二、字母:
 * 0 分: 没有字母
 * 10 分: 全都是小（大）写字母
 * 20 分: 大小写混合字母
 * 三、数字:
 * 0 分: 没有数字
 * 10 分: 1 个数字
 * 20 分: 大于1 个数字
 * 四、符号:
 * 0 分: 没有符号
 * 10 分: 1 个符号
 * 25 分: 大于1 个符号
 * 五、奖励:
 * 2 分: 字母和数字
 * 3 分: 字母、数字和符号
 * 5 分: 大小写字母、数字和符号
 * 最后的评分标准:
 * >= 90: 非常安全
 * >= 80: 安全（Secure）
 * >= 70: 非常强
 * >= 60: 强（Strong）
 * >= 50: 一般（Average）
 * >= 25: 弱（Weak）
 * >= 0:  非常弱
 * 对应输出为：
 * VERY_SECURE
 * SECURE,
 * VERY_STRONG,
 * STRONG,
 * AVERAGE,
 * WEAK,
 * VERY_WEAK,
 * 请根据输入的密码字符串，进行安全评定。
 * 注：
 * 字母：a-z, A-Z
 * 数字：-9
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 *
 * !"#$%&'()*+,-./     (ASCII码：0x21~0x2F)
 *
 * :;<=>?@             (ASCII<=><=><=><=><=>码：0x3A~0x40)
 *
 * [\]^_`              (ASCII码：0x5B~0x60)
 *
 * {|}~                (ASCII码：0x7B~0x7E)
 *
 * 接口描述：
 *
 *
 * Input Param
 * String pPasswordStr:    密码，以字符串方式存放。
 *
 * Return Value
 * 根据规则评定的安全等级。
 *
 *
 *
 * public static Safelevel GetPwdSecurityLevel(String pPasswordStr)
 * {
 *return null;
         *}
         *输入描述:
         *输入一个string的密码
         *
         *输出描述:
         *输出密码等级
         *示例1
         *输入
         *38$@NoNoNo
         *输出
         *VERY_SECURE
 *
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String code = scanner.next();
            System.out.println(scoreAndLevel(code));
        }
        scanner.close();
    }

    /**
     * 统计密码得分，最后获取级别
     */
    private static String scoreAndLevel(String code){
        int score = 0;
        score += getLengthScore(code);
        score += getScoreByLetterAndNumberAndSymbol(code);
        return level(score);
    }

    /**
     * 获取密码的长度评分
     */
    private static int getLengthScore(String code){
        if(code.length()<=4){
            return 5;
        }
        if(code.length()>=5&&code.length()<=7){
            return 10;
        }
        if(code.length()>=8){
            return 25;
        }
        return 0;
    }

    /**
     * 获取字母，符号和数字相关的评分
     */
    private static int getScoreByLetterAndNumberAndSymbol(String code){
        int score = 0;
        //大写字母出现次数
        int bigLetters=0;
        //小写字母出现次数
        int smallLetters=0;
        //数字出现次数
        int nums=0;
        //符号出现次数
        int symbols = 0;
        for(char c:code.toCharArray()){
            if(c>='0'&&c<='9'){
                //密码中包含数字
                nums++;
            }else if(c>='A'&&c<='Z'){
                //密码中包含大写字母
                bigLetters++;
            }else if(c>='a'&&c<='z'){
                //密码中包含小写字母
                smallLetters++;
            }else if (c >= 0x21 && c <= 0x2F ||c >= 0x3A && c <= 0x40 || c >= 0x5B && c <= 0x60 ||c >= 0x7B && c <= 0x7E){
                //密码中包含字符，字符的ASCII码在题干中都有，注意这种比较代码写法
                symbols++;
            }
        }
        //根据数字评分
        if(nums==1){
            score+=10;
        }else if(nums>1){
            score+=20;
        }
        /*根据字母评分*/
        if(bigLetters >0 &&smallLetters==0||bigLetters == 0&&smallLetters>0){
            //全是大写字母或者全是小写字母，注意：不用大小写字母长度等于密码长度
            score+=10;
        }else if(bigLetters>0&&smallLetters>0){
            //大小写字母混合，不用全是字母
            score+=20;
        }
        /**根据符号评分*/
        if(symbols==1){
            score+=10;
        }else if(symbols > 1){
            score+=25;
        }

        /**根据奖励评分*/
        if(bigLetters>0&&smallLetters>0&&nums>0&&symbols>0){
            //大小写字母数字和符号，这几项长度加起来不用等于总长度
            score+=5;
        }else if(bigLetters>0&&nums>0&&symbols>0||smallLetters>0&&nums>0&&symbols>0){
            //字母数字和符号，这几项长度加起来不用等于总长度
            score+=3;
        }else if(bigLetters>0&&nums>0||smallLetters>0&&nums>0){
            //字母和数字，这几项长度加起来不用等于总长度
            score+=2;
        }
        return score;
    }

    /**
     * 通过具体密码得分获取级别信息
     */
    private static String level(int score){
        if(score >= 90){
            return "VERY_SECURE";
        }else if(score >= 80){
            return "SECURE";
        }else if(score >= 70){
            return "VERY_STRONG";
        }else if(score >= 60){
            return "STRONG";
        }else if(score >= 50){
            return "AVERAGE";
        }else if(score >= 25){
            return "WEAK";
        }else{
            return "VERY_WEAK";
        }
    }
}
