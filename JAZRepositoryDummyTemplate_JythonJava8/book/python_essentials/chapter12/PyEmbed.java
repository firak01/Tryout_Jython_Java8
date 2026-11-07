package python_essentials.chapter12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.python.core.*;
import org.python.util.*;

/**Aus dem Buch "Python Essentials", Kapitel 12.
 * Das Problem ist, das ich aus dem downloadbaren Quellcode zum Buch nicht weiss was in embed.py programmiert ist. 
 * Daher habe ich einfach ein eigenen embed.py erstellt.
 * 
 * Sinn des - von mir erweiteten - Beispiels ist
 * a) Man kann ein Python Script aufrufen
 *    Parameter übergeben und Ergebnisse empfangen (Meine Erweiterung)
 *    
 * b) Man kann auch mit Objekten arbeiten (s. Buch Originalscript)
 *    Z.B.  this.interp.set("g", this.easel.getGraphics());
 *          definiert g, so dass in Python die Zeile ausgeführt werden kann:
 *          g.drawLine(10,10,100,10)
 * 
 * @author Fritz Lindhauer
 *
 */
public class PyEmbed extends JFrame {

    PythonInterpreter interp;
    JPanel easel;
    String startFile;
    JTextField textFieldScript;
    JTextField textFieldCommand;
    JTextField textFieldResult;
    
    public PyEmbed(String startupScriptPath, String startupCommand) {
        this.startFile = startupScriptPath;
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }});
        this.getContentPane().setLayout(new BorderLayout());
        this.easel = new JPanel();
        this.easel.setPreferredSize(new Dimension(200, 200));
        this.getContentPane().add(this.easel, BorderLayout.CENTER);
        
        //FGL: Das Ergebnistextfeld
        this.textFieldResult = new JTextField("");
        this.textFieldResult.setPreferredSize(new Dimension(200, 20));
        this.getContentPane().add(this.textFieldResult, BorderLayout.EAST);
        
        //FGL: Übergib den Namen des Python Scripts an das Eingabefeld, damit was tolles passiert.       
        this.textFieldScript = new JTextField(startupScriptPath);
        this.textFieldScript.setPreferredSize(new Dimension(200, 20));
        this.getContentPane().add(this.textFieldScript, BorderLayout.NORTH);
        this.textFieldScript.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	String sAction = PyEmbed.this.textFieldScript.getText();
            	System.out.println("Script action...: " + sAction);
                
            	//Das führt das ganze Script aus
            	PyEmbed.this.interp.execfile(sAction);
                
                //FGL: Damit was sinnvolles passiert
                PyObject pyErgebnis = PyEmbed.this.interp.get("ergebnis");
                String sErgebnis = pyErgebnis.toString();
               
                PyEmbed.this.textFieldResult.setText("Ergebnis: " + sErgebnis);
                
                PyEmbed.this.getContentPane().revalidate();
                PyEmbed.this.getContentPane().repaint();
                
                
            }});
        
        
        this.textFieldCommand = new JTextField(startupCommand);
        this.textFieldCommand.setPreferredSize(new Dimension(200, 20));
        this.getContentPane().add(this.textFieldCommand, BorderLayout.SOUTH);
        
        // Übergib hier eine Befehlszeile an Python.  
        // Z.B.:    g.drawline(10,10,100,100), macht auch was tolles und arbeite mit dem in Java erzeugeten Graphics g Objekt.
        this.textFieldCommand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	String sAction = PyEmbed.this.textFieldCommand.getText();
            	System.out.println("Command action...: " + sAction);
            	
                //Das führt nur eine einzelne Befehlszeilencommando in Python aus
            	PyEmbed.this.interp.exec(sAction);
            	            	            	
                PyEmbed.this.textFieldResult.setText("Aktion ausgeführt.");
                
                //FGL: Hier nicht neu malen, das löscht z.B. die gezeichnete Linie
                //PyEmbed.this.getContentPane().revalidate();
                //PyEmbed.this.getContentPane().repaint();                                
            }});

        //this.textfieldCommand
        this.pack();
    }
    
    public void initInterp() {
        PySystemState.initialize();
        this.interp = new PythonInterpreter(); 
        this.interp.set("w", this);
        this.interp.set("e", this.easel);
        this.interp.set("g", this.easel.getGraphics());
        
        //FGL: ich weiss immer noch nicht warum embed.py wichtig ist. Die Datei ist ja eh nicht das Original, was ja fehlt.
        //     aber in dem "geklauten" Beispiel fehlt basis_zahl.
        //     Vielleicht kann ich sie so übergeben? Ja, klappt. siehe embed.py
        this.interp.set("basis_zahl", 2);
    }
    
    public void show() {
        super.show();
        this.initInterp();
        //this.interp.execfile(this.startFile);
    }
    
    public static void main(String[] argv) {
   	
    	//Möglich, ein absoluter Pfad
    	//String sScript = "C:\\1fgl\\repo\\EclipseOxygen_V02\\Project_JAZxJython_Python2\\JAZxJython_Python2\\book\\python_essentials\\chapter12\\embed.py";
    	
    	//Es reicht aber wohl der relative Pfad, mit den Packages!
    	String sScript = "book\\python_essentials\\chapter12\\embed.py";
    	String sCommand = "g.drawLine(10,10,100,10)";
        PyEmbed embed = new PyEmbed(sScript, sCommand);
        embed.show();
    }
              
}

