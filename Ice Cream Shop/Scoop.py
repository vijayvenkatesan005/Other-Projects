#Vijay Venkatesan
#11/26/2022

import math

class Scoop:
   ''' Class: Scoop
        Attributes: radius
        Methods: get_radius, volume'''

   def __init__(self, radius):
      ''' Constructor
            Parameters:
               self
               radius - radius of the scoop'''

      if radius > 10:
         self.radius = 10
      elif radius <= 0:
         self.radius = 1
      else:
         self.radius = radius
      
   def get_radius(self):
      ''' get_radius
            Parameters:
                self
            Return:
                the radius of the scoop'''
      return self.radius

   def volume(self):
      ''' volume
            Parameters:
                self
            Return:
                the volume of a scoop'''
      return 4/3 * math.pi*self.radius**3


