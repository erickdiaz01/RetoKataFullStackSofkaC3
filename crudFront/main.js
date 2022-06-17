import { getAll } from "./js/getAll.js";
import { handleClick } from "./js/handles/handleClick.js";
import { handleNewCategory } from "./js/handles/handleNewCategory.js";
import { handleSubmit } from "./js/handles/handleSubmit.js";

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
  document.addEventListener("click", e=>{
    e.preventDefault();
    handleClick(e)
  })
}

main();
