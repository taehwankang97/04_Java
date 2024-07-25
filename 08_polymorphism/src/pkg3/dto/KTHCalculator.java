package pkg3.dto;

public class KTHCalculator implements Calculator {

    @Override
    public int plus(int a, int b) {
        int result = a + b;
        if (result > 100_000_000) {
            result = 100000000;
        } else if (result < -100_000_000) {
            result = -100000000;
        }
        return result;
    }

    @Override
    public int minus(int a, int b) {
        int result = a - b;
        if (result > 100_000_000) {
            System.out.println("100,000,000");
        } else if (result < -100_000_000) {
            System.out.println("-100,000,000");
        }
        return result;
    }

    @Override
    public int multi(int a, int b) {
        int result = a * b;
        if (result > 100_000_000) {
            System.out.println("100,000,000");
        } else if (result < -100_000_000) {
            System.out.println("-100,000,000");
        }
        return result;
    }

    @Override
    public int div(int a, int b) {
        int result = a / b;
        if (result > 100_000_000) {
            System.out.println("100,000,000");
        } else if (result < -100_000_000) {
            System.out.println("-100,000,000");
        }
        return result;
    }

    @Override
    public int mod(int a, int b) {
        int result = a % b;
        if (result > 100_000_000) {
            System.out.println("100,000,000");
        } else if (result < -100_000_000) {
            System.out.println("-100,000,000");
        }
        return result;
    }

    @Override
    public int pow(int a, int b) {
        double result = Math.pow(a, b);
        if (result > 100_000_000) {
            System.out.println("100,000,000");
        } else if (result < -100_000_000) {
            System.out.println("-100,000,000");
        }
        return (int) result;
    }

    @Override
    public double areaOfCircle(double r) {
        double result = (r * r) * 3.14;
        if (result > 100_000_000) {
            System.out.println("100,000,000");
        } else if (result < -100_000_000) {
            System.out.println("-100,000,000");
        }
        return result;
    }

    @Override
    public String toBinaly(int num) {
        String result = Integer.toBinaryString(num);
        return result;
    }

    @Override
    public String toHexadecimal(int num) {
        String hexString = Integer.toHexString(num);
        return hexString;
    }
}
