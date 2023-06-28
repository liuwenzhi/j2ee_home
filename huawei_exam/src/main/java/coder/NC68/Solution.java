package coder.NC68;

/**
 * 本题同offer 10-II
 */
public class Solution {
    public int JumpFloor(int target) {
        if(target <= 2){
            return target;
        }
        int pre2 = 1, pre1 = 2;
        for (int i = 3; i <= target; i++){
            int cur = pre2 + pre1;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
