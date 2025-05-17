package Java;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class c1{

    final static HashMap<Integer, String> numberMap = new HashMap<>();
    final static HashMap<Integer, String> groupMap = new HashMap<>();
    static {
        numberMap.put(1, "One");
        numberMap.put(2, "Two");
        numberMap.put(3, "Three");
        numberMap.put(4, "Four");
        numberMap.put(5, "Five");
        numberMap.put(6, "Six");
        numberMap.put(7, "Seven");
        numberMap.put(8, "Eight");
        numberMap.put(9, "Nine");
        numberMap.put(10, "Ten");
        numberMap.put(11, "Eleven");
        numberMap.put(12, "Twelve");
        numberMap.put(13, "Thirteen");
        numberMap.put(15, "Fifteen");
        numberMap.put(20, "Twenty");
        numberMap.put(50, "Fifty");
        numberMap.put(30, "Thirty");
    }
    static {
        groupMap.put(1, "Thousand");
        groupMap.put(2, "Million");
        groupMap.put(3, "Billion");
        groupMap.put(4, "Trillion");
        groupMap.put(5, "Quadrillion");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();

        if (number < 0) {
            System.out.println("Negative numbers are not supported.");
            return;
        }

        String result = convertToWords(number);
        System.out.println(result);
    }

    public static String getGroupValue (HashMap<Integer, String> map, int key, String defaultvalue) {
        return map.containsKey(key) ? map.get(key) : defaultvalue;
    }

    public static String convertToWords(int number) {
        StringBuilder convertedWords = new StringBuilder();

        try {
            DecimalFormat df = new DecimalFormat("#,###");
            String[] groupedValue = df.format(number).split(","); // groupedValue = ["123","456","789"]

            int groupPosition = groupedValue.length - 1; // pointer from left to right traverse (hundreds to ones)

            for (String group: groupedValue) {
                int value = Integer.parseInt(group);
                if (value == 0) {
                    continue;
                }

                String numberWord = extractWords(value, groupPosition);

                convertedWords.append(numberWord);

                groupPosition--;
            }
    
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return convertedWords.toString();
    }

    public static String extractWords(int groupValue, int groupPosition) {
        StringBuilder result = new StringBuilder();

        int hundredsFirstDigit = groupValue / 100;
        int hundredsRemainingDigits = groupValue % 100;

        if(hundredsFirstDigit > 0) {
            result.append(String.format("%s %s ", getGroupValue(numberMap, hundredsFirstDigit, ""), "Hundred"));
        }

        if(hundredsRemainingDigits > 0){
            if(!numberMap.containsKey(hundredsRemainingDigits)){
                int tensFirstDIgit = hundredsRemainingDigits / 10;
                int tensSecondDigit = hundredsRemainingDigits % 10;

                if(hundredsRemainingDigits < 20){
                    result.append(String.format("%s%s ", getGroupValue(numberMap, hundredsRemainingDigits - 10, ""), "teen")); // e.g 14 gets 4 by 14-10 then add teen
                }
                else{
                    String tensDefault = String.format("%s%s", getGroupValue(numberMap, tensFirstDIgit, ""), "ty");
                    result.append(String.format("%s ", getGroupValue(numberMap, tensFirstDIgit * 10, tensDefault))); //gets unique tens from map e.g 20, 30 else add ty to first digit e.g four-ty
                    result.append(getGroupValue(numberMap, tensSecondDigit, ""));
                }
            }
            else{
                result.append(getGroupValue(numberMap, hundredsRemainingDigits, ""));
            }
        }

        result.append(String.format(" %s ", getGroupValue(groupMap, groupPosition, ""))); 

        return result.toString();

    }
}