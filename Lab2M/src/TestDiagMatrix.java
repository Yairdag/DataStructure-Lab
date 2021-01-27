import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestDiagMatrix {

	public static void main(String[] args) throws IOException {
		Matrix mat = new DiagonalMatrix(4);
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer token = new StreamTokenizer(reader);
		
		System.out.print("Enter the tasks ( end with quit)  : ");
		
		while( token.nextToken() == StreamTokenizer.TT_WORD ) {
						
			
			switch ( token.sval.toLowerCase() ) { 
			
			
				case "put" : {
					token.nextToken();
					int i = (int)token.nval;
					token.nextToken();
					int j = (int)token.nval;
					token.nextToken();
					int x = (int)token.nval;
					mat.put(i,j,x);
					break;
					
				}
				
				case "get" : {
					token.nextToken();
					int i = (int)token.nval;
					token.nextToken();
					int j = (int)token.nval;
					System.out.println(mat.get(i, j));
					break;
				}	
				
				case "printm" : {
					System.out.println(mat);
					break;
				}		
			
				case "multcons" : {
					token.nextToken();
					int c = (int)token.nval;
					mat.multByConstant(c);
					break;
				}			
				case "transm" : {
					mat.transpose();
					break;
				}
				case "quit" : {
					return;
				}
				
				default : {
					System.out.println("invalid input");
					break;
				}
			}

		
		
		}

	}
	
}