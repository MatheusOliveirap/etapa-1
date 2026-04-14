import br.ulbra.controller.ChamadoController;
import br.ulbra.model.Chamado;

public class Teste {
    public static void main(String[] args) {

        Chamado c = new Chamado();
        c.setSolicitante("Professor João");
        c.setSala("Lab 1");
        c.setEquipamentoTag("PC-01");
        c.setProblemaRelatado("Computador não liga");
        c.setDiagnosticoTecnico("Fonte queimada");
        c.setPrioridade("ALTA");

        ChamadoController controller = new ChamadoController();
        controller.salvar(c);

        System.out.println("Inserido!");
    }
}