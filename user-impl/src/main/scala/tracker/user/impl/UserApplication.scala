package tracker.user.impl

import com.lightbend.lagom.scaladsl.persistence.jdbc.JdbcPersistenceComponents
import com.lightbend.lagom.scaladsl.server.{LagomApplication, LagomApplicationContext}
import play.api.libs.ws.ahc.AhcWSComponents
import tracker.user.api.UserService
import com.softwaremill.macwire._
import play.api.db.HikariCPComponents

abstract class UserApplication(context: LagomApplicationContext)
  extends LagomApplication(context) with AhcWSComponents with JdbcPersistenceComponents
    with HikariCPComponents {

  override lazy val lagomServer = serverFor[UserService](wire[UserServiceImpl])
}
