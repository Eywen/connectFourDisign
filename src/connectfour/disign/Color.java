package connectfour.disign;

enum Color {

    A, R, NULL;

    private Coordinate lastCoordinateColor;
    void write() {
        String color = this.name();
        if (this.isNull()) {
            color = " ";
        }
        System.out.print(color);
        //Console.getInstance().write(color);
    }

    public boolean isNull() {
        return this.name().equals(Color.NULL);
    }

    static Color getColor(int colorIndex){
        assert colorIndex >= 0 && colorIndex < Color.NULL.ordinal();
        return Color.values()[colorIndex];
    }


    public void setCoordinate(Coordinate coordinate) {
        this.lastCoordinateColor = coordinate;
    }

    public Coordinate getlastCoordinate(){
        return this.lastCoordinateColor;
    }
}
