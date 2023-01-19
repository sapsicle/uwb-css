/**
 * Driver for CSS 162 Lab
 *
 * uncomment sections to test Square, Circle, and Picture
 *
 * @author Rob Nash
 */


public class ShapesPictureDriver {


	//precondition: assumes {Square, Circle, Picture} all exist in the same working directory
	//postcondition: 2 Squares, 2 Circles, and 1 Picture are constructed and manipulated, then reclaimed once main exits
	public static void main(String[] args) {
		/* Uncomment for Square Tests
		Square firstSquare = new Square();
		Square secondSquare = new Square(10,20);

		firstSquare.setX(3);
		firstSquare.setY(4);

		System.out.println( "Drawing the first square : " + firstSquare.toString());

		firstSquare.draw();

		secondSquare.setWidth(30);
		secondSquare.setHeight(30);

		System.out.println( "Drawing the next square with area : " + secondSquare.getArea());

		secondSquare.draw();

		*/



		/* Uncomment for Circle Tests
		//now for some circles
		Circle firstCircle = new Circle();
		Circle secondCircle = new Circle(5,5);

		firstCircle.setX(1);
		firstCircle.setY(5);
		firstCircle.setRadius(3);

		System.out.println( "Drawing the first circle : " + firstCircle.toString());

		firstCircle.draw();

		secondCircle.setX(2);
		secondCircle.setY(10);
		secondCircle.setRadius(6);

		System.out.println( "Drawing the second circle with area " + secondCircle.getArea());

		secondCircle.draw();
		*/

		/* Uncomment for Picture Tests
		//now, lets see the bigger picture
		ObjectList picture = new ObjectList();

		picture.addSquare( firstSquare );
		picture.addSquare( secondSquare );
		picture.addCircle( firstCircle );
		picture.addCircle( secondCircle );

		System.out.println( "Drawing a Picture using ObjectList with Circles and Squares:\n" );

		System.out.println(picture.toString());
		*/

	}

}
