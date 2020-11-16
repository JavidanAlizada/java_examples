package alizada.stream.dao;

import alizada.stream.model.Sale;
import alizada.stream.utility.Csv2BeanMapper;
import alizada.stream.utility.Gender;
import alizada.stream.utility.Item;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SaleRepository extends Repository<Sale> {

    String[] getCsvCols();

    String[] getBeanFields();

    Map<String, String> getBranchAndCity();

    Map<String, String> getGenderWithPercentage();

    Long getTotalBetweenDates(LocalDate startDate, LocalDate endDate);

    String getMostUsedProductLine();

    String getMostUsedProductLineByGender(Gender gender);

    Sale[] getMostExpensiveSalesInNNumbers(int n);

    Map<String, Number> getTotalNumberOfBranch();

    Map<String, Number> getTotalNumberOfCity();

    Map<String, Number> getTotalNumberOfCustomerType();

    Map<String, Number> getTotalNumberOfProductLine();

    Map<String, Number> getMostExpensiveSale();

    Map<String, Number> getMostCheapestSale();

    Map<String, Item> getTotalNumberOfPaymentTypeByCity();

    Map<String, Number> getProductLineAverageByCity();

    Sale[] getSalesOrderByRating();

    @Override
    Sale getObject(String invoiceId);

    @Override
    Sale create(Sale sale);

    @Override
    default List<Sale> getList() {
        final Csv2BeanMapper<Sale> csv2BeanMapper = new Csv2BeanMapper<>();
        return csv2BeanMapper.mapCsvToBeans(getCsvCols(), getBeanFields(), Sale.class);
    }
}
