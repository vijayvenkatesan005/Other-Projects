#Vijay Venkatesan
#11/26/2022

import Carton
import Scoop

class IceCreamShoppe:
    ''' Class: IceCreamShoppe
        Attributes: carton_radius, carton_height,
        cartons_used, current_carton 
        Methods: serve, cartonsUsed'''

    def __init__(self, carton_radius, carton_height):
        ''' Constructor
            Parameters:
                self
                carton_radius - radius of a carton
                carton_height - height of a carton'''

        if carton_radius <= 0:
            self.carton_radius = 1
        else:
            self.carton_radius = carton_radius
            

        if carton_height <= 0:
            self.carton_height = 1
        else:
            self.carton_height = carton_height

        self.cartons_used = 1
        self.current_carton = Carton.Carton(carton_radius, carton_height)

    def serve(self, numScoops:int, scooper:Scoop.Scoop):
        ''' serve
            Parameters:
                numScoops - the number of Scoops wanted
                scooper - the scoop object with the desired radius'''

        count = 0

        while count != numScoops:
            if self.current_carton.hasEnoughFor(scooper):
                self.current_carton.remove(scooper)
                count += 1
            else:
                self.current_carton = Carton.Carton(self.carton_radius, self.carton_height)
                self.cartons_used += 1
                self.current_carton.remove(scooper)
                count += 1

    def cartonsUsed(self):
        ''' cartonsUsed
            Parameters:
                self
            Return:
                the total number of cartons used to make ice cream'''

        return self.cartons_used
