package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import zio.Task

@Singleton
class SAMLController @Inject()(cc: ControllerComponents)
    extends BaseController(cc) {

  def index(): Action[AnyContent] = TaskAction { implicit request =>
    Task.succeed(Ok("Hello World"))
  }

  def index2(idpId: String): Action[AnyContent] = TaskAction {
    implicit request =>
      Task.succeed(Ok("Hello World"))
  }

}
