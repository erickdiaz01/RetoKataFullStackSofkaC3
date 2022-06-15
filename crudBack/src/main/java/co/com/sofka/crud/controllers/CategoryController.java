package co.com.sofka.crud.controllers;

import co.com.sofka.crud.models.CategoryModel;
import co.com.sofka.crud.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService serviceCategory;
@GetMapping(value = "/api/categories")
    public Iterable<CategoryModel> listCategories (){return serviceCategory.listCategories();}
@PostMapping(value = "/api/category")
    public CategoryModel saveCategory(CategoryModel newCategory){
        return serviceCategory.saveCategory(newCategory);
    }
@DeleteMapping(value = "/api/category/{id}")
    public void deleteCategory (@PathVariable("id") Long id){
    serviceCategory.deleteCategory(id);
    }
    @GetMapping(value = "/api/category{id}")
    public CategoryModel getById (@PathVariable("id") Long id){
        return serviceCategory.getById(id);
    }

}
