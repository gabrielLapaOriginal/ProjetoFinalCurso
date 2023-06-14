document.querySelector('#btnLogin')
.addEventListener('click', ()=>{
    formLogin.style.left = "25px"
    formCadastro.style.left = "450px"
    btnColor.style.left = "0px"
})

document.querySelector('#btnCadastro')
.addEventListener('click', ()=>{
    formLogin.style.left = "-450px"
    formCadastro.style.left = "25px"
    btnColor.style.left = "110px"
})

var formLogin = document.querySelector('#login');
var formCadastro = document.querySelector('#cadastro');
var btnColor = document.querySelector('.btnColor');

const url = 'http://localhost:8080/'



formCadastro.addEventListener('submit', (e)=>{
    e.preventDefault()
    let nome =  document.getElementById("nome").value  
    let email =  document.getElementById("email2").value           
    let senha =  document.getElementById("senha2").value
    let cpf2 = document.getElementById("cpf").value
    let dataNascimento = document.getElementById("data").value
    console.log(cpf)

    
    axios.post(url + 'clientes',{
        nome: nome,
        cpf: cpf2,
        email: email,
        senha: senha,
        dataDeNascimento: dataNascimento
    })
    .then((res)=>{
        console.log(res)
        user = res.data
        if(user.email == ""){
            alert("Email já cadastrado, tente outro.")
        }else if (user.cpf == ""){
            alert("Esse CPF já foi cadastrado, tente outro.")
        }else{
            alert("Cadastrado com sucexo!")
            window.location.href = "login.html";
        }
    })
})

formLogin.addEventListener('submit', (e)=>{
    e.preventDefault()
    let email = document.getElementById("email").value;
    let senha = document.getElementById("senha").value;

    axios.post(url + 'clientes/login?', {
        email: email,
        senha: senha
    }).then((res)=>{
        console.log(res);
        user = res.data;
        if(user != ""){
            window.location.href = "princ/index.html"
            localStorage.setItem('user', user.idCliente)
        }else{
            alert("Email e/ou Senha incorreto(s)!")
        }
    })
})