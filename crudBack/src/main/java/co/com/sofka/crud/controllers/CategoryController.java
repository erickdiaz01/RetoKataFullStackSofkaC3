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
    public CategoryModel saveCategory(@RequestBody CategoryModel newCategory){
        return serviceCategory.saveCategory(newCategory);
    }
    @PutMapping(value = "/api/category/{id}")
    public CategoryModel updateCategory(@RequestBody CategoryModel actuallyCategory){
        if(actuallyCategory.getId_category()!= null) {
            return serviceCategory.saveCategory(actuallyCategory);
        }
        throw new RuntimeException("Para actualizar una categoria es necesario ingresar el ID en el cuerpo de la peticion");
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
