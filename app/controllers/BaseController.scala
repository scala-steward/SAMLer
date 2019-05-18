package controllers

import controllers.common.CustomActions
import play.api.mvc.{AbstractController, ControllerComponents}

class BaseController(cc: ControllerComponents)
    extends AbstractController(cc)
    with CustomActions
