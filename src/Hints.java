import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Hints {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //Functions
        //FUNCTION-!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        System.out.println("FUNCTION--------------------------------");
        //Function<Параметър(Типа на параметъра, който приема) , Резултат(Типа на параметъра, който приема)>
        Function<Integer, Integer> func = x -> x * x;
        //Example 1
        System.out.println("Example 1--------------------------------");
        System.out.println(func.apply(10));

        //CONSUMER-!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        System.out.println("CONSUMER--------------------------------");
        //Consumer<Параметър(Типа на параметъра, който приема)>
        Consumer<Integer> consumer = x -> System.out.println(x);
        //Example 1 - принитираме дадено число
        System.out.println("Example 1--------------------------------");
        consumer.accept(277);
        //Example 2 - принитираме всички числа от листа
        System.out.println("Example 2--------------------------------");
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        list.stream().forEach(consumer);
        //Example 3 - Добавяме в стека всички елементи от листа
        System.out.println("Example 3--------------------------------");
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        list.stream().forEach(nums::push);

        //SUPPLIER-!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        System.out.println("SUPPLIER--------------------------------");
        //Supplier<> - Не приема входна стойност, А само връща резултат.
        Supplier<Integer> supplier = () -> new Random().nextInt(10);
        //Example 1 - принитира случйано число.
        System.out.println("Example 1--------------------------------");
        System.out.println(supplier.get());

        //PREDICATE-!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        System.out.println("PREDICATE--------------------------------");
        //Predicat<Параметър(Типа на параметъра, който приема)> -> Връща резултат
        Predicate<Integer> predicate = x -> x > 0;
        //Example 1 - принитира true or false спрямо това дали подаденото число е по-голямо от 0;
        System.out.println("Example 1--------------------------------");
        System.out.println(predicate.test(-10));
        //Example 2 - принитира true or false за всяко едно i;
        System.out.println("Example 2--------------------------------");
        for (int i = -1; i < 2; i++) {
            System.out.println(predicate.test(i));
        }


        //------------------------------------------------------------------------------------------------------------
        //Iterators and comparators
        /*Няма значение с какъв тип данни работят.
         * Iterator -> Iterable
         * Iterable(Това е интерфейс) казва че може да се свърши някакво действие -> Колекциите(Colletcion) аследяват Iterable. ->
         * -> List, Sets,.... Наследяват колекциите
         * Iterator върши дадено действие - Итератор е метод. - Итераторът също е интерфейс.
         * (Iterable казва че нещо може да се итерира. Iterator казва как може да се итерира)
         *
         *
         * Comparable - interface - Казва че този тип може да се сравнява
         *
         * Comparator - interface - Казва как се сравянва
         *
         *  */


        }
        





    //Проверява дали реда и колоната са в рамките на матрицата
    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }

    //Принтира матрица
    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
