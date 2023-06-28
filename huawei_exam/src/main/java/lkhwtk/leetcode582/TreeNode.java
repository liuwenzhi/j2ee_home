package lkhwtk.leetcode582;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private int val;
    private List<TreeNode> children = new ArrayList<>();

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
