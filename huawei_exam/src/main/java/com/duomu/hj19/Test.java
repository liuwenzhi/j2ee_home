package com.duomu.hj19;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args){
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("cqzlyaszjvlsjmkwoqijggmybr 645",1);
        map.put("rzuwnjvnuz 633",1);
        map.put("atl 637",1);
        map.put("rwyfvzsopsuiqjnr 647",1);
        map.put("eez 648",1);
        map.put("fmwafhhgeyawnool 649",1);
        map.put("c 637",1);
        map.put("f 633",1);
        map.put("ywzqaop 631",2);
        System.out.println(map.size());
        for(Map.Entry<String,Integer> it:map.entrySet()){
            System.out.println(it.getKey()+" "+it.getValue());
        }
        map.remove(map.entrySet().iterator().next());
        for(Map.Entry<String,Integer> it:map.entrySet()){
            System.out.println(it.getKey()+" "+it.getValue());
        }
        /*int i=0;
        for(Map.Entry<String,Integer> it:map.entrySet()){
            //注意这里的设计，只有当i进入最后八条记录时，才做输出，这个地方有点容易乱，比如按照样例中给的日志内容，
            //map最终大小是9，其中有一条记录重复，那么i=0，不显示，i=1显示日志，i=2显示日志...i=8显示日志，
            if(map.size()-i<8){
                System.out.println(it.getKey()+" "+it.getValue());
            }
            i++;
        }*/
    }
}
