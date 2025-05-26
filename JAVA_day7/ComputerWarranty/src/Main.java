public class Main {
    public static void main(String[] args) {
        Computer gamingPC = new Computer("Gaming-Xtreme", 1500.0);
        Computer.Warranty warranty = gamingPC.new Warranty(3);

        warranty.printWarrantyInfo();

        //정적 내부 클래스 > Computer 객체 없어도 바로 생성 가능
        Computer.Utils pcUtils = new Computer.Utils();

        //또한 객체 자체를 생성하지 않아도 사용 가능
        boolean isExpensive = Computer.Utils.isExpensive(gamingPC);
        System.out.println("이 컴퓨터는 비싼가요? : " + isExpensive);

        Computer budget = Computer.Utils.createBudgetModel("Cheap-Gaming-PC", 500.0);
        System.out.println("저가 모델 : " + budget.getModel());
        System.out.println("가격 : " + budget.getPrice());
    }
}
