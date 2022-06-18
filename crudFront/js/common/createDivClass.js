/**
 * Metodo que recibe como parametro el valor del atributo class, devuelve un elemento div con dicha clase
 * @param {String} className
 * @returns {Element}
 */
export const createDivClass = (className) => {
  const divCreated = document.createElement("div");
  divCreated.setAttribute("class", className);
  return divCreated;
};
