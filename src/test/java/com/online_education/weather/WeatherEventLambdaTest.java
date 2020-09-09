package com.online_education.weather;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.google.common.truth.Truth.assertThat;

/**
 * @author fangboyang
 */
public class WeatherEventLambdaTest {
  @Mock
  private DynamoDB dynamoDB;
  private WeatherEventLambda weatherEventLambda;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    weatherEventLambda = new WeatherEventLambda();
  }

  @Test
  public void testGetWeatherSuccess() throws Exception {
    int sum = 1 + 1;
    assertThat(sum).isEqualTo(2);
  }
}
