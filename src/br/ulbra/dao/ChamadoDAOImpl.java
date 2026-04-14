
package br.ulbra.dao;

import br.ulbra.model.Chamado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChamadoDAOImpl implements ChamadoDAO {

    @Override
    public void salvar(Chamado chamado) {
        String sql = "INSERT INTO chamado_tecnico (solicitante, sala, equipamento_tag, problema_relatado, diagnostico_tecnico, prioridade, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, chamado.getSolicitante());
            stmt.setString(2, chamado.getSala());
            stmt.setString(3, chamado.getEquipamentoTag());
            stmt.setString(4, chamado.getProblemaRelatado());
            stmt.setString(5, chamado.getDiagnosticoTecnico());
            stmt.setString(6, chamado.getPrioridade());
            stmt.setString(7, chamado.getStatus());

            stmt.execute();
            stmt.close();

            System.out.println("Chamado salvo!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public List<Chamado> listar() {
        List<Chamado> lista = new ArrayList<>();

        String sql = "SELECT * FROM chamado_tecnico";

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Chamado c = new Chamado();

                c.setId(rs.getLong("id"));
                c.setSolicitante(rs.getString("solicitante"));
                c.setSala(rs.getString("sala"));
                c.setEquipamentoTag(rs.getString("equipamento_tag"));
                c.setProblemaRelatado(rs.getString("problema_relatado"));
                c.setDiagnosticoTecnico(rs.getString("diagnostico_tecnico"));
                c.setPrioridade(rs.getString("prioridade"));
                c.setStatus(rs.getString("status"));
                c.setDataAbertura(rs.getTimestamp("data_abertura"));

                lista.add(c);
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }
}