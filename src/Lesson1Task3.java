public class Lesson1Task3 {
    public static void main(String[] args) {
        System.out.println(closestToZeroNegative(-5, -2, 0));
        System.out.println(closestToZeroNegative(2, 3, 4));
    }

    // TODO: Luua funktsioon, mis tagastab vastava arvu alati negatiivsena
    // Näited:
    // neg(0) = 0
    // neg(-1) = -1
    // neg(8) = -8
    public static int neg(int x){
        if(x <= 0){
            return x;
        } else {
            return -1 * x;
        }
    }

    // TODO: Luua funktsioon mis leiab sisend muutujates negatiivse numbri mis on kõige lähemal 0-ile
    // TODO: Kui ühtegi negatiivset arvu ei ole siis tagasta lihtsalt kõige väiksem number
    // Näited
    // (-5, -2, 0) -> -2
    // (2, 3, 4) -> 2
    public static int closestToZeroNegative(int a, int b, int c){
        if(a < 0 || b < 0 || c < 0){
            return negMin(negMin(a, b), c);
        } else {
            return min(min(a, b), c);
        }
    }

    private static int negMin(int a, int b) {
        if(a < 0 && b < 0) {
            if(a>b){
                return a;
            } else {
                return b;
            }
        } else if(a < 0){
            return a;
        } else {
            return b;
        }
    }

    private static int min(int a, int b) {
        if(a < b){
            return a;
        } else {
            return b;
        }
    }

}
