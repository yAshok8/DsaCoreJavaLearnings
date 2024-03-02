package LnTRiyadhAssignment;

public class VendingMachine {
    public void serveDrink(Drink drink) {
        System.out.println(drink.serve());
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.serveDrink(new Coke());
        vendingMachine.serveDrink(new Sprite());
        vendingMachine.serveDrink(new Fanta());
    }
}

interface Drink {
    String serve();
}


class Coke implements Drink {
    public String serve() {
        return "Serving Coke";
    }
}

class Fanta implements Drink {
    public String serve() {
        return "Serving Fanta";
    }
}

class Sprite implements Drink {
    public String serve() {
        return "Serving Sprite";
    }
}
