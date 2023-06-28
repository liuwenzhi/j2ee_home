package com.duomu.hj68;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目描述
 * 查找和排序
 *
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * 都按先录入排列在前的规则处理。
 *
 * 例示：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 *
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 *
 * 从低到高
 * smith     67
 * jack      70
 * Tom       70
 * peter     96
 *
 * 注：0代表从高到低，1代表从低到高
 * 输入描述:
 * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
 *
 * 输出描述:
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 *
 * 示例1
 * 输入
 * 3
 * 0
 * fang 90
 * yang 50
 * ning 70
 * 输出
 * fang 90
 * ning 70
 * yang 50
 */
class Student{
    private String name;
    private int score;
    public static final Comparator<Student> INCREASE = new Increase();
    public static final Comparator<Student> DECREASE = new Decrease();
    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString() {
        return name + " " + score;
    }
    private static class Increase implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s1.score - s2.score;
        }
    }
    private static class Decrease implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s2.score - s1.score;
        }
    }
}
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int sort = scanner.nextInt();
            Student[] students = new Student[n];
            for(int i=0;i<n;i++){
                students[i] = new Student(scanner.next(),scanner.nextInt());
            }
            if(sort==0){
                //降序排列
                Arrays.sort(students,Student.DECREASE);
            }else{
                //生序排列
                Arrays.sort(students,Student.INCREASE);
            }
            for(Student student:students){
                System.out.println(student);
            }
        }
        scanner.close();
    }
}
