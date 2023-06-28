package lkhwtk.leetcode721;

import java.util.*;

/**
 * 721. 账户合并
 * 题干备注：题干中这句话：一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。开始有些没看懂，实际表达含义是：
 * 前边说了，账户名称相同不一定是同一个人，但是如果里边的邮箱名称相同，则对应同一个人，然后再回看这句：一个人所有账户都具有
 * 相同名称，则说明一点：相同账户名称不一定对应同一个人，但是如果里边邮箱名称相同，就是同一个人的，而且这两个集合中的账户名
 * 称一定是一致的。本题的难点在于如何构建并查集这个模型，需要给每一个邮箱设置一个编号，单独存储每一个邮箱对应的账户名称。
 * 参考题解：官方。
 * 基于之前个人684题的积累，本题直接参考官方题解即可。代码中Map的初始化方式都改成HashMap，能提升1ms
 */
public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //建立一个 根据邮箱地址到Index的映射，邮箱地址肯定具有唯一性，实际是建立并查集的模型，给每一个邮箱都单独建立一个索引编号，编号为从0开始的整数，然后基于这个编号进行合并相关操作
        Map<String, Integer> emailToIndex = new HashMap<>();
        //建立一个 根据邮箱地址到户主名字的映射，并查集执行完成之后辅助查找邮箱的账户，邮箱地址具有唯一性，对应的户主名字唯一，但是不同的户主可能有相同的名字，这个不影响并查集的计算
        Map<String, String> emailToName = new HashMap<>();
        //统计邮箱的个数
        int emailsCount = 0;
        //遍历给出的用户和对应的邮箱地址
        for (List<String> account : accounts) {
            //得到当前遍历账户下的户主名字
            String name = account.get(0);
            //得到当前遍历账户下List的长度
            int size = account.size();
            //通过此长度对接下来的邮箱进行遍历
            for (int i = 1; i < size; i++) {
                //得到当前i时的 邮箱地址
                String email = account.get(i);
                //看邮箱对应Index中是否有这个邮箱地址，保证每个邮箱的唯一性
                if (!emailToIndex.containsKey(email)) {
                    //如果没有出现过这个邮箱，将它添加到两个对应的map中
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }
        //一共有多少个不同的邮箱，就初始化并查集初始数组大小为多大
        UnionFind uf = new UnionFind(emailsCount);
        //遍历account
        for (List<String> account : accounts) {
            //得到当前account下第一个邮箱的地址，根据地址得到索引，把它作为根
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            //得到当前account下的邮箱个数进行遍历
            int size = account.size();
            for (int i = 2; i < size; i++) {
                //得到需要进行合并操作的邮箱地址，因为对于同一账户，他们都属于一个人，因此把他们合并
                String nextEmail = account.get(i);
                //根据邮箱地址从映射中取出Index
                int nextIndex = emailToIndex.get(nextEmail);
                //合并操作
                uf.union(firstIndex, nextIndex);
            }
        }
        //通过上面的操作，首先将同一个账户中第2到n个邮箱的代表节点设置为第1邮箱，后续在其他的账户中遇到了相同的邮箱，再接着合并操作，
        //如果后边遍历的邮箱出现了和前边的重复的，在进行合并的过程中，前边的根节点的代表节点就变成了当前的根节点，此
        //时并查集对象中parent集合就存储了全部的代表节点，同个代表节点出现的个数就是该对应的用户数，parent数组中每一
        //个位置可以代表一个邮箱（前边有邮箱和index的对应map），数组中的值就是该邮箱的代表节点

        //建立一个Index对应邮箱地址的Map，把同属于一个代表结点的全部邮箱放到集合中
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        //通过emailToIndex遍历邮箱地址
        for (String email : emailToIndex.keySet()) {
            //根据索引在并查集中得到当前邮箱地址的根节点，即查找代表节点
            int index = uf.find(emailToIndex.get(email));
            //判断是否存在根节点，没有就创建一个ArrrayList，有的话就获取当前的ArrayList
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            //在当前的List中加入现邮箱地址，因为他们有同一个根
            account.add(email);
            //更新indexToEmails的邮箱列表
            indexToEmails.put(index, account);
        }

        //创建答案表，按要求对答案进行整理
        List<List<String>> merged = new ArrayList<List<String>>();
        //通过indexToEmail的值（values）进行遍历
        for (List<String> emails : indexToEmails.values()) {
            //将emails按照题目要求进行排序
            Collections.sort(emails);
            //拿到了属于通个账户的邮箱，随便拿出一个到emailToName集合中查找下账户名称
            String name = emailToName.get(emails.get(0));
            //创建一个account表
            List<String> account = new ArrayList<String>();
            //首先添加用户名字，然后用addAll将emails表整个添加到account中
            account.add(name);
            account.addAll(emails);
            //最后在答案表中添加整理好后的用户以及邮箱表
            merged.add(account);
        }
        return merged;
    }
}
