package io.github.raffaeleflorio.client_analyzer.domain;

import io.github.raffaeleflorio.client_analyzer.domain.port.out.GetJavaVersionPortOut;
import io.github.raffaeleflorio.client_analyzer.domain.port.out.GetNetworkSpeedPortOut;
import io.github.raffaeleflorio.client_analyzer.domain.usecase.GetCapabilitiesUseCase;

public class UseCaseFactory {
  public static GetCapabilitiesUseCase getCapabilitiesUseCase(
    GetJavaVersionPortOut getJavaVersionPortOut,
    GetNetworkSpeedPortOut getNetworkSpeedPortOut
  ) {
    return new Analyzer(getJavaVersionPortOut, getNetworkSpeedPortOut);
  }
}
