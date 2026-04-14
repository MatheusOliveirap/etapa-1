/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;



import br.ulbra.model.Chamado;
import java.util.List;

public interface ChamadoDAO {

    void salvar(Chamado chamado);

    List<Chamado> listar();
}
