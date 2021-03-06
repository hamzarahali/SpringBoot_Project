//Regex Init
const RegexAlphab = /^[a-zA-Z]*$/
// const RegexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
const RegexDigit = /[0-9]/
const RegexChar = /[a-zA-Z]/
//todo add helpers and placeholer 

function validate(){
    const fname = document.getElementById('firstname')
    const lname = document.getElementById('lastname')
    const password1 = document.getElementById('password1')
    const password2 = document.getElementById('password2')
    const email = document.getElementById('email')
    var valid = true

    const errors = {
        'firstname':'',
        'lastname':'',
        'password1':'',
        'password2':''
}
    if (!RegexAlphab.test(fname.value) || fname.value.length == 0 || fname.value.length > 20 ){
        errors['firstname'] = 'Please enter a valid First name'
    }
    
    if (!RegexAlphab.test(lname.value) || lname.value.length == 0  || lname.value.length > 20  ){
        errors['lastname'] = 'Please enter a valid Last name'

    }


    if (email.value.length == 0  || email.value.length > 100 ){
        errors['email'] = "Please enter a valid email"
    }
    
    if (password1.value != password2.value || password2.value.length == 0){
        errors['password2'] = "Password didn't match"
    }

    if(!RegexDigit.test(password1.value) || !RegexChar.test(password1.value) ) {
        errors['password1'] ="Password must contain numbers (0-9) and characters (a-z) !"
    }

    if(password1.value.length < 8){
        errors['password1'] ="Password must contain at least 8 characters"

    }
   
    for (var key in errors) {
        var errorNode = document.createElement("span"); 
        var errorInput = document.getElementById(key); 
        var nextElement = errorInput.nextSibling
        if (nextElement.tagName == "SPAN"){
            nextElement.remove()
            errorInput.style.borderColor = "black"
        }
        if (errors[key] != ''){
            valid=false
            var errorContent = document.createTextNode(errors[key])
            errorNode.appendChild(errorContent);  
            errorNode.classList.add('input-error')
            errorInput.style.borderColor = "crimson"
            errorInput.parentNode.insertBefore(errorNode, errorInput.nextSibling)
            
        }
    }  
    return valid   

}