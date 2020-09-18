package com.online_education.finance.server;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component
public interface FinanceComponent {
  void inject(FinanceServiceHandler financeServiceHandler);
}
