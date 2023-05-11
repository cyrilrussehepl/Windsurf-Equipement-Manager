package Windsurf;

public class Sail extends Equipment {
    //Variables---------------------------------------------------------------------------------------------------------
    private float area;
    private int luff;
    private int boom;
    private Mast.Curve mastCurve;
    private String model;
    private int nCamber;

    //Constructors------------------------------------------------------------------------------------------------------
    public Sail(float area, int luff, int boom, Mast.Curve mastCurve, String model, int nCamber) {
        super();
        this.area = area;
        this.luff = luff;
        this.boom = boom;
        this.mastCurve = mastCurve;
        this.model = model;
        this.nCamber = nCamber;
    }

    public Sail(float area, int luff, int boom, String model){
        this(area, luff, boom, Mast.Curve.CONST_CURVE, model, 0);
    }

    public Sail(int year, String brand, Category category, Discipline discipline){
        super(year, brand, category, discipline);
    }

    //Getters and Setters-----------------------------------------------------------------------------------------------
    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getLuff() {
        return luff;
    }

    public void setLuff(int luff) {
        this.luff = luff;
    }

    public int getBoom() {
        return boom;
    }

    public void setBoom(int boom) {
        this.boom = boom;
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