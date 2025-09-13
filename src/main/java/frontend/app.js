const BASE_URL = "http://localhost:8080/funcionarios";

let funcionarioSelecionado = null;
const modalEmail = new bootstrap.Modal(document.getElementById("modalEmail"));

// Listar todos
async function listarFuncionarios() {
    const resp = await fetch(BASE_URL);
    const funcionarios = await resp.json();

    const tbody = document.querySelector("#tabela-funcionarios tbody");
    tbody.innerHTML = "";

    funcionarios.forEach(f => {
        tbody.innerHTML += `
      <tr>
        <td>${f.id.empresa}</td>
        <td>${f.id.filial}</td>
        <td>${f.id.matricula}</td>
        <td>${f.nome}</td>
        <td>${f.email}</td>
        <td>${f.cargo}</td>
        <td>
          <button class="btn btn-sm btn-warning" 
            onclick="abrirModalEmail('${f.id.empresa}', '${f.id.filial}', '${f.id.matricula}', '${f.email}')">
            Editar Email
          </button>
        </td>
      </tr>
    `;
    });
}

// Buscar
async function buscarFuncionario(event) {
    event.preventDefault();

    const empresa = document.getElementById("empresa").value;
    const filial = document.getElementById("filial").value;
    const matricula = document.getElementById("matricula").value;

    const resp = await fetch(`${BASE_URL}/${empresa}/${filial}/${matricula}`);

    if (resp.ok) {
        const f = await resp.json();
        document.getElementById("resultado-busca").innerHTML = `
      <div class="card p-3">
        <h5>${f.nome}</h5>
        <p><b>Email:</b> ${f.email}</p>
        <p><b>Cargo:</b> ${f.cargo}</p>
        <button class="btn btn-warning" 
          onclick="abrirModalEmail('${empresa}', '${filial}', '${matricula}', '${f.email}')">
          Editar Email
        </button>
      </div>
    `;
    } else {
        document.getElementById("resultado-busca").innerHTML =
            `<p class="text-danger">Funcionário não encontrado</p>`;
    }
}

// Abrir modal
function abrirModalEmail(empresa, filial, matricula, emailAtual) {
    funcionarioSelecionado = { empresa, filial, matricula };
    document.getElementById("novoEmail").value = emailAtual;
    modalEmail.show();
}

// Salvar email
document.getElementById("salvarEmail").addEventListener("click", async () => {
    const { empresa, filial, matricula } = funcionarioSelecionado;
    const novoEmail = document.getElementById("novoEmail").value;

    const resp = await fetch(`${BASE_URL}/${empresa}/${filial}/${matricula}/email`, {
        method: "PATCH",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(novoEmail)
    });

    if (resp.ok) {
        alert("Email atualizado!");
        modalEmail.hide();
        listarFuncionarios();
    } else {
        alert("Erro ao atualizar email. Verifique se o email está preenchido e termina com @empresa.com");
    }
});
