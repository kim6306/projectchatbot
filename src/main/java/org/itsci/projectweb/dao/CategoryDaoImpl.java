package org.itsci.projectweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.projectweb.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getCategorys() {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> query = session.createQuery("from Category", Category.class);
        List<Category> categories = query.getResultList();
        return categories;
    }

    @Override
    public void saveCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
    }

    @Override
    public Category getCategorys(int categoryid) {
        Session session = sessionFactory.getCurrentSession();
        Category category = session.get(Category.class, categoryid);
        return category;
    }

    @Override
    public void deleteCategory(int categoryid) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Category where id=:categoryid");
        query.setParameter("categoryid",categoryid);
        query.executeUpdate();
    }
}
