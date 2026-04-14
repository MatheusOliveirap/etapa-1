package br.ulbra.service;

import br.ulbra.dao.ChamadoDAO;
import br.ulbra.dao.ChamadoDAOImpl;
import br.ulbra.model.Chamado;
import java.util.List;

public class ChamadoService {

    private ChamadoDAO dao = new ChamadoDAOImpl();

    public void salvar(Chamado chamado) {

        // VALIDAÇÃO
        if (chamado.getSolicitante() == null || chamado.getSolicitante().isEmpty()) {
            throw new RuntimeException("Solicitante obrigatório!");
        }

        if (chamado.getProblemaRelatado() == null || chamado.getProblemaRelatado().isEmpty()) {
            throw new RuntimeException("Problema obrigatório!");
        }

        // padrão
        chamado.setStatus("PENDENTE");

        dao.salvar(chamado);
    }

    public List<Chamado> listar() {
        return dao.listar();
    }
}