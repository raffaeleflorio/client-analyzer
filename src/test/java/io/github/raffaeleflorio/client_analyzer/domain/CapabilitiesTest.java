package io.github.raffaeleflorio.client_analyzer.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

class CapabilitiesTest {
  @Test
  void with_negative_network_speed() throws Throwable {
    String javaVersion = randomString();
    Long networkSpeed = randomNegativeLong();

    try {
      new Capabilities(javaVersion, networkSpeed);
      throw new IllegalStateException("Invalid capabilities built!");
    } catch (IllegalArgumentException e) {
    }
  }

  private String randomString() {
    return UUID.randomUUID().toString();
  }

  private Long randomNegativeLong() {
    return ThreadLocalRandom.current().nextLong(1L, Long.MAX_VALUE) * -1L;
  }
}
