package com.nishchay.ds.dp.catalan;


/*
 *
 *===========Program for nth Catalan Number===========
 *
 *
 * here is Catalan numbers series
 * 				n 		= 0, 1, 2, 3,  4,  5,   6,   7,    8,    9,	…
 * Catalan numbers		= 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
 *
 *
 * f(0) 	= 1
 * f(0) 	= 1 , n >=0
 * f(n)	= for(i = 0 to n-1) res + = f(i) * f(n-i-1) ;
 *
 *
 * https://www.geeksforgeeks.org/applications-of-catalan-numbers/
 *
 *===========Applications of Catalan Numbers===========
 *
 * https://www.geeksforgeeks.org/applications-of-catalan-numbers/
 * */
public class CatalanSeries {


    public static void main(String[] args) {
        CatalanSeries ref = new CatalanSeries();
        for (int i = 0; i < 10; i++)
            System.out.print(ref.catalan(i) + " ");
    }


    // A recursive function to find nth catalan number
    int catalan(int n) {
        int res = 0;

        // Base case
        if (n <= 1)
            return 1;

        for (int i = 0; i < n; i++)
            res += catalan(i) * catalan(n - i - 1);

        return res;
    }

}
/*
* O/P => 1 1 2 5 14 42 132 429 1430 4862
 * */