package com.example.khovai.DomainModels;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String cate_code;
    @Column
    private String cate_name;

    public Category() {
    }

    public Category( String cate_code, String cate_name) {

        this.cate_code = cate_code;
        this.cate_name = cate_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCate_code() {
        return cate_code;
    }

    public void setCate_code(String cate_code) {
        this.cate_code = cate_code;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", cate_code='" + cate_code + '\'' +
                ", cate_name='" + cate_name + '\'' +
                '}';
    }
}

