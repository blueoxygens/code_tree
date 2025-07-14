import java.util.Scanner;
// import java.util.Integer;
import java.util.Arrays;

class Weather implements Comparable<Weather>{
    String date;
    String day;
    String weather;

    public Weather(String date, String day, String weather){
        this.date = date;
        this.day = day;
        this.weather = weather;
    }

    @Override
    public int compareTo(Weather o2){
        return Integer.parseInt(this.date.replaceAll("-","")) - Integer.parseInt(o2.date.replaceAll("-",""));
    }

    public void print(){
        System.out.println(this.date + " " + this.day + " " + this.weather);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Weather[] arr = new Weather[n];
        for (int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();
            // Please write your code here.
            arr[i] = new Weather(date, day, weather);
        }
        Arrays.sort(arr);
        for (int i = 0; i<n; i++){
            if(arr[i].weather.equals("Rain")){
                arr[i].print();
                break;
            }
        }
    }
}