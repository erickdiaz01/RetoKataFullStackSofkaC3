/**
 * Metodo que maneja el evento de dar click en el boton de crear una nueva lista de tareas, maneja la
 * captura del valor del nombre de la nueva lista de tareas a crear asi como la categoria de esta lista de
 * tareas, si alguno de los  valores esta vacio
 * dispara una alerta que da un mensaje al usuario para que ingrese un valor valido y pueda enviar
 * la peticion POST
 * @param {Object} e
 */
export const handleSubmit = async (e) => {
  console.log("hola async")
  const form = document.querySelector("#form-newListTodo"),
    input = form.querySelector("#inputListTodo"),
    selectCategory = form.querySelector("#selectCategory"),
    buttonSub=document.querySelector("#create");
  if (e.target === buttonSub) {
    if (input.value == "" || selectCategory.value == "") {
      alert("Por favor ingresa toda la informacion requerida");
    } else {
      try {
        const categoryObject = JSON.parse(selectCategory.value);
        let options = {
          method: "POST",
          headers: {
            "Content-type": "application/json; charset=utf-8",
          },
          data: JSON.stringify({
            name: input.value,
            category: {
              id_category: categoryObject.id_category,
              name: categoryObject.name,
            },
          }),
        };
        let { data } = await axios(
          "http://localhost:8080/api/todolist",
          options
        );
        if (data) {
          location.reload();
        }
      } catch (error) {
        console.log(error);
        let message = err.statusText || "Ocurrió un error";
        form.insertAdjacentHTML(
          "afterend",
          `<p><b>Error ${err.status}: ${message}</b></p>`
        );
      }
    }
  }
};
