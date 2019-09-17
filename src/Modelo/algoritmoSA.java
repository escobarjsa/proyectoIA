package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class algoritmoSA extends algoritmoQAP {

    String[] auxPermutacion = null;

    public String SimulatedAnnealing(int n1, int n2, int T, double dT) {
        //Cargamos las dos matrizces 
        int[][] mFlujo;
        int[][] mDistancia;

        ArrayList<Double> puntos = new ArrayList<Double>();
        //Declaracion de variables
        double delta = 0;
        double sActual = 0;
        double sNuevo = 0;
        double aleatorio = 0;
        double aux = 1000000;
        int count = 0;
        Random rand = new Random();
        permutar();
        //Inicio del algorito
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                sActual = calcularCosto();
                //System.out.println("Costo Actual: " + sActual);
                permutar();
                sNuevo = calcularCosto();
                //System.out.println("Costo Nuevo: " + sNuevo);
                delta = sNuevo - sActual;
                if (delta < 0) {
                    sActual = sNuevo;
                    if (!(sActual > aux)) {
                        aux = sActual;
                        //auxPermutacion =permutaciones;
                        auxPermutacion = convertir(permutaciones);
                    }
                } else {
                    aleatorio = 0 + (1 - 0) * rand.nextDouble();
                    if (aleatorio < euler(delta, T)) {
                        sActual = sNuevo;
                    }
                }
                //Guardar (j, sActual)
                count++;
                puntos.add(sActual);
            }
            T *= dT;
        }
        grafica g = new grafica();
        g.setPuntos(puntos);
        g.graficar();
        //System.out.println("SActual: " + sActual);
        //System.out.println("Costo menor hallado: " + aux);
        String result = "";
        for (int i = 0; i < auxPermutacion.length; i++) {
            //System.out.print("[" +auxPermutacion[i] + "] ");
            result += "[" + auxPermutacion[i] + "]";
        }
        return aux + " " + result;
    }

    public double euler(double delta, int T) {
        return Math.exp((-delta / T));
    }

    public String[] convertir(int[] array) {
        String[] arreglo = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            arreglo[i] = (array[i] + "");
        }
        return arreglo;
    }
}
