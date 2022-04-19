package com.company;

public class Crawler {

    private String URL;
    private static int maxDepth;
    public static int CountThreads;

    public static int WaitingThreads = 0;
    public static int CountURLs = 0;

    public static int getMaxDepth() { return maxDepth; }

    public Crawler(String URL, int maxDepth, int countThreads) {
        this.URL = URL;
        Crawler.maxDepth = maxDepth;
        Crawler.CountThreads = countThreads;
    }

    public void run() {
        CrawlerTask task = new CrawlerTask(new URLDepthPair(URL,0));
        task.start();
    }

    public static void main(String[] args) {
        Crawler crawler = new Crawler("https://mtuci.ru",2 ,10);
        crawler.run();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> printResult()));
        //Лямбда функция, делит лямбда выражение
        //на две части, левая - список параметров выражения, правая - собственно выполнение некоторого действа
        //Здесь - создаёт поток, который будет выводить результат, когда программа закончила делать дела, мы вызываем
        //ShutdownHook.
    }

    private static void printResult() {
        System.out.println();
        System.out.println("Всего ссылок: " + CountURLs);
    }
}
