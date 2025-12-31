package com.example.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.mockito_demo.business.DataService;
import com.example.mockito_demo.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class SomeBusinessImplTest {
  
  @Test
  void testFindGreatestFromAllData() {
    DataServiceStub dataServiceStub = new DataServiceStub();
    SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
    int result = business.findGreatest(); // returns NPE because dataService is null
    assertEquals(24, result);
  }
  
  @Test
  void testFindGreatestFromAllDataWithOneValue() {
    DataServiceStub2 dataServiceStub = new DataServiceStub2(); // whenever i want to change the data, i have to create a new stub class, which is an overhead
    SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
    int result = business.findGreatest(); // returns NPE because dataService is null
    assertEquals(24, result);
  }

}

class DataServiceStub implements DataService {

  @Override
  public int[] retrieveAllData() {
    return new int[] {24, 15, 3};
  }
  
  //since this implements an interface, we have to provide implementation for all the methods in the interface
  //which is an overhead if the interface has many methods
  
}

class DataServiceStub2 implements DataService {

  @Override
  public int[] retrieveAllData() {
    return new int[] {24};
    // whenever i want to change the data, i have to create a new stub class, which is an overhead
  }
  
  //since this implements an interface, we have to provide implementation for all the methods in the interface
  //which is an overhead if the interface has many methods
  
}