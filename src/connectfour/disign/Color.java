package connectfour.disign;

enum Color {

    A, R, NULL;

    void write() {
        String color = this.name();
        if (this.isNull()) {
            color = " ";
        }
        System.out.print(color);
        //Console.getInstance().write(color);
    }

    private boolean isNull() {
        return this.name().equals(Color.NULL);
    }

    static Color getColor(int colorIndex){
        assert colorIndex >= 0 && colorIndex < Color.NULL.ordinal();
        return Color.values()[colorIndex];
    }


}
