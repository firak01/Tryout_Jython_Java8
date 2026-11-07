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

# Berechnung mit einer Variablen, die wohl aus Java übergeben wird
# FGL: Das scheint aber nicht zu klappen. Nur wenn ich diesen Wert hart verdrahte gibt es keine Fehler.... basis_zahl = 2
# FGL: Wenn ich im Java-Teil dem Interpreter basis_zahl übergebe, dann klappt´s.
#      s. PyEmbed.java
#				public void initInterp() {
#               		....
#				      	this.interp.set("basis_zahl", 2);

ergebnis = basis_zahl * 2

print "Berechnung in Python abgeschlossen: %s" % ergebnis