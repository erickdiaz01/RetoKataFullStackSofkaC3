import { createTodoList } from "./createTodoList.js";

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
      option.value = { name: category.name, id_category: category.id_category };
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
