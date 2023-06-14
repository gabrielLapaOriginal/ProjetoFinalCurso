var user = localStorage.getItem('user')
if (user == null) {
    window.location.href = "../login.html"
}

const url = 'http://localhost:8080/'
window.addEventListener('load', (e) => {

    e.preventDefault()
    axios.get(url + `medicos`)
        .then(
            (res) => {
                let array = res.data
                let selecteds = document.getElementById('medico')

                array.forEach((element) => {
                    let medicos = document.createElement('option')
                    medicos.value = element.id_medico
                    medicos.innerHTML = `
               ${element.nome} - ${element.especialidade}
                `
                    selecteds.appendChild(medicos)
                });


            }
        )
    let consulta = document.getElementById('consulta')
    

    consulta.addEventListener('submit', (e) => {
        e.preventDefault()
        let medico = document.getElementById('medico').value
        let data = document.getElementById('data').value
        let hora = document.getElementById('horario').value
        console.log(medico)

        axios.post(url + 'consultas', {
            dataDaConsulta: data,
            horaDaConsulta: hora,
            medicoId: parseInt(medico),
            clienteId: parseInt(user)

        }).then((res) => {
            alert("Consulta marcada com sucexo!");
            window.location.href="MC.html"
        })

    })
})


