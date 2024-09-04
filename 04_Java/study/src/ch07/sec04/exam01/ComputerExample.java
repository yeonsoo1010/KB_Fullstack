package ch07.sec04.exam01;

public class ComputerExample {
    public static void main(String[] args) {
        int r = 10;

        Calculator calculator = new Calculator();
        double result_Cal = calculator.areaCircle(r);
        System.out.println("원 면적: " + result_Cal);
        System.out.println();

        Computer computer = new Computer();
        double result_Comp = computer.areaCircle(r);
        System.out.println("원 면적: " + result_Comp);
    }
}
