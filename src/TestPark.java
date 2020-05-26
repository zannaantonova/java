public class TestPark {
    public void main(String[] args) {
        Pair a = new Pair(1, 2);
        System.out.println(a.getA());
        System.out.println(a.getB());

        Node node = new Node(this);
    }

    private static class Node {

        private TestPark testPark;
        public Node(TestPark testPark) {
            this.testPark = testPark;
        }
    }
}
