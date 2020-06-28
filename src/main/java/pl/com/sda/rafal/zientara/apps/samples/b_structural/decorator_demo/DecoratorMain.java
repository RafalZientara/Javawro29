package pl.com.sda.rafal.zientara.apps.samples.b_structural.decorator_demo;

public class DecoratorMain {
    public static void main(String[] args) {
        System.out.println("Tworzenie zwykłych obiektów Shape...");
        Shape rectangle = new Rectangle();
        Shape circle = new Circle();
        System.out.println("Rysowanie zwykłych obiektów Shape...");
        rectangle.draw();
        System.out.println();
        circle.draw();
        System.out.println();
        System.out.println("Tworzenie udekorowanego, czerwonego koła z niebieskim obrysem w stylu dash i grubością linii 2 ...");
        Shape circle1 = new FillColorDecorator(new LineColorDecorator(new LineStyleDecorator(
                new LineThicknessDecorator(new Circle(), 2.0d), LineStyle.DASH), Color.BLUE), Color.RED);
        circle1.draw();
        System.out.println();
        // nie ma znaczenia kolejność dekorowania
        // dekorowanie może również odbywać się w osobnych poleceniach
        System.out.println("Tworzenie podobnego obiektu z osobnych poleceń");
        Circle c = new Circle();
        LineThicknessDecorator lt = new LineThicknessDecorator(c, 2.0d);
        LineStyleDecorator ls = new LineStyleDecorator(lt, LineStyle.DASH);
        LineColorDecorator lc = new LineColorDecorator(ls, Color.BLUE);
        FillColorDecorator fc = new FillColorDecorator(lc, Color.RED);
        Shape circle3 = fc;
        circle3.draw();
        System.out.println();
        System.out.println("Tworzenie udekorowanego koła kolor zielony, linie czarne...");
        Shape circle2 = new FillColorDecorator(new LineColorDecorator(new Circle(), Color.BLACK), Color.GREEN);
        circle2.draw();
        System.out.println();
        System.out.println("Tworzenie udekorowanego żółtego prostokąta w czerwone linie...");
        Shape rectangle1 = new FillColorDecorator(new LineColorDecorator(new Rectangle(), Color.RED), Color.YELLOW);
        rectangle1.draw();
        System.out.println();
    }
}
