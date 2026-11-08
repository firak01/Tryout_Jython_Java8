# -*- coding: utf-8 -*-

'''
Erstellter Code durch KI-Google Suche.
Als Seite wird angegeben: https://mr-dai.github.io/embedding-jython/


Diese Datei fehlte im Download der Buchbeispiele.
Damit soll wohl gezeigt werden, dass Python Code ausgeführt werden kann.
Ich vermute dass basis_zahl aus Java übergeben werden sollte.


Created on 15.10.2026

@author: Fritz Lindhauer
'''

# embed.py
# Einfaches Skript zur Demonstration von Variablen und Berechnungen in Jython

print "Starte die Ausfuehrung von embed.py..."

# Berechnung mit einer Variablen, die aus Java übergeben wird
# FGL: Wenn ich im Java-Teil dem Interpreter basis_zahl übergebe, dann klappt´s.
#      s. PyEmbed.java
#				public void initInterp() {
#               		....
#				      	this.interp.set("basis_zahl", 2);

''' Code mit dem man rausfindet, das basis_zahl kein richtiges Objekt ist, sondern nur 'int' object, das kein Attribut 'getClass' hat 
oBasis_ZahlClass = basis_zahl.getClass()
'''

# Man kann auch ganze Java Ojekte übergeben
#      s. PyEmbed.java
#               public void initInterp() {
#                       ....this.interp.set("t", this.textFieldInput);

''' Code mit dem man Details herausfindet und ggfs. auch Jythons Binding Probleme
print("Objekt:", t)

oTClass = t.getClass()
print("Klassen SimpleName :", oTClass.getSimpleName())
print("Klassen CanonicalName:", oTClass.getCanonicalName())
print("Inhalt:", repr(t.getText()))

from java.lang import Class
print("Klassen Name durch Class.getName(...):", Class.getName(oTClass))

# Variante 1: geht nicht, hier wird angeblich in getName() ein Argument erwartet
# print("Klassen Name :", oTClass.getName())
#
# Variante 2: geht nicht, hier wird angeblich in getName() ein Argument erwartet
# print("Klassen Name durch __call__():", oTClass.getName.__call__())


# Aber es klappt wiederum:
from java.lang import String
oStringClass = String("Test").getClass()
print(oStringClass.getSimpleName())
print(oStringClass.getName())
'''


############################
sInputByT = t.getText()
if sInputByT is None or sInputByT == '':
    ergebnis = basis_zahl * 2
else:
    # Den String in einen int Wert umwandeln
    # Witzig: Ohne Umwandlung in einen int Wert gilt:  sInputByT * 2 bewirkt, dass der String 2 mal ausgegen wird.    
    ergebnis = int(sInputByT) * 2

print "Berechnung in Python abgeschlossen: %s" % ergebnis

# Das Ergebnis kann nicht nur hier ausgegeben werden, sondern steht im JavaUI auch zur Verfügung
''' siehe PyEmbed.java

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
'''