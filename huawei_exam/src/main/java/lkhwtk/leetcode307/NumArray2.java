package lkhwtk.leetcode307;

/**
 * 参考题解：官方，线段树实现
 */
public class NumArray2 {
    /**用数组方式构建线段树*/
    int[] tree;
    int n;
    public NumArray2(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            //nums中的元素都在叶子节点，可以通过计算得知一棵线段树中的节点大约为2n个
            tree = new int[n * 2];
            buildTree(nums);
        }
    }

    /**
     * 构建线段树，采用从底向上，构建叶子节点之后构架父节点
     * 叶子节点都是nums数组中的元素，采用数组方式构建线段树，数组长度可以设置为2*n，肯定是小于等于这个范围。
     */
    private void buildTree(int[] nums) {
        //创建叶子节点
        for (int i = n, j = 0;  i < 2 * n; i++,  j++) {
            tree[i] = nums[j];
        }
        //从后往前计算父节点，数组最开始几位节点有可能是0，这个正常
        for (int i = n - 1; i > 0; --i) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    /**
     * 更新元素值，搜西安更新叶节点的值，然后从下往上，依次更新父节点的值
     */
    void update(int pos, int val) {
        //叶节点在线段树数组后边，位置先+n
        pos += n;
        //更新叶节点的值
        tree[pos] = val;
        //算法真漂亮：通过当前位置找到左右子树，当前pos位置的元素，可能是左子树，也可能是右子树，
        //如果是左子树，则找右子树位置为pos+1，如果是右子树，则找左子树位置为pos-1，然后循环这
        //个过程，一层一层找父节点
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            //更新父节点
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

    /**
     * 统计某个区间的总和，注意：虽然有tree数组存放了叶子节点信息，
     * 统计总量的时候直接计算也会导致超时，下边这个算法背一下，通过
     * 检索父节点的值大大减小了区间计算的时间复杂度
     */
    public int sumRange(int l, int r) {
        //在线段树数组中找到l位置的叶子节点
        l += n;
        //在线段树数组中找到r位置的叶子节点
        r += n;
        int sum = 0;
        while (l <= r) {
            //第一次循环：如果左侧位置叶子节点是右子树，单独算一下这个值，左边界右移
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            //第一次循环：如果右侧位置叶子节点是左子树，单独算一下这个值，右边界左移
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            //通过上边l和r的修改，能够找到具体的父节点
            l /= 2;
            r /= 2;
        }
        return sum;
    }

}
