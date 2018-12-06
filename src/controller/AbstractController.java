package controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import model.InvestModelInterfaceNew;
import model.InvestmentModelNew;
import properties.PropertiesLoader;

/**
 * This is an abstract controller. This class is used to implement the features which are common for
 * both the GUI controller and the Text based console controller.
 */
public abstract class AbstractController implements IStockMarketController {


  protected InvestModelInterfaceNew model;

  /**
   * This method is used to save the model in a text file which is configurable in the application
   * properties file.
   *
   * @throws IOException if the file is not present or is corrupted.
   */
  protected void saveData() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    objectMapper.writeValue(new File(new PropertiesLoader().getValue("DISKFILE")), model);
  }

  /**
   * This method is used to retrieve and load the model from the JSON file.
   *
   * @return the InvestmentModel Object.
   * @throws IOException if the file is not present or is corrupted.
   */
  protected InvestModelInterfaceNew retrieveData() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    InvestModelInterfaceNew obj = objectMapper.readValue(new File(new PropertiesLoader().getValue("DISKFILE")),
            InvestmentModelNew.class);
    return obj;
  }
}
