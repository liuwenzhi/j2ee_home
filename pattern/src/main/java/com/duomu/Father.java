package com.duomu;

public class Father {
    private String name;

    public void a(){
        System.out.println("Father");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void bark(){
        System.out.println("father");
    }
}
