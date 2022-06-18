package co.com.sofka.crud.controllers;

import co.com.sofka.crud.models.CategoryModel;
import co.com.sofka.crud.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Esta clase corresponde a un controlador del modelo de datos Category, se
 * encarga de generar los endpoints
 * de las peticiones y mediante el servicio del modelo de ejecutar el metodo
 * correspondiente a cada peticion.
 * Para evitar los problemas de CORS se adiciona una gestion del origen de las
 * peticiones al localhost con el puerto 5500 el cual corresponde al utilizado
 * por el servidor de Live Server extension de Visual Studio Code
 * 
 * @author Erick Diaz
 * @date 17-06-2022
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryService serviceCategory;

    /**
     * Metodo con la peticion GET, recoge todas las categorias disponibles con sus
     * listas de tareas y tareas de estas en cascada y las retorna en una lista
     * 
     * @return {CategoryModel}
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping(value = "/api/categories")
    public Iterable<CategoryModel> listCategories() {
        return serviceCategory.listCategories();
    }

    /**
     * Metodo con la peticion POST, del cuerpo de la peticion recoge los datos para
     * crear un nuevo objeto de la clase Category y lo envia en una peticion al
     * endpoint para guardarlo en la base de datos correspondiente
     * 
     * @param newCategory
     * @return {CategoryModel} devulve el objeto creado por el metodo y tal como se
     *         guardo en la base de datos
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping(value = "/api/category")
    public CategoryModel saveCategory(@RequestBody CategoryModel newCategory) {
        return serviceCategory.saveCategory(newCategory);
    }

    /**
     * Metodo con la peticion PUT, del cuerpo de la peticion recoge los datos de un
     * objeto de la clase Category previamente creado, esto significa que el cuerpo
     * debe contener ya un id unico para que al mandar la peticion se actualice el
     * objeto especifico y que no se cree uno nuevo en si. En el endPoint tambien se
     * manda el ID del objeto a actualizar para no crear uno nuevo, o no cambiar el
     * ID correspondiente
     * 
     * @param actuallyCategory
     * @return {CategoryModel} devuelve el objeto actualizado tal cual se guardo en
     *         la base de datos
     */
    @PutMapping(value = "/api/category/{id}")
    public CategoryModel updateCategory(@RequestBody CategoryModel actuallyCategory) {
        if (actuallyCategory.getId_category() != null) {
            return serviceCategory.saveCategory(actuallyCategory);
        }
        throw new RuntimeException(
                "Para actualizar una categoria es necesario ingresar el ID en el cuerpo de la peticion");
    }

    /**
     * Metodo con la peticion DELETE, solamente es necesario pasar por el EndPoint
     * el ID unico del objeto que se quiere eliminar, internamente se hace el manejo
     * y no devuelve nada, el parametro se saca del EndPoint
     * 
     * @param id
     */
    @DeleteMapping(value = "/api/category/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        serviceCategory.deleteCategory(id);
    }

    /**
     * Metodo con la peticion GET, el metodo busca y devuelve un objeto de la clase
     * Category, este objeto se busca con el parametro del ID unico, por lo que se
     * pasa desde el Endpoint el parametro del ID a buscar
     * 
     * @param id
     * @return
     */
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping(value = "/api/category{id}")
    public CategoryModel getById(@PathVariable("id") Long id) {
        return serviceCategory.getById(id);
    }

}
