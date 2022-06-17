export const getAll = async () => {
  const d = document
//   ,
    // selectCategory = d.querySelector("#selectCategory"),
    // cardBody = d.querySelector(".card-body");

  try {
    console.log("hola");
  let categories = await axios.get("http://localhost:8080/api/categories");
    const lists = await axios.get("http://localhost:8080/api/todolist");
   let jsonCategories = categories.data;
    let jsonList = lists.data;
    console.log(jsonCategories);
    console.log(jsonList);
  } catch (error) {
    console.log(error);
  }
};
