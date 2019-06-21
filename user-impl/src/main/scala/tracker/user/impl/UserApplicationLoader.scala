package tracker.user.impl

import com.lightbend.lagom.scaladsl.api.{Descriptor, ServiceLocator}
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server.{LagomApplication, LagomApplicationContext, LagomApplicationLoader}
import tracker.user.api.UserService

class UserApplicationLoader extends LagomApplicationLoader {


  override def loadDevMode(context: LagomApplicationContext): LagomApplication = {
    new UserApplication(context) with LagomDevModeComponents
  }

  override def load(context: LagomApplicationContext): LagomApplication = {
    new UserApplication(context) {
      override def serviceLocator: ServiceLocator = ServiceLocator.NoServiceLocator
    }
  }

  override def describeService: Option[Descriptor] = Some(readDescriptor[UserService])
}
