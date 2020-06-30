var Department = /** @class */ (function () {
    // public name : string;
    // protected name : string;
    // contructor
    function Department(n) {
        this.name = n;
    }
    Department.prototype.describe = function () {
        console.log("Department : " + this.name);
    };
    return Department;
}());
var dept1 = new Department("Account");
var dept2 = {
    name: "DUMMY",
    describe: dept1.describe
    /*describe : function(){
        console.log("Dummy Department");
    }*/
};
dept1.describe();
dept2.describe();
