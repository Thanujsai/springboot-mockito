package com.example.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.mockito_demo.business.DataService;
import com.example.mockito_demo.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class SomeBusinessImplMockTest {
  
  @Test
  void testFindGreatestFromAllData() {
    DataService dataService = mock(DataService.class);
    when(dataService.retrieveAllData()).thenReturn(new int[] {24, 15, 3});
    SomeBusinessImpl business = new SomeBusinessImpl(dataService);
    int result = business.findGreatest();
    assertEquals(24, result);
  }
  
  @Test
  void testFindGreatestFromAllDataWithOneValue() {
    DataService dataService = mock(DataService.class);
    when(dataService.retrieveAllData()).thenReturn(new int[] {24});// whenever i want to change the data, i just have to change this line, i dont have to create a new stub class
    SomeBusinessImpl business = new SomeBusinessImpl(dataService);
    int result = business.findGreatest();
    assertEquals(24, result);
  }

}