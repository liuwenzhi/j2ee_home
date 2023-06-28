package exam2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 这个是个人第一次提交的代码，提示测试用例跑完45%，存在数组下标越界异常。
 * 应该是类型错误，中间计算的时候，尤其涉及到各个字节内容累加，不能用int，用long类型，涉及到字节内容计算这块一定要注意
 * 可能会超过int范围，因为int是4个字节，32位，但是还有一位符号位，最大值是：2147483647，四个字节中后边三个字节都是1，
 * 最前边一个字节开头是0，后边是1，所以从数值的角度来说，int占不满4个字节全部位。题干中说整数占四个字节，有可能会超过int范围
 * 比如是无符号整数。可以参考下附件截图中的内容：int 最大值是2147483647，题目中入参出现：3165757026,hj6题中录入自然数就通过
 * scanner.nextLong()的方式。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            //c值，也应该使用long，取余比较可以根据long进行比较
            int compareValue = scanner.nextInt();
            //b值，也应该使用long
            int modeValue = scanner.nextInt();
            int valueInfo[] = new int[10];
            for (int i = 0; i < valueInfo.length; i++) {
                // todo 换成nextLong
                valueInfo[i] = scanner.nextInt();
            }
            System.out.println(getEffectiveDataNum(compareValue, modeValue, valueInfo));
        }
    }

    private static int getEffectiveDataNum(int compareValue, int modeValue, int[] valueInfo) {
        // 将录入的整形数组计算累加值数组
        int[] addValue = getByAddValue4Array(valueInfo);
        // 根据累加值数组计算出取模数组
        int[] modeArrayValue = getModeValue(addValue, modeValue);
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < modeArrayValue.length; i++) {
            if (modeArrayValue[i] < compareValue) {
                // 有效类型
                if (resultMap.containsKey(modeArrayValue[i])) {
                    resultMap.put(modeArrayValue[i], resultMap.get(modeArrayValue[i]) + 1);
                } else {
                    resultMap.put(modeArrayValue[i], 1);
                }
            }
        }
        // 返回有效数据类型最多的数据量
        int max = 0;
        for (int i = 0; i < resultMap.size(); i++) {
            if (resultMap.get(i) > max) {
                max = resultMap.get(i);
            }
        }
        return max;
    }

    /**
     * 遍历一个整形数组，对其中每个数据进行取模，返回取模后的数组
     */
    private static int[] getModeValue(int[] addValue, int modeValue) {
        int[] resultInfo = new int[addValue.length];
        for (int i = 0; i < addValue.length; i++) {
            resultInfo[i] = addValue[i] % modeValue;
        }
        return resultInfo;
    }

    /**
     * 遍历一个整形数组，获取其中每个整数的各字节累加值
     */
    private static int[] getByAddValue4Array(int[] valueInfo) {
        int[] resultInfo = new int[valueInfo.length];
        for (int i = 0; i < valueInfo.length; i++) {
            resultInfo[i] = getByteAddValue(valueInfo[i]);
        }
        return resultInfo;
    }

    /**
     * 获取一个数字各个字节的累加和
     */
    private static int getByteAddValue(int n) {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            temp += n % 256;
            n = n / 256;
        }
        return temp;
    }
}
