package lab2.dc.unifil.br;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import static lab2.dc.unifil.br.Classificadores.OredemClassificacao;


/**
 * Write a description of class lab2.dc.unifil.br.Cronometro here.
 * 
 * @author Ricardo Inacio Alvares e Silva
 * @version 20200519
 */
public class Cronometro {

    /**
     * Faz benchmarkings do algoritmo que recebe uma entrada N, inicialmente igual a nInicial,
     * até nFinal, incrementando a nPasso. Retorna uma lista com todas essas medições, classificada
     * do menor N ao maior.
     *
     * @param nInicial Valor escalar de N inicialmente.
     * @param nFinal Valor escalar de N que interrompe as medições.
     * @param nPasso Quantidade de incremento em N a cada iteração de medições.
     * @param repeticoes Quantidade de vezes que cada medição é feita. Quanto maior o valor,
     *                   mais precisa a medição, mas mais demorado o processo total.
     * @param recriadorCobaia Método que recria a estrutura de dados aceita como entrada pelo
     *                        algoritmo em teste, a fim de evitar testes em estruturas já modificadas
     *                        por algoritmos que causam mutação no objeto.
     * @param algoritmo Algoritmo a ser testado.
     * @param <T> Tipo da estrutura de dados do algoritmo.
     * @return Lista com medições de tempo, classificada do menor ao maior N.
     */
    public static <T> List<Medicao> benchmarkCrescimentoAlgoritmo(int nInicial, int nFinal,
            int nPasso, int repeticoes,
            Supplier<T> recriadorCobaia,
            Consumer<T> algoritmo) {

        double tempoPassado = 0;
        List<Medicao> copia = new ArrayList<>();
        //copia.addAll((Collection<? extends Medicao>) recriadorCobaia.get());
        int contador = 0;

        for (int n = nInicial; n < nFinal;  n += nPasso) {
            T cobaia = recriadorCobaia.get();
            long tempoInicial = System.nanoTime();
            algoritmo.accept(cobaia);

            Classificadores.quicksortDecrecente((List<Integer>) cobaia);

            contador++;

            long tempoFim = System.nanoTime();
            tempoPassado = (tempoFim - tempoInicial) * 1e-9;
            tempoPassado /= repeticoes;
            Medicao medidas = new Medicao(contador, tempoPassado);
            copia.add(medidas);
        }
        System.out.println("tempo: "+tempoPassado);
        return copia;
    }


    /**
     * o metodo benchmarkAlgoritmo ele calcula o menor tempo do cronometro
     *
     * @param recriadorCobaia Método que recria a estrutura de dados aceita como entrada pelo
     *                        algoritmo em teste.
     * @param algoritmo Algoritmo a ser testado.
     * @param repeticoes Quantidade de vezes que cada medição é feita.
     * @param <T> Tipo da estrutura de dados do algoritmo.
     * @return retorna o menor tempo
     */
    public static <T> double benchmarkAlgoritmo(Supplier<T> recriadorCobaia,
                                                Consumer<T> algoritmo, int repeticoes) {
        Cronometro cron = new Cronometro();
        double menorTempo = Double.POSITIVE_INFINITY;
        for (int i = 0; i < repeticoes; i++) {
            T cobaia = recriadorCobaia.get();

            cron.zerar();
            cron.iniciar();
            algoritmo.accept(cobaia);
            double ultimoTempo = cron.parar();

            menorTempo = Math.min(menorTempo, ultimoTempo);
        }

        return menorTempo;
    }

    /**
     * Construtor padrão da classe.
     */
    public Cronometro() {

        throw new RuntimeException("O aluno ainda não implementou essa funcionalidade.");
    }


    /**
     * Inicia ou reinicia a contagem de tempo. Nunca zera o último estado do contador. Se o tempo já
     * estiver correndo, não faz nada.
     */
    public void iniciar() {

        throw new RuntimeException("O aluno ainda não implementou essa funcionalidade.");
    }
    
    /**
     * Para a contagem de tempo e retorna uma leitura do tempo decorrido.
     * 
     * @return Tempo decorrido até o momento da parada, em milissegundos.
     */
    public double parar() {

        throw new RuntimeException("O aluno ainda não implementou essa funcionalidade.");
    }
    
    /**
     * Retorna o tempo decorrido contado até então, independente se está parado ou correndo. Não
     * altera o estado de contagem (parado/correndo).
     * 
     * @return Tempo decorrido contado pelo cronômetro, em milissegundos.
     */
    public double lerTempoEmMilissegundos() {
        long tempoInicial = System.currentTimeMillis();

        //throw new RuntimeException("tem algo faltando.");

        long tempoFinal = System.currentTimeMillis();
        double resultadoMilesegundo = (tempoFinal - tempoInicial) / 1000d;

        return resultadoMilesegundo;
    }
    
    /**
     * Zera o contador de tempo do cronômetro. Se o cronômetro estava em estado de contagem, ele é
     * parado.
     */
    public void zerar() {

        throw new RuntimeException("O aluno ainda não implementou essa funcionalidade.");
    }
    
    // Atributos da classe são declarados aqui
    
}
