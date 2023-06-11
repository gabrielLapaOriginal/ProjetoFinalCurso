var user = localStorage.getItem('user')
if(user == null){
    window.location.href = "../login.html"
}

const url = 'http://localhost:8080/'
window.addEventListener('load', (e)=>{
 
    e.preventDefault()
    axios.get(url + `clientes/${user}`)
    .then(
        (res)=>{
            let name = res.data.nome
            let divContainer = document.getElementById('name');
            divContainer.innerHTML = `<h1 class="nome" id="nomeh1">Olá, ${name}</h1>`
            
        }
    )
})