import { getAll } from "./js/getAll.js";

function main() {
  document.addEventListener("DOMContentLoaded", getAll )
   document.getElementById("form-newListTodo").addEventListener("submit",(e)=>{
    e.preventDefault();
    
   })
};

main()
