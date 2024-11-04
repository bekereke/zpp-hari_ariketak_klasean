package unieibar;

public class FibonacciHariaLambda {
    public static void Fibonacci(int n){
        int a=0;
        int b=1;
        int lag;
        String segida =a+", "+b;
        for (int i=0;i<n;i++){
            lag = a + b;
            a = b;
            b = lag;
            segida+=", "+lag;
        }
        System.out.println(segida);
    }

    public static void main(String[] args) {
        int n = 5;
        Thread fibonacci = new Thread(()-> { Fibonacci(n); });

        fibonacci.start();
    }  
}
