package ru.otus;


public class Main {
    static int size = 5*1000*1000;

    public static void main(String[] args) throws InterruptedException {
        MyWorker myWorker = new MyWorker();
        myWorker.setSize(size);
        myWorker.run();
    }


    }