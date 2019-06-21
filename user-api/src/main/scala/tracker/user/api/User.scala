package tracker.user.api

import play.api.libs.json.{Format, Json}

object User {

  implicit val format: Format[User] = Json.format[User]
}

case class User(login: String)
