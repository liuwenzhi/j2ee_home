package lkhwtk.leetcode1360;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 1360. 日期之间隔几天
 * 个人思路：效率偏低
 */
public class Solution {
    public int daysBetweenDates(String date1, String date2) {
        Date begin = getStringDate(date1);
        Date end = getStringDate(date2);
        //日期信息可能是前边大，后边小
        if(begin.after(end)){
            return getDays(end,begin);
        }
        return getDays(begin,end);
    }

    /**
     * 将字符串日期按照格式"yyyy-MM-dd"转成Date类型
     */
    private Date getStringDate(String dataString) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取两个date日期的相差天数
     */
    private int getDays(Date startDate, Date endDate) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(startDate);
        int startDay = calendar1.get(Calendar.DAY_OF_YEAR);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(endDate);
        int endDay = calendar2.get(Calendar.DAY_OF_YEAR);
        if (calendar2.get(Calendar.YEAR) != calendar1.get(Calendar.YEAR)) {
            int timeDistance = 0;
            int year1 = calendar1.get(Calendar.YEAR);
            int year2 = calendar2.get(Calendar.YEAR);
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    timeDistance += 366;
                } else {
                    timeDistance += 365;
                }
            }
            return timeDistance + endDay - startDay;
        }
        return endDay - startDay;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.daysBetweenDates("2019-06-29","2019-06-30"));
    }
}
