import { createButtonConfig } from "./common/createButtonConfig.js";
import { createDivClass } from "./common/createDivClass.js";
import { createIconDelete } from "./common/createIconDelete.js";
import { createEditIcon } from "./common/createIconEdit.js";
import { createInputConfig } from "./common/createInputConfig.js";

export const createTodoList = (list, category) => {
  console.log(category);
  const sectionListTodo = document.querySelector(".listTodo");
  const divCard = createDivClass("card");
  const divCardHeader = createDivClass("card-header");
  const divRowHeader = createDivClass("row");
  const divCol9Header = createDivClass("col-9");
  const divCol3Header = createDivClass("col-3");
  const titleHeader = document.createElement("h2");
  titleHeader.textContent = `Categoria: ${category.name}`;
  divCol9Header.append(titleHeader);
  const buttonDeleteList = createButtonConfig(
    "btn btn-danger",
    "",
    "",
    "",
    "Eliminar Lista"
  );

  divCol3Header.append(buttonDeleteList);

  divRowHeader.append(divCol9Header, divCol3Header);

  divCardHeader.append(divRowHeader);
  const divCardBody = createDivClass("card-body");
  const divRowTitleBody = createDivClass("row");
  const divTitleBodyCol9 = createDivClass("col-9");
  const divTitleBodyCol1 = createDivClass("col-1");
  const divTitleBodyCol2 = createDivClass("col-2");
  const titleListTodo = document.createElement("h5");
  const completedListTodo = document.createElement("h6");
  const actionsListTodo = document.createElement("h6");
  titleListTodo.textContent = list.name;
  completedListTodo.textContent = "Hecho";
  actionsListTodo.textContent = "Acciones";
  divTitleBodyCol9.append(titleListTodo);
  if(list.listTodos.length!==0){
    console.log("hola soy 0")

    divTitleBodyCol1.append(completedListTodo);
    divTitleBodyCol2.append(actionsListTodo);
  }
  
  divRowTitleBody.append(divTitleBodyCol9, divTitleBodyCol1, divTitleBodyCol2);
  divCardBody.append(divRowTitleBody);
  list.listTodos.forEach((todo) => {
    const divRowTodo = createDivClass("row");
    const divTodoCol9 = createDivClass("col-9");
    const divTodoCol1 = createDivClass("col-1");
    const divTodoCol2 = createDivClass("col-2");
    const todoParagraph = document.createElement("p");
    todoParagraph.textContent = todo.name;
    const divCheckBox = createDivClass("form-check form-switch");
    const inputCheckbox = createInputConfig(
      "form-check-input",
      "checkbox",
      "switch",
      "isCompleted"
    );
    divCheckBox.append(inputCheckbox);
    const buttonEdit = createButtonConfig(
      "btn btn-primary",
      "button",
      "modal",
      "#editModal",
      ""
    );
    buttonEdit.innerHTML = createEditIcon();
    const buttonDelete = createButtonConfig(
      "btn btn-danger",
      "button",
      "",
      "",
      ""
    );
    buttonDelete.innerHTML = createIconDelete();
    divTodoCol9.append(todoParagraph);
    divTodoCol1.append(divCheckBox);
    divTodoCol2.append(buttonEdit, buttonDelete);
    divRowTodo.append(divTodoCol9, divTodoCol1, divTodoCol2);
    divCardBody.append(divRowTodo);
  });
  const divRowNewTodo = createDivClass("row");
  divRowNewTodo.setAttribute("id", "newTarea");
  const divCol10NewTodo = createDivClass("col-10");
  const inputNewTodo = createInputConfig("form-control", "text", "", "newTodo");
  inputNewTodo.setAttribute("placeholder", "Agregue una nueva tarea");
  const divCol2NewTodo = createDivClass("col-2");
  const buttonNewTodo = createButtonConfig("btn btn-success", "", "", "", "+");
  divCol10NewTodo.append(inputNewTodo);
  divCol2NewTodo.append(buttonNewTodo);
  divRowNewTodo.append(divCol10NewTodo, divCol2NewTodo);

  divCard.append(divCardHeader, divCardBody, divRowNewTodo);
  sectionListTodo.append(divCard);
};
