/**
 * Metodo que maneja el evento de dar click en el boton de editar una tarea, maneja la captura del valor del nombre de la tarea actualizada, si el valor esta vacio
 * dispara una alerta que da un mensaje al usuario para que ingrese un valor valido y pueda enviar
 * la peticion PUT
 * @param {Object} e
 */
export const handleEditTodo = async (e) => {
  const modalEdit = document.querySelector("#editModal"),
    button = modalEdit.querySelector("#editTodoButton"),
    inputID = modalEdit.querySelector("#idTodo"),
    input = modalEdit.querySelector("#recipient-name");

  const category = JSON.parse(inputID.dataset.category);
  const list = JSON.parse(inputID.dataset.list);
  const completedBoolean = inputID.dataset.completed === "true";
  console.log(category);
  console.log(list);
  if (e.target === button) {
    if (input.value == "") {
      alert("Por favor ingresa el nombre de la tarea actualizada");
    } else {
      try {
        let options = {
          method: "PUT",
          headers: {
            "Content-type": "application/json; charset=utf-8",
          },
          data: {
            id_todo: inputID.dataset.id,
            name: input.value,
            listTodo: {
              id_TodoList: list.id_TodoList,
              name: list.name,
              category: {
                id_category: category.id_category,
                name: category.name,
              },
            },
            completed: completedBoolean,
          },
        };
        let res = await axios(
          `http://localhost:8080/api/todo/${inputID.dataset.id}`,
          options
        );
        if (res) {
          alert("Bien hecho, editaste la tarea!");
          location.reload();
        }
      } catch (error) {
        console.log(error);
        let message = error.statusText || "Ocurrió un error";
        alert(message);
      }
    }
  }
};
