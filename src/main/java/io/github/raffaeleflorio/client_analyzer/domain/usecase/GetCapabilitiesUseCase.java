package io.github.raffaeleflorio.client_analyzer.domain.usecase;

import io.github.raffaeleflorio.client_analyzer.domain.Capabilities;
import io.reactivex.Single;

public interface GetCapabilitiesUseCase {
  Single<Capabilities> getCapabilities();
}
