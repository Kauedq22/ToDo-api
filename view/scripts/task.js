
async function task(){
  let description = document.getElementById("descriprion").value;

  let key = "Authorization";

  console.log(description);

  const response = await fetch("http://localhost:8080/task", {
    
    method: "POST",
    headers: new Headers({
      Authorization: localStorage.getItem(key),
      "Content-Type": "application/json; charset=utf8",
      Accept: "application/json",
    }),
    body: JSON.stringify({
      description: description

    }),
  });

  if (response.ok) {
    showToast("#okToast");
  } else {
    showToast("#errorToast");
  }
  window.setTimeout(function () {
    window.location = "/view/index.html";
  }, 2000);
}

function showToast(id) {
  var toastElList = [].slice.call(document.querySelectorAll(id));
  var toastList = toastElList.map(function (toastEl) {
    return new bootstrap.Toast(toastEl);
  });
  toastList.forEach((toast) => toast.show());

}


