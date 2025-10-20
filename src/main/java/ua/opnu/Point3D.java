import ua.opnu.java.inheritance.point.Point;

public class Point3D extends Point {
    private int z;

    public Point3D() {
        super();
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    public int getZ() {
        return z;
    }

    public double distance(Point3D p) {
        long dx = (long) getX() - p.getX();
        long dy = (long) getY() - p.getY();
        long dz = (long) z - p.z;
        double d = Math.sqrt(dx * dx + dy * dy + dz * dz);
        return Math.round(d * 1e13) / 1e13;
    }

    @Override
    public double distanceFromOrigin() {
        long dx = (long) getX();
        long dy = (long) getY();
        long dz = (long) z;
        double d = Math.sqrt(dx * dx + dy * dy + dz * dz);
        return Math.round(d * 1e13) / 1e13;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}
