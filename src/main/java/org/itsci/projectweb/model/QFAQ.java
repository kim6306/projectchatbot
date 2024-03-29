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

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "qfaq")
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
        this.topic = qfaq.getTopic();
        this.qfaq_name = qfaq.getQfaq_name();
    }
}
