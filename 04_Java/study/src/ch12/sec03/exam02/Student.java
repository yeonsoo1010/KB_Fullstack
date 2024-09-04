package ch12.sec03.exam02;

public class Student {
    // 필드
    private int no;
    private String name;

    // 생성자
    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    // Getter: no
    public int getNo() {
        return no;
    }

    // Setter: no
    public void setNo(int no) {
        this.no = no;
    }

    // Getter: name
    public String getName() {
        return name;
    }

    // Setter: name
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hashCode = no + name.hashCode();
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student target) {
            if (this.no == target.getNo() && this.name.equals(target.getName())) {
                return true;
            } return false;
        } return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
