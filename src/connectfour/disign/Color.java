package connectfour.disign;

enum Color {

    A, R, NULL;

    void write() {
        String color = this.name();
        if (this.isNull()) {
            color = " ";
        }
        System.out.println(color);
        //Console.getInstance().write(color);
    }

    private boolean isNull() {
        return this.name().equals(Color.NULL);
    }


}
