package ru.gb.Lesson4;

public class Square {

    public static double Area(double a, double b, double c) throws Exception {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new Exception("Side <= 0");
        }


        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }
}

   /* public static void IsSquareByThreeSides ( int a, int b, int c) throws PerimetepException {
        double p = (a + b + c) / 2;
        if (p==a|p==b|p==c)
        {
            throw new PerimetepException();


            double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println(square);

        }else System.out.println("Cann't use");

    }
            /*public static void main(String[] args) {
                IsSquareByThreeSides(2, -3, 4);

                 if (p==a|p==b|p==c)
        {
            throw new Exception("HalfPerimeter cann't to be less then ona from sides");}
    */


