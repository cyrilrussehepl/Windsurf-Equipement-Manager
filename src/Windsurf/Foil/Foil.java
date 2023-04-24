package Windsurf.Foil;

import Windsurf.Equipement;

import java.util.ArrayList;

public class Foil extends Equipement {
   //Variables----------------------------------------------------------------------------------------------------------
   private String model;
   private FoilMast foilMast;
   private ArrayList<Fuselage> fuselages = new ArrayList<Fuselage>();
   private ArrayList<Wing> wings = new ArrayList<Wing>();

   //Constructors-------------------------------------------------------------------------------------------------------
   public Foil(String model, FoilMast foilMast) {
      super();
      this.model = model;
      this.foilMast = foilMast;
   }

   public Foil(String model){
      this(model, null);
   }

   //Getters and Setters------------------------------------------------------------------------------------------------
   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public FoilMast getFoilMast() {
      return foilMast;
   }

   public void setFoilMast(FoilMast foilMast) {
      this.foilMast = foilMast;
   }

   public void addWing(Wing wing){
      wings.add(wing);
   }

   public void removeWing(int index){
      wings.remove(index);
   }

   public void addFuselage(Fuselage fuselage){
      fuselages.add(fuselage);
   }

   public void removeFuselage(int index){
      fuselages.remove(index);
   }

   public enum MaterialType{
      CARBON,
      ALUMINIUM
   }

   //Methods------------------------------------------------------------------------------------------------------------
   @Override
   public String toString() {
      return "Ceci est un foil";
   }
}
