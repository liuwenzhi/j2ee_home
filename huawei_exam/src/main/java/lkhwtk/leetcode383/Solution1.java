package lkhwtk.leetcode383;

/**
 * 对Solution的优化，老思路，用数组替代Map
 */
public class Solution1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 统计 magazine 字符
        int[] chars = new int[26];
        int magazineLen = magazine.length();
        for (int i = 0; i < magazineLen; i++) {
            chars[magazine.charAt(i) - 'a']++;
        }
        int ransomLen = ransomNote.length();
        // 遍历 ransomNote
        for (int i = 0; i < ransomLen; i++) {
            //magazine中没有这个赎金信中的字符
            if (chars[ransomNote.charAt(i) - 'a'] == 0) {
                return false;
            }else{
                chars[ransomNote.charAt(i) - 'a']--;
            }
        }
        return true;
    }
}
