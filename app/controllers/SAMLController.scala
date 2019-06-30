package controllers

import dtos.api.AuthnResponse
import javax.inject._
import play.api.mvc._
import zio.Task

@Singleton
class SAMLController @Inject()(cc: ControllerComponents) extends BaseController(cc) {

  def respondToAuthn(idpId: String): Action[AuthnResponse] =
    TaskAction(parse.form(AuthnResponse.form)) { implicit request =>
      val response = request.body
      Task.succeed(
        jsonOut(Ok, response)
      )
    }
}
