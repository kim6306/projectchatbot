package org.itsci.projectweb.model;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int topic_id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String topic_name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="topic", cascade = CascadeType.ALL)
    private List<QFAQ> qfaqs = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    private Category category;

    public Topic() {

    }

    public Topic(int topic_id, String topic_name, List<QFAQ> qfaqs, Category category) {
        this.topic_id = topic_id;
        this.topic_name = topic_name;
        this.qfaqs = qfaqs;
        this.category = category;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public List<QFAQ> getQfaqs() {
        return qfaqs;
    }

    public void setQfaqs(List<QFAQ> qfaqs) {
        this.qfaqs = qfaqs;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public Topic(String topictext, Category category) {
        this.topic_name = topictext;
        this.category = category;
    }
}
