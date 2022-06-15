package co.com.sofka.crud.services;

import co.com.sofka.crud.models.CategoryModel;
import co.com.sofka.crud.models.TodoModel;
import co.com.sofka.crud.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repositoryCategory;

    public Iterable<CategoryModel> listCategories (){return repositoryCategory.findAll();}

    public CategoryModel saveCategory(CategoryModel newCategory){
        return repositoryCategory.save(newCategory);
    }

    public void deleteCategory (Long id){
        repositoryCategory.delete(getById(id));
    }
    public CategoryModel getById (Long id){
        return repositoryCategory.findById(id).orElseThrow();
    }

}
