package org.itsci.projectweb.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    private String category_id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String category_name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="category", cascade = CascadeType.ALL)
    private List<Topic> topics = new ArrayList<>();

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public void fill(Category category) {
        this.category_name = category.getCategory_name();
        this.category_id = category.getCategory_id();
    }

    public Category () {}

    public Category(String category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }
}
