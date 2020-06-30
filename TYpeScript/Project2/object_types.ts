// explicit type specification for object
/*const person : {
    name : string;
    age: number;
    hobbies : string[]
    // hobbies : Array<String>
    // hobbies : (string | number)[] union
    // hobbies : any[]  // Javascript
} */

enum Roles{
    ADMIN, // 0
    READ_ONLY, // 1
    AUTHOR //2
}
const person :{
    name : string;
    age: number;
    hobbies : string[];
    role : Roles;
    // role: [number,string,];
    // hobbies : Array<String>
    // hobbies : (string | number)[] union
    // hobbies : any[]  // Javascript
} = {
    name: 'First',
    age:25,
    hobbies: ['Chess', "Reading"],
    // role : [2, 'author'] // Tuple
    role : Roles.AUTHOR
    
};

console.log(person);
console.log(person.name);

// person.role.push("");
// person.role[0]=3;

for(const hobby of person.hobbies){
    console.log(hobby);
}


