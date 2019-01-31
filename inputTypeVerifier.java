
package us.mattgreen;

public class inputTypeVerifier extends Exception {

    public inputTypeVerifier() {
        super("Please enter cat, dog, or student.");
    }
    
    public inputTypeVerifier(int i) {
        super(i + " is not a letter");
    }
    
    public inputTypeVerifier(double d) {
        super(d + " is not a letter");
    }    
    
    public inputTypeVerifier(String s) {
        super(s + " is not a number");
    }
}
