package org.itsci.projectweb.model;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Entity
@Table(name = "afaqs")
public class AFAQ {
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "qfaq_afaq", joinColumns = {@JoinColumn(name = "afaq_id")},
            inverseJoinColumns = {@JoinColumn(name = "qfaq_id")})
    private List<QFAQ> qfaqs;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    @NotNull
    @Column(name = "afaqtext", columnDefinition = "TEXT")
    private String afaqtext;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAfaqtext() {
        return afaqtext;
    }

    public List<QFAQ> getQfaqs() {
        return qfaqs;
    }

    public void setQfaqs(List<QFAQ> qfaqs) {
        this.qfaqs = qfaqs;
    }

    public void setAfaqtext(String afaqtext) {
        this.afaqtext = afaqtext;
    }

    public void fill(AFAQ afaq) {

        this.afaqtext = afaq.getAfaqtext();
    }
}
