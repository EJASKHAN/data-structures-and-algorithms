package string;

/**
 * @author Ejaskhan
 **/
public class LexographicallySmallest {


    static String findSmallest(String a[], int n)
    {
        StringBuilder builder= new StringBuilder();
        String nextStr;
        String currStr;
        for(int i=0;i<n-1;i++)
        {
           currStr = a[i];
           nextStr = a[i+1];
           for(int k=0;k<currStr.length();k++)
            {
                if(currStr.charAt(k) >= nextStr.charAt(0))
                {
                    break;
                }
                else
                {
                    builder.append(currStr.charAt(k));
                }
            }
        }
        builder.append(a[n-1].charAt(0));
        return builder.toString();
    }
        static void sort(String a[], int n)
        {
            //sort the array
            for(int i = 0;i < n;i++)
            {
                for(int j = i + 1;j < n;j++)
                {

                    // comparing which of the
                    // two concatenation causes
                    // lexiographically smaller
                    // string
                    if((a[i] + a[j]).compareTo(a[j] + a[i]) > 0)
                    {
                        String s = a[i];
                        a[i] = a[j];
                        a[j] = s;
                    }
                }
            }
        }

        static String lexsmallest(String a[], int n)
        {

            // Sort strings
            sort(a,n);

            // Concatenating sorted strings
            String answer = "";
            for (int i = 0; i < n; i++)
                answer += a[i]+"-";

            return answer;

           /* StringBuilder answer = new StringBuilder();
            for (int i = 0; i < n; i++)
                answer.append("");*/

            //return answer.toString();
        }


        // Driver code
        public static void main(String args[])
        {
           String a[] = {"c", "cb", "cba"};
            //String a[] = {"aabb"};
            String testCase[]={
                    "apq",
                    "bct",
                    "def",
                    "aes"
            };
            String testCase2[]={
                    "aabb",
                    "bbcc",
                    "ccdd",
                    "ddee",
                    "eeff",
                    "ffgg"
            };
            String b[]={"dkibghhc",
                    "ejdkjjif",
                    "hdhfffb",
                    "hjjehgi",
                    "ijc",
                    "cchhjcdb",
                    "iccbe" };
            String test[] = {"aabbccddeeff","aabbccddeeffgg","aabbccddeeffg","abcdef"};
            String testCase3[]={"apq", "bcd" , "cde"};
            int n = 1;
            /*System.out.println("lexiographically smallest string = "
                    + lexsmallest(a, ));*/

            System.out.println("lexiographically smallest string = "+
                    findSmallest(b,7));

        }


}
