package com.online_education.user;/**
 * Copyright (C) 2020 Urban Compass, Inc.
 */

import com.online_education.user.command.CreateUserCommand;

import javax.inject.Inject;

/**
 * @auther fansun
 */
public class UserServiceHandler {
  @Inject
  CreateUserCommand createUserCommand;

  public UserServiceHandler() {
    DaggerUserComponent.create().inject(this);
  }
}
