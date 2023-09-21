package org.itsci.projectweb.dao;

import org.itsci.projectweb.model.Category;

import java.util.List;
public interface CategoryDao {
    List<Category> getCategorys();

    void saveCategory(Category category);

    Category getCategorys(int categoryid);

    void deleteCategory(int id);
}
