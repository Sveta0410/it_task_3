import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));

        System.out.println("Задание 2");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));

        System.out.println("Задание 3");
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));

        System.out.println("Задание 4");
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));

        System.out.println("Задание 5");
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));

        System.out.println("Задание 6");
        int[] array1 = new int[]{1, 3, 4, 4, 4};
        int[] array2 = new int[]{2, 5, 7};
        System.out.println(same(array1, array2));
        int[] array3 = new int[]{9, 8, 7, 6};
        int[] array4 = new int[]{4, 4, 3, 1};
        System.out.println(same(array3, array4));
        int[] array5 = new int[]{2};
        int[] array6 = new int[]{3, 3, 3, 3, 3};
        System.out.println(same(array5, array6));

        System.out.println("Задание 7");
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));
        System.out.println(isKaprekar(0));
        System.out.println(isKaprekar(1));

        System.out.println("Задание 8");
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));

        System.out.println("Задание 9");
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));

        System.out.println("Задание 10");
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));
    }

    // возвраащаем число решений квадратного уравнения ax^2+bx+c=0
    public static int solutions(int a, int b, int c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return 0;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    // возвращаем позицию второго вхождения zip в строку
    public static int findZip(String s) {
        int firstZip = s.indexOf("zip"); // находим позицию первого вхождения zip
        String sWithoutFirstZip = s.substring(firstZip + 3); // обрезаем строку(убераем всё до zip + само zip)
        int positionWithoutFirstZip = sWithoutFirstZip.indexOf("zip"); // находим вхождение zip в обрезаннос строке
        if (positionWithoutFirstZip == -1) {
            return -1; // если zip не найдено
        } else {
            return positionWithoutFirstZip + firstZip + 3;
            // позиция первого вхождения zip + длина zip + позиция второго вхождения в обрезанной строке
        }
    }

    // проверяем, можно ли записать число как сумму его множителей, исключая само число (6=1+2+3)
    public static boolean checkPerfect(int number) {
        int sum = 1; // т.к. все числа делятся на 1
        // 6=1*2*3, 6%2==0 => 6%(6/3)==0
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                sum += i;
                // если множитель равен корню исходного числа, то его "пару" добавлять не надо, т.к. это то же число
                if (i != Math.sqrt(number)) {
                    sum += number / i;
                }
            }
        }
        return sum == number;
    }

    // меняем в строке первый и последний символ
    public static String flipEndChars(String myString) {
        if (myString.length() < 2) {
            // если длина строки меньше 2, возвращаем "несовместимо."
            return "Incompatible.";
        } else if (myString.charAt(0) == myString.charAt(myString.length() - 1)) {
            // если первый и последний символы совпадают, возвращаем "два-это пара."
            return "Two's a pair.";
        } else {
            // substring =  от какого-то значения i (включительно) до j (НЕ включаем)
            return myString.charAt(myString.length() - 1) +
                    myString.substring(1, myString.length() - 1) +
                    myString.charAt(0);
        }
    }

    // определяем, является ли строка допустимым шестнадцатеричным кодом
    public static boolean isValidHexCode(String myString) {
        if (myString.charAt(0) != '#') {
            return false;
        } else //регулярное выражение (цифры 0-9 или буквы A-F, a-f,  кол-во символов 6) [рассматриваем подстроку(без #)]
            // !ВАЖНО! рассматриваем противоположное событие (строка не подошла по параметрам -> возвращаем false)
            if (myString.length() != 7) {
            // 7 = 6 + #
            return false;
        } else return myString.substring(1, myString.length()).matches("[A-Fa-f0-9]{6}");
    }

    // возвращаем true, если два массива имеют одинаковое количество уникальных элементов, и false в противном случае
    public static boolean same(int[] arr1, int[] arr2) {
        return removeDublicates(arr1).size() == removeDublicates(arr2).size();
    }

    // вспомогательная функция, позволяющая создать из исходного массива список с уникальными элементами
    public static List<Integer> removeDublicates(int[] arr) {
        List<Integer> newArr = new ArrayList<Integer>();
        for (int num : arr) {
            if (!(newArr.contains(num))) {
                newArr.add(num);
            }
        }
        return newArr;
    }

    // возвращаем true, если это число Капрекара, и false, если это не так
    // (число, кот. после возведения в квадрат и разбиения на две части равно сумме двух полученных новых чисел)
    public static boolean isKaprekar(int number) {
        int nSquare = number * number;
        String numStr = Integer.toString(nSquare);
        int numLen = numStr.length();
        if (numLen == 1) {
            // если количество цифр == 1
            return nSquare == number;
        } else {
            int left = Integer.parseInt(numStr.substring(0, numLen / 2));
            int right = Integer.parseInt(numStr.substring(numLen / 2));
            return left + right == number;
        }
    }

    // возвращаем самую длинную последовательность последовательных нулей в двоичной строке
    public static String longestZero(String number) {
        if (number.contains("0")) {
            String[] zeroes = number.split("1+");
            Arrays.sort(zeroes);
            return zeroes[zeroes.length - 1];
        } else {
            return "";
        }
    }

    // возвращаем следующее простое число. если число простое, возвращаем само число
    public static int nextPrime(int number) {
        for (int i = number; ; i++){
            if (isPrime(i)){
                return i;
            }
        }
    }
    // вспомогательная функция, которая проверяет, является ли число простым
    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    // проверяем, являются ли числа x, y, и z рёбрами прямоугольного треугольника
    public static boolean rightTriangle(int x, int y, int z) {
        // проверяем по теореме Пифагора (если x - гипотенуза ||(или) y - гипотенуза || z - гипотенуза)
        return (x * x - y * y - z * z == 0) || (y * y - x * x - z * z == 0) || (z * z - x * x - y * y == 0);
    }
}