public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));

        System.out.println("Задание 2");
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));

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
}