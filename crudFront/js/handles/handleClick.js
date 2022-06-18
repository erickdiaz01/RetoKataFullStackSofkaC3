

/**
 * Arrow function que maneja los eventos correspondientes a las acciones posibles a realizar en la lista
 * de tareas para cada uno de los registros que se tienen, verifica si se 'clickeó' el boton de editar o el
 *  de eliminar, o el de crear una nueva tarea dependiendo de eso realiza una acción especifica.
 * 
 * Si se 'clickeó' el boton de editar se insertan los valores del registro en los inputs del formulario
 * alojado en una ventana modal para que el usuario edite con mayor
 * precisión, ademas de agregar el ID existente del registro para que cuando se realice el submit se mande 
 * la peticion PUT.
 * Si se 'clickeó' el boton de eliminar se lanza una alerta de confirmacion para eliminar definitivamente o 
 * no el registro, si se confirma la eliminacion se lanza la petición de DELETE con el ID del registro.
 * Si se clickeó el boton de agregar una nueva tarea, internamente se realiza el manejo de seleccion para
 * capturar el valor de la tarea ingresada, si el valor es vacio no permite crear una nueva tarea en la
 * lista correspondiente
 * @param {Object} e Objeto que se crea cuando se dispara el evento correspondiente
 */
export const handleClick = async (e) => {
  const modalDiv = document.querySelector(".listTodo");
  const modal = modalDiv.querySelector("#editModal");
  const inputID = modal.querySelector("#idTodo");
  const inputTodo = modal.querySelector("#recipient-name");

  if (e.target.matches("#editTodo")) {
    
    inputID.value = e.target.dataset.id;
    inputTodo.value = e.target.dataset.name;
    inputID.dataset.id=e.target.dataset.id;
    inputID.dataset.name = e.target.dataset.name;
    inputID.dataset.completed = e.target.dataset.completed;
    inputID.dataset.category = e.target.dataset.category
    inputID.dataset.list = e.target.dataset.list
    
  }

  if (e.target.matches("#deleteTodo")) {

    let isDelete = confirm(
      `¿Estás seguro de eliminar la tarea con id ${e.target.dataset.id}?`
    );

    if (isDelete) {
      //Delete - DELETE
      try {
        let options = {
            method: "DELETE",
            headers: {
              "Content-type": "application/json; charset=utf-8",
            },
          },
          res = await axios(
            `http://localhost:8080/api/todo/${e.target.dataset.id}`,
            options
          ),
          json = await res.data;
        console.log(json);
        location.reload();
      } catch (err) {
        let message = err.statusText || "Ocurrió un error";
        alert(`Error ${err.status}: ${message}`);
      }
    }
  }
  if (e.target.matches("#createNewTodo")) {
    let input = document.querySelector(
      `#newTarea input[data-id-input='${e.target.dataset.id}']`
    );
    if (input) {
      try {
        if (input.value == "") {
          alert("INGRESA UN VALOR VALIDO DE TAREA");
        } else {
          let options = {
            method: "POST",
            headers: {
              "Content-type": "application/json; charset=utf-8",
            },
            data: JSON.stringify({
              name: input.value,
              listTodo: {
                id_TodoList: e.target.dataset.id,
              },
              isCompleted: false,
            }),
          };
          let { data } = await axios("http://localhost:8080/api/todo", options);
          if (data) {
            location.reload();
          }
        }
      } catch (error) {
        console.log(error);
        let message = err.statusText || "Ocurrió un error";
        alert(message);
      }
    }
  }
  if (e.target.matches("#deleteList")) {
    let isDelete = confirm(
      `¿Estás seguro de eliminar la lista de tareas con id ${e.target.dataset.id}?`
    );

    if (isDelete) {
      //Delete - DELETE
      try {
        let options = {
            method: "DELETE",
            headers: {
              "Content-type": "application/json; charset=utf-8",
            },
          },
          res = await axios(
            `http://localhost:8080/api/todolist/${e.target.dataset.id}`,
            options
          ),
          json = await res.data;
        console.log(json);
        location.reload();
      } catch (err) {
        let message = err.statusText || "Ocurrió un error";
        alert(`Error ${err.status}: ${message}`);
      }
    }
  }
  if (e.target.matches("#isCompleted")) {
    try {
      let category = JSON.parse(e.target.dataset.category);
      let listTodo = JSON.parse(e.target.dataset.list);
      console.log(e.target.dataset.completed);
      if (e.target.dataset.completed === "false") {
        console.log("first");
        let options = {
          method: "PUT",
          headers: {
            "Content-type": "application/json; charset=utf-8",
          },
          data: {
            id_todo: e.target.dataset.id,
            name: e.target.dataset.name,
            listTodo: {
              id_TodoList: listTodo.id_TodoList,
              name: listTodo.name,
              category: {
                id_category: category.id_category,
                name: category.name,
              },
            },
            completed: true,
          },
        };
        let res = await axios(
          `http://localhost:8080/api/todo/${e.target.dataset.id}`,
          options
        );
        if (res) {
          alert("Bien hecho, completaste la tarea!");
          location.reload();
        }
      } else {
        console.log("hola");
        let options = {
          method: "PUT",
          headers: {
            "Content-type": "application/json; charset=utf-8",
          },
          data: {
            id_todo: e.target.dataset.id,
            name: e.target.dataset.name,
            listTodo: {
              id_TodoList: listTodo.id_TodoList,
              name: listTodo.name,
              category: {
                id_category: category.id_category,
                name: category.name,
              },
            },
            completed: false,
          },
        };
        let res = await axios(
          `http://localhost:8080/api/todo/${e.target.dataset.id}`,
          options
        );
        if (res) {
          alert(
            "¿Te confundiste? No importa, a todos nos pasa, sigue haciendo tus tareas!"
          );
          location.reload();
        }
      }
    } catch (error) {
      console.log(error);
    }
  }
};
