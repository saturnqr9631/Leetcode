/*Runtime: 5 ms, faster than 55.25% of Java online submissions for Integer to Roman.
Memory Usage: 43.1 MB, less than 6.20% of Java online submissions for Integer to Roman */
class Solution {
    public String intToRoman(int num) {
        String romanForm = "";
        romanForm = intToRoman_rec(num);
        return romanForm;
    }

    private String intToRoman_rec(int num) {
        if (num >= 1000) {
            int scale = num / 1000;
            String part = "";
            for (int i = 0; i < scale; i++) {
                part += "M";
            }
            return part + intToRoman_rec(num - scale * 1000);
        } else if (num >= 500) {
            int scale = num / 100;
            String part = "";
            if (scale == 9) {
                part += "CM";
                return part + intToRoman_rec(num - 900);
            } else {
                scale = num / 500;
                for (int i = 0; i < scale; i++) {
                    part += "D";
                }
                return part + intToRoman_rec(num - scale * 500);
            }

        } else if (num >= 100) {
            int scale = num / 100;
            String part = "";
            if (scale == 4) {
                part += "CD";
            } else {
                for (int i = 0; i < scale; i++) {
                    part += "C";
                }
            }
            return part + intToRoman_rec(num - scale * 100);
        } else if (num >= 50) {
            int scale = num / 10;
            String part = "";
            if (scale == 9) {
                part += "XC";
                return part + intToRoman_rec(num - 90);
            } else {
                scale = num / 50;
                for (int i = 0; i < scale; i++) {
                    part += "L";
                }
                return part + intToRoman_rec(num - scale * 50);
            }
        } else if (num >= 10) {
            int scale = num / 10;
            String part = "";
            if (scale == 4) {
                part += "XL";
            } else {
                for (int i = 0; i < scale; i++) {
                    part += "X";
                }
            }
            return part + intToRoman_rec(num - scale * 10);
        } else if (num >= 5) {
            int scale = num / 1;
            String part = "";
            if (scale == 9) {
                part += "IX";
                return part + intToRoman_rec(num - 9);
            } else {
                scale = num / 5;
                for (int i = 0; i < scale; i++) {
                    part += "V";
                }
                return part + intToRoman_rec(num - 5);
            }
        } else {
            String part = "";
            if (num == 4) {
                return "IV";
            } else {
                for (int i = 0; i < num; i++) {
                    part += "I";
                }
                return part;
            }

        }
    }
}