package unieibar;

public class FibonacciHaria extends Thread {

    public void Fibonacci(int n){
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

    @Override
    public void run(){
        int n = 5;
        Fibonacci(n);
    }

    public static void main(String[] args) {
        FibonacciHaria fibonacci = new FibonacciHaria();

        fibonacci.start();
    }
}