// serve para quando eu clicar em NOVO no cadastro e nao colocar os campos ai volta para a mesma tela NOVO
function verificar(xhr, status, args, dlg, tb) {
	if(args.validationFailed) {
		// PF é do prime faces
		PF(dlg).jq.effect("shake", {time:5}, 100);
	}
	else {
		PF(dlg).hide();
		PF(tb).clearFilters();
	}
}