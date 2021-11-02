package za.com.ayo.pattern;

import za.com.ayo.enums.ConversionType;
import za.com.ayo.service.ConvertorService;
import za.com.ayo.service.AreaServiceImpl;
import za.com.ayo.service.LengthServiceImpl;
import za.com.ayo.service.TemperatureServiceImpl;
import za.com.ayo.service.VolumeServiceImpl;
import za.com.ayo.service.WeightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class ConversionFactoryPattern {

    private final VolumeServiceImpl volumeServiceImpl;
    private final WeightServiceImpl weightServiceImpl;
    private final TemperatureServiceImpl temperatureServiceImpl;
    private final AreaServiceImpl areaServiceImpl;
    private final LengthServiceImpl lengthServiceImpl;

    @Autowired
    public ConversionFactoryPattern(final TemperatureServiceImpl temperatureServiceImpl,
                                    final AreaServiceImpl areaServiceImpl,
                                    final LengthServiceImpl lengthServiceImpl,
                                    final VolumeServiceImpl volumeServiceImpl,
                                    final WeightServiceImpl weightServiceImpl) {
        this.temperatureServiceImpl = temperatureServiceImpl;
        this.areaServiceImpl = areaServiceImpl;
        this.lengthServiceImpl = lengthServiceImpl;
        this.volumeServiceImpl = volumeServiceImpl;
        this.weightServiceImpl = weightServiceImpl;
    }

    public ConvertorService getConvertor(final ConversionType type) {
        if (ConversionType.TEMPERATURE.equals(type)) {
            return temperatureServiceImpl;
        } else if (ConversionType.AREA.equals(type)) {
            return areaServiceImpl;
        } else if (ConversionType.LENGTH.equals(type)) {
            return lengthServiceImpl;
        } else if (ConversionType.VOLUME.equals(type)) {
            return volumeServiceImpl;
        } else if (ConversionType.WEIGHT.equals(type)) {
            return weightServiceImpl;
        } else {
            throw new RuntimeException(format("Could not find implementation for the conversion type [%s]",
                    type.name()));
        }
    }
}
