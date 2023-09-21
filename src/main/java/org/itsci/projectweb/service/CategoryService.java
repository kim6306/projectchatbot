package org.itsci.projectweb.service;

import org.itsci.projectweb.model.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getCategorys();

    public void saveCategory(Category category);

    Category getCategorys(int categoryid);

    void deleteCategory(int categoryid);

    void updateCategory(Category categoryEntity, Category category);
}
