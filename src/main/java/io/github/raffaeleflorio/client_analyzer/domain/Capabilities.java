package io.github.raffaeleflorio.client_analyzer.domain;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
@Builder
public class Capabilities {
  private final String javaVersion;
  private final Long networkSpeed;
}
