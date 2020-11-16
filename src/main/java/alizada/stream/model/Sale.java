package alizada.stream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    private String invoiceId;
    private String branch;
    private String city;
    private String customerType;
    private String gender;
    private String productLine;
    private String unitPrice;
    private String quantity;
    private String taxFivePercentage;
    private String total;
    private String date;
    private String time;
    private String payment;
    private String cogs;
    private String grossMarginPercentage;
    private String grossIncome;
    private Double rate;

}
