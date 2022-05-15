public class PotterKata {
    private static int PRICE=8;

    /*
    * booksCount[i] => buy booksCount[i] of copies of book i
    * */
    public double calculatePrice(int[] booksCount) {
        //check args
        if (booksCount==null||booksCount.length!=5)
            throw new IllegalArgumentException();

        //only buy one kind of book
        int no=-1;
        boolean allZero = true;
        for (int i=0;i<5;i++){
            if (no==-1 && booksCount[i]!=0){
                no=i;
                allZero = false;
            }else if(no!=-1 && booksCount[i]!=0){
                no=-2;
            }
        }
        if (allZero)return 0;
        if (no>=0)return booksCount[no]*PRICE;

        //more than two types
        //the largest count of one type of book
        int maxCount = 0;
        for (int bookCount : booksCount){
            maxCount = Math.max(maxCount, bookCount);
        }

        //for calculation
        int[][] matrix = new int[5][];
        for (int i = 0; i < matrix.length; i++)
        {
            matrix[i] = new int[maxCount];
            int bookCountIndex = booksCount[i] - 1;
            for (int j = 0; j < maxCount; j++)
            {
                if (j <= bookCountIndex) {
                    matrix[i][j] = i;
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        //total price
        double sum = 0;
        boolean flag = false;

        //calculate discount
        for (int i = 0; i < maxCount; i++)
        {
            double sumOfColumn = 0;

            double sumOfNextColumn = 0;

            for (int[] n : matrix) {
                if (n[i] > -1) sumOfColumn += 1;
                if (i < maxCount - 1 && n[i + 1] > -1) sumOfNextColumn += 1;
            }

            //check special case
            if ( (sumOfColumn == 5)  && (sumOfNextColumn == 3) )  {
                flag = true;
                //count using two sets of four books instead of one set of 5 and 3
                sum += (4 * 8 * 0.8) + (4 * 8 * 0.8);
            } else if (sumOfColumn == 5)  {
                sum += (5 * 8 * 0.75);
            }
            else if (sumOfColumn == 4)  {
                sum += (4 * 8 * 0.8);
            }
            else if (sumOfColumn == 3)  {
                if (!flag) sum += (3 * 8 * 0.90);
                else flag = false;
            }
            else if (sumOfColumn == 2)  {
                sum += (2 * 8 * 0.95);
            }
            else if (sumOfColumn == 1)  {
                sum += 8;
            }
        }

        return sum;
    }
}
