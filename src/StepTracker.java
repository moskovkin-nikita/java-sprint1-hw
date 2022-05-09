import java.util.Scanner;
import java.util.Random;

public class StepTracker {
    
        
public static void main(String[] args) {
    int aim = 500;
    int [][] stepsCount = new int [30][12];
    
       
    Scanner scanner = new Scanner(System.in);
    System.out.println("Привет! Это счетчик калорий.");
    while (true){
    printMenu();
    int selectMenu = scanner.nextInt();
        if (selectMenu !=1 && selectMenu !=2 && selectMenu !=3 && selectMenu !=4 && selectMenu != 5){
            System.out.println("Введено некорректное значение, повторите ввод.");
        }
        if (selectMenu == 1){
            stepsCount = inputData(scanner, stepsCount);
        }
        else if (selectMenu == 2){
            showStatistics(scanner, stepsCount, aim);
        }
        else if (selectMenu == 3){    
            aim = changeAim(scanner, aim);
            System.out.println("Новая цель: "+ aim+ " шагов!");
        }
        else if (selectMenu == 4){
            System.out.println("Работа приложения завершена.");
            break;   
        }
        else if(selectMenu == 5){
            stepsCount = randomData(stepsCount);
        }
    }
}      


public static int[][] randomData(int [][]stepsCount){
        for(int day=0; day<stepsCount.length; day++){
            for(int month=0; month<stepsCount[0].length; month++){
                stepsCount[day][month] = new Random().nextInt(1000);
            }
    } return stepsCount;
}

   public static void printMenu() {
        System.out.println();
        System.out.println("Выбери нужный пункт меню:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
   }
   
public static int[][] inputData(Scanner scanner, int [][] stepsCount){
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        System.out.println("Введите номер дня");
        int dayNumber = scanner.nextInt();
        System.out.println("Введите количество шагов, пройденных в этот день");
        int steps = scanner.nextInt();
        stepsCount[dayNumber-1][monthNumber-1] = steps;
        return stepsCount;
    }

public static void showStatistics(Scanner scanner, int [][] stepsCount, int aim){
        System.out.println("Введите месяц, за который нужна статистика");
        int monthNumber = scanner.nextInt();
        infoPerDay(stepsCount, monthNumber-1);
        System.out.println("Общее количество шагов за " + monthNumber +" месяц = "+sumMonth(stepsCount,monthNumber-1));
        System.out.println("Максимальное кол-во шагов в месяце: " + maxInMonth(stepsCount,monthNumber-1));
        System.out.println("Среднее количество шагов: " + averageInMoth(stepsCount,monthNumber-1));
        System.out.println("Пройденная дистанция (в км): " + distanceCalc(stepsCount,monthNumber-1));
        System.out.println("Количество сожжённых килокалорий: "+ caloriesCalc(stepsCount,monthNumber-1));
        System.out.println("Лучшая серия: " + bestSerie(stepsCount, monthNumber-1, aim) + " дней");
}

public static int changeAim(Scanner scanner, int currentAim) { //метод изенения цели по количеству шагов в день
        System.out.println("Текущая цель шагов: "+ currentAim);    
        System.out.println("Введите новую цель");
        while(true){
            int newAim = scanner.nextInt();
            if(newAim < 0){
                System.out.println("Введено некорректное значение, повторите ввод.");
            }
            else if (newAim >= 0) {
                currentAim = newAim;
                break;
                } 
        }return currentAim;
    }

public static void infoPerDay(int[][] array, int col){ //метод вывода шагов по дням
        System.out.println("Количество пройденных шагов по дням:");
        for(int row = 0; row < array.length; row++){
            System.out.print((row+1)+ " день: " +array[row][col]+", ");
        }
        System.out.println();
}

public static int sumMonth(int[][] array,int col){ //метод подсчета общего количества шагов в месяц
        int sum=0;
        for(int row=0;row<array.length;row++){
            sum+=array[row][col];
        }
        return sum;
    }

public static int maxInMonth(int[][] array, int col){ //метод нахождения максимального количества шаго в месяце
        int max = 0;
        for(int row=0; row<array.length; row++){
            if(array[row][col]> max){
            max = array[row][col];
            }
        }
        return max;
}

public static double averageInMoth(int[][] array, int month){ // метод расчета среднего количества шагов
        double sum = sumMonth(array,month);
        double length = array.length;
        double average = sum / length;
        return average;
}


   public static double distanceCalc(int[][] array, int month){ // метод расчета расстояния
       double distance= sumMonth(array,month)* 0.75 / 1000;
       return distance;
   }
   
   public static double caloriesCalc(int[][] array, int month){ //метод расчета коичества калорий
       double calories = sumMonth(array,month)*50/1000;
       
       return calories;
   }
  
public static int bestSerie(int[][] array, int month, int aim){
        int maxSerie = 0;
        int currentSerie = 0;
        for(int day=0; day<array.length; day++){
            if(array[day][month]>= aim){
                currentSerie++;
                if(currentSerie > maxSerie){
                    maxSerie = currentSerie;
                }
            }
            else {
                currentSerie = 0;
            }
            }   return maxSerie;
}
}


