package com.online_education.user;/**
 * Copyright (C) 2020 Urban Compass, Inc.
 */

import lombok.Builder;
import lombok.Data;

/**
 * @auther fansun
 */
@Builder
@Data
public class UserEvent {
  private String userName;
  public UserEvent(){}
}
