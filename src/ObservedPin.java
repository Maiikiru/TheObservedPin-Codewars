import java.util.ArrayList;
import java.util.List;
//https://www.codewars.com/kata/5263c6999e0f40dee200059d/train/java

public class ObservedPin {

    private static boolean initialized = false;

    private static List<String> getPins = new ArrayList<String>();

    private static int[][] myArray = new int[10][];

    private static String current="";

    //initialize all the values that each number can be.
    private static void initialize(){
        myArray[0] = new int[]{0,8};
        myArray[1] = new int[]{1,2,4};
        myArray[2] = new int[]{1,2,3,5};
        myArray[3] = new int[]{2,3,6};
        myArray[4] = new int[]{1,4,5,7};
        myArray[5] = new int[]{2,4,5,6,8};
        myArray[6] = new int[]{3,5,6,9};
        myArray[7] = new int[]{4,7,8};
        myArray[8] = new int[]{5,7,8,9};
        myArray[9] = new int[]{6,8,9};
    }

    public static List<String> getPINs(String observed) {
        if(!initialized){
            initialize();
            initialized = true;
        }

        try{
            possibleCombination(observed.trim(),0,0);
        }catch (Exception e){
            e.printStackTrace();
        }

        for(int i=0;i<getPins.size();i++){
            System.out.print(getPins.get(i)+",");
        }

        //System.out.println("\n"+getPins.size());

        return getPins;
    } // getPINs

    //recursive function that adds all possible combinations to an arraylist.
    public static String possibleCombination(String observed,int num,int i) throws Exception{
        //base condition
        if(i == observed.length()-1){
            for(int j=0;j< myArray[num].length;j++){
                current+=(String.valueOf(myArray[num][j]));
                    if(current.length() == observed.length()){
                        getPins.add(current);
                        current = current.substring(0,current.length()-1);
                    }
            }
            return "";
        }
        //todo make this work.

        //transform char to int.
        num = Character.getNumericValue(observed.charAt(i));
        if(num < 0 || num > 9) throw new Exception("Invalid number!");


        for(int k=0;k< myArray[num].length;k++){
            current += String.valueOf(myArray[num][k]);
            possibleCombination(observed,num,i+1);
            current = current.substring(0,current.length()-1);
        }

        return "";
    }
} // ObservedPin
