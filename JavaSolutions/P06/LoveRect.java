/* Write a function to find the rectangular intersection 
   of two given love rectangles. Love rectangles are always
   "straight" and never "diagonal." More rigorously: each side
   is parallel with either the x-axis or the y-axis.
 */

public class LoveRect {

    public static class Rectangle {
	
	// coordinates of bottom left corner
	Integer leftX;
	Integer bottomY;
	
	// dimensions
	Integer width;
	Integer height;
	
	public Rectangle(Integer leftX, Integer bottomY, Integer width, Integer height) {
	    this.leftX = leftX;
	    this.bottomY = bottomY;
	    this.width  = width;
	    this.height = height;
	}
	
	public Rectangle() {}
	
	public String toString() {
	    return String.format("(%d, %d, %d, %d)", leftX, bottomY, width, height);
	}
    }

    public static int[] intervalIntersect(int[] i, int[] j) {
	int beg = i[0] > j[0] ? i[0] : j[0];
	int end = i[1] < j[1] ? i[1] : j[1];
	if (beg < end) return new int[] {beg, end};
	return null;
    }

    public static Rectangle rectIntersect(Rectangle x, Rectangle y) {
	int[] xv = new int[] {x.bottomY, x.bottomY + x.height};
	int[] xh = new int[] {x.leftX, x.leftX + x.width};

	int[] yv = new int[] {y.bottomY, y.bottomY + y.height};
	int[] yh = new int[] {y.leftX, y.leftX + y.width};

	int[] iv = intervalIntersect(xv, yv);
	int[] ih = intervalIntersect(xh, yh);

	if (iv == null || ih == null) return null;

	return new Rectangle(ih[0], iv[0], ih[1] - ih[0], iv[1] - iv[0]);
    }

    public static void test(Rectangle x, Rectangle y) {
	System.out.println("Rectangle 1: " + x.toString());
	System.out.println("Rectangle 2: " + y.toString());
	Rectangle intersect = rectIntersect(x, y);
	System.out.println("Intersect:   " + (intersect != null ? intersect.toString() : "null"));
	System.out.println("______________________________________");
    }

    public static void main(String[] args) {
	Rectangle x, y;

	x = new Rectangle(0, 0, 6, 3);
	y = new Rectangle(4, -4, 4, 6);
	test(x, y);

        x = new Rectangle(0, 3, 5, 5);
	y = new Rectangle(3, 0, 1, 9);
	test(x, y);

	x = new Rectangle(0, 0, 8, 4);
	y = new Rectangle(4, 1, 3, 2);
	test(x, y);

	x = new Rectangle(0, 1, 5, 3);
	y = new Rectangle(5, 0, 2, 5);
	test(x, y);

	x = new Rectangle(0, 8, 8, 6);
	y = new Rectangle(4, 0, 8, 6);
	test(x, y);

    }

}
