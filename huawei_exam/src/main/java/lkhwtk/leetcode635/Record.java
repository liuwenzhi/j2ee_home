package lkhwtk.leetcode635;

/**
 * 使用字符串工具类比较两个日期，具体参考main方法
 */
public class Record {
    static final String YEAR_STRING = "Year";
    static final String MONTH_STRING = "Month";
    static final String DAY_STRING = "Day";
    static final String HOUR_STRING = "Hour";
    static final String MINUTE_STRING = "Minute";
    static final String SECOND_STRING = "Second";

    int id;
    String timestamp;
    public Record(int id, String timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    /**
     * 比较日期，可以直接使用compareTo，耗时能减少1ms
     * substring提取过程中，末尾位置就是冒号位置
     */
    public int compare(String timestamp, String granularity) {
        switch (granularity) {
            case YEAR_STRING:
                return this.timestamp.substring(0,4).compareToIgnoreCase(timestamp.substring(0,4));
            case MONTH_STRING:
                return this.timestamp.substring(0,7).compareToIgnoreCase(timestamp.substring(0,7));
            case DAY_STRING:
                return this.timestamp.substring(0, 10).compareToIgnoreCase(timestamp.substring(0, 10));
            case HOUR_STRING:
                return this.timestamp.substring(0, 13).compareToIgnoreCase(timestamp.substring(0, 13));
            case MINUTE_STRING:
                return this.timestamp.substring(0, 16).compareToIgnoreCase(timestamp.substring(0, 16));
            case SECOND_STRING:
                return this.timestamp.compareToIgnoreCase(timestamp);
            default:
                System.out.println("error");
                break;
        }

        return 0;
    }

    public static void main(String[] args){
        //如果前边的字符串比后边的小，返回-1
        System.out.println("2017:01:01:23:59:59".compareToIgnoreCase("2017:01:02:23:59:59"));
        //相等返回0
        System.out.println("2017:01:01:23:59:59".compareToIgnoreCase("2017:01:01:23:59:59"));
        //大于返回1
        System.out.println("2017:02:01:23:59:59".compareToIgnoreCase("2017:01:01:23:59:59"));
    }

}
