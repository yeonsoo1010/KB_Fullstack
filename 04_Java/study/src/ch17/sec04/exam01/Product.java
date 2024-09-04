package ch17.sec04.exam01;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Product {
    // 필드
    private int pno;
    private String name;
    private String company;
    private int price;

    @Override
    public String toString() {
        return "{" +
                "pno:" + pno +
                ", name:'" + name + '\'' +
                ", company:'" + company + '\'' +
                ", price:" + price +
                '}';
    }
}
