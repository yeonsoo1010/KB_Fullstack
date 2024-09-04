package ch07.sec07.exam01;

// 상속 관계
// A <- B <- D , A <- C <- E
class A{}
class B extends A{}
class C extends A{}
class D extends B{}
class E extends C{}

public class PromotionExample {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();

        A a1 = b; // 부모 = 자식(더 많은 기능), 실체는 자식, 이름을 부모: 고양이는 동물이다. / 부모를 자식으로 본다? 아닌가?
        A a2 = c;
        A a3 = d;
        A a4 = e;

        B b1 = d; // 부모 = 자식
        C c1 = e;

//        B b3 = e; // 상속 관계 X
//        C c2 = d; // 상속 관계 X
    }
}
