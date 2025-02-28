package main.java.com.si3ri;

import main.java.com.si3ri.interfaces.AthleticRaceInterface;
import org.jvnet.substance.skin.*;

import javax.swing.*;

public class IniciarCarrera {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel( new SubstanceOfficeBlue2007LookAndFeel()); // Tema de Office 2007 de la biblioteca 'Substance'.
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize theme of Substance" );
        }

        new AthleticRaceInterface();
    }
}
