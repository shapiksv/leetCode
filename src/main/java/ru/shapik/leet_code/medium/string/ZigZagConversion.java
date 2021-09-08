package ru.shapik.leet_code.medium.string;

public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
       int length = s.length();
       if (length < numRows || numRows <=1) return s;

       char[] chars = new char[length];
       int count = 0;

       int interval = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            int step = interval - 2 * i;
            for (int j = i; j < length; j += interval) {
                chars[count] = s.charAt(j);
                count++;
                if (step> 0 && step< interval && j + step < length) {
                    chars[count]=s.charAt(j+step );
                    count++;
                }
            }
        }
        return new String(chars);
    }
}
