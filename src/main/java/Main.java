import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static Scanner out = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Main main = new Main();
        boolean flag = true;
        int lengthArr = 0;
        int newValue = 0;
        System.out.println("Please enter , how many numbers do you want to be sorted?");
        try {
            do {
                lengthArr = out.nextInt();
                logger.debug("checking length");
                flag = main.checkLenghtArr(lengthArr);
            } while (!flag);
        } catch (java.util.InputMismatchException e) {
            logger.error(e.getMessage());
        }

        System.out.println("please enter " + lengthArr + " number:");
        Integer[] array = new Integer[lengthArr];
        Integer[] copyArray = new Integer[array.length];
        for (int i = 0; i < lengthArr; i++) {
            do {
                do {
                    newValue = out.nextInt();
                    logger.debug("check to not be repetitive");
                    flag = main.checkNonRepetitive(newValue, array, i);
                } while (!flag);
                logger.debug("check to be in range");
                flag = main.checkValue(newValue);
                if (flag) {
                    logger.debug("the element can add to array");
                    array[i] = newValue;
                    copyArray[i] = array[i];
                }
            } while (!flag);
        }

        logger.debug("sorting array <descending>");
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println(main.compare(array, copyArray) + " cell has been changed. ");
    }

    public boolean checkLenghtArr(int n) {
        if (n < 1 || n > 300000) {
            System.out.println("this number is out of range.(1<n<300,000) .please try again!!");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkValue(int n) {
        if (-1000000000 > n || n > 1000000000) {
            System.out.println("this number is too big or  small.(-1000000000<n<1000000000). please try another one!!");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkNonRepetitive(int num, Integer[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == num) {
                System.out.println("this number is already exist ,please try another one!!");
                return false;
            }
        }
        return true;
    }


    public int compare(Integer arr1[], Integer arr2[]) {
        int counter = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                counter++;
        }
        return counter;
    }

    /*public void showArr(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }*/
}
