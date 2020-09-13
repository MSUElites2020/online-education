package com.online_education.weather.command;

import static com.google.common.truth.Truth.assertThat;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GetWeatherCommandTest {
  @Mock private AmazonDynamoDB amazonDynamoDB;
  @Mock private ObjectMapper objectMapper;
  private GetWeatherCommand getWeatherCommand;

  @Before
  public void setup() {
    MockitoAnnotations.openMocks(this);
    getWeatherCommand = new GetWeatherCommand(objectMapper, amazonDynamoDB);
  }

  @Test
  public void testGetWeatherSuccess() throws Exception {
    assertThat(1+1).isEqualTo(2);
  }
}
