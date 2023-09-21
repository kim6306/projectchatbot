package org.itsci.projectweb.model;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topic {
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "topic_qfaq", joinColumns = {@JoinColumn(name = "topic_id")},
            inverseJoinColumns = {@JoinColumn(name = "qfaq_id")})
    private List<QFAQ> qfaqs;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "topic_cate", joinColumns = {@JoinColumn(name = "topic_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Category category;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @NotNull
    @Column(name = "topictext", columnDefinition = "TEXT")
    private String topictext;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopictext() {
        return topictext;
    }

    public void setTopictext(String topictext) {
        this.topictext = topictext;
    }

    public void fill(Topic topic) {

        this.topictext = topic.getTopictext();
    }
}
