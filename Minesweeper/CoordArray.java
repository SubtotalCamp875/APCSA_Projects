class CoordArray {
    private static int x = 0;
    private static int y = 0;
    private static Boolean flag = false;

    public CoordArray() {}

    public static void setX(int n) {
        x = n;
    }

    public static void setY(int n) {
        y = n;
    }

    public static void setFlag(Boolean f) {
        flag = f;
    }

    public static void changeFlag() {
        flag = !flag;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static Boolean getFlag() {
        return flag;
    }
}