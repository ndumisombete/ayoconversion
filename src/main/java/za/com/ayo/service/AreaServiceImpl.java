package za.com.ayo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AreaServiceImpl implements ConvertorService {
    @Override
    public double convToMetric(final double acreValue) {
        return Precision.round(acreValue / 2.471, 2);
    }

    @Override
    public double convToImperial(final double hectareValue) {
        return Precision.round(hectareValue * 2.471, 2);
    }
}
