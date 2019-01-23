package com.wchb.mj.dreamG;

/**
 * @date 12/14/18 6:25 PM
 */
public class Boggle {
    static int M = 3;
    static int N = 3;

    public static void main(String[] args) {

        String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};

        char[][] boggle = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}
        };

        for (int i = 0; i < dictionary.length; i++) {
            String word = dictionary[i];
            if (isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), 0, 0)) {
                System.out.println(word);
            }
        }
    }

    private static boolean isValidMove(char[][] boggle, char ch, String word, int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex > (M - 1) || colIndex < 0 || colIndex > (N - 1)) {
            return false;
        }
        if (boggle[rowIndex][colIndex] == ch && "".equals(word)) {
            return true;
        }

        boolean b = false;
        if (!"".equals(word)) {
            b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex + 1, colIndex);
            if (!b)
                b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex - 1, colIndex);
            if (!b)
                b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex, colIndex + 1);
            if (!b)
                b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex, colIndex - 1);
            if (!b)
                b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex - 1, colIndex - 1);
            if (!b)
                b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex + 1, colIndex + 1);
            if (!b)
                b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex + 1, colIndex - 1);
            if (!b)
                b = isValidMove(boggle, word.charAt(0), word.substring(1, word.length()), rowIndex - 1, colIndex + 1);
            return b;
        } else {
            return b;
        }
    }
}
