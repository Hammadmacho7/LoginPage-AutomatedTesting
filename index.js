const email = document.getElementById('myEmail')
const password = document.getElementById('myPass')
const form = document.getElementById("form")
const error = document.getElementById("error")
const btn = document.getElementById("btn")

form.addEventListener('submit', (e) =>{
    let messages = []
    if(password.value.length < 8){
        e.preventDefault()
        alert("password length must be more than 8")
    }

    if (password.value.match("(?=.*[0-9])") ){
    }
    else{
        e.preventDefault()
        alert("Password must contain a numeric digit")
    }

    if (password.value.match("(?=.*[a-z])") ){
    }
    else{
        e.preventDefault()
        alert("Password must contain a lower case letter")
    }

    if (password.value.match("(?=.*[A-Z])") ){
    }
    else{
        e.preventDefault()
        alert("Password must contain an upper case letter")
    }

    if (password.value.match("(?=.*[#\\-\\_\\.\\#\\$\\%\\&\\?\\,\\=\\:\\;\\<\\>\\^\\'\\(\\)\\{\\}\\!])") ){
        e.preventDefault()
        alert("Password must contain only '@' and '+' special characters")
    }
   // else{
     //   e.preventDefault()
      //  alert("Password must contain only '@' and '+' special characters")
    //}
    if (password.value.match("(?=.*\\s)") ){
        e.preventDefault()
        alert("No blank spaces")
    }


    if ( password.value.match("(?=^.{8,}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s)[0-9a-zA-Z!*^?](?!.*[#\\-\\_\\.\\#\\$\\%\\&\\?\\,\\=\\:\\;\\<\\>\\^\\'\\(\\)\\{\\}\\!])") ){
        e.preventDefault()
        alert("Logged in")
    }
    else{
        e.preventDefault()
    }


})