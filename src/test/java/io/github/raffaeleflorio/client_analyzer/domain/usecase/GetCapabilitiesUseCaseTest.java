package io.github.raffaeleflorio.client_analyzer.domain.usecase;

import io.github.raffaeleflorio.client_analyzer.domain.Capabilities;
import io.github.raffaeleflorio.client_analyzer.domain.UseCaseFactory;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GetCapabilitiesUseCaseTest {
  @Test
  void ok() throws Throwable {
    String javaVersion = randomString();
    Long networkSpeed = randomNonNegativeLong();
    GetCapabilitiesUseCase useCase = UseCaseFactory.getCapabilitiesUseCase(
      () -> Single.just(javaVersion),
      () -> Single.just(networkSpeed)
    );

    TestObserver<Capabilities> useCaseObserver = useCase
      .getCapabilities()
      .test();
    assertTrue(useCaseObserver.await(100, TimeUnit.MILLISECONDS));

    useCaseObserver
      .assertResult(new Capabilities(javaVersion, networkSpeed));
  }

  private String randomString() {
    return UUID.randomUUID().toString();
  }

  private Long randomNonNegativeLong() {
    return ThreadLocalRandom.current().nextLong(0L, Integer.MAX_VALUE);
  }
}
