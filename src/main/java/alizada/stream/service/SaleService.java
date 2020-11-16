package alizada.stream.service;

import alizada.stream.dao.SaleRepository;
import alizada.stream.model.Sale;
import alizada.stream.utility.Gender;
import alizada.stream.utility.Item;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SaleService implements SaleRepository {

    private final List<Sale> sales = getList();

    @Override
    public String[] getCsvCols() {
        return new String[]{"Invoice ID", "Branch", "City", "Customer type", "Gender",
                "Product line", "Unit price", "Quantity", "Tax 5 %", "Total", "Date", "Time", "Payment",
                "cogs", "gross margin percentage", "gross income", "Rating"};
    }

    @Override
    public String[] getBeanFields() {
        return new String[]{
                "invoiceId", "branch", "customerType", "gender", "productLine", "unitPrice", "quantity",
                "taxFivePercentage", "total", "date", "time", "payment", "cogs", "grossMarginPercentage",
                "grossIncome", "rate"
        };
    }

    @Override
    public Map<String, String> getBranchAndCity() {
        Map<String, String> branchCity = new HashMap<>();
        return null;
    }

    @Override
    public Map<String, String> getGenderWithPercentage() {
        return null;
    }

    @Override
    public Long getTotalBetweenDates(LocalDate startDate, LocalDate endDate) {

        return null;
    }

    @Override
    public String getMostUsedProductLine() {
        return null;
    }

    @Override
    public String getMostUsedProductLineByGender(Gender gender) {
        return null;
    }

    @Override
    public Sale[] getMostExpensiveSalesInNNumbers(int n) {
        return null;
    }

    @Override
    public Map<String, Number> getTotalNumberOfBranch() {
        return null;
    }

    @Override
    public Map<String, Number> getTotalNumberOfCity() {
        return null;
    }

    @Override
    public Map<String, Number> getTotalNumberOfCustomerType() {
        return null;
    }

    @Override
    public Map<String, Number> getTotalNumberOfProductLine() {
        return null;
    }

    @Override
    public Map<String, Number> getMostExpensiveSale() {
        return null;
    }

    @Override
    public Map<String, Number> getMostCheapestSale() {
        return null;
    }

    @Override
    public Map<String, Item> getTotalNumberOfPaymentTypeByCity() {

        return null;
    }

    @Override
    public Map<String, Number> getProductLineAverageByCity() {
        return null;
    }

    @Override
    public Sale[] getSalesOrderByRating() {
        return sales.stream()
                .sorted(Comparator.comparingDouble(Sale::getRate).reversed())
                .toArray(Sale[]::new);
    }

    @Override
    public Sale getObject(String invoiceId) {
        return sales.stream()
                .filter(obj -> obj.getInvoiceId().equals(invoiceId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Sale create(Sale sale) {
        Sale saleCreated = new Sale();
        saleCreated.setInvoiceId(sale.getInvoiceId());
        saleCreated.setBranch(sale.getBranch());
        saleCreated.setCity(sale.getCity());
        saleCreated.setCogs(sale.getCogs());
        saleCreated.setCustomerType(sale.getCustomerType());
        saleCreated.setDate(sale.getDate());
        saleCreated.setGender(sale.getGender());
        saleCreated.setGrossIncome(sale.getGrossIncome());
        saleCreated.setGrossMarginPercentage(sale.getGrossMarginPercentage());
        saleCreated.setQuantity(sale.getQuantity());
        saleCreated.setRate(sale.getRate());
        saleCreated.setTaxFivePercentage(sale.getTaxFivePercentage());
        saleCreated.setTotal(sale.getTotal());
        saleCreated.setTime(sale.getTime());
        saleCreated.setUnitPrice(sale.getUnitPrice());
        saleCreated.setProductLine(sale.getProductLine());
        saleCreated.setPayment(sale.getPayment());
        return saleCreated;
    }
}
