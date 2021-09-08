package ru.shapik.leet_code.medium.string;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring substring = new LongestPalindromicSubstring();
        System.out.println(substring.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {

        String responce = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i ; j--) {
                if (responce.length() < j - i) {
                    String result = checkPalindrome(s.substring(i, j));
                    if (responce.length() < result.length()) responce = result;
                }

            }
        }
        return responce;
    }

    private String checkPalindrome(String s) {
        int middle = s.length()/2;
        for (int i = 0; i < middle; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return "";
        }
        return s;
    }
}
