class ReverseInteger {

    public static void main(String[] args) {
        int x = -4236469;
        System.out.println(reverse(x));
    }

    public static int reverse2(int x) {
        String s = "" + x;
        StringBuilder result = new StringBuilder();
        boolean hasMinus = x < 0;
        int initialIndex = hasMinus ? 1 : 0;
        for (int i = s.length() - 1; i >= initialIndex; i--) {
            char sign = s.charAt(i);
            result.append(sign);
        }
        if (hasMinus) {
            result.insert(0, '-');
        }
        try {
            return Integer.parseInt(result.toString());
        } catch (NumberFormatException n) {
            return 0;
        }
    }


    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) res;
        }
    }
}