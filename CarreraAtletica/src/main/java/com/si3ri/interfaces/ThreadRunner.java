package main.java.com.si3ri.interfaces;

import javax.swing.JTextArea;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadRunner implements Runnable {
    private final Runner runner;
    private final JTextArea cajaResultados;
    private static final AtomicInteger contadorPosiciones = new AtomicInteger(1);
    // Variable que cuenta por el orden de llegada de los corredores. Aplica para que múltiples hilos pueden acceder y modificar su valor.

    public ThreadRunner(Runner runner, JTextArea cajaResultados) {
        this.runner = runner;
        this.cajaResultados = cajaResultados;
    }

    @Override
    public void run() {
        try {
            int sleepTime = runner.getSpeed() * 1000; // Transforma el tiempo de milisegundos a segundos.
            for (int i = 0; i < sleepTime; i += 100) {
                if (!runner.isRunning()) {
                    return; // Sale del método 'run' si la carrera es cancelada por corredor.
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (runner.isRunning()) { // Se actualiza la caja de texto si el corredor no ha sido detenido.
            int ordenLlegada = contadorPosiciones.getAndIncrement(); // Cuando un corredor termina su ejecución, se incrementa el contador.
            String resultado = String.format("%d - %s - Tiempo: %d segundos.\n", ordenLlegada, runner.getName(), runner.getSpeed());
            javax.swing.SwingUtilities.invokeLater(() -> cajaResultados.append(resultado));
        }
    }
    public static void resetContadorPosiciones() { // Método para restablecer el contador de posiciones a 1.
        contadorPosiciones.set(1);
    }
}
