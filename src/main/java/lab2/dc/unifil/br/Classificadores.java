package lab2.dc.unifil.br;

import java.util.*;
import java.util.function.Function;

public class Classificadores {

    public enum OredemClassificacao{
        CRESCENTE, DECRESCENETE;
    }

    //codigo feio

    /**
     Classifica a lista em ordem crescente, pelo método de
     * quicksort, in-place. Utiliza memória auxiliar.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
    public static void quicksort(List<Integer> lista) {
        quick(lista, 0, lista.size() - 1);
    }
    public static void quick(List<Integer> lista, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = inicio;
            int esquerda = inicio + 1;
            int direita = fim;
            int pivoValor = lista.get(pivo);
            while (esquerda <= direita) {
                System.out.println(lista);
                while (esquerda <= fim && pivoValor >= lista.get(esquerda)) {
                    esquerda++;
                }
                while (direita > inicio && pivoValor < lista.get(direita)) {
                    direita--;
                }
                if (esquerda < direita) {
                    Collections.swap(lista, esquerda, direita);
                }
            }
            Collections.swap(lista, pivo, esquerda - 1);
            quick(lista, inicio, direita - 1);
            quick(lista, direita + 1, fim);
        }
    }

    /**
     * Classifica a lista em ordem crescente, pelo método de
     * mergesort, in-place. Utiliza memória auxiliar.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
    public static void mergesort(List<Integer> lista) {
        // Casos base
        if (lista.size() <= 1) return;

        // Casos de subdivisão recursiva
        final int idxMeioLista = lista.size() / 2;
        List<Integer> esquerda = lista.subList(0, idxMeioLista);
        mergesort(esquerda);

        List<Integer> direita = lista.subList(idxMeioLista, lista.size());
        mergesort(direita);

        merge(lista, esquerda, direita);
    }

    private static void merge(List<Integer> lista, List<Integer> esquerda, List<Integer> direita) {
        List<Integer> merged = new ArrayList<>(lista);

        int idxE = 0, idxD = 0, idxL = 0;
        while (idxE < esquerda.size() && idxD < direita.size()) {
            if (esquerda.get(idxE) < direita.get(idxD)) {
                merged.set(idxL, esquerda.get(idxE));
                idxE++;
            } else {
                merged.set(idxL, direita.get(idxD));
                idxD++;
            }
            idxL++;
        }

        int idxF;
        List<Integer> faltantes;
        if (idxE < esquerda.size()) {
            faltantes = esquerda;
            idxF = idxE;
        } else {
            faltantes = direita;
            idxF = idxD;
        }

        while (idxF < faltantes.size()) {
            merged.set(idxL, faltantes.get(idxF));
            idxL++; idxF++;
        }

        for (int i = 0; i < lista.size(); i++) {
            lista.set(i, merged.get(i));
        }
    }

    /**
     * Classifica a lista em ordem crescente, pelo método de
     * inserção, in-place.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
    public static void insertionsort(List<Integer> lista) {

        for (int i = 1; i < lista.size(); i++) {
            Integer elem = lista.get(i);

            int j = i;
            while (j > 0 && lista.get(j-1) > elem) {

                lista.set(j, lista.get(j-1)); // Deslocamento

                j--;
            }

            lista.set(j, elem);
        }
    }


    /**
     * Classifica a lista em ordem crescente, pelo método de
     * bubblesort, in-place.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
    public static void bubblesort(List<Integer> lista) {

        boolean houvePermuta; do {
            houvePermuta = false;

            // Sobe a bolha
            for (int i = 1; i < lista.size(); i++) {

                if (lista.get(i - 1) > lista.get(i)) {
                    permutar(lista, i - 1, i);
                    houvePermuta = true;
                }
            }
        } while (houvePermuta);
    }

    /**
     * Classifica a lista em ordem crescente, pelo método de
     * selection sort, in-place.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
    public static void selectionsort(List<Integer> lista) {

        for (int i = 0; i < lista.size(); i++) {
            int menorIdx = encontrarIndiceMenorElem(lista, i);
            permutar(lista, menorIdx, i);
        }
    }


    /********
     *  SECAO DOS PRIVATES
     */


    /**
     * Encontra o índice do menor elemento da lista.
     * @param lista lista a ser procurada.
     * @return índice do elemento, na escala iniciada em zero.
     */
    private static int encontrarIndiceMenorElem(List<Integer> lista, int idxInicio) {
        int menor = idxInicio;
        for (int i = idxInicio+1; i < lista.size(); i++) {

            if (lista.get(menor) > lista.get(i))
                menor = i;
        }
        return menor;
    }

    /**
     * Permuta (swap) dois elementos da lista de posição.
     *
     * @param lista Lista cujos elementos serão permutados.
     * @param a     Îndice do primeiro elemento a ser permutado.
     * @param b     Îndice do outro elemento a ser permutado.
     */
    private static void permutar(List<Integer> lista, int a, int b) {
        Integer permutador = lista.get(a); // permutador = lista[a]
        lista.set(a, lista.get(b)); // lista[a] = lista[b]
        lista.set(b, permutador); // lista[b] = permutador
    }

