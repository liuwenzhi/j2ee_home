package exam2;

import java.util.*;

/**
 * 第三次我直接把数组都改成List列表，代码如下：
 * 修改完了还是只跑完45%的测试用例，提示存在数组下标越界异常。
 */
public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //c值
        int compareValue = scanner.nextInt();
        //b值
        int modeValue = scanner.nextInt();
        List<Integer> valueInfoList = new ArrayList<>();
        for(int i=0;i<10;i++){
            valueInfoList.add(scanner.nextInt());
        }
        System.out.println(getEffectiveDataNum(compareValue,modeValue,valueInfoList));
    }

    private static int getEffectiveDataNum(int compareValue,int modeValue,List valueInfoList){
        //将录入的整形数组计算累加值数组
        List<Integer> addValueList = getByAddValue4Array(valueInfoList);
        //根据累加值数组计算出取模数组
        List<Integer> modeValueList = getModeValue(addValueList,modeValue);
        Map<Integer,Integer> resultMap = new HashMap<>();
        for(Integer i:modeValueList){
            if(i<compareValue){
                //有效类型
                if(resultMap.containsKey(i)){
                    resultMap.put(i,resultMap.get(i)+1);
                }else{
                    resultMap.put(i,1);
                }
            }
        }
        //返回有效数据类型最多的数据量
        int max = 0;
        for(int i=0;i<resultMap.size();i++){
            if(resultMap.get(i) > max){
                max = resultMap.get(i);
            }
        }
        return max;
    }

    /**
     * 遍历一个整形数组，对其中每个数据进行取模，返回取模后的数组
     */
    private static List<Integer> getModeValue(List<Integer> addValueList,int modeValue){
        List<Integer> resultInfoList = new ArrayList<>(addValueList.size());
        for(int i:addValueList){
            resultInfoList.add(i%modeValue);
        }
        return resultInfoList;
    }

    /**
     * 遍历一个整形数组，获取其中每个整数的各字节累加值
     */
    private static List<Integer> getByAddValue4Array(List<Integer> valueInfoList){
        List<Integer> resultInfoList = new ArrayList<>(valueInfoList.size());
        for(int i:valueInfoList){
            resultInfoList.add(getByteAddValue(i));
        }
        return resultInfoList;
    }

    /**
     * 获取一个数字各个字节的累加和
     */
    private static int getByteAddValue(int n){
        int temp = 0;
        for(int i=0;i<4;i++){
            temp += n % 256;
            n = n/256;
        }
        return temp;
    }
}
