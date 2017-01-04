package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static {
        threads.add(new firstThread());
        threads.add(new secondThread());
        threads.add(new thridThread());
        threads.add(new fourthThread());
        threads.add(new fifthThread());
    }

    public static class firstThread extends Thread{
        public void run()
        {
            while (!isInterrupted()){}
        }
    }

    public static class secondThread extends Thread{
        public void run(){
            try{
                while (!isInterrupted())
                {
                    sleep(500);
                }
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class thridThread extends Thread{

        public void run(){
            try{
                while (!isInterrupted()){
                    System.out.println("Ура");
                    sleep(500);
                }
            }
            catch (InterruptedException e){}
        }
    }

    public static class fourthThread extends Thread implements Message{

        public void run()
        {
            while (!currentThread().isInterrupted()){}
        }

        public void showWarning()
        {
            this.interrupt();
            stop();
        }
    }

    public static class fifthThread extends  Thread{

        public void run(){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0 ;
            try{
                String input = reader.readLine();
                while (!input.equals("N")){
                    sum+=Integer.parseInt(input);
                    input = reader.readLine();
                }
                System.out.println(sum);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
