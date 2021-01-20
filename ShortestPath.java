import java.util.*;
public class ShortestPath{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Matrix matrix  = new Matrix(input);
        //matrix.Stringed(matrix.getData());
        ArrayList<Integer> test = new ArrayList<Integer>();
        int[] test2 = {61, 63, 65, 43, 5, 29, 10, 32, 20};
        test.add(0);
        test.add(3);
        test.add(2);
        //System.out.println(shortestDistanceCity(matrix, 4));
        System.out.println(finalDistance(matrix));

    }


    public static int shortestDistance(Matrix matrix, ArrayList<Integer> visited, int currentCity){
        int index = -1;
        int[] current = matrix.getData()[currentCity];
        //System.out.println(Arrays.toString(current));
        for(int i = 0; i < matrix.size(); i++){
            if((index == -1 || current[index] > current[i]) && !visited.contains(i)){
                //System.out.println(index);
                index = i;
                //System.out.println(index);

            }
        }

        return index;
    }

    public static int shortestDistanceCity(Matrix matrix, int index){
        ArrayList<Integer> visited = new ArrayList<Integer>();
        int[][] data = matrix.getData();
        
        int distance = 0;
        for(int i = 0; i < matrix.size() - 1; i++){
            visited.add(index);
            int temp = index;
            index = shortestDistance(matrix, visited, index);
            //System.out.println(""+ data[temp][index]);
            distance+=data[temp][index];
        }
        return distance;
    }

    public static int finalDistance(Matrix matrix){
        int distance = -1;
        for(int i = 0; i < matrix.size(); i++){
            //System.out.println(shortestDistanceCity(matrix, i));
            if(distance == -1 || distance > shortestDistanceCity(matrix, i)) distance = shortestDistanceCity(matrix, i);
        }
        return distance;
    }

}
