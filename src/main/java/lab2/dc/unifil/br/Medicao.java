package lab2.dc.unifil.br;

public class Medicao {

    /**
     *
     *
     * @param n recebe um numero
     * @param tempoSegundos recebe o tempo de segundos
     */
    public Medicao(int n, double tempoSegundos) {
        this.n = n;
        this.tempoSegundos = tempoSegundos;
    }

    /**
     *
     * @return o n
     */
    public int getN() {
        return n;
    }

    /**
     *
     * @return o tempo por segundo
     */
    public double getTempoSegundos() {
        return tempoSegundos;
    }

    private int n;
    private double tempoSegundos;
}
