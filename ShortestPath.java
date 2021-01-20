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
        System.out.println(shortestDistance(test2, test));
        System.out.println(shortestDistanceCity(matrix, 0));

    }


    public static int shortestDistance(int[] current, ArrayList<Integer> visited){
        int index = -1;
        for(int i = 0; i < current.length; i++){
            if((index == -1 || current[index] > current[i]) && !visited.contains(i)){
                index = i;
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
            index = shortestDistance(data[index], visited);
            distance+=data[temp][index];
        }
        return distance;
    }

    public int finalDistance(Matrix matrix){
        int distance = -1;
        for(int i = 0; i < matrix.size(); i++){
            // distance = shortestDistance
            // if(distance > shortestDistance(i)) distance = shortestDistance(i)
        }

        return distance;
    }

}
