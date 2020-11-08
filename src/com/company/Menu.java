package com.company;

import java.util.Scanner;

public class Menu {


    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) {
                return false;
            }
        return true;
    }

    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        int number;
        int[] array = new int[0];
        int index;
        while (true) {
            System.out.println("+---------------------------------------+");
            System.out.println("|      Welcome to Mr.Thanh's            |");
            System.out.println("|             Menu                      |");
            System.out.println("+---------------------------------------+");
            System.out.println(" Please make a selection");
            System.out.println("1) Task 1 : Input odd number:");
            System.out.println("2) Task 2 : Check prime number:");
            System.out.println("3) Task 3 : Display the  the first few prime numbers:");
            System.out.println("4) Task 4 : Input N numbers of array:");
            System.out.println("5) Task 5 : Display the array from task 4:");
            System.out.println("6) Task 6 : List of prime number in the array:");
            System.out.println("7) Task 7 : Check if N exit in the inout array, if not return location:");
            System.out.println("8) Task 8 : Delete N in the input array");
            System.out.println("9) Task 9 : Sort the array in ascending order");
            System.out.println("10) Task 10 : Input X number with the condition that it dont affect the order of sorting");
            System.out.println("0) Exit");
            System.out.println("\n");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    do {
                        System.out.print("Enter a number: ");
                        number = scanner.nextInt();
                    } while (number % 2 !=0);
                    System.out.println("Please enter an odd number");
                    break;
                case 2:
                    System.out.print("Enter a number: ");
                    number = scanner.nextInt();
                    boolean bool = isPrime(number);
                    if (bool) {
                        System.out.print(number + " is a prime");
                    } else
                        System.out.print(number + " is not a prime");
                    break;
                case 3:
                    System.out.print("Enter N primes you want to display: ");
                    number = scanner.nextInt();

                    int count = 0;
                    int n = 2;
                    StringBuilder str = new StringBuilder(" ");

                    while (count < number) {
                        int i = 2;
                        boolean flag = true;
                        while (i <= Math.sqrt(n)) {
                            if (n % i == 0) {
                                flag = false;
                                break;
                            }
                            i++;
                        }
                        if (flag) {
                            str.append(n).append(" ");
                            count++;
                        }
                        n++;
                    }
                    System.out.print(str);
                    break;
                case 4:
                    int num;
                    do {
                        System.out.print("Enter the number of elements in an array: ");
                        num = scanner.nextInt();

                    } while (num < 0);
                    array = new int[num];

                    for (int j = 0; j < num; j++) {
                        System.out.print("Enter element " + (j + 1) + " : ");
                        array[j] = scanner.nextInt();
                    }
                    break;
                case 5:
                    System.out.print("Show array: ");
                    for (int a : array) {
                        System.out.print(a + " ");
                    }
                    break;
                case 6:
                    StringBuilder s = new StringBuilder(" ");
                    for (int item : array) {
                        if (isPrime(item)) {
                            s.append(item).append(" ");
                        }
                    }
                    System.out.print("Prime in array: " + s);
                    break;
                case 7:
                    System.out.print("Enter value to check in array: ");
                    int k = scanner.nextInt();
                    int i;
                    for (i = 0; i < array.length; i++) {
                        if (array[i] == k) {
                            System.out.println("There is an element " + k + " in the array and is located " + i);
                            break;
                        }
                    }
                    if (i == array.length) {
                        System.out.println("There is no element k in the array");
                    }
                    break;
                case 8:
                    int b, c;
                    System.out.print("Enter the value to be deleted: ");
                    int N = scanner.nextInt();
                    for (b = c = 0; b < array.length; b++) {
                        if (array[b] != N) {
                            array[c] = array[b];
                            c++;
                        }
                    }
                    System.out.print("Array remaining after the element " + N + " is deleted: ");
                    for (int a : array) {
                        System.out.print(a + " ");
                    }
                    break;
                case 9:
                    int temp;
                    for (int j = 0; j < array.length; j++) {
                        for (int l = j + 1; l < array.length; l++) {
                            if (array[j] > array[l]) {
                                temp = array[j];
                                array[j] = array[l];
                                array[l] = temp;
                            }
                        }
                    }
                    System.out.print("Sorts the array in ascending order: ");
                    for (int a : array) {
                        System.out.print(a + " ");
                    }
                    break;
                case 10:
                    System.out.print("Enter the value want insert: ");
                    int value = scanner.nextInt();
                    System.out.print("Enter index of value want insert: ");
                    index = scanner.nextInt();
                    if (index < 0 || index > array.length) {
                        System.out.println("The array does not have this location");
                    } else {
                        if (args.length + 1 - index >= 0)
                            System.arraycopy(array, index - 1, array, index, args.length + 1 - index);
                        array[index] = value;
                        System.out.println("Array after inserting: ");
                        for (int a : array) {
                            System.out.print(a + " ");
                        }
                    }
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
