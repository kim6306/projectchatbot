package org.itsci.projectweb.dao;

import org.itsci.projectweb.model.Category;

import java.util.List;
import java.util.Map;

public interface CategoryDao {

    Category getCategoryById (String categoryId);
    void updateCategory(Category category);
    List<Category> getAllCategories ();
    void deleteCategory (Category category);
    void saveCategory (Category category);
    String getMaxCategoryId ();

}
