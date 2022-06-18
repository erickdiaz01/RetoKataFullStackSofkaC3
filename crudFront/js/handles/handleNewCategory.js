/**
 * Metodo que maneja el evento de dar click en el boton de crear una nueva categoria, despliega la ventana
 * modal y maneja la captura del valor del nombre de la nueva categoria a crear, si el valor esta vacio
 * dispara una alerta que da un mensaje al usuario para que ingrese un valor valido y pueda enviar
 * la peticion POST
 * @param {Object} e 
 */
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
