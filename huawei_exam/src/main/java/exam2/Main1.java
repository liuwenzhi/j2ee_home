package exam2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 然后我怀疑可能是录入出现了问题，就修改了入参接收这部分代码，修改后如下：
 * 结果还是只跑完45%的测试用例，提示存在数组下标越界异常。
 */
public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            int[] temp = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            //c值
            int compareValue = temp[0];
            //b值
            int modeValue = temp[1];
            int valueInfo[] = new int[10];
            for(int i=2;i<temp.length;i++){
                valueInfo[i-2] = temp[i];
            }
            System.out.println(getEffectiveDataNum(compareValue,modeValue,valueInfo));
        }
    }

    private static int getEffectiveDataNum(int compareValue,int modeValue,int[] valueInfo){
        //将录入的整形数组计算累加值数组
        int[] addValue = getByAddValue4Array(valueInfo);
        //根据累加值数组计算出取模数组
        int[] modeArrayValue = getModeValue(addValue,modeValue);
        Map<Integer,Integer> resultMap = new HashMap<>();
        for(int i=0;i<modeArrayValue.length;i++){
            if(modeArrayValue[i]<compareValue){
                //有效类型
                if(resultMap.containsKey(modeArrayValue[i])){
                    resultMap.put(modeArrayValue[i],resultMap.get(modeArrayValue[i])+1);
                }else{
                    resultMap.put(modeArrayValue[i],1);
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
    private static int[] getModeValue(int[] addValue,int modeValue){
        int[] resultInfo = new int[addValue.length];
        for(int i=0;i<addValue.length;i++){
            resultInfo[i] = addValue[i] % modeValue;
        }
        return resultInfo;
    }

    /**
     * 遍历一个整形数组，获取其中每个整数的各字节累加值
     */
    private static int[] getByAddValue4Array(int[] valueInfo){
        int[] resultInfo = new int[valueInfo.length];
        for(int i=0;i<valueInfo.length;i++){
            resultInfo[i] = getByteAddValue(valueInfo[i]);
        }
        return resultInfo;
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
