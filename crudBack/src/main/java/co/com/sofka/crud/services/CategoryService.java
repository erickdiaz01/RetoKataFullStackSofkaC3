package co.com.sofka.crud.services;

import co.com.sofka.crud.models.CategoryModel;
import co.com.sofka.crud.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio que utiliza los metodos manejados por el repositorio especifico de
 * la entidad Category
 * 
 * @author Erick Diaz
 * @date 17-06-2022
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repositoryCategory;

    /**
     * Recoge todas las categorias disponibles con sus
     * listas de tareas y tareas de estas en cascada y las retorna en una lista
     * 
     * @return {CategoryModel}
     */
    public Iterable<CategoryModel> listCategories() {
        return repositoryCategory.findAll();
    }

    /**
     * Del cuerpo de la peticion recoge los datos para
     * crear un nuevo objeto de la clase Category y lo envia en una peticion al
     * endpoint para guardarlo en la base de datos correspondiente
     * 
     * @param newCategory
     * @return {CategoryModel} devulve el objeto creado por el metodo y tal como se
     *         guardo en la base de datos
     */
    public CategoryModel saveCategory(CategoryModel newCategory) {
        return repositoryCategory.save(newCategory);
    }

    /**
     * Solamente es necesario pasar
     * el ID unico del objeto que se quiere eliminar, internamente se hace el manejo
     * y no devuelve nada, el parametro se saca del EndPoint
     * 
     * @param id
     */
    public void deleteCategory(Long id) {

        repositoryCategory.delete(getById(id));
    }

    /**
     * El metodo busca y devuelve un objeto de la clase
     * Category, este objeto se busca con el parametro del ID unico
     * 
     * @param id
     * @return {CategoryModel} devuelve el objeto encontrado mediante el ID
     */
    public CategoryModel getById(Long id) {
        return repositoryCategory.findById(id).orElseThrow();
    }

}
