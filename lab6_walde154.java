/*class Polygon
{
    private int[] sideLengths;

    public Polygon(int sides, int ... lengths)
    {
        int index = 0;
        sideLengths = new int[sides];
        for (int length: lengths)
        {
            sideLengths[index] = length;
            index += 1;
        }
    }

    public int side(int number)
    {
        return sideLengths[number];
    }

    public int perimeter()
    {
        int total = 0;
        for (int index = 0; index < sideLengths.length; index += 1)
        {
            total += side(index);
        }
        return total;
    }
}
*/
class Rectangle extends Polygon{
    int topBottomLength;
    int leftRightLength;

    public Rectangle(int topBottomLength, int leftRightLength) {
        super(4,topBottomLength,leftRightLength,topBottomLength,leftRightLength);
        this.topBottomLength = topBottomLength;
        this.leftRightLength = leftRightLength;
    }

    public int area(){
        return topBottomLength * leftRightLength;
    }
}

class Square extends Rectangle{
    public Square (int side){
        super(side,side);
    }

}

