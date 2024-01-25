package org.itsci.projectweb.service;

import org.itsci.projectweb.model.Category;
import java.util.List;
import java.util.Map;

public interface CategoryService {

    Category getCategoryById (String categoryId);
    List<Category> getAllCategories ();
    void deleteCategory (String categoryId);
    void saveCategory (Map<String, String> map);

}
