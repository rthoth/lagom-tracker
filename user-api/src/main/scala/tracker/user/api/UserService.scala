package tracker.user.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.Service._
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait UserService extends Service {

  def store: ServiceCall[User, UserStored]

  def get(login: String): ServiceCall[NotUsed, User]

  override def descriptor: Descriptor = {
    named("user").withCalls(
      pathCall("/user", store),
      pathCall("/user/:login", get _)
    )
  }
}
