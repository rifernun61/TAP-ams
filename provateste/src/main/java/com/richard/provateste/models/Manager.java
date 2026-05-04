package com.richard.provateste.models;

public class Manager extends Employee {
    private String area;

    public Manager(Long id, String name, Double salary, String position, String area) {
        super(id, name, salary, position);
        this.area = area;
    }

    public Manager() {
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
