package chapter1.section2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Q15 {
    public static final String path = "C:\\Users\\shevtsov dmitry\\AppData\\Roaming\\JetBrains\\IntelliJIdea2023.2\\scratches\\scratch_2.txt";

    public static void main(String[] args) {
        String text = readAllTextFromFile(path);
        int[] ints = readAllIntsFromText(text);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] readAllIntsFromText(String text) {
        text = text.replaceAll("[^\\d]", " ");
        return getParsedArray(text);
    }

    private static int[] getParsedArray(String text) {
        String stringRepresentationOfIntArray = parseStringRepresentationOfIntArray(text);
        return parseIntArray(stringRepresentationOfIntArray);
    }

    private static int[] parseIntArray(String stringRepresentationOfIntArray) {
        String[] strings = stringRepresentationOfIntArray.split(",");
        return Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
    }


    private static String parseStringRepresentationOfIntArray(String text) {
        var sb = new StringBuilder();
        for (int i = 0; i < text.length() - 1; i++) {
            char currentChar = text.charAt(i);
            char nextChar = text.charAt(i + 1);

            if(currentChar != ' '){
                sb.append(currentChar);
                if(nextChar == ' ' && i + 1 != sb.length() - 1){
                    sb.append(',');
                }
            }

            // check if last element of string is number
            if (i + 1 == text.length() - 1 && Character.isDigit(nextChar))
                sb.append(nextChar);
        }

        return sb.toString();
    }

    private static String readAllTextFromFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            System.out.println("There is a problem with file application interacts. Check if it exists or maybe it was renamed");
            throw new RuntimeException(e);
        }
    }


}
