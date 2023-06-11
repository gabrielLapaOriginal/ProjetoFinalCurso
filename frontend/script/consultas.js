var user = localStorage.getItem('user')
if (user == null) {
    window.location.href = "../login.html"
}

const url = 'http://localhost:8080/'
window.addEventListener('load', (e) => {
    e.preventDefault()
    axios.get(url + `consultas/paciente/${user}`)
        .then(
            (res) => {
                console.log(res)
                let array = res.data.consultas
                let medicos = res.data.medicos
                let consultas = document.getElementById('consultas')
                console.log(consultas)
                var consultasMedicos = [];
                array.forEach(function (consulta) {
                    var medico = medicos.find(function (medico) {
                        return medico.id_medico === consulta.medicoId;
                    });

                    if (medico) {
                        consultasMedicos.push({
                            data: consulta.dataDaConsulta,
                            hora: consulta.horaDaConsulta,
                            medicoNome: medico.nome,
                            medicoEspecialidade: medico.especialidade
                        });
                    }
                });
                console.log(consultasMedicos)
                consultasMedicos.forEach((e) => {
                    let divConsulta = document.createElement('div')
                    divConsulta.className = 'consulta'
                    divConsulta.innerHTML = `
                        <h4>Especialista: ${e.medicoNome}</h4>
                        <p>Especialidade: ${e.medicoEspecialidade}</p>
                        <p>Data da consulta: ${e.data}</p>
                        <p>Hora da consulta: ${e.hora}</p>
                    `
                    consultas.appendChild(divConsulta)
                })
            }
        )
})