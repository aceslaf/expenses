public class Sphere {

	Vector3D center;
	float radius;

	public Sphere(Vector3D center, float radius) {
		super();
		this.center = center;
		this.radius = radius;
	}

	public Vector3D getCenter() {
		return center;
	}

	public void setCenter(Vector3D center) {
		this.center = center;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
	
	public boolean isInsideSphere(Vector3D point)
	{
		return Vector3D.SQRDistance(point, center)<(radius*radius);
	}

}
