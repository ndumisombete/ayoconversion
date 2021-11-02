package za.com.ayo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LengthServiceImpl implements ConvertorService {
    @Override
    public double convToMetric(final double mileValue) {
        return Precision.round(mileValue * 1.609, 2);
    }
    @Override
    public double convToImperial(final double kilometerValue) {
        return Precision.round(kilometerValue / 1.609, 2);
    }
}