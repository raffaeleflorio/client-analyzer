package io.github.raffaeleflorio.client_analyzer.vertx;

import io.reactivex.Completable;
import io.vertx.reactivex.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle {
  @Override
  public Completable rxStart() {
    return Completable.complete();
  }
}
