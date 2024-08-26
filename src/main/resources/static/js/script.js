console.log("Script is loaded");

let currentTheme = getTheme();
document.addEventListener("DOMContentLoaded", () => {
  chnageTheme();
});
function chnageTheme() {
  changePageTheme(currentTheme, currentTheme);

  // changing the theme of the button
  let changeThemeButton = document.querySelector("#theme_change_button");

  // we are changing the text of the button when theme changes

  const oldTheme = currentTheme;
  changeThemeButton.addEventListener("click", () => {
    if (currentTheme === "dark") {
      currentTheme = "light";
    } else {
      currentTheme = "dark";
    }
    changePageTheme(currentTheme, oldTheme);
  });
}

function settheme(theme) {
  localStorage.setItem("theme", theme);
}

function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

function changePageTheme(theme, oldTheme) {
  // now after doing above steps theme is changed but
  // not updated in local storage mtlb wo dikhegi nahi so we
  // have to update in localstorage
  settheme(currentTheme);
  // remove the currentTheme
  document.querySelector("html").classList.remove(oldTheme);
  // add the currrentheme
  document.querySelector("html").classList.add(theme);

  document
    .querySelector("#theme_change_button")
    .querySelector("span").textContent = theme == "light" ? "Dark" : "Light";
}
