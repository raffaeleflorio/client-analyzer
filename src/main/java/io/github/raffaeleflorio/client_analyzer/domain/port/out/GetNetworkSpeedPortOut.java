package io.github.raffaeleflorio.client_analyzer.domain.port.out;

import io.reactivex.Single;

public interface GetNetworkSpeedPortOut {
  Single<Long> getNetworkSpeed();
}
