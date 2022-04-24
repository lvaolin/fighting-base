package com.dhy.juc.enum1;

public enum Color {
    RED("1","2","3"), YELLOW("4","5","6"), BLACK("7","8","9"){
        @Override
        public String toString() {
            return this.ordinal()+"";
        }
    };

    private String id1;
    private String id2;
    private String id3;
    private Color(String id1,String id2,String id3){
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id1='" + id1 + '\'' +
                ", id2='" + id2 + '\'' +
                ", id3='" + id3 + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Color c = Color.BLACK;

        switch (c){
            case RED:
                System.out.println(c);
                System.out.println(c.ordinal());
                System.out.println(c.toString());
                break;
            case BLACK:
                System.out.println(c);
                break;
            case YELLOW:
                System.out.println(c);
                break;
            default:
                System.out.println(c);
        }
    }
}
