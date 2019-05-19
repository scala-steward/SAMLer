package controllers

import javax.inject._
import play.api.mvc._
import services.SAMLService

@Singleton
class OAuthController @Inject()(
    samlService: SAMLService,
    cc: ControllerComponents
) extends BaseController(cc) {

  def authorize(
      client_id: String,
      idp: String,
      response_type: String,
      scope: String,
      nonce: String,
      redirect_uri: String,
      state: String
  ): Action[AnyContent] = TaskAction { implicit request =>
    samlService
      .buildAuthnRequest(
        client_id,
        idp,
        response_type,
        scope,
        nonce,
        redirect_uri,
        state
      )
      .map { authnRequest =>
        Ok(
          views.html.authnredirect(authnRequest)
        )
      }
  }

}
