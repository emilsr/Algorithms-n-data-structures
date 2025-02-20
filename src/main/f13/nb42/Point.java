package main.f13.nb42;

class Point {
    float x, y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float distanceTo(Point other) {
        float dx = this.x - other.x;
        float dy = this.y - other.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}