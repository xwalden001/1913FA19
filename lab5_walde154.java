//
//  SIEVE. The Sieve of Eratosthenes.
//
//    James B. Moen
//    08 Oct 19
//
//  Test the SIEVE class, for 30 points total.
//

//
//  Put your code for the class SIEVE here!!!
//

//  TOSS THE KNEES. Run SIEVE on some examples.
class Sieve {
    int max;
    boolean [] boolnumbers;
    int [] numbers;

    public Sieve(int max){
        this.max = max;
        if(max < 2){
            throw new IllegalArgumentException();
        }
        else{
            boolnumbers = new boolean[max];
            for(int i = 1; i < max; i++){
                boolnumbers[i] = true;
            }
            numbers = new int[max];
            for(int x = 1; x < max+1; x++){
                numbers[x-1] = x;
            }
        }

    }


    public void findPrimes(){
        for(int i = 0; i < max; i++){
            if (boolnumbers[i]){
                int hold = numbers[i];
                for(int x = 0; x < max; x++){
                    if(hold != numbers[x]) {
                        if ((numbers[x] % hold) == 0) {
                            boolnumbers[x] = false;
                        }
                    }

                }
            }

        }
        // for(int y = 0; y <max; y++){
        //System.out.println(boolnumbers[y]);
        //System.out.println(numbers[y]);
        //}
    }

    public String toString(){
        String answer = "";
        for(int i = 0; i < max; i++){
            if(boolnumbers[i]){
                answer += (" "+numbers[i]);
            }



        }
        return answer;
    }
}










class TossTheKnees
{

//  MAIN. Find some primes.

    public static void main(String [] args)
    {
        Sieve sieve = null;  //  We must initialize SIEVE or Java will cry.

//  5 points. This must print "Sieve size must be at least 2." but without the
//  quotes.

        try
        {
            sieve = new Sieve(0);
        }
        catch (IllegalArgumentException oops)
        {
            System.out.println("Sieve size must be at least 2.");
        }

//  5 points. This must print nothing.

        try
        {
            sieve = new Sieve(100);
        }
        catch (IllegalArgumentException oops)
        {
            System.out.println("Sieve size must be at least 2.");
        }

//  10 points. This must print integers from 2 to 99, separated by blanks.

        System.out.println(sieve);

//  10 points. This must print the prime numbers between 2 and 99, separated by
//  blanks. They are:
//
//  2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

        sieve.findPrimes();
        System.out.println(sieve);
    }
}

