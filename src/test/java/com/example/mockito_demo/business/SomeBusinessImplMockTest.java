package com.example.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.mockito_demo.business.DataService;
import com.example.mockito_demo.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // to enable Mockito annotations
public class SomeBusinessImplMockTest {
  
  @Mock
  private DataService dataService; // creating a mock instance of DataService interface, mocking the dependencies of SomeBusinessImpl class
  
  @InjectMocks // to inject the mock dataService into businessImpl, whatever mocks are defined in the class must be injected into the class under test
  private SomeBusinessImpl businessImpl;
  
  @Test
  void testFindGreatestFromAllData() {
    when(dataService.retrieveAllData()).thenReturn(new int[] {24, 15, 3});
    int result = businessImpl.findGreatest();
    assertEquals(24, result);
  }
  
  @Test
  void testFindGreatestFromAllDataWithOneValue() {
    when(dataService.retrieveAllData()).thenReturn(new int[] {24});// whenever i want to change the data, i just have to change this line, i dont have to create a new stub class
    int result = businessImpl.findGreatest();
    assertEquals(24, result);
  }

}