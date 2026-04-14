package br.ulbra.controller;

import br.ulbra.model.Chamado;
import br.ulbra.service.ChamadoService;
import java.util.List;

public class ChamadoController {

    private ChamadoService service = new ChamadoService();

    public void salvar(Chamado chamado) {
        service.salvar(chamado);
    }

    public List<Chamado> listar() {
        return service.listar();
    }
}