import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

class Student implements Comparable<Student>{
    char name;
    int score;
    public Student(char name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student s){
        return this.score - s.score;
    }
}

// comparable 객체

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Please write your code here.
        ArrayList <Student> arr = new ArrayList <Student>();

        for(int i = 0; i<5; i++){
            char name = sc.next().charAt(0);
            int score = sc.nextInt();
            arr.add(new Student(name, score));
            // System.out.println(arr[i].name + " " + arr[i].score);
        }

        Collections.sort(arr);
        System.out.println(arr.get(0).name + " " + arr.get(0).score);
    }
}