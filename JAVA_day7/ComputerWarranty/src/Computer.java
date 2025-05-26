public class Computer {
    private String model;
    private double price;

    public Computer(String model, double price){
        this.model = model;
        this.price = price;
    }

    public class Warranty{
        private int years;

        public Warranty(int years){
            this.years = years>0? years : 0;
        }

        public void printWarrantyInfo(){
            System.out.println("모델 : " + model);
            System.out.println("가격 : " + price);
            System.out.println("보증 기간 : " + years);
        }
    }

    public static class Utils{
        public static boolean isExpensive(Computer c){
            return c.price > 1000.0;
        }

        public static Computer createBudgetModel(String model, double price){
            return new Computer(model, price);
        }
    }

    public String getModel() {return model;}
    public double getPrice() {return price;}
}
