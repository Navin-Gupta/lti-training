interface Greetings{
    greet(message : string):void;
}

class EmailGreeting implements Greetings{
    greet(message : string):void{
        console.log("Email : "  + message);
    }
}

class Department{
    // name : string; // public
    // private name : string;
    // public name : string;
    // protected name : string;

    // contructor
   /* constructor(n : string){
        this.name = n;
    }*/

    constructor(private readonly name : string){
        // this.name = n;
    }


    // every method has a inbuilt param : this
    // 'this' : object calling the method by default any
    describe(this:Department){
        console.log("Department : " + this.name);
    }

    // by default return type is any
  test(): string{
        return "";
    }

    trial():undefined{
        return;
    }

}

let dept1 = new Department("Account");
let dept2 = {
    name : "DUMMY",
    describe : dept1.describe
    /*describe : function(){
        console.log("Dummy Department");
    }*/
};
dept1.describe();
dept2.describe();

let service: Greetings

service = new EmailGreeting();