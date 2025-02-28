package main.java.com.si3ri.interfaces;

import java.util.Random;

public class Runner {
    private final String name; // Atributo que corresponde al nombre del corredor.
    private final int speed; // Atributo que proveé de un número del 0 al 30.
    private boolean running = true; // Variable para controlar la ejecución del hilo.

    public Runner(String name) {
        this.name = name;
        this.speed = new Random().nextInt(31); // Velocidad entre 0 y 30 al ejecutarse los hilos.
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isRunning() {
        return running;
    }

    public void stopRunning() {
        this.running = false;
    }
}
