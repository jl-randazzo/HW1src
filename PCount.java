/**
 * Created by jl_ra on 9/13/2016.
 */


public class PCount {
    public static void main(String args[]){
        int index1 = 0, arith = 0;
        int rightp, leftp, numbcount;
        String testString = "1+2)*3-4)*5-6)))";

        while(index1 < testString.length()) {
            index1 = testString.indexOf(')', index1);
            rightp=1;
            leftp=0;
            numbcount = 0;
            for (int i = index1; i >= 0; i--) {
                if (i == 0 && arith > 0){
                    testString = "(" + testString.substring(0, testString.length());
                    arith--;
                    index1++;
                    break;
                }
                if (testString.charAt(i) == ')') rightp++;
                if (testString.charAt(i) != '*' && testString.charAt(i) != '/' && testString.charAt(i) != '+' && testString.charAt(i) != '-' && testString.charAt(i) != '(') {
                    numbcount++;
                    continue;
                }

                if (testString.charAt(i) == '(') {
                    rightp--;
                    leftp++;
                    continue;
                }
                //if (testString.charAt(i) <= '9' && testString.charAt(i) >= '0') continue;

                if (arith > leftp && i > 0 && (leftp<rightp) && (numbcount%2)==0) {
                    int j = i + 1;
                    testString = testString.substring(0, j) + "(" + testString.substring(j);
                    arith--;
                    index1++;
                    break;
                }
                if (testString.charAt(i) == '*' || testString.charAt(i) == '/' || testString.charAt(i) == '+' || testString.charAt(i) == '-') {
                    arith++;
                    continue;
                }

            }
            arith=0;
            index1++;
        }
        System.out.println(testString);
    }

}
