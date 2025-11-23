public class Rotor {

    private String rotorValues; 
    private char startChar;     

    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.startChar = c;

        // rotate until the top equals startChar
        while (this.rotorValues.charAt(0) != this.startChar) {
            this.rotate();
        }
    }

    public boolean rotate() {

        // get the last character
        char last = this.rotorValues.charAt(this.rotorValues.length() - 1);

        // new string, includes the last character and everything else except the last
        this.rotorValues = last + this.rotorValues.substring(0, this.rotorValues.length() - 1);

        // return true if back to starting top character
        return this.rotorValues.charAt(0) == this.startChar; 

    }


    // find the index of the character
    public int indexOf(char c) {
        for (int i = 0; i < this.rotorValues.length(); i++) {
            if (this.rotorValues.charAt(i) == c){
                return i;
            }
        }

        // should not happen if the input is valid
        return -1; 
    }


    // Character at index
    public char charAt(int idx) {
        return this.rotorValues.charAt(idx);
    }
}
