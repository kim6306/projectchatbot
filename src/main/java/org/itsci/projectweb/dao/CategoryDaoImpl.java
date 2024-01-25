package org.itsci.projectweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.projectweb.model.Category;
import org.itsci.projectweb.model.QFAQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Category getCategoryById(String categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> query = session.createQuery("FROM Category c WHERE c.category_id =: cId", Category.class);
        query.setParameter("cId", categoryId);
        return query.getSingleResult();
    }

    @Override
    public void updateCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.update(category);
    }

    @Override
    public List<Category> getAllCategories() {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> query = session.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }

    @Override
    public void deleteCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(category);
    }

    @Override
    public void saveCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
    }

    @Override
    public String getMaxCategoryId() {
        Session session = sessionFactory.getCurrentSession();
        Query<String> query = session.createQuery("SELECT c.category_id FROM Category c ORDER BY c.category_id DESC", String.class);
        query.setMaxResults(1);
        return query.uniqueResult();
    }
}
