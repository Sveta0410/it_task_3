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

    }

    // возвраащаем число решений квадратного уравнения ax^2+bx+c=0
    public static int solutions(int a, int b, int c) {
        double discriminant = b*b - 4*a*c;
        if (discriminant < 0){
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
        if (positionWithoutFirstZip == -1){
            return  -1; // если zip не найдено
        } else {
            return positionWithoutFirstZip + firstZip + 3;
            // позиция первого вхождения zip + длина zip + позиция второго вхождения в обрезанной строке
        }
    }
    // проверяем, можно ли записать число как сумму его множителей, исключая само число (6=1+2+3)
    public static boolean checkPerfect(int number) {
        int sum = 1; // т.к. все числа делятся на 1
        // 6=1*2*3, 6%2==0 => 6%(6/3)==0
        for (int i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0){
                sum += i;
                // если множитель равен корню исходного числа, то его "пару" добавлять не надо, т.к. это то же число
                if (i != Math.sqrt(number)){
                    sum += number / i;
                }
            }
        }
        return sum == number;
    }

}