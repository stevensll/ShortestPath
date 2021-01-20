import java.util.*;

public class Matrix{
    private int[][] CitiesData = new int[10][10];
    private ArrayList<String> CitiesNames = new ArrayList<String>();
    
    public Matrix(Scanner input){
        InputParse(input);
    }

    public void InputParse(Scanner input){
        /*
        what this parse does is that it collects two inputs (a -> b) and adds them to an ArrayList. If
        the list does not have these new city pairs, it will add them. This essentially creates the 1 Dimensional
        version of our cities. Then we add the distances between the cities into the 2D version.

        Assumes that inputs are organized such that a->b, a->c, a->d, b->c, b->d, etc.
        */

        while(input.hasNext()){
            //get first city
            String city0 = input.next();
            //skip
            input.next();
            //gets second city
            String city1 = input.next();
            //skip
            input.next();
            //get distance
            int distance = Integer.parseInt(input.next());

            if(!CitiesNames.contains(city0)) CitiesNames.add(city0);
            if(!CitiesNames.contains(city1)) CitiesNames.add(city1);

            int rows = CitiesNames.indexOf(city0);
            int columns = CitiesNames.indexOf(city1);

            CitiesData[rows][columns] = distance;
            CitiesData[columns][rows] = distance;

        }
    }
    // toString method 
    public void Stringed(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }    

    public int size(){
        return CitiesNames.size();
    }
    public int[][] getData(){
        return CitiesData;
    }
}