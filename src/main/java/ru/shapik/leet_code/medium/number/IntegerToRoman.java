package ru.shapik.leet_code.medium.number;

public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman roman = new IntegerToRoman();
        System.out.println(roman.intToRoman(1998));
    }



    public String intToRoman(int num) {
        String number = "";
        number = number + "M".repeat(num/1000);
        num %=1000;
        if (num>=900) {
            number +="CM";
            num-=900;
        }
        int D = num/500;
        num %=500;
        if (num>=400) {
            number +="CD";
            num-=400;
        }
        number = number + "D".repeat(D);
        number = number + "C".repeat(num/100);
        num %=100;
        if (num>=90) {
            number +="XC";
            num-=90;
        }
        int L = num/50;
        num %=50;
        if (num>=40) {
            number +="XL";
            num-=40;
        }
        number = number + "L".repeat(L);
        number = number + "X".repeat(num/10);
        num %=10;
        if (num == 9) return number + "IX";
        int v = num/5;
        num%=5;
        if (num == 4) return number + "IV";
        number = number + "V".repeat(v);
        number = number + "I".repeat(num);

        return number;
    }
}
// MCMXCIV
//    Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
