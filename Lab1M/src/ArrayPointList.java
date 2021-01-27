import java.awt.Point;
import java.util.Arrays;

public class ArrayPointList implements PointList {
		
	private Point[] points;
	private int size;
	private int cursor;
	
	public ArrayPointList() {
		this(MAX_SIZE);
	}

	public ArrayPointList(int maxSize) {
		points = new Point[maxSize];
		this.cursor = -1;
		this.size = 0;
	}
	
	@Override
	public void append(Point newPoint) {
        points[this.size] = newPoint;
        this.size++;
        this.cursor++;
	}
	
	

	@Override
	public void clear() {
		
		points = new Point[points.length];
		this.cursor = -1;
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean isFull() {
		return size == points.length;
	}

	@Override
	public boolean goToBeginning() {
		
		if (!isEmpty()) {
			this.cursor = 0;
			return true;
		}
		return false;
	}

	@Override
	public boolean goToEnd() {
		if (!isEmpty()) {
			this.cursor = size-1;
			return true;
		}
		return false;
	}
	

	@Override
	public boolean goToNext() {
		
		if (isEmpty() || this.cursor == size-1) return false;
		return ++this.cursor > 0;
	}

	@Override
	public boolean goToPrior() {
		
		if (isEmpty() || this.cursor == 0) return false;
		return -this.cursor > 0;
		
	}

	@Override
	public Point getCursor() {
		
		if (isEmpty()) return null;
		return new Point(points[this.cursor]);
	}

	@Override
	public String toString() {
		if (isEmpty()) return "Empty list";
		StringBuilder str = new StringBuilder();
		for (Point p : points)
			str.append(p.toString());
		
		return str.toString();
	}
}
