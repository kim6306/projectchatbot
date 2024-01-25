package org.itsci.projectweb.controller;

import org.itsci.projectweb.model.Category;
import org.itsci.projectweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/add-category-page")
    public String goToAddCategoryPage () {
        return "category/category-form";
    }

    @PostMapping("/save")
    public String saveCategory (@RequestParam Map<String, String> map) {
        categoryService.saveCategory(map);
        return "redirect:/update-page";
    }

    @RequestMapping("/delete/{categoryId}")
    public String deleteCategory (@PathVariable("categoryId") String categoryId) {
        categoryService.deleteCategory(categoryId);
        return "redirect:/update-page";
    }

}
