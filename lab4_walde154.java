class Zillion {
    int size;
    int[] digits;

    public Zillion(int size) {
        this.size = size;
        if (size > 0) {
            digits = new int[size];
        }

    }

    public String toString() {
        String result = "";
        for (int i = 0; i < digits.length; i++) {
            result += digits[i];
        }
        return result;
    }

    public void increment() {
        for (int i = digits.length - 1; i > -1; i--) {
            if ((digits[i]) + 1 < 10) {
                digits[i] = digits[i] + 1;
                break;
            }
                else if((digits.length*-1) == (i)){
                    for(int x = 0; x < digits.length; x++){
                        digits[x] = 0;
                    }
                    break;
                }
                else{
                    digits[i] = 0;
                }
        }
    }
}




