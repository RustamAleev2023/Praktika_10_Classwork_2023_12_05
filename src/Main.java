import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
        task8();
    }

    //Task1
    public static void task1() {
        Random random = new Random();
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(20);
            arr2[i] = random.nextInt(20);
        }


        //Сформировать третий массив, содержащий элементы
        //обоих массивов
        int[] arr3_1 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3_1[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3_1[arr1.length + i] = arr2[i];
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3_1));
        System.out.println("===================================================");

        //Сформировать третий массив, содержащий элементы
        //обоих массивов без повторений;
        int[] arr3_2 = new int[arr1.length + arr2.length];
        int index1 = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            arr3_2[index1] = arr1[i];
            index1++;
        }
        Arrays.sort(arr3_2, 0, index1);

        for (int i = 0; i < arr2.length; i++) {
            if (Arrays.binarySearch(arr3_2, arr2[i]) < 0) {
                arr3_2[index1] = arr2[i];
                index1++;
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3_2));
        System.out.println("===================================================");


        //Сформировать третий массив, содержащий элементы
        //общие для двух массивов

        int[] arr3_3 = new int[arr1.length];
        int index2 = 0;

        for (int i = 0; i < arr1.length; i++) {
            if (Arrays.binarySearch(arr2, arr1[i]) >= 0) {
                arr3_3[index2] = arr1[i];
                index2++;
            }
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3_3));
        System.out.println("===================================================");

        //Сформировать третий массив, содержащий только
        //уникальные элементы каждого из массивов;
        int[] arr3_4 = new int[arr1.length + arr2.length];
        int index4 = 0;
        //создаем копии исходных массивов чтобы использовать оригиналы в следующих подзадачах
        int[] arr1Copy = Arrays.copyOf(arr1, arr1.length);
        int[] arr2Copy = Arrays.copyOf(arr2, arr2.length);
        //убираем повторяющиеся элементы
        int[] array1 = Arrays.stream(arr1Copy).distinct().toArray();
        int[] array2 = Arrays.stream(arr2Copy).distinct().toArray();

        for (int i = 0; i < array1.length; i++) {
            arr3_4[index4] = array1[i];
            index4++;
        }
        for (int i = 0; i < array2.length; i++) {
            arr3_4[index4] = array2[i];
            index4++;
        }
        Arrays.stream(arr3_4).distinct().toArray();


        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3_4));
        System.out.println("===================================================");


        //Сформировать третий массив, содержащий только
        //минимальное и максимальное значение каждого из
        //массивов
        int[] arr3_5 = new int[4];
        //arr1 min
        arr3_5[0] = min(arr1);
        //arr2 min
        arr3_5[1] = min(arr2);
        //arr1 max
        arr3_5[2] = max(arr1);
        //arr2 max
        arr3_5[3] = max(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3_5));
        System.out.println("===================================================");
    }

    public static int min(int[] array) {
        Arrays.sort(array);
        return array[0];
    }

    public static int max(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }

    //Task2
    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во сотрудников");
        int size = scanner.nextInt();
        int[] staff = new int[size];
        for (int i = 0; i < staff.length; i++) {
            System.out.println("Введите зарплату сотрудника " + (i + 1));
            staff[i] = scanner.nextInt();
        }
        System.out.println("Выберите как отсортировать ЗП (вверх/вниз)");
        String direction = scanner.next();

        switch (direction) {
            case "вверх" -> {
                int temp;
                for (int i = 1; i < staff.length; i++) {
                    if (staff[i - 1] > staff[i]) {
                        temp = staff[i - 1];
                        staff[i - 1] = staff[i];
                        staff[i] = temp;
                    }
                }
            }
            case "вниз" -> {
                int temp;
                for (int i = 1; i < staff.length; i++) {
                    if (staff[i - 1] < staff[i]) {
                        temp = staff[i - 1];
                        staff[i - 1] = staff[i];
                        staff[i] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(staff));
    }

    //Task3
    public static void task3() {
        Random random = new Random();
        int[] arr = new int[15];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(arr));
        //разбиваем на две части
        int[] arr1 = Arrays.copyOf(arr, arr.length / 2);
        int[] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));

        //сортируем по возрастанию
        sort(arr1);
