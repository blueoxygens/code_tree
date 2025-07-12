import java.util.Scanner;

class Product {
    String name = "codetree";
    int code = 50;

    public Product() {}

    public Product(String name, int code){
        this.name = name;
        this.code = code;
    }

    public void print(){
        System.out.println("product " + code + " is " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id2 = sc.next();
        int code2 = sc.nextInt();
        // Please write your code here.
        Product[] parr = new Product[2];
        parr[0] = new Product();
        parr[1] = new Product(id2, code2);

        for(int i=0; i<2; i++){
            parr[i].print();
        }

    }
}