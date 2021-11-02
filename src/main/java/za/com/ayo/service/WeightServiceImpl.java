package za.com.ayo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WeightServiceImpl implements ConvertorService {

    @Override
    public double convToMetric(final double fromValue) {
        return Precision.round(fromValue / 2.205, 2);
    }

    @Override
    public double convToImperial(final double fromValue) {
        return Precision.round(fromValue * 2.205, 2);
    }
}
