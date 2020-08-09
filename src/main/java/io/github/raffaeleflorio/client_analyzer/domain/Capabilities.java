package io.github.raffaeleflorio.client_analyzer.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Capabilities {
  public Capabilities(String javaVersion, Long networkSpeed) {
    this.javaVersion = javaVersion;
    this.networkSpeed = networkSpeed;

    if (this.networkSpeed < 0L) throw new IllegalArgumentException("Network speed should be greater than 0!");
  }

  private final String javaVersion;
  private final Long networkSpeed;
}
