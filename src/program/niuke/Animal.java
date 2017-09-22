package program.niuke;

public interface Animal {
    void eat();
}

class Chicken implements Animal{

    @Override
    public void eat() {
        System.out.println("chicken has eat!");
    }
}

class Duck implements Animal{

    @Override
    public void eat() {
        System.out.println("duck has eat!");
    }
}
