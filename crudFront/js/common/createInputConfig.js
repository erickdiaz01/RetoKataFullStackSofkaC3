/**
 * Metodo que crea rapidamente un elemento input con los valores de los atributos pasados por parametros
 * @param {String} className 
 * @param {String} type 
 * @param {String} role 
 * @param {String} id 
 * @returns {Element}
 */
export const createInputConfig = (className, type, role, id) => {
  const input = document.createElement("input");
  input.setAttribute("class", className);
  input.setAttribute("type", type);
  input.setAttribute("role", role);
  input.setAttribute("id", id);
  return input;
};