    /**
     * cria numeros aleatorios
     */
    private static Random rng = new Random("Seed constante repetível".hashCode());

    /**
     Classifica a lista em ordem Decrecente, pelo método de
     * quicksort, in-place.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
    public static void quicksortDecrecente(List<Integer> lista) {
        quickDecrecentes(lista, 0, lista.size() - 1);
    }
    public static void quickDecrecentes(List<Integer> lista, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = inicio;
            int esquerda = inicio + 1;
            int direita = fim;
            int pivoValor = lista.get(pivo);
            while (esquerda <= direita) {
                System.out.println(lista);
                while (esquerda <= fim && pivoValor <= lista.get(esquerda)) {
                    esquerda++;
                }
                while (direita > inicio && pivoValor > lista.get(direita)) {
                    direita--;
                }
                if (esquerda < direita) {
                    Collections.swap(lista, esquerda, direita);
                }
            }
            Collections.swap(lista, pivo, esquerda - 1);
            quick(lista, inicio, direita - 1);
            quick(lista, direita + 1, fim);
        }
    }

    /**
     * Classifica a lista em ordem Decrecente, pelo método de
     * mergesort, in-place. Utiliza memória auxiliar.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
    public static void mergesortDecrecente(List<Integer> lista) {
        // Casos base
        if (lista.size() <= 1) return;

        // Casos de subdivisão recursiva
        final int idxMeioLista = lista.size() / 2;
        List<Integer> esquerda = lista.subList(0, idxMeioLista);
        mergesort(esquerda);

        List<Integer> direita = lista.subList(idxMeioLista, lista.size());
        mergesort(direita);

        mergeDecrecente(lista, esquerda, direita);
    }

    private static void mergeDecrecente(List<Integer> lista, List<Integer> esquerda, List<Integer> direita) {
        List<Integer> merged = new ArrayList<>(lista);

        int idxE = 0, idxD = 0, idxL = 0;
        while (idxE < esquerda.size() && idxD < direita.size()) {
            if (esquerda.get(idxE) > direita.get(idxD)) {
                merged.set(idxL, esquerda.get(idxE));
                idxE++;
            } else {
                merged.set(idxL, direita.get(idxD));
                idxD++;
            }
            idxL++;
        }

        int idxF;
        List<Integer> faltantes;
        if (idxE < esquerda.size()) {
            faltantes = esquerda;
            idxF = idxE;
        } else {
            faltantes = direita;
            idxF = idxD;
        }

        while (idxF < faltantes.size()) {
            merged.set(idxL, faltantes.get(idxF));
            idxL++; idxF++;
        }

        for (int i = 0; i < lista.size(); i++) {
            lista.set(i, merged.get(i));
        }
    }

    /**
     * Classifica a lista em ordem Decrecente, pelo método de
     * inserção, in-place.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
    public static void insertionsortDecrecente(List<Integer> lista) {

        for (int i = 1; i < lista.size(); i++) {
            Integer elem = lista.get(i);

            int j = i;
            while (j > 0 && lista.get(j-1) < elem) {

                lista.set(j, lista.get(j-1)); // Deslocamento

                j--;
            }

            lista.set(j, elem);
        }
    }


    /**
     * Classifica a lista em ordem Decrecente, pelo método de
     * bubblesort, in-place.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
    public static void bubblesortDecrecente(List<Integer> lista) {

        boolean houvePermuta; do {
            houvePermuta = false;

            // Sobe a bolha
            for (int i = 1; i < lista.size(); i++) {

                if (lista.get(i - 1) < lista.get(i)) {
                    permutar(lista, i - 1, i);
                    houvePermuta = true;
                }
            }
        } while (houvePermuta);
    }

    /**
     * Classifica a lista em ordem Decrecente, pelo método de
     * selection sort, in-place.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
    public static void selectionsortDecrecente(List<Integer> lista) {

        for (int i = 0; i < lista.size(); i++) {
            int menorIdx = encontrarIndiceMenorElemD(lista, i);
            permutar(lista, menorIdx, i);
        }
    }


    /********
     *  SECAO DOS PRIVATES
     */


