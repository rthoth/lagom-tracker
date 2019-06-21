package tracker.user.api

import play.api.libs.json.{Format, Json}

object UserStored {

  implicit val format: Format[UserStored] = Json.format[UserStored]
}

case class UserStored(
  user: User
)
