package com.example.khovai.DomainModels;

import javax.persistence.*;

@Entity
@Table(name = "Sub_Category")
public class Sub_Cate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String sub_cate_code;
    @Column
    private String sub_cate_name;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSub_cate_code() {
        return sub_cate_code;
    }

    public void setSub_cate_code(String sub_cate_code) {
        this.sub_cate_code = sub_cate_code;
    }

    public String getSub_cate_name() {
        return sub_cate_name;
    }

    public void setSub_cate_name(String sub_cate_name) {
        this.sub_cate_name = sub_cate_name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
