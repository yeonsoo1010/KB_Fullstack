package ch11.sec04;

public class MyResource implements AutoCloseable {
    // 필드
    private String name;

    // 생성자
    public MyResource(String name) {
        this.name = name;
        System.out.println("[MyResource(" + this.name + ") 열기]");
    }

    // 메소드
    public String read1() {
        System.out.println("[MyResource(" + this.name + ") 읽기]");
        return "100";
    }

    public String read2() {
        System.out.println("[MyResource(" + this.name + ") 읽기]");
        return "abc";
    }

    @Override
    public void close() throws Exception {
        System.out.println("[MyResource(" + this.name + ") 닫기]");
    }
}
