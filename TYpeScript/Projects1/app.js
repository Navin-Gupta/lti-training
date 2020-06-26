var button = document.querySelector("button");
// make it type specific
var input1 = document.getElementById("num1");
var input2 = document.getElementById("num2");
// button=? not allowed
// input1=? allowed
function add(num1, num2) {
    return num1 + num2;
}
button.addEventListener("click", function () {
    console.log(add(+input1.value, +input2.value));
});
