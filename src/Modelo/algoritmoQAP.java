package Modelo;

import java.util.Random;

public class algoritmoQAP {

    protected int[] permutaciones = new int[10];
    private int[][] mFlujo;
    private int[][] mDistancia;

    public int calcularCosto() {
        int costo = 0;
        for (int i = 0; i < permutaciones.length; i++) {
            for (int j = 0; j < permutaciones.length; j++) {
                costo += mFlujo[i][j] * mDistancia[permutaciones[i]][permutaciones[j]];
            }
        }
        return costo;
    }

    public void permutar() {
        if (vectorVacio(permutaciones) == false) {
            Random rand = new Random();
            int aleatorio1 = 0, aleatorio2 = 0;
            while (aleatorio1 == aleatorio2) {
                aleatorio1 = (int) (Math.random() * (mDistancia.length)) + 0;
                aleatorio2 = (int) (Math.random() * (mDistancia.length)) + 0;
                int aux1 = permutaciones[aleatorio1];
                int aux2 = permutaciones[aleatorio2];
                permutaciones[aleatorio1] = aux2;
                permutaciones[aleatorio2] = aux1;

                calcularCosto();
            }
        } else {
            permutaciones = new int[mDistancia.length];
            for (int i = 0; i < mDistancia.length; i++) {
                permutaciones[i] = i;
                System.out.print("[" + permutaciones[i] + "] ");
            }
        }
    }

    public boolean vectorVacio(int[] permu) {
        boolean tf = true;
        for (int i = 0; i < permu.length; i++) {
            if (permu[i] != 0) {
                tf = false;
            }
        }
        return tf;
    }

    public int[][] getmFlujo() {
        return mFlujo;
    }

    public void setmFlujo(int[][] mFlujo) {
        this.mFlujo = mFlujo;
    }

    public int[][] getmDistancia() {
        return mDistancia;
    }

    public void setmDistancia(int[][] mDistancia) {
        this.mDistancia = mDistancia;
    }

}
