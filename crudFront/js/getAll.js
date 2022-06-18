import { createTodoList } from "./createTodoList.js";

/**
 * Metodo que se dispara apenas el DOM de la pagina es cargado, permite traer toda la data necesaria para
 * insertar los valores de las categorias en el elemento select del formulario para crear una nueva lista
 * de tareas y tambien para crear e insertar las card correspondientes a las listas de tareas existentes
 * en la base de datos
 */
export const getAll = async () => {
  const d = document,
    selectCategory = d.querySelector("#selectCategory"),
    cardBody = d.querySelector(".card-body"),
    fragmentCateogories = d.createDocumentFragment();

  try {
    console.log("hola");
    let categories = await axios.get("http://localhost:8080/api/categories");
    const lists = await axios.get("http://localhost:8080/api/todolist");
    let jsonCategories = categories.data;
    let jsonList = lists.data;
    console.log(jsonCategories);
    console.log(jsonList);

    jsonCategories.forEach((category) => {
      
      const option = d.createElement("option");
      option.textContent = category.name;
      option.value = JSON.stringify(category)  ;
      fragmentCateogories.appendChild(option);
    });
    selectCategory.appendChild(fragmentCateogories);
    jsonList.forEach((list) => {
      let category = jsonCategories.find(
        categoria=> categoria.listsTodos.find(listTodo=>listTodo.id_TodoList==list.id_TodoList)
      )
      console.log(category)
      createTodoList(list,category)
    });
  } catch (error) {
    console.log(error);
  }
};
