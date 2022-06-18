import { getAll } from "./js/getAll.js";
import { handleClick } from "./js/handles/handleClick.js";
import { handleNewCategory } from "./js/handles/handleNewCategory.js";
import { handleSubmit } from "./js/handles/handleSubmit.js";
/**
 * Metodo principal, el cual mediante el manejo del DOM agregar los listener para que los metodos
 * correspondientes puedan ser ejecutados y se puedan manejar los eventos de la aplicacion mediante los
 * handlers
 *
 * @author Erick Diaz
 * @date 17-06-2022
 */
function main() {
  document.addEventListener("DOMContentLoaded", getAll);
  document
    .getElementById("form-newListTodo")
    .addEventListener("submit", (e) => {
      e.preventDefault();
      handleSubmit(e);
    });
  document.getElementById("createCategory").addEventListener("click", (e) => {
    e.preventDefault();
    handleNewCategory(e);
  });
  document.addEventListener("click", (e) => {
    e.preventDefault();
    handleClick(e);
  });
}

main();
