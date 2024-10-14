#Vijay Venkatesan
#11/26/2022

import unittest
import Scoop
import Carton
import IceCreamShoppe
import math

class ScoopTest(unittest.TestCase):

    #Tests the value of radius when given normal input
    def test_get_radius_normal(self):
        scoop1 = Scoop.Scoop(1)
        self.assertEqual(scoop1.get_radius(),1)
    
    #Tests the value of radius when given very large input
    def test_get_radius_edge_1(self):
        scoop1 = Scoop.Scoop(1000)
        self.assertEqual(scoop1.get_radius(),10)
    
    #Tests the value of radius when given zero as input
    def test_get_radius_edge_2(self):
        scoop1 = Scoop.Scoop(0)
        self.assertEqual(scoop1.get_radius(),1)
    
    #Tests the value of radius when given a negative input
    def test_get_radius_malicious_user(self):
        scoop1 = Scoop.Scoop(-100)
        self.assertEqual(scoop1.get_radius(),1)

    #Tests the value of volume when given normal input
    def test_volume_normal(self):
        scoop1 = Scoop.Scoop(1)
        self.assertAlmostEqual(scoop1.volume(),4.1887902047863905)

class CartonTest(unittest.TestCase):

    #tests the value of hasEnoughFor when given normal input
    def test_hasEnoughFor_normal_1(self):
        carton1 = Carton.Carton(1,1)
        scoop1 = Scoop.Scoop(2)
        self.assertFalse(carton1.hasEnoughFor(scoop1))

    #tests the value of hasEnoughFor when given normal input
    def test_hasEnoughFor_normal_2(self):
        carton1 = Carton.Carton(5,5)
        scoop1 = Scoop.Scoop(1)
        self.assertTrue(carton1.hasEnoughFor(scoop1))
    
    #tests the value of hasEnoughFor when given very large input
    def test_hasEnoughFor_edge_1(self):
        carton1 = Carton.Carton(10000,10000)
        scoop1 = Scoop.Scoop(5)
        self.assertTrue(carton1.hasEnoughFor(scoop1))
    
    #tests the value of hasEnoughFor when given very small input
    def test_hasEnoughFor_edge_2(self):
        carton1 = Carton.Carton(0,0)
        scoop1 = Scoop.Scoop(5)
        self.assertFalse(carton1.hasEnoughFor(scoop1))
    
    #tests the value of hasEnoughFor when given negative input
    def test_hasEnoughFor_malicious_user(self):
        carton1 = Carton.Carton(-100,-100)
        scoop1 = Scoop.Scoop(5)
        self.assertFalse(carton1.hasEnoughFor(scoop1))

    #tests the value of get_contains when given normal input
    def test_get_contains_normal(self):
        carton1 = Carton.Carton(5,6)
        self.assertAlmostEqual(carton1.get_contains(),471.238898038)
    
    #tests the value of get_contains when given very large input
    def test_get_contains_edge_1(self):
        carton1 = Carton.Carton(10000,10000)
        self.assertAlmostEqual(carton1.get_contains(),3141.59265359)
    
    #tests the value of get_contains when given very small input
    def test_get_contains_edge_2(self):
        carton1 = Carton.Carton(0,0)
        self.assertAlmostEqual(carton1.get_contains(),math.pi)
    
    #tests the value of get_contains when given negative input
    def test_get_contains_malicious_user(self):
        carton1 = Carton.Carton(-100,-100)
        self.assertAlmostEqual(carton1.get_contains(),math.pi)

    #tests the value of remove when given normal input
    def test_remove_normal(self):
        carton1 = Carton.Carton(5,6)
        scoop1 = Scoop.Scoop(1)
        carton1.remove(scoop1)
        self.assertAlmostEqual(carton1.get_contains(),467.050107833)
    
    #tests the value of remove when given very large input
    def test_remove_edge(self):
        carton1 = Carton.Carton(10000,10000)
        scoop1 = Scoop.Scoop(0)
        carton1.remove(scoop1)
        self.assertAlmostEqual(carton1.get_contains(),3137.40386339)
        
    
class IceCreamShoppeTest(unittest.TestCase):

    #tests the value of current_carton is correct after using the serve method with normal input
    def test_serve__normal(self):
        shoppe1 = IceCreamShoppe.IceCreamShoppe(5, 6)
        scoop1 = Scoop.Scoop(2)
        shoppe1.serve(3,scoop1)
        self.assertAlmostEqual(shoppe1.current_carton.get_contains(), 370.707933123)

    #tests the value of cartonsUsed after using the serve method with normal input
    def test_cartonsUsed__normal(self):
        shoppe1 = IceCreamShoppe.IceCreamShoppe(5, 6)
        scoop1 = Scoop.Scoop(3)
        scoop2 = Scoop.Scoop(4)
        shoppe1.serve(3,scoop1)
        shoppe1.serve(3,scoop2)

        self.assertEqual(shoppe1.cartonsUsed(),4)
    
    #tests the value of cartonsUsed after using the serve method with low input
    def test_cartonsUsed__edge(self):
        shoppe1 = IceCreamShoppe.IceCreamShoppe(5, 6)
        scoop1 = Scoop.Scoop(0)
        scoop2 = Scoop.Scoop(0)
        shoppe1.serve(0,scoop1)
        shoppe1.serve(0,scoop2)

        self.assertEqual(shoppe1.cartonsUsed(),1)


if __name__ == "__main__":
    unittest.main()
















        


    
    

    



def main():
    unittest.main()

if __name__ == "__main__":
    main()
