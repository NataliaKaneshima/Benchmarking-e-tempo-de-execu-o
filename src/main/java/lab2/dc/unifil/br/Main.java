package lab2.dc.unifil.br;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        // Realiza benchmarkings
                List<Integer> cobaia = Arrays.asList(7,3,9,2,5,8,1,2,8,5,32,8,9,34,7,3,2);
        List<Medicao> medicoebubblesort = Cronometro.benchmarkCrescimentoAlgoritmo(
                10,100,5,1,
                () -> new ArrayList<>(cobaia),
                Classificadores::quicksortDecrecente
        );

        // Plotta gráfico com resultados levantados
        TabelaTempos tt = new TabelaTempos();
        tt.setTitulo("Tempo para ordenação");
        tt.setEtiquetaX("Qtde elementos lista");
        tt.setEtiquetaY("Tempo (s)");
        tt.setLegendas("quicksortDecrecente ");
        for (int i = 0; i < medicoebubblesort.size(); i++) {
            Medicao amostramedicoebubblesort = medicoebubblesort.get(i);

            tt.anotarAmostra(amostramedicoebubblesort.getN(),
                    amostramedicoebubblesort.getTempoSegundos());
        }
        tt.exibirGraficoXY();
    }


}
