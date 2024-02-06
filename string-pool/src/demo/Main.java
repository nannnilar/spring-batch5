package demo;

public class Main {
    public static void main(String[] args) {
       String s1 = "Hello World";
       String s2 = "Hello World";
       String s3 = new String("Hello World");
       s3=s3.intern();

       boolean test = s1 == s3;
        System.out.println(test);
    }
}