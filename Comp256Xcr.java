/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp256.xcr;

/**
 *
 * @author Shayna
 */
public class Comp256Xcr {

    /**
     * Name: Shayna Stewart Compsci 256 Extra Credit Project
     *
     * @param args    
     *
     */
    public static void main(String[] args) {
        System.out.println(findA_n(5, 0));
        System.out.println(findA_n(5, 1));
        System.out.println(findA_n(5, 2));

    }

    public static int findA_n(int n, int a_0) {
        int a_n = ((a_0 * 4) - 3);
        if (n == 1) {
            return a_n;
        } else {
            return findA_n(n - 1, a_n);
        }
    }
}
