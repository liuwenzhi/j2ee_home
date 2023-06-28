package lkhwtk.leetcode635;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 635. 设计日志存储系统
 * 参考题解：java使用 compareTo真的很简单，题解比较巧
 * 官方题解对于时间计算比较复杂，参考下这个题解，单独建立一个Record类
 */
public class LogSystem {

    /**
     * 2021年9月24日二轮刷题将列表初始化方式改为ArrayList
     */
    List<Record> records = new ArrayList<>();

    public LogSystem() {

    }

    public void put(int id, String timestamp) {
        records.add(new Record(id, timestamp));
    }

    /**
     * s:start,e:end
     * 注意：包含两端
     */
    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < records.size(); i++) {
            if(records.get(i).compare(start, granularity) >= 0 && records.get(i).compare(end, granularity) <= 0) {
                list.add(records.get(i).id);
            }
        }
        return list;
    }

}
