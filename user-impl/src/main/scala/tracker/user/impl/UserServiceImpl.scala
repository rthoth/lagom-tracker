package tracker.user.impl

import com.lightbend.lagom.scaladsl.api.ServiceCall
import tracker.user.api.{User, UserService}

import scala.concurrent.Future

class UserServiceImpl extends UserService {

  override def store = ServiceCall { _ =>
    Future.failed(new IllegalArgumentException("xxx"))
  }

  override def get(login: String) = ServiceCall { x =>
    Future.successful(User(login))
  }
}
