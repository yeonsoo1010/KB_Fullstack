package ch11.sec04;

public class TryWithResourceExample {
    public static void main(String[] args) {
        try(MyResource res = new MyResource("A")) {
            String data = res.read1(); // 메소드 리턴값 "100"
            int value = Integer.parseInt(data);
            System.out.println(data);
        } catch (Exception e) {
            System.out.println("예외: " + e.toString());
        }
        System.out.println();

        try(MyResource res = new MyResource("A")) {
            String data = res.read2(); // 메소드 리턴값 "abc"
            int value = Integer.parseInt(data);
            System.out.println(value);
        } catch (Exception e) {
            System.out.println("예외: " + e.toString());
        }
        System.out.println();
    }
}
