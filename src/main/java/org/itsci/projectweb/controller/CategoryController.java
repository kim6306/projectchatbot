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

@Controller
@RequestMapping("/category")
public class CategoryController {
    private String title = "หมวดหมู่";
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String listCategory(Model model) {
        model.addAttribute("title", "รายการ" + title);
        model.addAttribute("categorys", categoryService.getCategorys());
        return "category/list";
    }
    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("category", new Category());
        return "category/category-form";
    }
    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
    Category category = categoryService.getCategorys(id);
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("category", category );
        return "category/category-form";
    }
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("category")Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "มีข้อผิดพลาดในการบันทึก" + title);
            return "category/category-form";
        } else {
            Category entityCategory = categoryService.getCategorys(category.getId());
                if (entityCategory != null) {
                    categoryService.updateCategory(entityCategory, category);
                }else {
                    categoryService.saveCategory(category);
                }
            return "redirect:/category/list";
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return "redirect:/category/list";
    }

}
