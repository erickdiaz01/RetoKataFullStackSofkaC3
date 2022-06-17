export const createInputConfig = (className, type, role, id) => {
  const input = document.createElement("input");
  input.setAttribute("class", className);
  input.setAttribute("type", type);
  input.setAttribute("role", role);
  input.setAttribute("id", id);
  return input;
};
