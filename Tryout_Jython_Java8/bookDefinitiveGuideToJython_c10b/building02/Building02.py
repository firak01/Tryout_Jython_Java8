# -*- coding: utf-8 -*-
from org.jython.book02.interfaces import BuildingType

# wird oben nicht das korrekte Interface (Package) angegeben, gibt es eine ClassCastException später in der Factory
# ausserdem muss hier die coding Zeile auch rein
class Building(BuildingType):
    def __init__(self):
       self.name = None
       self.address  =  None
       self.id = -1

    def getBuildingName(self):
        return self.name

    def setBuildingName(self, name):
        self.name = name;

    def getBuildingAddress(self):
        return self.address

    def setBuildingAddress(self, address):
        self.address = address

    def getBuildingId(self):
        return self.id

    def setBuildingId(self, id):
        self.id = id