//        System.out.println(Arrays.toString(arr1));

        //сортируем по убыванию
        sort(arr2); //сортируем по возрастанию
        for (int i = 0; i < arr2.length / 2; i++) { //реверс
            int temp = arr2[i];
            arr2[i] = arr2[arr2.length - 1 - i];
            arr2[arr2.length - 1 - i] = temp;
        }
//        System.out.println(Arrays.toString(arr2));

        //соединяем два массива в один
        for (int i = 0; i < arr.length; i++) {
            if (i >= 0 && i < arr.length / 2) {
                arr[i] = arr1[i];
            }
            if (i >= arr.length / 2 && i < arr.length) {
                arr[i] = arr2[i - arr.length / 2];
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort(int[] arr) {
        boolean isSorted = false;
        int temp;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }

    //Task4
    public static void task4() {
        Random random = new Random();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
//        System.out.println(Arrays.toString(temp));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число для поиска (0 - 100)");
        int n = scanner.nextInt();

        int index = Integer.MAX_VALUE;

        int low = 0;
        int high = temp.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (temp[mid] < n) {
                low = mid + 1;
            } else if (temp[mid] > n) {
                high = mid - 1;
            } else if (temp[mid] == n) {
                index = mid;
                break;
            }
        }

        if (index == Integer.MAX_VALUE) {
            System.out.println("Такого числа нет в массиве");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == temp[index]) {
                    System.out.println("Искомое число:  " + arr[i]);
                    break;
                }
            }
        }
    }

    //Task5
    public static void task5() {
        int[][] numbers = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.println("Введите элемент массива");
                numbers[i][j] = scanner.nextInt();
                sum += numbers[i][j];
            }
        }

        System.out.println("Сумма элементов массива = " + sum);
        System.out.println("Среднее арифметическое = " + sum / (3 * 3));
        System.out.println();


        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {

                System.out.print(numbers[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //Task6
    public static void task6() {
        int[][] numbers = new int[5][5];
        int min;
        int max;
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = random.nextInt(100);
                System.out.print(numbers[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < numbers.length; i++) {
            int[] temp = Arrays.copyOf(numbers[i], numbers.length);
            Arrays.sort(temp);
            System.out.println("Строка " + i + ": min = " + temp[0] + ", max = " + temp[temp.length - 1]);
        }
    }

    //Task7
    public static void task7() {
        int[][] numbers = new int[5][5];
        int min;
        int max;
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = random.nextInt(100);
                System.out.print(numbers[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        int[][] temp = new int[numbers.length][numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                temp[i][j] = numbers[j][i];
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            int[] arr = Arrays.copyOf(temp[i], temp.length);
            Arrays.sort(arr);
            System.out.println("В столбце " + i + ": min = " + arr[0] + ", max = " + arr[arr.length - 1]);
        }
    }

    //Task8
    public static void task8() {
        int[][] num1 = new int[2][2];
        int[][] num2 = new int[2][2];
        int[][] result = new int[2][2];

        Random random = new Random();

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num1[i].length; j++) {
                num1[i][j] = random.nextInt(100);
                num2[i][j] = random.nextInt(100);
            }
        }
        System.out.println("Num1:");
        print(num1);
        System.out.println("Num2:");
        print(num2);

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num1[i].length; j++) {
                result[i][j] = num1[i][j] + num2[i][j];
            }
        }
        System.out.println("Сумма двух матриц");
        print(result);

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num1[i].length; j++) {
                result[i][j] = num1[i][j] - num2[i][j];
            }
        }
        System.out.println("Разность двух матриц");
        print(result);

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num1[i].length; j++) {
                result[i][j] = num1[i][j] * num2[i][j];
            }
        }
        System.out.println("Произведение двух матриц");
        print(result);



    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }


}

