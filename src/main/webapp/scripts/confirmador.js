/**
 * Confirmador de exclusão contato
 */

function confirmar(idcon) {
	let resposta = confirm("Confirmar a exclusão desse contato?");

	if (resposta) {
		window.location.href = "delete?idcon=" + idcon;
	}
}