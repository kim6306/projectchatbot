package org.itsci.projectweb.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "categorys")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private String id;
    @NotNull
    @Column(name = "catetext", columnDefinition = "TEXT")
    private String catetext;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatetext() {
        return catetext;
    }

    public void setCatetext(String catetext) {
        this.catetext = catetext;
    }

    public void fill(Category category) {
        this.catetext = category.getCatetext();
        this.id = category.getId();
    }
}
