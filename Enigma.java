public class Enigma {

    private String rotorInit[] = {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    private Rotor rotors[];

    public Enigma(int id1, int id2, int id3, String start) {
        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1 - 1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2 - 1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3 - 1], start.charAt(2));
    }

    public String decrypt(String message) {
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            //find c on the outer rotor
            int idx = rotors[2].indexOf(c);

            //map to the middle rotor using the same index
            char map = rotors[1].charAt(idx);

            //find the mapped char on the outer rotor
            idx = rotors[2].indexOf(map);

            //map to the inner rotor and then append
            map = rotors[0].charAt(idx);

            //add it to the result string
            result = result + map;

            // rotate it 
            rotate();
        }

        return result;
    }

    public String encrypt(String message) {
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            //find c on the inner rotor
            int idx = rotors[0].indexOf(c);

            // map to the outer rotor using the same idnex
            char map = rotors[2].charAt(idx);

            //find the mapped char on the middle rotor
            idx = rotors[1].indexOf(map);

            //map that index to outer rotor again
            map = rotors[2].charAt(idx);

            //add it to the result string
            result = result + map;

            //rotate it 
            rotate();
        }

        return result;
    }

    private void rotate() {
        if (rotors[0].rotate()) {
            if (rotors[1].rotate()) {
                rotors[2].rotate();
            }
        }
    }
}
