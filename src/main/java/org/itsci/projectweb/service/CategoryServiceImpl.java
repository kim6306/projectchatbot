package org.itsci.projectweb.service;

import org.itsci.projectweb.dao.AFAQDao;
import org.itsci.projectweb.dao.CategoryDao;
import org.itsci.projectweb.dao.QFAQDao;
import org.itsci.projectweb.dao.TopicDao;
import org.itsci.projectweb.model.AFAQ;
import org.itsci.projectweb.model.Category;
import org.itsci.projectweb.model.QFAQ;
import org.itsci.projectweb.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private AFAQDao afaqDao;

    @Autowired
    private QFAQDao qfaqDao;

    @Autowired
    private TopicDao topicDao;

    @Override
    public Category getCategoryById(String categoryId) {
        return null;
    }

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    @Transactional
    public void deleteCategory(String categoryId) {
        Category category = categoryDao.getCategoryById(categoryId);
        for (Topic topic : category.getTopics()) {
            for (QFAQ qfaq : topic.getQfaqs()) {
                for (AFAQ afaq : qfaq.getAfaqs()) {
                    afaq.setQfaq(null);
                    afaqDao.updateAFAQ(afaq);
                    afaqDao.deleteAFAQ(afaq);
                }
                qfaq.setAfaqs(null);
                qfaq.setTopic(null);
                qfaqDao.updateQFAQ(qfaq);
                qfaqDao.deleteQFAQ(qfaq);
            }
            topic.setQfaqs(null);
            topic.setCategory(null);
            topicDao.updateTopic(topic);
            topicDao.deleteTopic(topic);
        }
        category.setTopics(null);
        categoryDao.updateCategory(category);
        categoryDao.deleteCategory(category);
    }

    @Override
    @Transactional
    public void saveCategory(Map<String, String> map) {
        String category_name = map.get("category_name");
        List<Topic> topics = new ArrayList<>();
        String latestCategoryId = categoryDao.getMaxCategoryId();
        int newCategoryId = Integer.parseInt(latestCategoryId) + 1;
        Category category = new Category(String.valueOf(newCategoryId), category_name);
        categoryDao.saveCategory(category);
    }
}
