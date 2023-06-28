package lwltest2;

import java.util.*;

/**
 * 题目信息：打印菜单目录树
 * 核心思路：递归+回溯
 * 题目细节边界注意看下
 */
public class ShowMeBug {
    static class Node {
        int id;
        int parentId;
        String name;

        public Node(int id, int parentId, String name) 				{
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Node> nodeList = Arrays.asList(
                new Node(1, 0, "AA"),
                new Node(2, 1, "BB"),
                new Node(3, 1, "CC"),
                new Node(4, 3, "DD"),
                new Node(5, 3, "EE"),
                new Node(6, 2, "FF"),
                new Node(7, 2, "GG"),
                new Node(8, 4, "HH"),
                new Node(9, 5, "II"),
                new Node(10, 0, "JJ"),
                new Node(11, 10, "KK"),
                new Node(12, 10, "LL"),
                new Node(13, 12, "MM"),
                new Node(14, 13, "NN"),
                new Node(15, 14, "OO")
        );
        print(nodeList);
    }

    public static void print(List<Node> nodeList) {
        //todo
        Map<Integer, List<Node>> resultMap = new HashMap<>();
        //0号根节点在数组中没有，需要单独加上
        resultMap.put(0, new ArrayList<>());
        for (Node node : nodeList) {
            resultMap.put(node.id, new ArrayList<>());
            if (resultMap.containsKey(node.parentId)) {
                List<Node> list = resultMap.get(node.parentId);
                list.add(node);
            }
        }
        boolean[] visited = new boolean[16];
        //nodeList列表中从0开始记录,这里传key0传-1,map和visited中取的时候再把1加回来
        a(nodeList,resultMap,-1,"",visited);
    }

    public static void a(List<Node> nodeList,Map<Integer, List<Node>> resultMap,int key,String space,boolean[] visited) {
        visited[key+1] = true;
        //0号目录不打印
        if(key!=-1) {
            //nodeList列表中从0开始排序
            System.out.println(space + nodeList.get(key).name);
        }
        //注意：从resultMap中获取key需要再把1加回来
        List<Node> list = resultMap.get(key+1);
        //递归实际出口，没有子目录了直接返回退出
        if(list.size()==0){
            return;
        }
        for(Node node:list){
            if(!visited[node.id]) {
                //nodeList列表中从0开始记录,这里传id-1,map和visited中取的时候再把1加回来
                a(nodeList, resultMap, node.id-1, space + "  ",visited);
            }
        }
    }

}
