package com.duomu;

public class Son extends Father{
    private String name;
    private int age;

    public void a(){
        System.out.println("son");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void bark(){
        System.out.println("son");
    }

    public static void main(String[] args){
        Father father = new Father();
        father.bark();
        Son son = new Son();
        son.bark();

    }
}
