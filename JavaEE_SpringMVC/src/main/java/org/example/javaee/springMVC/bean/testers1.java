package org.example.javaee.springMVC.bean;

import org.springframework.stereotype.Component;

@Component
public class testers1 {


    private Long id;
    private String name;

    @Override
    public String toString() {
        return "testers1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public testers1() {
    }

    public testers1(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id; }
    public String getName() {return name; }
    public void setName(String name) {this.name = name; }

}
