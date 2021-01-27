import java.awt.Point;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestPointListTok {

	public static void main(String args[]) throws IOException {

		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer token = new StreamTokenizer(reader);
		PointList list = new ArrayPointList();

		System.out.print("Enter the tasks ( end with quit)  : ");

		while (token.nextToken() == StreamTokenizer.TT_WORD) {

			switch (token.sval.toLowerCase()) {

			case "add": {

				token.nextToken();
				int x = (int) token.nval;
				token.nextToken();
				int y = (int) token.nval;
				list.append(new Point(x, y));
				break;

			}

			case "curr": {

				System.out.println(list.getCursor());
				break;
			}

			case "next": {

				System.out.println(list.goToNext());
				break;
			}

			case "prev": {
				System.out.println(list.goToNext());
				break;
			}

			case "start": {
				System.out.println(list.goToBeginning());
				break;
			}

			case "end": {
				System.out.println(list.goToEnd());
				break;
			}

			case "empty": {
				System.out.println(list.isEmpty());
				break;
			}

			case "full": {
				System.out.println(list.isFull());
				break;
			}

			case "clear": {
				list.clear();
				break;
			}

			case "quit": {
				return;
			}

			default: {
				System.out.println("invalid input");
				break;
			}
			}

		}

	}

}
