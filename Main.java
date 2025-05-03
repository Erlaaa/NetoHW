import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int income = 0;
        int expenses = 0;

        while (true) {
            String input;

            System.out.println("Выберите операцию и введите её номер: ");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            
            input = scanner.nextLine();
            if("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch(operation) {
                case 1:
                    System.out.println("Введите сумму дохода: ");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    income += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода: ");
                    String spendingStr = scanner.nextLine();
                    int spending = Integer.parseInt(spendingStr);
                    expenses += spending;
                    break;
                case 3:
                    int tax = taxIncomeMinusExpenses(income, expenses);
                    int taxInc = taxIncome(income);
                    Difference(tax, taxInc);
                    System.out.println("Ваш налог составит: " + taxIncome(income) + " рублей");
                    System.out.println("Налог на другой системе: " + taxIncomeMinusExpenses(income, expenses) + " рублей");
                    System.out.println("Экономия: " + Economy(tax, taxInc) + " рублей");
                    break;
            }

        }
    }
    public static int taxIncomeMinusExpenses(int income, int expenses) {
        int tax = (income - expenses) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxIncome(int income) {
        int taxInc = (income * 6) / 100;
        return taxInc;
    }

    public static void Difference(int tax, int taxInc) {
        if (tax > taxInc) {
            System.out.println("Мы советуем вам УСН доходы минус расходы");
        } else if (tax < taxInc) {
            System.out.println("Мы советуем вам УСН доходы");
        } else {
            System.out.println("Можете выбрать любую систему налогообложения");

        }
    }

    public static int Economy(int tax, int taxInc) {
        int economy = Math.abs(tax - taxInc);
        return economy;
    }
}
