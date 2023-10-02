package com.nishchay.core.basics.exc;

public class ExceptionUtil {

  public static boolean containsCause(Throwable failure, Class<? extends Throwable> cause) {
    Throwable intermediate = failure;
    do {
      if (cause.isInstance(intermediate)) {
        return true;
      }
    } while ((intermediate = intermediate.getCause()) != null);

    return false;
  }

}
