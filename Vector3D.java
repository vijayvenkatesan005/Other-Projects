/**
 * This class represents 3-dimensional vectors and common operations that can be
 * done on them
 * Every 3-dimensional vector has x, y, z components
 */
public class Vector3D {

    double x;
    double y;
    double z;

    /**
     * Constructs a Vector3D object and initializes it to the
     * given x, y, and z components of the vector.
     * @param x -> a double value representing the x component
     * @param y -> a double value representing the y component
     * @param z -> a double value representing the z component
     */
    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public static void main(String[] args){



        Vector3D v1 = new Vector3D(10,20,30);
        Vector3D v2 = new Vector3D(25, 35, 45);

        Vector3D v3 = new Vector3D(2,3,5);
        Vector3D v4 = new Vector3D(1,6,-4);

        Vector3D a = new Vector3D(7,3,-4);
        Vector3D b = new Vector3D(1,0,6);



        System.out.println(v1.toString());
        System.out.println(v2.toString());


        System.out.println(v1.getMagnitude());
        System.out.println(v1.add(v1, v2));

        System.out.println(v1.multiply(2));
        System.out.println(v1.add(v1,v2));
        System.out.println(v1.dotProduct(v1,v2));
        System.out.println(v1.angleBetween(v1,v2));

        System.out.println(v3.angleBetween(v3,v4));

        System.out.println(a.crossProduct(a,b));

        System.out.println(v4.normalize(v4));

    }


    /**
     * method that returns the field x
     * @return
     */
    public double getX()
    {
        return x;

    }

    /**
     * method that returns the field y
     * @return
     */
    public double getY(){

        return y;
    }

    /**
     * method that returns the field z
     * @return
     */
    public double getZ(){

        return z;
    }

    /**
     * method that returns a string that describes the vector
     * @return
     */
    public String toString(){

        return String.format("(%.2f, %.2f, %.2f)",x,y,z);

    }

    /**
     * method that returns the magnitude of a vector
     * @return
     */
    public double getMagnitude(){

        return Math.sqrt((Math.pow(x,2.0) + Math.pow(y,2.0) + Math.pow(z,2.0)));

    }

    /**
     * method that takes in one parameter of type Vector3D
     * method returns a normalized version of the vector
     * @param v1
     * @return
     */
    public Vector3D normalize(Vector3D v1){
        double magnitude = v1.getMagnitude();
        if(magnitude <= 0) throw new IllegalStateException("Magnitude must be non-negative");
        Vector3D normalizedVector = new Vector3D(v1.x/magnitude, v1.y/magnitude,v1.z/magnitude);
        return normalizedVector;

    }


    /**
     * method takes in two parameters of type Vector3D
     * method returns an instance of the Vector3D class where each
     * vector component is the sum of the respective components of the
     * two input vectors
     * @param v1
     * @param v2
     * @return
     */
    public Vector3D add(Vector3D v1, Vector3D v2){

        Vector3D sumVector = new Vector3D(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
        return sumVector;
    }


    /**
     * method takes in one parameter of type double which represents
     * the constant to multiply to each vector component
     * method returns an instance of the Vector3D class where the value of
     * each component is equal to the input vector's respective component times
     * the constant value
     * @param constant
     * @return
     */
    public Vector3D multiply(double constant){

        Vector3D multipliedVector = new Vector3D(x * constant, y * constant, z * constant);
        return multipliedVector;

    }

    /**
     * method takes in two parameters of type Vector3D
     * method returns the sum of multiplying the respective components of
     * each vector which is of type double
     * @param v1
     * @param v2
     * @return
     */
    public double dotProduct(Vector3D v1, Vector3D v2){
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;

    }

    /**
     * method takes in two parameters of type Vector3D
     * method returns the angle between the two vectors in degrees
     * @param v1
     * @param v2
     * @return
     */
    public double angleBetween(Vector3D v1, Vector3D v2){

        if(v1.getMagnitude() <= 0 || v2.getMagnitude() <= 0)
            throw new IllegalStateException("Magnitude must be non-negative");
        return Math.toDegrees(Math.acos(dotProduct(v1,v2) / (v1.getMagnitude() * v2.getMagnitude())));
    }

    /**
     * method takes in two parameters of type Vector3D
     * method returns an instance of the Vector3D class which represents
     * a vector that is at a right angle to both input vectors
     * @param v1
     * @param v2
     * @return
     */
    public Vector3D crossProduct(Vector3D v1, Vector3D v2){
        Vector3D crossProductVector = new Vector3D
                (v1.y * v2.z - v1.z * v2.y,
                        v1.z * v2.x - v1.x * v2.z,
                        v1.x * v2.y - v1.y * v2.x);

        return crossProductVector;


    }





}
