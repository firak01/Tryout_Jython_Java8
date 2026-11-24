from org.jython.book.interfaces import BuildingType

class Building(BuildingType):
   def __init__(self, name, address, id):
      self.name = name
      self.address  =  address
      self.id = id

   def getBuildingName(self):
      return self.name

   def getBuildingAddress(self):
      return self.address

#hier war im Buch ein fehlendes i getBuldingId...
   def getBuildingId(self):
      return self.id
