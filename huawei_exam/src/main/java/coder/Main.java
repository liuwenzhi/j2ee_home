package coder;

public class Main {
    public static void main(String[] args){
        int i = 10;
        //i++底层三步操作：temp = i;i=i+1;return temp;
        System.out.println((i++)+(i++));//10+11=21
        int j = 1;
        //j = j++底层实现原理：temp = j;j=j+1;return temp;j = temp(因为j++最终return的是temp)
        j = j++;
        System.out.println(j);

        //z= z+1;temp = z;return z;z=temp
        int z = 1;
        z = ++z;
        System.out.println(z);
    }
}
