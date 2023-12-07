import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
        task3();
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
            if(i >=0 && i < arr.length/2){
                arr[i] = arr1[i];
            }
            if(i >= arr.length/2 && i < arr.length){
                arr[i] = arr2[i - arr.length/2];
            }

        }
        System.out.println(Arrays.toString(arr));


    }
    public static int[] sort(int[] arr){
        boolean isSorted = false;
        int temp;

        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        return arr;
    }


}

