package HM12;

public class Toyota extends JapaneseCar {
    private String ExteriorColor;
    private String InteriorColor;

    public Toyota(String brand, String model, boolean isJapaneseCar, String exteriorColor, String interiorColor) {
        super(brand, model, isJapaneseCar);
        ExteriorColor = exteriorColor;
        InteriorColor = interiorColor;
    }

    public void printToyota() {
        System.out.println("Toyota:" +
                super.info() +
                "\nExterior Color = " + ExteriorColor +
                "\nInterior Color = " + InteriorColor);
        if (this.isJapaneseCar()) {
            System.out.println("This is real Japanese car!!!!!");
        } else {
            System.out.println("Not Japanese car");
        }
    }
}