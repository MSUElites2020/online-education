package com.online_education.finance.server;

import dagger.Component;
import javax.inject.Singleton;

/** @auther fangboyang */
@Singleton
@Component
public interface FinanceComponent {
  void inject(FinanceServiceHandler financeServiceHandler);
}
