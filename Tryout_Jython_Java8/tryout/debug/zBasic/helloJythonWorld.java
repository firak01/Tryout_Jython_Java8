package debug.zBasic;

import java.io.File;

import org.python.util.PythonInterpreter;

public class helloJythonWorld {

	public static void main(String[] args) {
        PythonInterpreter python = new PythonInterpreter();

        try {
            File script = new File("script/helloJava_I_am_python.py");

            python.execfile(script.getAbsolutePath());

            // Python-Funktion aufrufen
            python.exec("ergebnis = addiere(17, 25)");

            // Ergebnis zurück nach Java holen
            Object ergebnis = python.get("ergebnis", Object.class);

            System.out.println("Ergebnis aus Python: " + ergebnis);


        } finally {
            python.close();
        }
	}
}
