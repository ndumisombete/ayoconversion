package za.com.ayo.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import za.com.ayo.service.ConvertorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import za.com.ayo.model.exception.ExceptionResponseType;

import java.util.List;

@RestController
@RequestMapping({"/v1"})
@CrossOrigin
@Slf4j
public class ConversionResource {

    private final ConvertorServiceImpl convertorServiceImpl;

    @Autowired
    public ConversionResource(final ConvertorServiceImpl convertorServiceImpl) {
        this.convertorServiceImpl = convertorServiceImpl;
    }

    @RequestMapping(value = "/{measurementcategory}/{measuringsystem}/{value}", method = {RequestMethod.GET}, produces = {"application/json"})
    @ApiOperation(value = "Get conversion", response = String.class, responseContainer = "List")
    @ApiResponses({@ApiResponse(code = 200, message = "Successful get conversion", response = String.class, responseContainer = "List"), @ApiResponse(code = 404, message = "conversion does not found", response = ExceptionResponseType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public ResponseEntity<String> convert(@PathVariable final String measurementcategory, @PathVariable final String measuringsystem, @PathVariable final Double value) {
        return convertorServiceImpl.convert(measurementcategory, measuringsystem, value);
    }
    @RequestMapping(value = "/measurementcategories", method = {RequestMethod.GET}, produces = {"application/json"})
    @ApiOperation(value = "Get conversion", response = String.class, responseContainer = "List")
    @ApiResponses({@ApiResponse(code = 200, message = "Successful get conversion", response = String.class, responseContainer = "List"), @ApiResponse(code = 404, message = "conversion does not found", response = ExceptionResponseType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public ResponseEntity<List<String>> measurementcategories() {
        return convertorServiceImpl.measurementcategories();
    }
    @RequestMapping(value = "/units", method = {RequestMethod.GET}, produces = {"application/json"})
    @ApiOperation(value = "Get conversion", response = String.class, responseContainer = "List")
    @ApiResponses({@ApiResponse(code = 200, message = "Successful get conversion", response = String.class, responseContainer = "List"), @ApiResponse(code = 404, message = "conversion does not found", response = ExceptionResponseType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public ResponseEntity<List<String>> getSiUnits() {
        return convertorServiceImpl.getSiUnits();
    }
}
