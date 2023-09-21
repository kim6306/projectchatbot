package org.itsci.projectweb.service;

import org.itsci.projectweb.dao.CategoryDao;
import org.itsci.projectweb.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDao categoryDao;
    @Override
    @Transactional
    public List<Category> getCategorys() {
        return categoryDao.getCategorys();
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryDao.saveCategory(category);
    }

    @Override
    @Transactional
    public Category getCategorys(int categoryid) {
        return categoryDao.getCategorys(categoryid);
    }

    @Override
    @Transactional
    public void deleteCategory(int categoryid) {
        categoryDao.deleteCategory(categoryid);
    }

    @Override
    @Transactional
    public void updateCategory(Category categoryEntity, Category category) {
        categoryEntity.fill(category);
        categoryDao.saveCategory(categoryEntity);
    }
}
