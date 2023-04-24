package Windsurf;

public class Mast extends Equipement {
    //Variables---------------------------------------------------------------------------------------------------------
    public enum Curve {
        HARD_TOP,
        CONST_CURVE,
        FLEX_TOP
    }
    public enum DiameterMast{
        RDM,
        SDM
    }
    private int length;
    private int carbonPercent;
    private Curve curve;
    private DiameterMast diameterMast;

    //Constructors------------------------------------------------------------------------------------------------------
    public Mast(int length, int carbonPercent, Curve curve, DiameterMast diameterMast) {
        super();
        this.length = length;
        this.carbonPercent = carbonPercent;
        this.curve = curve;
        this.diameterMast = diameterMast;
    }

    public Mast(int length, int carbonPercent){
        this(length, carbonPercent, Curve.CONST_CURVE, DiameterMast.SDM);
    }

    public Mast(int length){
        this(length, 0);
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