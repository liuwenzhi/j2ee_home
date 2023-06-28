package lkhwtk.leetcode535;

import java.util.HashMap;
import java.util.Map;

/**
 * 535. TinyURL 的加密与解密
 * 本题属于开放式试题，可以直接返回url结果信息，参考Codec1题解
 * 官方题解给出多个设计加密的方式
 */
public class Codec {
    /**
     * 简单计数器方式，定义一个map集合，用0到n的编号作为key，请求路径url作为value
     * 加密的url路径是一个常量路径地址加上map中key这个编号，解密的时候，把路径常量
     * 的部分替换为空字符串，获取到编号i，用这个编号作为key到map集合中获取路径
     */
    Map<Integer, String> map = new HashMap<>();
    int i = 0;

    public String encode(String longUrl) {
        map.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }

    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }

}
