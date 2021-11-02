package za.com.ayo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.com.ayo.pattern.ConversionFactoryPattern;
import za.com.ayo.enums.ConversionType;
import za.com.ayo.enums.MeasuringSystemType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ConvertorServiceImpl {

    private final ConversionFactoryPattern conversionFactoryPattern;

    public ConvertorServiceImpl(final ConversionFactoryPattern conversionFactoryPattern) {
        this.conversionFactoryPattern = conversionFactoryPattern;
    }
    public ResponseEntity<String> convert(final String measurementcategory, final String measuringsystem, final Double inputValue)
            throws IllegalArgumentException {
        Double convertedValue;
        HttpStatus status;

        if (inputValue != null && measurementcategory != null && measuringsystem != null) {

            try {
                ConvertorService convertorService = this.getConvertor(measurementcategory);

                switch (this.getSystemToConvertInto(measuringsystem)) {
                    case METRIC:
                        convertedValue = convertorService.convToMetric(inputValue);
                        break;
                    case IMPERIAL:
                        convertedValue = convertorService.convToImperial(inputValue);
                        break;
                    default:
                        throw new RuntimeException("Unknown Unit Type, please use "  +
                                MeasuringSystemType.METRIC.name() + " and " + MeasuringSystemType.IMPERIAL.name());
                }

                status = HttpStatus.OK;
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }

        } else {
            convertedValue = null;
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(String.valueOf(convertedValue), status);
    }

    private ConvertorService getConvertor(final String measurement) {
        ConvertorService convertorService;

        try {
            convertorService = conversionFactoryPattern.getConvertor(ConversionType.valueOf(measurement.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Please only use a known measurement such as: [" +
                    Arrays.stream(ConversionType.values()).map(ConversionType::name)
                            .collect(Collectors.joining(", ")) + "]");
        }

        return convertorService;
    }

    private MeasuringSystemType getSystemToConvertInto(final String system) throws IllegalArgumentException {
        MeasuringSystemType measuringSystemType;

        try {
            measuringSystemType = MeasuringSystemType.valueOf(system.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Please only use a known measurement system such as [" +
                    MeasuringSystemType.METRIC.name() + "] or [" + MeasuringSystemType.IMPERIAL.name() + "]");
        }

        return measuringSystemType;
    }

    public ResponseEntity<List<String>> measurementcategories() {
        return new ResponseEntity<>(Arrays.stream(ConversionType.values()).map(ConversionType::name).collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<List<String>> getSiUnits() {
        return new ResponseEntity<>(Arrays.stream(MeasuringSystemType.values()).map(MeasuringSystemType::name).collect(Collectors.toList()), HttpStatus.OK);
    }
}
