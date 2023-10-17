package org.itsci.projectweb.model;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Entity
@Table(name = "qfaqs")
public class QFAQ {
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "topic_qfaq", joinColumns = {@JoinColumn(name = "qfaq_id")},
            inverseJoinColumns = {@JoinColumn(name = "topic_id")})
    private Topic topics;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "qfaq_afaq", joinColumns = {@JoinColumn(name = "qfaq_id")},
            inverseJoinColumns = {@JoinColumn(name = "afaq_id")})
    private List<AFAQ> afaqs;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    int id;

    @NotNull
    @Column(name = "qfaqtext", columnDefinition = "TEXT")
    private String qfaqtext;

    public Topic getTopics() {
        return topics;
    }

    public void setTopics(Topic topics) {
        this.topics = topics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AFAQ> getAfaqs() {
        return afaqs;
    }

    public void setAfaqs(List<AFAQ> afaqs) {
        this.afaqs = afaqs;
    }

    public String getQfaqtext() {
        return qfaqtext;
    }

    public void setQfaqtext(String qfaqtext) {
        this.qfaqtext = qfaqtext;
    }

    public void fill(QFAQ qfaq) {
        this.qfaqtext = qfaq.getQfaqtext();
    }
}
