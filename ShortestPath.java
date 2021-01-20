import java.util.*;
public class ShortestPath{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Matrix matrix = new Matrix(input);
        //test code
        //matrix.Stringed(matrix.getData());
        // ArrayList<Integer> test = new ArrayList<Integer>();
        // int[] test2 = {61, 63, 65, 43, 5, 29, 10, 32, 20};
        // test.add(0);
        // test.add(3);
        // test.add(2);
        //System.out.println(shortestDistanceCity(matrix, 4));
        System.out.println(finalDistance(matrix));

    }
    /*
    Algorithm explanation:

    Starting from any given city, we find the shortest distance it can take to another city. We move onto that city, and repeat this process
    until we traverse the entire path.

    Since the total distance varies depending on the starting city, we will repeat this process for how many cities we have, and then find 
    the shortest distance among these.

    This is effecitively an O(n^3) algorithm since we have 3 for loops.

    */

    /*given an array (row of the 2D array), find the smallest element. However, ignore rows that have already been visited. 
    Return the index of the element.
    */
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

    /*given a starting city, call shortestDistance matrix.size()-1 times (we don't look at the start itself)
      for each shortestDistance index retrieved, add it to the distance and flag that index as visited.
    */
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

    /*
    given the 2D array, call shortestDistanceCity matrix.size() times. We look at the distances 
    found by starting at each city, and we loop through and retain the smallest distance.
    */
    public static int finalDistance(Matrix matrix){
        int distance = -1;
        for(int i = 0; i < matrix.size(); i++){
            //System.out.println(shortestDistanceCity(matrix, i));
            if(distance == -1 || distance > shortestDistanceCity(matrix, i)) distance = shortestDistanceCity(matrix, i);
        }
        return distance;
    }

}
