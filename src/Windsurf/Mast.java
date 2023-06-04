package Windsurf;

public class Mast extends Equipment {
    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    //Variables---------------------------------------------------------------------------------------------------------
    public enum Curve {
        CONST_CURVE,
        HARD_TOP,
        FLEX_TOP
    }
    public enum Geometry {
        SDM,
        RDM,
    }
    private int length;
    private int carbonPercent;
    private Curve curve;
    private Geometry geometry;

    //Constructors------------------------------------------------------------------------------------------------------
    public Mast(int length, int carbonPercent, Curve curve, Geometry geometry) {
        super();
        this.length = length;
        this.carbonPercent = carbonPercent;
        this.curve = curve;
        this.geometry = geometry;
    }

    public Mast(int length, int carbonPercent){
        this(length, carbonPercent, Curve.CONST_CURVE, Geometry.SDM);
    }

    public Mast(int length){
        this(length, 0);
    }

    public Mast(int year, String brand){
        super(year, brand, Category.BOTH);
    }

    //Getters and Setters-----------------------------------------------------------------------------------------------
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCarbonPercent() {
        return carbonPercent;
    }

    public void setCarbonPercent(int carbonPercent) {
        this.carbonPercent = carbonPercent;
    }

    public Curve getCurve() {
        return curve;
    }

    public void setCurve(Curve curve) {
        this.curve = curve;
    }
}