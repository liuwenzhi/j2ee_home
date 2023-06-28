package lkhwtk.leetcode470;

import java.util.Random;

public class SolBase {
    /**
     * 生成1到7之间随机数方法。注意:random的nextInt方法，
     * random.nextInt(7)是生成[0,6]之间的随机数字，即[0,7)
     */
    public int rand7(){
        Random random = new Random();
        return random.nextInt(7)+1;
    }
}
