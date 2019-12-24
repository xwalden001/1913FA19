class BinaryVsLinear {
    private static int linearSearch(int key, int[] keys) {
        int counter = 0;
        for (int idx = 0; idx < keys.length; idx++) {
            if (keys[idx] == key)
            {
                counter +=1;
                break;
            }
            else {
                counter += 1;
            }
        }
        return counter;
    }


    private static int binarySearch(int key, int[] keys) {
        int left = 0;
        int mid;
        int right = keys.length - 1;
        int counter = 0;
        while (true) {
            if(left > right){
                mid = -1;
                break;
            }
            else{
                counter +=1;
                mid = (left+right)/2;
                if(key < keys[mid]){
                    right = mid -1;
                    counter +=1;

                }
                else if(key > keys[mid]){
                    left = mid+1;
                    counter +=1;
                }
                else{
                    break;
                }

            }

        }
        return counter;

    }

    public static void main(String [] args)
    {
        for (int length = 1; length <= 30; length += 1)
        {
            int[] array = new int[length];
            for (int index = 0; index < length; index += 1)
            {
                array[index] = index;
            }

            double linearTotal = 0.0;
            double binaryTotal = 0.0;
            for (int element = 0; element < length; element += 1)
            {
                linearTotal += linearSearch(element, array);
                binaryTotal += binarySearch(element, array);
            }

            double linearAverage = linearTotal / length;
            double binaryAverage = binaryTotal / length;
            System.out.println(length + " " +linearAverage+ " " +binaryAverage);
        }
    }
}
