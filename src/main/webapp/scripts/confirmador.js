/**
 * Confirmador de exclusão contato
 */

function confirmar(link) {
	let resposta = confirm("Confirmar a exclusão?");

	if (resposta) {
		window.location.href = `${link}`;
	}
}