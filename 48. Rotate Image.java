class Solution {
    public void rotate(int[][] matrix) {
        int side_length= matrix.length;
        side_rotate(matrix, 0, side_length);
    }
    private void side_rotate(int [][] matrix, int start_pos, int side_length)
    {
      //base case when the rest length is two or three.
      if(side_length<=3)
      {
        int [] temp_side_1 = new int [side_length];
        int [] temp_side_2 = new int [side_length];
        int [] temp_side_3 = new int [side_length];
        int [] temp_side_4 = new int [side_length];
        temp_side_1 = copyRow_1(matrix,start_pos,side_length);
        temp_side_2 = copyCol_2(matrix,start_pos+side_length-1,side_length);
        temp_side_3 = copyRow_2(matrix,start_pos+side_length-1,side_length);
        temp_side_4 = copyCol_1(matrix,start_pos,side_length);
        pasteCol2(matrix,start_pos+side_length-1,temp_side_1,side_length);
        pasteRow2(matrix,start_pos+side_length-1,temp_side_2,side_length);
        pasteCol1(matrix,start_pos,temp_side_3,side_length);
        pasteRow1(matrix,start_pos,temp_side_4,side_length);

      }else{
        int [] temp_side_1 = new int [side_length];
        int [] temp_side_2 = new int [side_length];
        int [] temp_side_3 = new int [side_length];
        int [] temp_side_4 = new int [side_length];
        temp_side_1 = copyRow_1(matrix,start_pos,side_length);
        temp_side_2 = copyCol_2(matrix,start_pos+side_length-1,side_length);
        temp_side_3 = copyRow_2(matrix,start_pos+side_length-1,side_length);
        temp_side_4 = copyCol_1(matrix,start_pos,side_length);
        pasteCol2(matrix,start_pos+side_length-1,temp_side_1,side_length);
        pasteRow2(matrix,start_pos+side_length-1,temp_side_2,side_length);
        pasteCol1(matrix,start_pos,temp_side_3,side_length);
        pasteRow1(matrix,start_pos,temp_side_4,side_length);
        side_rotate(matrix, start_pos+1, side_length-2);
      }
    }

    private int[] copyRow_1(int [][] matrix, int start_pos, int side_length)
    {
      int [] temp_side = new int [side_length];
      for(int i = 0; i < side_length; i++)
      {
        temp_side[i] = matrix[start_pos][start_pos+i];
      }
      return temp_side;
    }

    private int[] copyRow_2(int [][] matrix, int start_pos, int side_length)
    {
      int [] temp_side = new int [side_length];
      for(int i = 0; i < side_length; i++)
      {
        temp_side[i] = matrix[start_pos][start_pos-side_length+1+i];
      }
      return temp_side;
    }
    private int[] copyCol_1(int [][] matrix, int start_pos, int side_length)
    {
      int [] temp_side = new int [side_length];
      for(int i = 0; i < side_length; i++)
      {
        temp_side[side_length-i-1] = matrix[start_pos+i][start_pos];
      }
      return temp_side;
    }
    private int[] copyCol_2(int [][] matrix, int start_pos, int side_length)
    {
      int [] temp_side = new int [side_length];
      for(int i = 0; i < side_length; i++)
      {
        temp_side[side_length-i-1] = matrix[start_pos-side_length+1+i][start_pos];
      }
      return temp_side;
    }

    private void pasteCol2(int [][] matrix, int start_pos, int[] temp_side, int side_length)
    {

        for(int i = 0; i<temp_side.length;i++)
        {
          matrix[start_pos-side_length+1+i][start_pos] = temp_side[i];
        }
    }
    private void pasteRow2(int [][] matrix, int start_pos, int[] temp_side, int side_length)
    {
        for(int i = 0; i<temp_side.length;i++)
        {
          matrix[start_pos][start_pos-side_length+1+i] = temp_side[i];
        }

    }
    private void pasteCol1(int [][] matrix, int start_pos, int[] temp_side, int side_length)
    {

        for(int i = 0; i<temp_side.length;i++)
        {
          matrix[start_pos+i][start_pos] = temp_side[i];
        }
    }
    private void pasteRow1(int [][] matrix, int start_pos, int[] temp_side, int side_length)
    {
        for(int i = 0; i<temp_side.length;i++)
        {
          matrix[start_pos][start_pos+i] = temp_side[i];
        }

    }
}
