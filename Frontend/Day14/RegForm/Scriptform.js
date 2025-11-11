document.getElementByName("myForm").addEventListener('submit' , function(event){

let userName = document.getElementById('username').value;
let userAge = document.getElementById('age').value;

alert('Form submitter! ' + userName);

});
