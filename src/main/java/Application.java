import java.text.DecimalFormat;
import java.util.*;

public class Application {


    public void plusMinus(List<Integer> arr){

        int numberOfElementsInArray = arr.size();
        List<Integer> splitOfPositivesNegativesAndZeros = getSplitOfPositiveNegativeAndZeroInArray(arr);
        List<Double> splitOfRatiosArray = getRatios(numberOfElementsInArray, splitOfPositivesNegativesAndZeros);
        printRatios(formatDecimals(6, splitOfRatiosArray));
    }

    private List<Double> formatDecimals(int decimalPlaces, List<Double> arrayToFormat) {
        List<Double> formattedList = new ArrayList<>();

        StringBuilder decimalPlacesToUse = new StringBuilder("#.");
        for (int i = 0; i < decimalPlaces; i++) decimalPlacesToUse.append("0");

        DecimalFormat formatter = new DecimalFormat(decimalPlacesToUse.toString());

        for (double numberToFormat: arrayToFormat){
            formattedList.add(Double.valueOf(formatter.format(numberToFormat)));
        }
        return formattedList;
    }

    public List<Integer> getSplitOfPositiveNegativeAndZeroInArray(List<Integer> array){
        int numberOfPositives = 0,
            numberOfNegatives = 0,
            numberOfZeros = 0;

        for (int integer: array){
            if (integer == 0) numberOfZeros++;
            if (integer > 0) numberOfPositives++;
            if (integer < 0) numberOfNegatives++;
        }

        List<Integer> result = new ArrayList<>(List.of(numberOfPositives,numberOfNegatives,numberOfZeros));
        return result;
    }

    public List<Double> getRatios(int size, List<Integer> arrayToOperate){
        List<Double> arrayToOperateDouble = new ArrayList<>();
        List<Double> result = new ArrayList<>();

        for (int integer: arrayToOperate){
            arrayToOperateDouble.add((double) integer);
        }

        for (double count: arrayToOperateDouble) {
            double resultingRatio = count/size;
            result.add(resultingRatio);
        }
        return result;
    }

    void printRatios(List<Double> listOfRatios){
        for (double ratio: listOfRatios) System.out.println(ratio);
    }


    public static void main(String[] args) {

        Application app = new Application();
        List<Integer> arr1 = List.of(-2,-1,0,1,2,3);
        List<Integer> arr2 = List.of(-1,0,1,2,3);
        List<Integer> arr3 = List.of(-2,-1,2,3);

        app.plusMinus(arr1);
        app.plusMinus(arr2);
        app.plusMinus(arr3);

    }


}
