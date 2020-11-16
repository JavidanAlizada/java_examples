package alizada.stream.utility;

import alizada.security.property_constant.PropertyFileName;
import alizada.security.property_constant.PropertyKeyValue;
import alizada.security.util.PropertyReader;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Csv2BeanMapper<T> {

    public <T> List<T> mapCsvToBeans(String[] arg1, String[] arg2, Class<T> type) {
        Map<String, String> mapping = new HashMap<>();
        if (arg1.length == arg2.length) {
            for (int i = 0; i < arg1.length; i++) {
                mapping.put(arg1[i], arg2[i]);
            }
        }
        HeaderColumnNameTranslateMappingStrategy<T> strategy =
                new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setType(type);
        strategy.setColumnMapping(mapping);
        CSVReader csvReader = null;
        String filePath = PropertyReader.readValueFromProperty(Csv2BeanMapper.class,
                PropertyFileName.PROPERTY_FILE_NAME, PropertyKeyValue.CSV_FILE, new Properties());
        try {
            csvReader = new CSVReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvToBean<T> csvToBean = new CsvToBean<>();
        csvToBean.setCsvReader(csvReader);
        return csvToBean.parse();
    }
}
