package lkhwtk.leetcode535;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考题解：官方
 * hashcode加密，加密思路和Codec类似，Codec中使用随机数作为key，这里直接使用url地址的hashcode，
 * hashcode的验证可以参考下main函数，时空效率和Codec差不多
 */
public class Codec2 {

    Map<Integer, String> map = new HashMap<>();

    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }

    public static void main(String[] args){
        //验证下hashcode，注意String类中hashcode的定义方式：public int hashCode()，hash属性是一个整型值
        String url = "https://leetcode.com/problems/design-tinyurl";
        System.out.println(url.hashCode());
        System.out.println("-123".hashCode());
    }
}
