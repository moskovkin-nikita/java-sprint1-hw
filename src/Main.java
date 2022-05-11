import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Привет! Это счетчик калорий."); // приветствие при первом запуске
        while (true) {
            printMenu();
            int userInput = inputInt();
            if (userInput == 1) {
                StepTracker.inputData(); // вызов метода ввода данных
            } else if (userInput == 2) {
                StepTracker.showStatistics(); // вызов метода печати статистики
            } else if (userInput == 3) {
                StepTracker.changeAim(); // вызов метода изменения цели
            } else if (userInput == 4) {
                System.out.println("Работа приложения завершена."); // завершение работы приложения
                break;
            }
            else {
                errorInput(); // обработка разных случаев
            }
        }
    }
    public static void printMenu() { // метод печати основного меню
        System.out.println();
        System.out.println("Выбери нужный пункт меню:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
    public static int inputInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static void errorInput(){
        System.out.println("Введено некорректное значение, повторите ввод.");
    }
    }

    
