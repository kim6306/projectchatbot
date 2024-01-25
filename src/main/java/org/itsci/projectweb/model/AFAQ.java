package org.itsci.projectweb.model;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "afaqs")
public class AFAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int afaq_id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String afaq_name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qfaq_id")
    private QFAQ qfaq;

    public AFAQ () {}

    public AFAQ(int afaq_id, QFAQ qfaq, String afaq_name) {
        this.afaq_id = afaq_id;
        this.qfaq = qfaq;
        this.afaq_name = afaq_name;
    }

    public int getAfaq_id() {
        return afaq_id;
    }

    public void setAfaq_id(int afaq_id) {
        this.afaq_id = afaq_id;
    }

    public QFAQ getQfaq() {
        return qfaq;
    }

    public void setQfaq(QFAQ qfaq) {
        this.qfaq = qfaq;
    }

    public String getAfaq_name() {
        return afaq_name;
    }

    public void setAfaq_name(String afaq_name) {
        this.afaq_name = afaq_name;
    }

    public void fill (AFAQ afaq) {
        this.afaq_id = afaq.getAfaq_id();
    }
}
