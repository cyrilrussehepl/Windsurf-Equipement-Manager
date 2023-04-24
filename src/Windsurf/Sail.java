package Windsurf;

public class Sail extends Equipement {
    //Variables---------------------------------------------------------------------------------------------------------
    private float area;
    private int mastSize;
    private int wishSize;
    private Mast.Curve mastCurve;
    private String model;
    private int nCamber;

    //Constructors------------------------------------------------------------------------------------------------------
    public Sail(float area, int mastSize, int wishSize, Mast.Curve mastCurve, String model, int nCamber) {
        super();
        this.area = area;
        this.mastSize = mastSize;
        this.wishSize = wishSize;
        this.mastCurve = mastCurve;
        this.model = model;
        this.nCamber = nCamber;
    }

    public Sail(float area, int mastSize, int wishSize, String model){
        this(area, mastSize, wishSize, Mast.Curve.CONST_CURVE, model, 0);
    }

    //Getters and Setters-----------------------------------------------------------------------------------------------
    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getMastSize() {
        return mastSize;
    }

    public void setMastSize(int mastSize) {
        this.mastSize = mastSize;
    }

    public int getWishSize() {
        return wishSize;
    }

    public void setWishSize(int wishSize) {
        this.wishSize = wishSize;
    }

    public Mast.Curve getMastCurve() {
        return mastCurve;
    }

    public void setMastCurve(Mast.Curve mastCurve) {
        this.mastCurve = mastCurve;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getnCamber() {
        return nCamber;
    }

    public void setnCamber(int nCamber) {
        this.nCamber = nCamber;
    }


    //Methods-----------------------------------------------------------------------------------------------------------
}