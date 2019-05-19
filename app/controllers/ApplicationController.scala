package controllers

import javax.inject._
import play.api.mvc._
import scalaz.zio.Task

@Singleton
class ApplicationController @Inject()(cc: ControllerComponents)
    extends BaseController(cc) {

  def healthcheck(): Action[AnyContent] = TaskAction { implicit request =>
    Task.succeed(Ok("PONG!"))
  }

}
