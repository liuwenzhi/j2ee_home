package lkhwtk.leetcode841;

import java.util.ArrayList;
import java.util.List;

/**
 * 841. 钥匙和房间
 * 纯个人递归思路
 */
public class Solution {
    /**
     * 房间信息数组，数组的编号对应房间号，
     */
    private int[] room;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        room = new int[rooms.size()];
        dfs(0,rooms);
        for(int i:room){
            if(i==0){
                return false;
            }
        }
        return true;
    }

    private void dfs(int num,List<List<Integer>> rooms){
        //递归方法出口
        if(room[num]==1){
            return;
        }
        room[num] = 1;
        List<Integer> roomList = rooms.get(num);
        //递归流程不使用兰姆达表达式效率能更高
        if(roomList!=null&&roomList.size()>0){
            /*roomList.forEach(roomNum->{
                dfs(roomNum,rooms);
            });*/
            for(int roomNum:roomList){
                dfs(roomNum,rooms);
            }
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        //[[1,3],[3,0,1],[2],[0]]
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        List<Integer> list4 = new ArrayList<>();
        list4.add(0);
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);
        solution.canVisitAllRooms(rooms);
    }
}
