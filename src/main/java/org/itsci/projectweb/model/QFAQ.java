package org.itsci.projectweb.model;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "qfaqs")
public class QFAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int qfaq_id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String qfaq_name;

    @ManyToOne(cascade=CascadeType.ALL)
    private Topic topic;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "qfaqs_afaqs", joinColumns = {@JoinColumn(name = "qfaq_id")},
            inverseJoinColumns = {@JoinColumn(name = "afaq_id")})
    private List<AFAQ> afaqs = new ArrayList<>();

    public QFAQ () {}

    public QFAQ(int qfaq_id, String qfaq_name, Topic topic, List<AFAQ> afaqs) {
        this.qfaq_id = qfaq_id;
        this.qfaq_name = qfaq_name;
        this.topic = topic;
        this.afaqs = afaqs;
    }

    public int getQfaq_id() {
        return qfaq_id;
    }

    public void setQfaq_id(int qfaq_id) {
        this.qfaq_id = qfaq_id;
    }

    public String getQfaq_name() {
        return qfaq_name;
    }

    public void setQfaq_name(String qfaq_name) {
        this.qfaq_name = qfaq_name;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<AFAQ> getAfaqs() {
        return afaqs;
    }

    public void setAfaqs(List<AFAQ> afaqs) {
        this.afaqs = afaqs;
    }

    public void fill (QFAQ qfaq) {
        this.qfaq_name = qfaq.getQfaq_name();
    }
}
