/**
 * Created by jl_ra on 9/12/2016.
 */
public class CircularRotation {

    public static void main(String args[])
    {
        String test1 = "ACTGACGQRSTAV";
        String test2 = "TGACGQRSTAVAC";
        char t1one = test1.charAt(0);
        boolean equal = false;
        boolean done = false;
        int ind1 = 0;


        if (test1.length() == test2.length()) {
            while(!done) {
                ind1 = test2.indexOf(t1one, ind1);
                if (ind1 == -1) break;
                for (int i = ind1; i < test2.length(); i++) {
                    if (test1.charAt(i - ind1) == test2.charAt(i)) equal = true;
                    else {
                        equal = false;
                        //break;
                    }
                }
                if (equal == true) {
                    for (int j = 0; j < (ind1); j++) {
                        if (test1.charAt(j + (test2.length()-ind1)) == test2.charAt(j)) {
                            equal = true;
                        } else {
                            equal = false;
                            //break;
                        }
                    }
                }
                if (equal == true) done = true;
                else ind1++;

            }
        }
        if(equal==true) System.out.println("Circular rotation true");
        else System.out.println("Circular rotation false");
    }
}

