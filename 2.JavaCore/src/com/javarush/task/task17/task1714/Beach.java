package com.javarush.task.task17.task1714;

/* 
Comparable
Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach.
Пляжи(Beach) будут использоваться нитями, поэтому позаботьтесь,
чтобы все методы были синхронизированы.
Реализовать метод compareTo так,
чтобы он при сравнении двух пляжей выдавал число,
которое показывает что первый пляж лучше (положительное число)
или второй пляж лучше (отрицательное число), и насколько он лучше.


Требования:
1. Класс Beach должен содержать три поля: String name, float distance, int quality.
2. Класс Beach должен реализовывать интерфейс Comparable.
3. Метод compareTo класса Beach как минимум должен учитывать качество пляжа и дистанцию.
4. Все методы класса Beach, кроме метода main, должны быть синхронизированы.
*/
public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach b1 = new Beach("b1", 10, 10);
        Beach b2 = new Beach("b2", 10, 10);

        System.out.println(b2.compareTo(b1));
    }

    @Override
    public synchronized int compareTo(Beach o) {
        float b1 = this.getQuality() - this.getDistance();
        float b2 = o.getQuality() - o.getDistance();

        return (int) (b1 - b2);
    }
}
/*public class Beach {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }
}*/
