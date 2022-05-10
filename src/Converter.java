public class Converter {
    static double sum;

    public static double distanceCalc(int[][] array, int month){ // метод расчета расстояния
        sum = StepTracker.sumMonth(array,month);
        return sum * 0.75 / 1000;
    }
    public static double caloriesCalc(int[][] array, int month){ //метод расчета коичества калорий
        sum = StepTracker.sumMonth(array,month);
        return sum * 50 / 1000;
     }

}
