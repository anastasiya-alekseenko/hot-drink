class HotDrink {
    private String name;
    private int volume;
    private int temperature;

    public HotDrink(String name, int volume, int temperature) {
        this.name = name;
        this.volume = volume;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "HotDrink{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", temperature=" + temperature +
                '}';
    }
}

interface VendingMachine {
    HotDrink getProduct(String name, int volume, int temperature);
}

class HotDrinkVendingMachine implements VendingMachine {
    private List<HotDrink> hotDrinks = new ArrayList<>();

    public void addHotDrink(HotDrink hotDrink) {
        hotDrinks.add(hotDrink);
    }

    @Override
    public HotDrink getProduct(String name, int volume, int temperature) {
        for (HotDrink hotDrink : hotDrinks) {
            if (hotDrink.getName().equalsIgnoreCase(name) &&
                hotDrink.getVolume() == volume &&
                hotDrink.getTemperature() == temperature) {
                return hotDrink;
            }
        }
        return null; // или можно выбросить исключение, если продукт не найден
    }
}

public class Main {
    public static void main(String[] args) {
        HotDrink tea = new HotDrink("Tea", 250, 80);
        HotDrink coffee = new HotDrink("Coffee", 200, 85);
        HotDrink hotChocolate = new HotDrink("Hot Chocolate", 300, 90);

        HotDrinkVendingMachine vendingMachine = new HotDrinkVendingMachine();
        vendingMachine.addHotDrink(tea);
        vendingMachine.addHotDrink(coffee);
        vendingMachine.addHotDrink(hotChocolate);

        HotDrink requestedDrink = vendingMachine.getProduct("Tea", 250, 80);
        System.out.println(requestedDrink);

        requestedDrink = vendingMachine.getProduct("Coffee", 200, 85);
        System.out.println(requestedDrink);

        requestedDrink = vendingMachine.getProduct("Hot Chocolate", 300, 90);
        System.out.println(requestedDrink);
    }
}