    /**
     * Encontra o índice do menor elemento da lista.
     * @param lista lista a ser procurada.
     * @return índice do elemento, na escala iniciada em zero.
     */
    private static int encontrarIndiceMenorElemD(List<Integer> lista, int idxInicio) {
        int menor = idxInicio;
        for (int i = idxInicio+1; i < lista.size(); i++) {

            if (lista.get(menor) < lista.get(i))
                menor = i;
        }
        return menor;
    }

//tentativa de usar o enum
    /*
    /**
     * Classifica a lista em ordem crescente, pelo método de
     * bubblesort, in-place.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
/*    public static void bubblesort(List<Integer> lista,OredemClassificacao ordem) {
        boolean houvePermuta; do {
            houvePermuta = false;

            // Sobe a bolha
            for (int i = 1; i < lista.size(); i++) {
                if (ordem == OredemClassificacao.CRESCENTE && lista.get(i-1) > lista.get(i)
                   || (ordem == OredemClassificacao.DECRESCENETE && lista.get(i-1)<lista.get(i))) {

                    permutar(lista, i - 1, i);
                    houvePermuta = true;

                }
            }
        } while (houvePermuta);
    }
*/
    /*
    /**
     * Classifica a lista em ordem crescente, pelo método de
     * inserção, in-place.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
  /*  public static void insertionsort(List<Integer> lista, OredemClassificacao ordena) {

        for (int i = 1; i < lista.size(); i++) {
            Integer elem = lista.get(i);

            int j = i;
            while (ordena == OredemClassificacao.CRESCENTE && j > 0 && lista.get(j-1) > elem
                    || ordena == OredemClassificacao.DECRESCENETE && j > 0 && lista.get(j-1) < elem) {

                lista.set(j, lista.get(j-1)); // Deslocamento

                j--;
            }

            lista.set(j, elem);
        }
    }
*/
    /*
    /**
     * Classifica a lista em ordem crescente, pelo método de
     * selection sort, in-place.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
  /*  public static void selectionsort(List<Integer> lista, OredemClassificacao ordena) {

        for (int i = 0; i < lista.size(); i++) {
            int menorIdx = encontrarIndiceMenorElem(lista, i, ordena);
            permutar(lista, menorIdx, i);
        }
    }

    public static void quicksort(List<Integer> lista) {
        quick(lista, 0, lista.size() - 1);
    }
    public static void quick(List<Integer> lista, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = inicio;
            int esquerda = inicio + 1;
            int direita = fim;
            int pivoValor = lista.get(pivo);
            while (esquerda <= direita) {
                System.out.println(lista);
                while (esquerda <= fim && pivoValor >= lista.get(esquerda)) {
                    esquerda++;
                }
                while (direita > inicio && pivoValor < lista.get(direita)) {
                    direita--;
                }
                if (esquerda < direita) {
                    Collections.swap(lista, esquerda, direita);
                }
            }
            Collections.swap(lista, pivo, esquerda - 1);
            quick(lista, inicio, direita - 1);
            quick(lista, direita + 1, fim);
        }
    }*/
    /*
    /**
     * Classifica a lista em ordem crescente, pelo método de
     * mergesort, in-place. Utiliza memória auxiliar.
     * @param lista Lista a ser classificada, sofre mutação (in-place).
     */
/*    public static void mergesort(List<Integer> lista, OredemClassificacao ordena) {
        // Casos base
        if (lista.size() <= 1) return;

        // Casos de subdivisão recursiva
        final int idxMeioLista = lista.size() / 2;
        List<Integer> esquerda = lista.subList(0, idxMeioLista);
        mergesort(esquerda,ordena);

        List<Integer> direita = lista.subList(idxMeioLista, lista.size());
        mergesort(direita,ordena);

        merge(lista, esquerda, direita, ordena);
    }

    private static void merge(List<Integer> lista, List<Integer> esquerda, List<Integer> direita,
                              OredemClassificacao ordena) {
        List<Integer> merged = new ArrayList<>(lista);

        int idxE = 0, idxD = 0, idxL = 0;
        while (idxE < esquerda.size() && idxD < direita.size()) {
            if (ordena == OredemClassificacao.CRESCENTE && esquerda.get(idxE) < direita.get(idxD)
                    || ordena == OredemClassificacao.DECRESCENETE && esquerda.get(idxE) > direita.get(idxD)) {
                merged.set(idxL, esquerda.get(idxE));
                idxE++;
            } else {
                merged.set(idxL, direita.get(idxD));
                idxD++;
            }
            idxL++;
        }

        int idxF;
        List<Integer> faltantes;
        if (idxE < esquerda.size()) {
            faltantes = esquerda;
            idxF = idxE;
        } else {
            faltantes = direita;
            idxF = idxD;
        }

        while (idxF < faltantes.size()) {
            merged.set(idxL, faltantes.get(idxF));
            idxL++; idxF++;
        }

        for (int i = 0; i < lista.size(); i++) {
            lista.set(i, merged.get(i));
        }
    }

    /*    /**
     * Permuta (swap) dois elementos da lista de posição.
     * @param lista Lista cujos elementos serão permutados.
     * @param a Îndice do primeiro elemento a ser permutado.
     * @param b Îndice do outro elemento a ser permutado.
     */
   /* private static void permutar(List<Integer> lista, int a, int b) {
        Integer permutador = lista.get(a); // permutador = lista[a]
        lista.set(a, lista.get(b)); // lista[a] = lista[b]
        lista.set(b, permutador); // lista[b] = permutador

    }

    /**
     * Encontra o índice do menor elemento da lista.
     * @param lista lista a ser procurada.
     * @return índice do elemento, na escala iniciada em zero.
     */
/*    private static int encontrarIndiceMenorElem(List<Integer> lista, int idxInicio, OredemClassificacao ordena) {
        int menor = idxInicio;
        for (int i = idxInicio+1; i < lista.size(); i++) {

            if (ordena == OredemClassificacao.CRESCENTE && lista.get(menor) > lista.get(i)
                    || ordena == OredemClassificacao.DECRESCENETE && lista.get(menor) < lista.get(i))
                menor = i;
        }
        return menor;
    }*/



}
