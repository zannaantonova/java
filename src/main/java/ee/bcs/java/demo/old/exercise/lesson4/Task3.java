package ee.bcs.java.demo.old.exercise.lesson4;

public class Task3 {
    // TODO
    // Mõtleme matemaatiliselt sellise jada peale, kus jada järgmine element on
    // a) kui arv on paaris arv, siis jagame 2
    // b) kui arv on paaritu siis korrutame 3 ja liidame 1
    // Vaja on luua funktsioon mis arvutaks sellise jada pikkuse
    // Näide: 12, 6, 3, 10, 5, 16, 8, 4, 2, 1. - pikkus: 10
    public static void main(String[] args) {
        System.out.println(sequence(4));
        System.out.println(sequenceLength(5));
    }

    // TODO 1
    // Defineeri funktsioon mis tagastab:
    // a) kui i on paaris arv return i/2;
    // b) kui i ei ole paaris arv return i*3+1;
    public static int sequence(int i){
        // WRITE CODE HERE
        if(i % 2 == 0){
            // on paaris arv
        }
        return 0;
    }

    // TODO 2
    // Defineeri funktsioon mis arvutab jada pikkuse
    public static int sequenceLength(int i){
        // WRITE CODE HERE
        return 1;
    }
}
