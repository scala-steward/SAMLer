package dtos.api

import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.{Format, Json}

case class AuthnResponse(RelayState: String, SAMLResponse: String)

object AuthnResponse {
  implicit val format: Format[AuthnResponse] = Json.format

  val form = Form(
    mapping(
      "RelayState" -> text,
      "SAMLResponse" -> text
    )(AuthnResponse.apply)(AuthnResponse.unapply)
  )
}
