package com.dayanE6.multithreaded;

public class Counters {

    static class FactorialCounter extends Counters implements Runnable{

        private final int n;

        public FactorialCounter(int n){
            this.n = n;
        }

        public void run(){
            try{
                long fact = 1;

                for (int i = 0; i < this.n; i++){
                    fact = fact * (i + 1);
                }

                System.out.println(fact);
            }
            catch (Exception e){
                System.out.println("Factorial Exception");
            }
        }
    }

    static class SumOfSequence implements Runnable{

        private final int n;

        public SumOfSequence(int n){
            this.n = n;
        }

        public void run(){
            try{
                long sum = 0;
                for (int i = 0; i < n; i++){
                    sum = sum + (i + 1);
                }

                System.out.println(sum);
            }
            catch (Exception e){
                System.out.println("Sum Exception");
            }
        }
    }
}
