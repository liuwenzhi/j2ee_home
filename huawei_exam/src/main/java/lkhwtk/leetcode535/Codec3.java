package lkhwtk.leetcode535;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 使用随机数加密，思路和Codec、Code2基本一致，计算随机数相对更更耗时一点
 */
public class Codec3 {
    Map<Integer, String> map = new HashMap<>();
    //找到一个随机数，然后从这个随机数到整形最大值之间再随机找一个数字
    Random r = new Random();
    int key = r.nextInt(Integer.MAX_VALUE);

    public String encode(String longUrl) {
        //处理冲突，如果map包含了key，则再生成一次
        while (map.containsKey(key)) {
            key = r.nextInt(Integer.MAX_VALUE);
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
