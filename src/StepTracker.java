import java.util.Random;

public class StepTracker {

    static int[][] stepsCount = new int[30][12];
    static int aim = 10000;
    static int month;
    static int day;
    static int steps;
public static void inputData(){
        while(true){
            Main.monthEntry();
            month = Main.inputInt();
            if (month < 0 || month > 11){
                Main.errorInput();
            }
            else{
                while(true){
                    Main.dayEntry();
                    day = Main.inputInt();
                    if (day < 1 || day > 30){
                        Main.errorInput();
                    }
                    else{
                        while(true){
                            Main.stepsEntry();
                            steps = Main.inputInt();
                            if (steps < 0) {
                                Main.errorInput();
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
        Main.monthEntry();
        month = Main.inputInt();
        while(true){
            if(month < 0 || month > 11){
                Main.errorInput();
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
            int newAim = Main.inputInt();
            if(newAim < 0){
                Main.errorInput();
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

public static void randomData(){
        for(int day=0; day<stepsCount.length; day++){
            for(int month=0; month<stepsCount[0].length; month++){
                stepsCount[day][month] = new Random().nextInt(20000);
            }
        }
    }


}


