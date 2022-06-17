export const createDivClass = (className) => {
  const divCreated = document.createElement("div");
  divCreated.setAttribute("class",className);
  return divCreated;
};
