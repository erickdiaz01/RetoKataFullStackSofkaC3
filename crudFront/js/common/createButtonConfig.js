export function createButtonConfig  (
  className,
  type,
  dataBsToggle,
  dataBsTarget,
  text
)  {
  let buttonConfig = document.createElement("button");
  buttonConfig.setAttribute("class", className);
  if(type!==""){
    buttonConfig.setAttribute("type", type);
  }
  if(dataBsTarget!==""){
    buttonConfig.setAttribute("data-bs-toggle", dataBsToggle);
  }
  if(dataBsToggle!==""){
    buttonConfig.setAttribute("data-bs-target", dataBsTarget);
  }
  
  buttonConfig.textContent = text;
  return buttonConfig;
};
