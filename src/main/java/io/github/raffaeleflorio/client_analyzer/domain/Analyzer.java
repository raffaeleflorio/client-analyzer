package io.github.raffaeleflorio.client_analyzer.domain;

import io.github.raffaeleflorio.client_analyzer.domain.Capabilities.CapabilitiesBuilder;
import io.github.raffaeleflorio.client_analyzer.domain.port.out.GetJavaVersionPortOut;
import io.github.raffaeleflorio.client_analyzer.domain.port.out.GetNetworkSpeedPortOut;
import io.github.raffaeleflorio.client_analyzer.domain.usecase.GetCapabilitiesUseCase;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class Analyzer implements GetCapabilitiesUseCase {
  @Override
  public Single<Capabilities> getCapabilities() {
    return Single.just(Capabilities.builder())
      .flatMap(this::getJavaVersion)
      .flatMap(this::getNetworkSpeed)
      .map(CapabilitiesBuilder::build);
  }

  private Single<CapabilitiesBuilder> getJavaVersion(CapabilitiesBuilder builder) {
    return getJavaVersionPortOut
      .getJavaVersion()
      .map(builder::javaVersion);
  }

  private Single<CapabilitiesBuilder> getNetworkSpeed(CapabilitiesBuilder builder) {
    return getNetworkSpeedPortOut
      .getNetworkSpeed()
      .map(builder::networkSpeed);
  }

  private final GetJavaVersionPortOut getJavaVersionPortOut;
  private final GetNetworkSpeedPortOut getNetworkSpeedPortOut;
}
