/**
 * Copyright (C) 2018 Lightbend Inc. <http://www.lightbend.com>
 */
package akka.stream.impl.streamref

import akka.annotation.InternalApi
import akka.event.Logging
import akka.stream.StreamRefSettings

import scala.concurrent.duration.FiniteDuration

/** INTERNAL API */
@InternalApi
private[akka] final case class StreamRefSettingsImpl private (
  override val bufferCapacity:           Int,
  override val demandRedeliveryInterval: FiniteDuration,
  override val subscriptionTimeout:      FiniteDuration
) extends StreamRefSettings {

  override def withBufferCapacity(value: Int): StreamRefSettings = copy(bufferCapacity = value)
  override def withDemandRedeliveryInterval(value: scala.concurrent.duration.FiniteDuration): StreamRefSettings = copy(demandRedeliveryInterval = value)
  override def withSubscriptionTimeout(value: FiniteDuration): StreamRefSettings = copy(subscriptionTimeout = value)

  override def productPrefix: String = Logging.simpleName(classOf[StreamRefSettings])
}
