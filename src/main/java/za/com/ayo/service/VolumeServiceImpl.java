package za.com.ayo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VolumeServiceImpl implements ConvertorService {
    @Override
    public double convToMetric(final double gallonValue) {
        return Precision.round(gallonValue * 4.546, 2);
    }

    @Override
    public double convToImperial(final double litreValue) {
        return Precision.round(litreValue / 4.546, 2);
    }
}
