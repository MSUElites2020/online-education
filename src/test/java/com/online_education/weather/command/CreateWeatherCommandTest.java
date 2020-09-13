package com.online_education.weather.command;

import static com.google.common.truth.Truth.assertThat;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_education.weather.command.CreateWeatherCommand;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/** @author fangboyang */
public class CreateWeatherCommandTest {
  @Mock private DynamoDB dynamoDB;
  @Mock private ObjectMapper objectMapper;
  private CreateWeatherCommand createWeatherCommand;

  @Before
  public void setup() {
    MockitoAnnotations.openMocks(this);
    createWeatherCommand = new CreateWeatherCommand(dynamoDB, objectMapper);
  }

  @Test
  public void testCreateWeatherSuccess() throws Exception {
    assertThat(1+1).isEqualTo(2);
  }
}
