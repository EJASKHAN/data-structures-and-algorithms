package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ejaskhan
 **/
public class IntegerToeEnglishWords {
    static Map<String, String> zeros;
    static Map<String, String> numbers;

    static {
        zeros = new HashMap<>();
        zeros.put("1", "0");
        zeros.put("2", "00");
        zeros.put("3", "000");

        numbers = new HashMap<>();
        numbers.put("1", "one");
        numbers.put("2", "two");
        numbers.put("3", "three");
        numbers.put("20", "twenty");
        numbers.put("100", "hundred");
        numbers.put("1000", "thousand");
    }

    public static void main(String args[])
    {
        String englishWord = convertToEnglishWords(1123);
        System.out.println(englishWord);
    }
    public static String convertToEnglishWords(long number) {
        String value = String.valueOf(number);
        int size = value.length();
        String numbersIndex =null;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char index = value.charAt(i);
            String one =null;
            String two =null;
            numbersIndex =null;
            if (i < size - 2) {
                numbersIndex= String.valueOf(index) + zeros.get(String.valueOf(size - (i+1)));
                 one = numbers.get(String.valueOf(index) )+ " ";
                 two= numbers.get(numbersIndex) + " ";
                builder.append(one);
                builder.append(two);
            } else if (i == size - 2) {
                numbersIndex = String.valueOf(index) + "0";
                one = numbers.get( numbersIndex) +" ";
                builder.append(one);
            } else if (i == size - 1) {
                one=numbers.get(String.valueOf(index));
                builder.append(one);
            }


        }
        return builder.toString();
    }
}
