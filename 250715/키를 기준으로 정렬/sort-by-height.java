import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Student {
    String name;
    int height;
    int weight;

    public Student(String name, int height, int weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public void print(){
        System.out.println(this.name + " " + this.height + " " + this.weight);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        Student[] arr = new Student[n];
        for(int i = 0; i< n; i++){
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            arr[i] = new Student(name, height, weight);
        }

        Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b){
                return a.height - b.height;
            }
        });

        for(int i = 0; i< n; i++){
            arr[i].print();
        }
    }
}