
public class Vector3D {
private float x;
private float y;
private float z;

public Vector3D(float x, float y, float z) {
	super();
	this.x = x;
	this.y = y;
	this.z = z;
}

public static float SQRDistance(Vector3D vec1,Vector3D vec2)
{
	return Sub(vec1, vec2).getSqrMagnitude();
}

public static float Distance(Vector3D vec1,Vector3D vec2)
{
	return (float)Math.sqrt(SQRDistance(vec1, vec2));
}

public static Vector3D Sub(Vector3D from, Vector3D subtractee)
{
	return new Vector3D(from.getX()-subtractee.getX(), from.getY()-subtractee.getY(), from.getZ()-subtractee.getZ());
}

public static Vector3D Add(Vector3D from, Vector3D subtractee)
{
	return new Vector3D(from.getX()+subtractee.getX(), from.getY()+subtractee.getY(), from.getZ()+subtractee.getZ());
}
public float getMagnitude(){
	return (float)Math.sqrt(this.getSqrMagnitude());
}
public float getSqrMagnitude()
{
	return this.x*this.x+this.y*this.y+this.z*this.z;
}
public float getX() {
	return x;
}
public void setX(float x) {
	this.x = x;
}
public float getY() {
	return y;
}
public void setY(float y) {
	this.y = y;
}
public float getZ() {
	return z;
}
public void setZ(float z) {
	this.z = z;
}

}
