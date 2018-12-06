package controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import model.InvestModelInterfaceNew;
import model.InvestmentModelNew;
import properties.PropertiesLoader;


public abstract class AbstractController implements IStockMarketController{


  protected InvestModelInterfaceNew model;


  protected void saveData() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    objectMapper.writeValue(new File(new PropertiesLoader().getValue("DISKFILE")), model);
  }

  protected InvestModelInterfaceNew retrieveData() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    InvestModelInterfaceNew obj = objectMapper.readValue(new File(new PropertiesLoader().getValue("DISKFILE")),
            InvestmentModelNew.class);
    return obj;
  }
}
