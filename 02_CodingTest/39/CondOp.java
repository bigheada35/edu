import java.io.Serializable;

/*
아래의 인터페이스에 맞추어(상속하여) 
아래를 프로그래밍 하시오.

Circle, Rectangle , Triangle


interface AreaGetable{
double getArea();
}
*/
//다형성 + 함수오버라이딩(
interface AreaGetable {
	double getArea();

}

class Circle implements AreaGetable {
	private double r;

	public Circle(double r) {
		this.r = r;
	}

	@Override
	public double getArea() {

		return r * r * Math.PI;
	}
}

class Rectangle implements AreaGetable {

	private double width, height;

	public Rectangle(double width, double height) {
		this.height = height;
		this.width = width;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * height;
	}
}


class CondOp {
	/*
	 * public static double getAllArea(AreaGetable[] area) {
	 * 
	 * double sum =0;
	 * 
	 * for (AreaGetable areaGetable : area) { sum = sum + areaGetable.getArea(); }
	 * 
	 * return sum;
	 * 
	 * }
	 */
	
	public static double getAllArea(AreaGetable[] area) {
		double sum =0;
		
		for (AreaGetable areaGetable  : area) {
			sum = sum + areaGetable.getArea();
		}
		
		for(int i=0; i< area.length; i++) {
			sum = sum + area[i].getArea();
		}			
		return sum;		
	}

	public static void main(String[] args) {

		AreaGetable[] area = { new Rectangle(4, 5), new Circle(4), new Circle(4), new Circle(5), new Circle(5),
				new Circle(6) ,new Rectangle(4, 5),new Rectangle(4, 5),new Rectangle(4, 5),};

		// AreaGetable oneArea = new Circle(4);
		System.out.println(getAllArea(area));
		System.out.println(getArea(new Circle(10))); //314
		System.out.println(getArea(new Rectangle(4, 5))); //20
	// oneArea = new Rectangle(4,5);
		// System.out.println(area.getArea());

	}

	private static double getArea( AreaGetable area ) {		
		return area.getArea();
	}
	

}