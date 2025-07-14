import java.util.Scanner;
import java.util.Arrays;

class Person implements Comparable<Person>{
    String names;
    String addresses;
    String regions;

    public Person(String names, String addresses, String regions){
        this.names = names;
        this.addresses = addresses;
        this.regions = regions;
    }

    @Override
    public int compareTo(Person b){
        // return (this.names > b.names);
        return this.names.compareTo(b.names);
    }

    public void print() {
        System.out.println("name " + this.names);
        System.out.println("addr " + this.addresses);
        System.out.println("city " + this.regions);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        String[] addresses = new String[n];
        String[] regions = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            addresses[i] = sc.next();
            regions[i] = sc.next();
        }
        Person[] arr = new Person[n];
        for (int i = 0; i<n; i++){
            arr[i] = new Person(names[i], addresses[i], regions[i]);
        }
        Arrays.sort(arr);
        // Please write your code here.
        arr[n-1].print();
    }
}