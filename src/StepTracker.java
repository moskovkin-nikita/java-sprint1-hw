import java.util.Scanner;

public class StepTracker {

    static int[][] stepsCount = new int[30][12];
    static int aim = 10000;
    static int month;
    static int day;
    static int steps;
public static void inputData(){
        while(true){
            monthEntry();
            month = inputInt();
            if (month < 0 || month > 11){
                errorInput();
            }
            else{
                while(true){
                    dayEntry();
                    day = inputInt();
                    if (day < 1 || day > 30){
                        errorInput();
                    }
                    else{
                        while(true){
                            stepsEntry();
                            steps = inputInt();
                            if (steps < 0) {
                                errorInput();
                            }
                            else {
                                stepsCount[day-1][month] = steps;
                                break;
                            }
                        } break;
                    }
                } break;
            }
        }
    }
public static void showStatistics(){
        monthEntry();
        month = inputInt();
        while(true){
            if(month < 0 || month > 11){
                errorInput();
            }
            else {
                infoPerDay(stepsCount, month);
                System.out.println("Общее количество шагов за " + month +" месяц = "+sumMonth(stepsCount,month));
                System.out.println("Максимальное кол-во шагов в месяце: " + maxInMonth(stepsCount,month));
                System.out.println("Среднее количество шагов: " + averageInMoth(stepsCount,month));
                System.out.println("Пройденная дистанция (в км): " + Converter.distanceCalc(stepsCount,month));
                System.out.println("Количество сожжённых килокалорий: "+ Converter.caloriesCalc(stepsCount,month));
                System.out.println("Лучшая серия: " + bestSeries(stepsCount, month, aim) + " дней");
                break;
            }
        }
}

public static void changeAim() { //метод изенения цели по количеству шагов в день
        System.out.println("Текущая цель шагов: "+ aim);
        System.out.println("Введите новую цель");
        while(true){
            int newAim = inputInt();
            if(newAim < 0){
                errorInput();
            }
            else {
                aim = newAim;
                break;
                } 
        }
    }
public static void infoPerDay(int[][] array, int month){ //метод вывода шагов по дням
        System.out.println("Количество пройденных шагов по дням:");
        for(int day = 0; day < array.length; day++){
            System.out.print((day+1)+ " день: " +array[day][month]+"; ");
        }
        System.out.println();
}

public static int sumMonth(int[][] array,int month){ //метод подсчета общего количества шагов в месяц
        int sum=0;
        for(int day=0; day < array.length; day++){
            sum += array[day][month];
        }
        return sum;
    }

public static int maxInMonth(int[][] array, int month){ //метод нахождения максимального количества шаго в месяце
        int max = 0;
        for(int day=0; day<array.length; day++){
            if(array[day][month]> max){
            max = array[day][month];
            }
        }
        return max;
}

public static double averageInMoth(int[][] array, int month){ // метод расчета среднего количества шагов
    double sum = sumMonth(array,month);
    double quantity= array.length;
    return sum / quantity;
}

public static int bestSeries(int[][] array, int month, int aim){ // метод нахождения серии дней
        int maxSeries = 0;
        int currentSeries = 0;
        for(int day=0; day<array.length; day++){
            if(array[day][month]>= aim){
                currentSeries++;
                if(currentSeries > maxSeries){
                    maxSeries = currentSeries;
                }
            }
            else {
                currentSeries = 0;
            }
            }   return maxSeries;
}
    public static void errorInput(){
        System.out.println("Введено некорректное значение, повторите ввод.");
    }
    public static void monthEntry(){
        System.out.println("Введите номер месяца (от нуля до 11)");
    }
    public static void dayEntry() {
        System.out.println("Введите номер дня (от 1 до 30)");
    }
    public static void stepsEntry() {
        System.out.println("Введите количество шагов, пройденных в этот день");
    }
    public static int inputInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }




}


