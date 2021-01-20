import java.util.*;

public class Matrix{
    int[][] CitiesData = new int[10][10];
    ArrayList<String> CitiesNames = new ArrayList<String>();
    
    public Matrix(Scanner input){
        InputParse(input);
    }

    public void InputParse(Scanner input){
        
        while(input.hasNext()){
            String city0 = input.next();
            //gets first city
            input.next();
            //gets second city
            String city1 = input.next();

            input.next();

            int distance = Integer.parseInt(input.next());

            if(!CitiesNames.contains(city0)) CitiesNames.add(city0);
            if(!CitiesNames.contains(city1)) CitiesNames.add(city1);

            int rows = CitiesNames.indexOf(city0);
            int columns = CitiesNames.indexOf(city1);

            CitiesData[rows][columns] = distance;
            CitiesData[columns][rows] = distance;

        }
    }

  
    
}