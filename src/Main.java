public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));

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
}