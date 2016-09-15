/**
 * Created by jl_ra on 9/12/2016.
 */
public class Hw_1 {

    public static void main(String args[])
    {
        /*int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }*/
        /*double t = 9.0;
        while (Math.abs(t-9.0/t)>.001)
            t = (9.0/t + t) / 2.0;
        System.out.printf("%.5f\n", t);*/
        /*int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum++;
        System.out.println(sum);*/
        /*System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char)('a' + 4));*/
        /*int[] a = new int[10];
        for (int i=0; i < 10; i++)
            a[i] = 9 - i;
        for (int i=0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i=0; i < 10; i++)
            System.out.println(a[i]);*/
        /*String hat = "hat";
        System.out.println(hat.indexOf('a'));
        System.out.println(hat.length());*/

        /*String test1 = "ACTGACG";
        String test2 = "TGACGAC";
        char t1one = test1.charAt(0);
        boolean equal = true;
        boolean done = false;
        int ind1 = 0;

        ind1 = test2.indexOf(t1one, ind1);
        System.out.println(ind1);
        ind1++;
        ind1 = test2.indexOf(t1one, ind1);
        System.out.println(ind1);
        */

        LukeDate testDate = new LukeDate(1, 1, 2000);
        System.out.println(testDate.dayOftheWeek());
    }
}
