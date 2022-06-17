import { getAll } from "./js/getAll.js";
import { handleSubmit } from "./js/handleSubmit.js";

function main() {
  document.addEventListener("DOMContentLoaded", getAll )
   document.getElementById("form-newListTodo").addEventListener("submit",(e)=>{
    e.preventDefault();
    handleSubmit(e);

   })
};

main()
