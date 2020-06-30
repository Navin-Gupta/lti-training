function add(n1:number, n2:number, showResult:boolean){
    const result = n1 + n2;
    if(showResult)
        console.log("Addition :" + result);
    else
        return result;
}

// inference

// let num1 = 20;
// let num1:number = 20;
let num1:number;
num1 = 20;
num1 = "Hello";
let num2 = 30;

const showResult = true;
showResult = false;

add(num1, num2, showResult);