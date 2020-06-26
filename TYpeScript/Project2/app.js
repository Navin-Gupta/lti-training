function add(n1, n2, showResult) {
    var result = n1 + n2;
    if (showResult)
        console.log("Addition :" + result);
    else
        return result;
}
// inference
// let num1 = 20;
// let num1:number = 20;
var num1;
num1 = 20;
num1 = "Hello";
var num2 = 30;
var showResult = true;
showResult = false;
add(num1, num2, showResult);
