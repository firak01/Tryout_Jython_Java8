Code aus dem Buch "The Definitive Guide To Jython"
Kapitel 10 building Factory

Dieses Beispiel wird im Buch bezeichnet als "Loosely Coupled Object Factory"
aber es soll wohl perfomanter sein, weil das wird als Ziel genannt:
// likely want to reuse PySystemState in some clever fashion since expensive to setup...


benötigt wie im vorherigen Beispiel (aber die Packagenamen mussten wg. Eindeutigkeit andere sein) 
building/Building.py    
bekanntgemacht in __init__.py
erbt aus dem Interace BuildingType.java

Java Klassen:
BuildingType.java
JythonObjectFactory.java     (neu:)
Main.java
          startet das mit run as... Java


