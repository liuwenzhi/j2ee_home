package lkhwtk.leetcode1396;

import java.util.HashMap;
import java.util.Map;

/**
 * 1396. 设计地铁系统
 * 参考题解：第一次周赛~~，官方建的模型比较麻烦，本题可用技巧的方式建模型
 * 技巧核心思路：单独保存从某站到某站的已统计的平均时间，这个平均时间对应的统计次数，
 * 再进行平均时间统计的时候，可以拿到这个平均时间*之前的统计次数得到一个之前的时间总和，
 * 再加上最新的时间，用这个时间/(统计次数—+1)，得到新一个平均时间，核心模型：
 * Map1：key：进站人Id，value：站名
 * Map2：key: 进站人Id，value：进站时间
 * Map3：key：始发站-终点站，value：目前平均时间
 * Map4: key: 始发站-终点站，value：统计次数
 */
public class UndergroundSystem {

    /**进站人Id，站名Map*/
    private HashMap<Integer,String> idStation;

    /**进站人Id，进站时间Map*/
    private HashMap<Integer,Integer> idCheckInTime;

    /**始发站，终点站平均时间Map*/
    private HashMap<String,Double> stationAvgTime;

    /**始发站，终点站平均时间统计样本数*/
    private HashMap<String,Integer> stationCount;

    public UndergroundSystem() {
        this.idStation = new HashMap<>();
        this.idCheckInTime = new HashMap<>();
        this.stationAvgTime = new HashMap<>();
        this.stationCount = new HashMap<>();
    }

    /**
     * 进站，
     * @param id 用户id
     * @param stationName 进站站名称
     * @param t 进站时刻
     */
    public void checkIn(int id, String stationName, int t) {
        idStation.put(id,stationName);
        idCheckInTime.put(id,t);
    }

    /**
     * 出站，
     * @param id 用户id
     * @param stationName 出站站名称
     * @param t 出站时刻
     */
    public void checkOut(int id, String stationName, int t) {
        //获取始发站
        String startStation = idStation.get(id);
        //获取入站时间
        int startTime = idCheckInTime.get(id);
        //拼一个始发站，终点站的key
        String key = startStation+"-"+stationName;
        if(!stationAvgTime.containsKey(key)){
            //第一次统计始发站到终点站时间
            double avgTime = t-startTime;
            stationAvgTime.put(key,avgTime);
            stationCount.put(key,1);
        }else{
            //第N次统计始发站到终点站时间
            double avgTime = stationAvgTime.get(key);
            int count = stationCount.get(key);
            double sum = avgTime * count;
            sum += (t-startTime);
            stationAvgTime.put(key,sum/(count+1));
            stationCount.put(key,++count);
        }

    }

    /**
     * 统计两个站点时间的平均到达时间，如果一个乘客在startStation进站，而没有在endStation出站，则不用进行统计
     */
    public double getAverageTime(String startStation, String endStation) {
        return stationAvgTime.get(startStation+"-"+endStation);
    }
}
