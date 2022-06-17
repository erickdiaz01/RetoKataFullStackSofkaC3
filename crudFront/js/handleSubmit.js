export const handleSubmit = async (e) => {
  const form = document.querySelector("#form-newListTodo"),
    input = form.querySelector("#inputListTodo"),
    selectCategory = form.querySelector("#selectCategory");
  if (e.target === form) {
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
        console.log(data);
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
