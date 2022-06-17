export const handleNewCategory = async (e) => {
  const modalCategory = document.querySelector("#categoryModal"),
    button = modalCategory.querySelector("#createCategory"),
    input = modalCategory.querySelector("#recipient-name");
  if (e.target === button) {
    if (input.value == "") {
      alert("Por favor ingresa el nombre de la nueva categoria");
    } else {
      try {
        let options = {
          method: "POST",
          headers: {
            "Content-type": "application/json; charset=utf-8",
          },
          data: JSON.stringify({
            name: input.value,
          }),
        };
        let { data } = await axios(
          "http://localhost:8080/api/category",
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
