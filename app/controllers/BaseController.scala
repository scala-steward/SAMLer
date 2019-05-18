package controllers

import controllers.common.TaskAction
import play.api.mvc.{AbstractController, ControllerComponents}

class BaseController(cc: ControllerComponents)
    extends AbstractController(cc)
    with TaskAction
